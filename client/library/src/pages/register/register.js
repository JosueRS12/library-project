import Layout from '../../components/layout/layout'
export default function Register(props){
  return(
    <Layout>
      <div>
        <h2> Registrarse </h2>
        <form>
          <label for="first_name">Nombre:</label><br/>
          <input type="text" id="first_name" name="first_name"/><br/>

          <label for="last_name">apellido:</label><br/>
          <input type="text" id="last_name" name="last_name"/><br/>

          <label for="pwd">Password:</label><br/>
          <input type="password" id="pwd" name="pwd"/><br/>

          <label for="username">Username:</label><br/>
          <input type="text" id="username" name="username"/><br/>

          <label for="id">Número de identificación:</label><br/>
          <input type="text" id="id" name="id"/><br/>

          <label for="tipo_id">tipo de identificación:</label><br/>
          <input type="text" id="tipo_id" name="tipo_id"/><br/>
          <input type="submit" value="Submit"/>
        </form>
      </div>
    </Layout>
  )
}
