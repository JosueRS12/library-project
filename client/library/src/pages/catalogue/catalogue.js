import {Link} from 'react-router-dom'
import Layout from '../../components/layout/layout';
import Card from '../../components/card/card';
import styles from './styles.css';

export default function Catalogue(){
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
        <Card/>
      </section>
      
    </Layout>
  );
}
