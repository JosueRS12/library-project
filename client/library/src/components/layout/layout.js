import React from 'react';

export default function Layout(props){
  return(
    <>
      <h1> Harry Books - Tienda Online </h1>
      <hr/>
      {props.children}
    </>
  )
}

