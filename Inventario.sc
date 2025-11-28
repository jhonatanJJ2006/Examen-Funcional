case class Producto(nombre: String, categoria: String, precios: List[Double])
case class ProductoPromedio(producto: Producto, promedio: Double)

// Inventario de productos
val inventario: List[Producto] = List(
  Producto("Producto 1", "Categoria 1", List(10.5, 11.5, 12.5, 13.5)),
  Producto("Producto 2", "Categoria 2", List(11.0, 12.0, 13.0, 14.0)),
  Producto("Producto 3", "Categoria 3", List(11.5, 12.5, 13.5, 14.5)),
  Producto("Producto 4", "Categoria 4", List(12.0, 13.0, 14.0, 15.0)),
  Producto("Producto 5", "Categoria 5", List(12.5, 13.5, 14.5, 15.5)),
  Producto("Producto 6", "Categoria 1", List(13.0, 14.0, 15.0, 16.0)),
  Producto("Producto 7", "Categoria 2", List(13.5, 14.5, 15.5, 16.5)),
  Producto("Producto 8", "Categoria 3", List(14.0, 15.0, 16.0, 17.0)),
  Producto("Producto 9", "Categoria 4", List(14.5, 15.5, 16.5, 17.5)),
  Producto("Producto 10", "Categoria 5", List(15.0, 16.0, 17.0, 18.0)),
  Producto("Producto 11", "Categoria 1", List(15.5, 16.5, 17.5, 18.5)),
  Producto("Producto 12", "Categoria 2", List(16.0, 17.0, 18.0, 19.0)),
  Producto("Producto 13", "Categoria 3", List(16.5, 17.5, 18.5, 19.5)),
  Producto("Producto 14", "Categoria 4", List(17.0, 18.0, 19.0, 20.0)),
  Producto("Producto 15", "Categoria 5", List(17.5, 18.5, 19.5, 20.5)),
  Producto("Producto 16", "Categoria 1", List(18.0, 19.0, 20.0, 21.0)),
  Producto("Producto 17", "Categoria 2", List(18.5, 19.5, 20.5, 21.5)),
  Producto("Producto 18", "Categoria 3", List(19.0, 20.0, 21.0, 22.0)),
  Producto("Producto 19", "Categoria 4", List(19.5, 20.5, 21.5, 22.5)),
  Producto("Producto 20", "Categoria 5", List(20.0, 21.0, 22.0, 23.0)),
  Producto("Producto 21", "Categoria 1", List(20.5, 21.5, 22.5, 23.5)),
  Producto("Producto 22", "Categoria 2", List(21.0, 22.0, 23.0, 24.0)),
  Producto("Producto 23", "Categoria 3", List(21.5, 22.5, 23.5, 24.5)),
  Producto("Producto 24", "Categoria 4", List(22.0, 23.0, 24.0, 25.0)),
  Producto("Producto 25", "Categoria 5", List(22.5, 23.5, 24.5, 25.5)),
  Producto("Producto 26", "Categoria 1", List(23.0, 24.0, 25.0, 26.0)),
  Producto("Producto 27", "Categoria 2", List(23.5, 24.5, 25.5, 26.5)),
  Producto("Producto 28", "Categoria 3", List(24.0, 25.0, 26.0, 27.0)),
  Producto("Producto 29", "Categoria 4", List(24.5, 25.5, 26.5, 27.5)),
  Producto("Producto 30", "Categoria 5", List(25.0, 26.0, 27.0, 28.0)),
  Producto("Producto 31", "Categoria 1", List(25.5, 26.5, 27.5, 28.5)),
  Producto("Producto 32", "Categoria 2", List(26.0, 27.0, 28.0, 29.0)),
  Producto("Producto 33", "Categoria 3", List(26.5, 27.5, 28.5, 29.5)),
  Producto("Producto 34", "Categoria 4", List(27.0, 28.0, 29.0, 30.0)),
  Producto("Producto 35", "Categoria 5", List(27.5, 28.5, 29.5, 30.5)),
  Producto("Producto 36", "Categoria 1", List(28.0, 29.0, 30.0, 31.0)),
  Producto("Producto 37", "Categoria 2", List(28.5, 29.5, 30.5, 31.5)),
  Producto("Producto 38", "Categoria 3", List(29.0, 30.0, 31.0, 32.0)),
  Producto("Producto 39", "Categoria 4", List(29.5, 30.5, 31.5, 32.5)),
  Producto("Producto 40", "Categoria 5", List(30.0, 31.0, 32.0, 33.0)),
  Producto("Producto 41", "Categoria 1", List(30.5, 31.5, 32.5, 33.5)),
  Producto("Producto 42", "Categoria 2", List(31.0, 32.0, 33.0, 34.0)),
  Producto("Producto 43", "Categoria 3", List(31.5, 32.5, 33.5, 34.5)),
  Producto("Producto 44", "Categoria 4", List(32.0, 33.0, 34.0, 35.0)),
  Producto("Producto 45", "Categoria 5", List(32.5, 33.5, 34.5, 35.5)),
  Producto("Producto 46", "Categoria 1", List(33.0, 34.0, 35.0, 36.0)),
  Producto("Producto 47", "Categoria 2", List(33.5, 34.5, 35.5, 36.5)),
  Producto("Producto 48", "Categoria 3", List(34.0, 35.0, 36.0, 37.0)),
  Producto("Producto 49", "Categoria 4", List(34.5, 35.5, 36.5, 37.5)),
  Producto("Producto 50", "Categoria 5", List(35.0, 36.0, 37.0, 38.0))
)

// Calcular Producto Promedio
def calcularProductoPromedio(inventario: List[Producto], cantidadPrecios: Int, precioBase: Double): List[ProductoPromedio] = {

    inventario
      .filter(producto => producto.precios.length == cantidadPrecios)
      .map(producto => {
        val preciosFiltrados = producto.precios.filter(_ > precioBase)
        val promedio = preciosFiltrados.sum / preciosFiltrados.length
        ProductoPromedio(producto, promedio)
      })

}

def valorPromedioMasAlto(productosPromedio: List[ProductoPromedio]): ProductoPromedio = {
    productosPromedio.maxBy(_.promedio)
}

val productosPromedio: List[ProductoPromedio] = calcularProductoPromedio(inventario, 3, 20.0)
println("Productos Promedio:")
println("--------------------------------")
println(productosPromedio)
println("--------------------------------")

val productoPromedioMasAlto: ProductoPromedio = valorPromedioMasAlto(productosPromedio)
println("Producto Promedio Mas Alto:")
println("--------------------------------")
println(productoPromedioMasAlto)
println("--------------------------------")