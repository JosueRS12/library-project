import React from 'react';
import ReactDOM from 'react-dom';
import Home from './pages/home/home'
import Catalogue from './pages/catalogue/catalogue'
import Register from './pages/register/register'
import Cart from './pages/shopping-cart/cart'

import { BrowserRouter as Router, Routes, Route} from "react-router-dom";

const RoutingApp = () =>{
          //<Route path='/cataloge/:nameCataloge' component={Catalogue}/>
  return(
    <>
      <Router>
        <Routes>
          <Route path='/' exact element={<Home />}/>
          <Route path='/catalogue' element={<Catalogue />}/>
          <Route path='/register' element={<Register />}/>
          <Route path='/cart/:id' element={<Cart />}/>
        </Routes>
      </Router>
    </>
  );
}

ReactDOM.render(
  <React.StrictMode>
    <RoutingApp/>
  </React.StrictMode>,
  document.getElementById('root')
);
