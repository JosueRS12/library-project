import React from 'react';
import ReactDOM from 'react-dom';
//import Layout from './components/layout/layout';
import Catalogue from './pages/catalogue/catalogue';

const Home = () =>{
  return(
    <>
      <Catalogue/>
    </>
  )
}

ReactDOM.render(
  <React.StrictMode>
    <Home/>
  </React.StrictMode>,
  document.getElementById('root')
);
