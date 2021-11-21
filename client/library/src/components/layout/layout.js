import styles from './styles.css'
import {Link} from 'react-router-dom';
export default function Layout(props){
  return(
    <>
      <h1> Harry Books - Tienda Online </h1>
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

