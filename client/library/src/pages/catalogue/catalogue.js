import {Link} from 'react-router-dom'
import {useState, useEffect} from 'react';
import Layout from '../../components/layout/layout';
import Card from '../../components/card/card';
import './styles.css';

export default function Catalogue(){
  const [books, setBooks] = useState([]);

  useEffect(()=>{
    fetchBooks(); 
  });

  const fetchBooks = async () => {
    const data = await fetch(`http://localhost:8080/api/catalogue/123`);
    const listBook = await data.json(); 
    setBooks(listBook);
  }

  var id = 12
  return(
    <Layout>
      <div className="header">
        <h2> Libros Disponibles </h2>
        <button className="decorade-button">
          <Link to={`/cart/${id}`}> Ir al carrito de compras </Link>
        </button>
      </div>
      <section id="product-card">
        {
          books.map((e)=>
            <Card key={e.id} idBook={e.id} name={e.name} count={e.count} price={e.price}/>
        )}
        <Card name="harry potter"/>
      </section>
      
    </Layout>
  );
}
