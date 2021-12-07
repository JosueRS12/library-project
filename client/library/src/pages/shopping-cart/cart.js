import Layout from '../../components/layout/layout'
import {useState, useEffect} from 'react'
import './styles.css' 
import {useParams} from 'react-router-dom'

export default function Cart(){
  const [prods, setProds] = useState([]);
  const [countProd, setCountProd] = useState(prods.length);
  var params = useParams();

  useEffect(()=>{
    fetchProds(); 
  }, [countProd]);

  const fetchBook = async (count, idBook) => {
    var book = {count, idBook};
    const res = await fetch(`http://localhost:8080/api/book/new-count`, {
      method: 'PUT',
      headers: {"Content-type":"application/json"},
      body: JSON.stringify(book)
    }); 
    return res.status;
  }

  const fetchProds = async () => {
    const res = await fetch(`http://localhost:8080/api/cart/${params.idCart}`); //123 => id cart => lo puedo obtener como en card...
    const listProds = await res.json(); 
    setProds(listProds);
    return res;
  }

  const fetchDeleteCartBook = async(idCart)=>{
    var cart = {idCart};
    const res = await fetch( `http://localhost:8080/api/cartbook/delete/cartbook`,{
      method: 'DELETE',
      headers: {"Content-type":"application/json"},
      body: JSON.stringify(cart)
    });
    return res.status;
  }

  const fetchDeleteProduct = async(idBook, idCart)=>{
    var book = {idBook, idCart};
    const res = await fetch( `http://localhost:8080/api/cartbook/delete/product`,{
      method: 'DELETE',
      headers: {"Content-type":"application/json"},
      body: JSON.stringify(book)
    });
    return res.status;
  }

  const handleSubmitProduct = async(idBook, idCart)=>{
    var status = await fetchDeleteProduct(String(idBook), String(idCart));
    if(status === 200){
      setCountProd(countProd - 1)
      window.alert("producto eliminado con éxito");
    }else{
      window.alert("Ha ocurrido un problema");
    } 
  }
  
  const obtainTotal = ()=>{
    var total = 0;
    prods.map((e)=>{
      total+= (e.price * e.count);   
      return null;
    });
    return total;
  }

  const updateCountBook = async ()=>{
    var status = 200;
    prods.map(async (e)=>{
      if(status === 200){
        status = await fetchBook(String(e.count), String(e.idBook)); //manejar escenarios y excepciones
        return status;
      }else{
        status = 500;
        return status;
      }
    });
  } 
  

  const purchase = async ()=> {
    //verificar si el producto está agotado
    await fetchDeleteCartBook(String(prods[0].idCart));
    setCountProd(countProd - 1)
    await updateCountBook();
    window.alert("compra realizada");
  }

  return(
    <Layout>
      <h1> Carrito de compras </h1>
      <table>
        <thead>
          <tr>
            <th>
              <input type="checkbox" id="all" name="all"/>
            </th>
            <th>Libros</th>
            <th>Cantidad</th>
            <th>Valor Unitario</th>
            <th>Valor Total</th>
          </tr>
        </thead>
        <tbody>
            {
              prods.map((e, i)=>
              <tr key={i}>
                <td>
                  <button onClick={()=>handleSubmitProduct(e.idBook, e.idCart)} type="submit" className="decorate_button">
                    Eliminar
                  </button>
                </td>
                <td>{e.name}</td>
                <td>{e.count}</td>
                <td>{e.price}</td>
                <td>{e.count * e.price}</td>
              </tr>
           )}
        </tbody>
      </table>
      <p>valor total de la compra: $ {obtainTotal()}</p>
      <div className="container_buttons">
        <button type="submit">
          Cancelar Compra
        </button>
        <button onClick={()=>purchase()}type="submit">
          Confirmar Compra
        </button>
      </div>
    </Layout>
  )
}
