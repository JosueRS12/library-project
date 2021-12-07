import React from 'react';
import {useState, useEffect} from 'react';
import './styles.css'

const fetchBooks = async (idBook, idCart, count) => {
  const book = {idBook, idCart, count};
  const res = await fetch( `http://localhost:8080/api/cartbook/add`,{
    method: 'POST',
    headers: {"Content-type":"application/json"},
    body: JSON.stringify(book)
  });
  return res.status;
}

const addBook = async (idBook, idClient, count, idCart) =>{
  if(count > 0){
    console.log(count);
    const status = await fetchBooks(String(idBook), String(idCart), String(count));
    if(status === 500){
      window.alert('No ha sido posible agregar el libro al carrito');
    }else if(status === 200){
      window.alert("se ha agregado con éxito");
    }
  } else{
      window.alert('Selecciona almenos 1 item');
  }
}


const handleButton = (op, disponible, idBook) =>{
  var val = document.getElementById(String(idBook));
  if(op === '+'){
    if(val.value < disponible)
      return ++val.value;
    else 
      return val.value;
  }
  else if (op === '-'){
    if(val.value > 0)
      return --val.value;
    else 
      return val.value;
  }
}


export default function Card({idBook, name, count, price, idClient, idCart}){
  const [prodCount, setProdCount] = useState(0);
  useEffect(()=>{
    var valueCount = document.getElementById(idBook);
    valueCount.setAttribute("value", prodCount);
  }, [prodCount, idBook]);
  
  return(
    <div className="container">
      <img className="img-container" src=" https://phantom-marca.unidadeditorial.es/8aaf9a66118e335ea504d938f4686fac/resize/1320/f/jpg/assets/multimedia/imagenes/2021/11/12/16367392288904.jpg" alt="harry potter"/>
      <div className="details-card">
        <h2> {name} </h2>
        <p> Cantidad disponible: {count}</p>
        <p> Precio: $ {price}</p>
        <div className="add-container">
          <p> Agregar al carrito: </p>
          <input className="input-item" type="text" id={String(idBook)} name="count"/><br/>
          <div className="selector">
            <button className="child_selector" onClick={()=>setProdCount(handleButton('+', count, idBook))}> + </button>
            <button className="child_selector" onClick={()=>setProdCount(handleButton('-', count, idBook))}> - </button>
          </div>
          <button type="submit" className="button-add" onClick={()=>addBook(idBook, idClient, prodCount, idCart)}>Agregar</button>
        </div>
      </div>
    </div>
  )
}
