import Layout from '../../components/layout/layout'
import {useState} from 'react'

export default function Register(props){

  const [client, setClient] = useState({})


  const fetchClient = async () => {
    const res = await fetch( `http://localhost:8080/api/client/register`,{
      method: 'POST',
      headers: {"Content-type":"application/json"},
      body: JSON.stringify(client)
    });
    return res.status;
  }

  const submit = (e)=>{
    e.preventDefault(); 
    fetchClient()
      .then((res)=>{
        
        if(res === 200)
          return window.alert(`registro exitoso del usuario ${client.user}`)
        else
          return window.alert(`Ha ocurrido un problema`)
      })
  }

  return(
    <Layout>
      <div>
        <h2> Registrarse </h2>
        <form action="/" onSubmit={submit}>
          <label for="first_name">Nombre:</label><br/>
          <input type="text" id="first_name" name="first_name" value={client.firstname} onChange={e=>setClient({...client, firstname: e.target.value})}/><br/>

          <label for="last_name">apellido:</label><br/>
          <input type="text" id="last_name" name="last_name" value={client.lastname} onChange={e=>setClient({ ...client, lastname: e.target.value})}/><br/>

          <label for="pwd">Password:</label><br/>
          <input type="password" id="pwd" name="pwd" value={client.password} onChange={e=>setClient({ ...client, password: e.target.value})}/><br/>

          <label for="username">Username:</label><br/>
          <input type="text" id="username" name="username" value={client.user} onChange={e=>setClient({ ...client, user: e.target.value})}/><br/>

          <label for="id">Número de identificación:</label><br/>
          <input type="text" id="id" name="id" value={client.id} onChange={e=>setClient({ ...client, id: e.target.value})}/><br/>

          <label for="tipo_id">tipo de identificación:</label><br/>
          <input type="text" id="tipo_id" name="tipo_id" value={client.typeid} onChange={e=>setClient({ ...client, typeid: e.target.value})}/><br/>
          <input type="submit" name="Registrarse"/>
        </form>
      </div>
    </Layout>
  )
}
