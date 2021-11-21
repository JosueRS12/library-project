import Layout from '../../components/layout/layout';
import {Link} from 'react-router-dom';

export default function Home(){
  return(
    <Layout>
      <div>
        <h2> Iniciar Sesion </h2>
        <form>
          <label for="username">Username:</label><br/>
          <input type="text" id="username" name="username"/><br/>
          <label for="pwd">Password:</label><br/>
          <input type="password" id="pwd" name="pwd"/><br/>
          <input type="submit" value="Submit"/>
        </form>
      </div>
      <br/>
      <button>
        <Link to={`/register`}>
          registrar usuario
        </Link>
      </button>
      <br/>
      <br/>
      <button>
        <Link to={`/catalogue`}>
          go to Catalogue
        </Link>
      </button>
    </Layout>
  )
}

