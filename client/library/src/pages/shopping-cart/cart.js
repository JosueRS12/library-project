import Layout from '../../components/layout/layout'
import styles  from './styles.css' 

export default function Cart(){
  return(
    <Layout>
      <h1> Carrito de compras </h1>
      <table>
        <thead>
          <tr>
            <th>
              <input type="checkbox" id="all" name="all"/>
            </th>
            <th>Libros</th>
            <th>Cantidad</th>
            <th>Valor Unitario</th>
            <th>Valor Total</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>
              <button type="submit" className="decorate_button">
                Eliminar
              </button>
            </td>
            <td>John Lennon</td>
            <td>Rhythm Guitar</td>
            <td>Rhythm Guitar</td>
            <td>Rhythm Guitar</td>
          </tr>
        </tbody>
      </table>
      <p>valor total de la compra: $000.000</p>
      <div className="container_buttons">
        <button type="submit">
          Cancelar Compra
        </button>
        <button type="submit">
          Cancelar Compra
        </button>
      </div>
    </Layout>
  )
}
