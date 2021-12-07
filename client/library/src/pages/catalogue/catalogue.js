import {Link, useParams} from 'react-router-dom'
import {useState, useEffect} from 'react';
import Layout from '../../components/layout/layout';
import Card from '../../components/card/card';
import './styles.css';

const CartButton = (props) =>{
  const stateButton = () => {
    let link;
    if(props.iduser){
      link = <Link to={`/cart/${props.cartid}`}> Carrito de Compras </Link>
      return link;
    } else{
      return "Active sesión para carrito de compras" 
    }
  }
  return(
        <button className="decorade-button" type="button" id="myButton">
          {stateButton()}
        </button>
  )
}


export default function Catalogue(props){
  var params = useParams();
  let iduser = parseInt(params.iduser)
  let idcat = parseInt(params.idcat)
  const [books, setBooks] = useState([]);
  const [cart, setCart] = useState({});

  useEffect(()=>{
    fetchBooks(); 
    uploadCart();
  }, [books.length]);

  const fetchBooks = async () => {
    const data = await fetch(`http://localhost:8080/api/catalogue/${idcat}`);
    const listBook = await data.json(); 
    setBooks(listBook);
  }

  const fetchFindCart = async (idClient) => {
    const res = await fetch( `http://localhost:8080/api/cart/client/${idClient}`)
    const data = await res.json();
    setCart(data);
    return res;
  }

  const fetchCreateCart = async (idCart, idClient) => {
    const cart = {idCart, idClient};
    const res = await fetch( `http://localhost:8080/api/cart/create`,{
      method: 'POST',
      headers: {"Content-type":"application/json"},
      body: JSON.stringify(cart)
    });
    return res;
  }

  const uploadCart = async()=> {
    let statusCart = await fetchFindCart(iduser);
    if(!statusCart.ok){
      let idCart = parseInt(iduser * 3/4);
      fetchCreateCart(String(idCart), String(iduser));
      setCart({id:idCart});
    }
  }
  return(
    <Layout>
      <div className="header">
        <h2> Libros Disponibles </h2>
        <CartButton cartid={cart.id} iduser={iduser} />
      </div>
      <section id="product-card">
        {
          books.map((e)=>
            <Card key={e.id} idBook={e.id} name={e.name} count={e.count} price={e.price} idClient={iduser} idCart={cart.id}/>
        )}
      </section>
    </Layout>
  );
}
