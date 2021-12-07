import Layout from '../../components/layout/layout';
import {useState} from 'react'
import {Link} from 'react-router-dom';

export default function Home(){
  const [idCatalogue, setIdCatalogue] = useState(0);
  const [user, setUser] = useState({});
  const [logged, setLogged] = useState(false);

  const fetchUser = async (us, pass) => {
    const res = await fetch( `http://localhost:8080/api/client/${us}/${pass}`);
    var data = await res.json();
    setUser(data);
    return res.status;
  }

  const login = (e) =>{
    e.preventDefault(); 
    let us = document.getElementById('username').value;
    let pass = document.getElementById('pwd').value;
    fetchUser(us, pass)
      .then((res)=>{
        if(res === 200){
          setLogged(true);
        }
        else{
          setLogged(false);
          window.alert(`No ha sido posible iniciar sesión`)
        }
      })
  }
 
  function goCatalogue(){
    if(logged)
      return <Link to={`/catalogue/${idCatalogue}/${user.id}`}>go to Catalogue </Link> 
    else
      return <Link to={`/catalogue/${idCatalogue}`} >go to Catalogue </Link> 
  }
  return(
    <Layout log={logged}>
      <div>
        <h2> Iniciar Sesion </h2>
        <form action="" onSubmit={login}>
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
      
      <input placeholder="ingrese el id del catalogo" type="text" id="catalogue" name="catalogue" onChange={e=>setIdCatalogue(e.target.value)}/><br/>
      <button>
        {goCatalogue()}
      </button>
    </Layout>
  )
}

