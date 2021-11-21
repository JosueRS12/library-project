import React from 'react';
import styles from './styles.css'

export default function Card(){
  //hacerlo dinamico
  //boton de cantidad
  return(
    <div className="container">
      <img className="img-container" src=" https://es.web.img2.acsta.net/pictures/14/04/30/11/55/592219.jpg " alt="harry potter"/>
      <div className="details-card">
        <h2> Harry Potter </h2>
        <p> Cantidad disponible: </p>
        <p> Precio: $50.000</p>
        <p> Agregar al carrito: </p>
        <button>Agregar</button>
      </div>
    </div>
  )
}
