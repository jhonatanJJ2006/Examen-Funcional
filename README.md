# Examen - Análisis de Inventario de Productos

## Prompt del Examen

Cada producto tiene un historial de precios (lista de Double). La gerencia quiere determinar cuál es el producto "más valioso" según su precio promedio, pero solo entre aquellos productos que:

1. Tienen al menos una cierta cantidad mínima de precios registrados.
2. Tienen un precio máximo en su historial mayor a un valor base (por ejemplo, 20.0).

Para registrar el resultado del análisis de manera clara, se pide definir una case class auxiliar:

```scala
case class ProductoPromedio(producto: Producto, promedio: Double)
```

Se debe implementar un método que reciba la lista de productos, el valor base para el precio máximo y la cantidad mínima de precios, y devuelva un valor de tipo ProductoPromedio que represente al producto con el mayor precio promedio entre los que cumplen las condiciones.

El método debe aplicar un algoritmo manual, sin usar groupBy ni tuplas, siguiendo una idea general como la siguiente:

1. Filtrar los productos que tienen suficientes precios en su lista y cuyo precio máximo es mayor que el valor base.
2. Para cada producto que pasó el filtro, calcular el promedio de su lista de precios (suma dividido para cantidad).
3. Construir, para cada producto válido, un objeto ProductoPromedio que almacene el producto original y su promedio.
4. Recorrer la lista de ProductoPromedio y seleccionar aquel que tenga el valor de promedio más alto.

---

## Estructura del Código

### Case Classes Definidas

```scala
case class Producto(nombre: String, categoria: String, precios: List[Double])
case class ProductoPromedio(producto: Producto, promedio: Double)
```

- **Producto**: Representa un producto con su nombre, categoría y un historial de precios.
- **ProductoPromedio**: Estructura auxiliar que almacena un producto junto con su precio promedio calculado.

---

## Funciones Implementadas

### 1. `calcularProductoPromedio`

**Firma:**
```scala
def calcularProductoPromedio(
  inventario: List[Producto], 
  cantidadPrecios: Int, 
  precioBase: Double
): List[ProductoPromedio]
```

**Descripción:**
Filtra y procesa los productos del inventario según los criterios especificados.

**Algoritmo:**
1. **Primer Filtro**: Selecciona productos que tienen al menos `cantidadPrecios` registros en su historial
   ```scala
   .filter(producto => producto.precios.length >= cantidadPrecios)
   ```

2. **Segundo Filtro**: De los productos restantes, selecciona aquellos cuyo precio máximo es mayor a `precioBase`
   ```scala
   .filter(producto => producto.precios.max > precioBase)
   ```

3. **Mapeo**: Para cada producto que cumple ambos criterios, calcula su precio promedio y crea un objeto `ProductoPromedio`
   ```scala
   .map(producto => {
     val promedio = producto.precios.sum / producto.precios.length
     ProductoPromedio(producto, promedio)
   })
   ```

**Parámetros:**
- `inventario`: Lista de productos a analizar
- `cantidadPrecios`: Cantidad mínima de precios requeridos (ej: 3)
- `precioBase`: Valor base para el precio máximo (ej: 20.0)

**Retorna:**
Lista de `ProductoPromedio` con todos los productos que cumplen los criterios.

---

### 2. `valorPromedioMasAlto`

**Firma:**
```scala
def valorPromedioMasAlto(productosPromedio: List[ProductoPromedio]): ProductoPromedio
```

**Descripción:**
Encuentra el producto con el precio promedio más alto de una lista de productos previamente procesados.

**Algoritmo:**
Utiliza el método `maxBy` para seleccionar el `ProductoPromedio` con el valor de `promedio` más alto:
```scala
productosPromedio.maxBy(_.promedio)
```

**Parámetros:**
- `productosPromedio`: Lista de productos con sus promedios calculados

**Retorna:**
El `ProductoPromedio` que tiene el mayor valor promedio.

---

## Ejemplo de Uso

```scala
// Calcular productos que cumplen los criterios
val productosPromedio: List[ProductoPromedio] = 
  calcularProductoPromedio(inventario, 3, 20.0)

// Encontrar el producto con el promedio más alto
val productoPromedioMasAlto: ProductoPromedio = 
  valorPromedioMasAlto(productosPromedio)
```

**Parámetros utilizados:**
- `cantidadPrecios = 3`: Solo productos con al menos 3 precios registrados
- `precioBase = 20.0`: Solo productos cuyo precio máximo supera 20.0

---

## Salida del Programa

El programa imprime dos resultados:

1. **Productos Promedio**: Lista completa de todos los productos que cumplen los criterios, con sus promedios calculados.

2. **Producto Promedio Más Alto**: El producto específico que tiene el mayor precio promedio entre todos los que cumplen los criterios.

---

## Conceptos de Programación Funcional Aplicados

### 1. **Filter (Filtrado)**
Se utiliza para seleccionar elementos que cumplen condiciones específicas:
- Productos con suficientes precios registrados
- Productos con precio máximo sobre el valor base

### 2. **Map (Transformación)**
Transforma cada producto en un objeto `ProductoPromedio`, calculando su promedio:
- Permite mantener la relación entre producto y su promedio calculado
- Crea una nueva estructura de datos sin modificar la original

### 3. **Inmutabilidad**
- Todas las operaciones crean nuevas estructuras de datos
- Los datos originales nunca se modifican
- Se utilizan `val` para valores inmutables

### 4. **Funciones de Orden Superior**
- `filter`, `map`, `maxBy` son funciones que reciben otras funciones como parámetros
- Uso de funciones lambda: `_.promedio`, `_ > precioBase`

### 5. **Case Classes**
- Estructuras de datos inmutables con funcionalidad adicional automática
- Pattern matching y comparación por valor incluidos

---

## Ventajas del Enfoque Funcional

1. **Legibilidad**: El código se lee como una descripción del proceso
2. **Composición**: Las operaciones se encadenan de forma natural
3. **Seguridad**: La inmutabilidad previene efectos secundarios no deseados
4. **Mantenibilidad**: Fácil de modificar y extender
5. **Testeable**: Funciones puras son más fáciles de probar

---

## Datos de Prueba

El inventario contiene 50 productos de prueba:
- 5 categorías diferentes
- 4 precios por producto
- Precios que van desde 10.5 hasta 38.0
- Todos los productos tienen exactamente 4 precios en su historial

Con los parámetros `cantidadPrecios=3` y `precioBase=20.0`, se seleccionan productos que:
- Tienen al menos 3 precios (todos cumplen, tienen 4)
- Su precio máximo es mayor a 20.0 (aproximadamente productos del 14 en adelante)

---

## Autor

Desarrollado como parte del examen de Programación Funcional - UTPL

