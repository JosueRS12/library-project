import './styles.css'
import {Link} from 'react-router-dom';
//import {useState, useEffect} from 'react'

export default function Layout(props){

  return(
    <>
      <h1> Harry Books - Tienda Online </h1>
      <p>
        {
          props.log ? 'sesion activa' : null
        }
      </p>
      <hr/>
      <button>
        <Link to="/">
          ir al home 
        </Link>
      </button>
      {props.children}
    </>
  )
}

