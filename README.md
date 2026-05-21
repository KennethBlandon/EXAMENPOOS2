# ShopElite - E-Commerce Android App

## Descripción

**ShopElite** es una aplicación móvil Android moderna desarrollada en **Kotlin** con **Jetpack Compose** y **Material Design 3**. Es una tienda en línea (e-commerce) que permite a los usuarios explorar productos, ver detalles, agregar artículos al carrito y completar el proceso de compra de manera intuitiva.

La aplicación está diseñada siguiendo principios de **arquitectura modular**, separación de responsabilidades y buenas prácticas de desarrollo Android, facilitando el mantenimiento y la escalabilidad del código.

---

## Funcionalidades Principales

### 1. **Pantalla de Inicio (Home)**
- Lista de nuevos productos disponibles
- Tarjetas de producto con información resumida (nombre, categoría, precio)
- Controles de cantidad (+/-)
- Navegación directa a detalles del producto

### 2. **Detalles del Producto (Product Detail)**
- Visualización completa de un producto
- Descripción detallada del artículo
- Selector de colores (display: 4 opciones de color)
- Selector de talla/tamaño (opciones: 38, 39, 40, 41, 42 para calzado)
- Botón "Favoritos" para guardar productos
- Botón prominente "Añadir al carrito"
- Precio destacado en color morado

### 3. **Carrito de Compras (Cart)**
- Vista de todos los productos agregados
- Controles para modificar cantidades (sumar/restar)
- Tarjeta de resumen con:
  - Subtotal
  - Costo de envío (GRATIS en esta versión)
  - Total a pagar
- Botón para proceder al pago

### 4. **Proceso de Compra (Checkout)**
- **Información de Envío:**
  - Nombre completo
  - Dirección de entrega
  - Ciudad
  - Código postal
  
- **Método de Pago:**
  - Selector de método (Tarjeta de crédito/débito o PayPal)
  - Campos para datos de tarjeta:
    - Número de tarjeta
    - Fecha de vencimiento (MM/AA)
    - CVV
  
- **Resumen de Compra:**
  - Desglose de costos
  - Total final en color morado
  - Botón "Confirmar Compra"

### 5. **Navegación Global**
- **Top Bar:** Logo "ShopElite", botón de menú, icono de carrito
- **Bottom Navigation:** Acceso rápido a:
  - Home (inicio)
  - Search (búsqueda - pantalla base)
  - Cart (carrito)
  - Profile (perfil - pantalla base)

---

## Arquitectura y Estructura del Proyecto

### Organización Modular

```
app/src/main/java/uni/edu/ni/ExamenPOO2/
├── MainActivity.kt                    # Punto de entrada de la aplicación
├── ui/
│   ├── model/
│   │   └── Product.kt                 # Data class y datos de ejemplo
│   ├── components/
│   │   └── Components.kt              # Componentes reutilizables
│   ├── screens/
│   │   ├── ShopApp.kt                 # Orquestador de navegación
│   │   ├── HomeScreen.kt              # Pantalla de inicio
│   │   ├── ProductDetailScreen.kt     # Detalles del producto
│   │   ├── CartScreen.kt              # Carrito de compras
│   │   └── CheckoutScreen.kt          # Proceso de checkout
│   └── theme/
│       ├── Color.kt                   # Paleta de colores
│       ├── Theme.kt                   # Tema Material 3
│       └── Type.kt                    # Tipografía
```

### Componentes Reutilizables (`Components.kt`)
- **`TopApp`**: Barra superior con menú y carrito
- **`BottomNavigationBar`**: Navegación inferior con 4 opciones
- **`ProductCard`**: Tarjeta de producto con imagen placeholder, nombre, categoría, precio y controles de cantidad

---

## Tecnologías Utilizadas

### Lenguaje y Framework
- **Kotlin** - Lenguaje principal de development
- **Jetpack Compose** - Framework UI moderno y declarativo
- **Material Design 3** - Diseño y componentes visuales

### Dependencias Principales
- `androidx.activity:activity-compose` - Integración de Compose con Activity
- `androidx.compose.material3` - Componentes Material 3
- `androidx.compose.foundation` - Fundamentos de Compose
- `androidx.compose.ui` - APIs de UI base

### Build Tools
- **Gradle** v9.3.1 - Sistema de construcción
- **Android SDK** - Para compilación y ejecución
- **Kotlin Compiler** - Compilación de código Kotlin

---

## Requisitos Previos

### Sistema
- **Android Studio** 2023.1 o superior (o Android Studio Hedgehog/Iguana recomendado)
- **JDK** 17 o superior
- **Android API Level** 24+ (API 24: Android 7.0 mínimo)

### Hardware
- Emulador de Android o dispositivo Android físico
- Mínimo 2 GB de RAM para el emulador
- 500 MB de espacio libre en disco

---

## Instalación y Configuración

### 1. Clonar/Descargar el Proyecto
```bash
# Si la app está en un repositorio
git clone <URL-del-repositorio>
cd ExamenPOO2

# O simplemente abre el proyecto desde Android Studio
# File > Open > Selecciona la carpeta del proyecto
```

### 2. Sincronizar Gradle
```bash
# Desde PowerShell en Windows (en la raíz del proyecto)
.\gradlew.bat clean
.\gradlew.bat sync
```

### 3. Compilar el Proyecto
```bash
# Compilar y generar APK de debug
.\gradlew.bat assembleDebug

# O para release
.\gradlew.bat assembleRelease
```

### 4. Ejecutar en Emulador o Dispositivo
- **Desde Android Studio:**
  - Run > Run 'app'
  - Selecciona el dispositivo o emulador
  - Presiona Enter o haz clic en Play

- **Desde línea de comandos:**
```bash
# Instalar en dispositivo/emulador conectado
.\gradlew.bat installDebug
```

---

## Uso de la Aplicación

### Flujo de Usuario Principal

1. **Explorar Productos (Home)**
   - La app abre en la pantalla de inicio
   - Se muestran 3 productos de ejemplo
   - Toca una tarjeta para ver detalles

2. **Ver Detalles del Producto**
   - Observa descripción, colores disponibles, tallas
   - Selecciona color y talla (si lo deseas)
   - Haz clic en "Añadir al carrito"

3. **Gestionar Carrito**
   - Desde la barra inferior o top bar, accede a "Cart"
   - Observa el total y puedes modificar cantidades
   - Presiona "Proceder al Pago"

4. **Completar Compra (Checkout)**
   - Ingresa datos de envío (nombre, dirección, ciudad, código postal)
   - Selecciona método de pago (Tarjeta o PayPal)
   - Completa los datos de pago (números ficticios en demo)
   - Revisa el resumen final
   - Presiona "Confirmar Compra"

5. **Volver a Inicio**
   - Tras confirmar, regresa a la pantalla de inicio
   - Puedes repetir el proceso

### Navegación
- **Top Bar (Arriba):** Toca el icono del carrito para ir directamente al carrito
- **Bottom Navigation (Abajo):** Navega entre Home, Search, Cart y Profile
- **Botones de Pantalla:** Botones contextuales para acciones específicas (Atrás, Favorito, Añadir, etc.)

---

## Datos de Ejemplo

La app incluye 3 productos de demostración:

| Producto | Categoría | Precio | Rating |
|----------|-----------|--------|--------|
| Pro Runner X1 | CALZADO DEPORTIVO | $129.00 | 4.9 ⭐ |
| HydroSteel Elite | ACCESORIOS | $45.00 | 4.6 ⭐ |
| SonicWave Pro | ELECTRÓNICA | $199.00 | 4.8 ⭐ |

*Nota: Estos datos son ficticios y se cargan desde `Product.kt`. Pueden reemplazarse fácilmente con una API real.*

---

## Diseño Visual

### Paleta de Colores
- **Morado Principal:** `#6650a4` (Purple40) - Usado para botones, textos destacados y acentos
- **Gris Claro:** `#EFEFF4` - Fondos de placeholders
- **Verde (Envío Gratis):** `#0B8043` - Indicadores positivos
- **Blanco:** Fondos principales

### Placeholders
- Las imágenes se muestran como cajas grises (`Box` con fondo claro)
- Listas de ejemplo con datos literales
- Diseño sin dependencias externas de imágenes (facilita demostración)

---

## Notas Importantes

### Estado Actual (Demo)
- **Datos:** Los productos son datos en memoria (`sampleProducts`) - no hay persistencia
- **Navegación:** Sistema simple basado en estado (`mutableStateOf`) - no usa Navigation Compose
- **Pago:** No hay integración real con pasarelas de pago (es un formulario visual)
- **Imágenes:** Se usan placeholders en lugar de imágenes reales

### Limitaciones Conocidas
- Los formularios de checkout no validan datos (es funcional visual)
- No hay autenticación de usuario
- No hay sincronización con backend
- Las imágenes no se cargan realmente

---

## Flujo de Código Destacado

### Navegación Simple (ShopApp.kt)
```kotlin
var currentScreen by remember { mutableStateOf("home") }

when (currentScreen) {
    "home" -> HomeScreen(...)
    "detail" -> ProductDetailScreen(...)
    "cart" -> CartScreen(...)
    "checkout" -> CheckoutScreen(...)
}
```

### Reutilización de Componentes
```kotlin
// En HomeScreen
products.forEach { p ->
    ProductCard(product = p, onClick = { onProductClick(p) })
}

// En CartScreen
sampleProducts.forEach {
    ProductCard(product = it)
}
```

---

## Próximas Mejoras y Extensiones

### Corto Plazo
- [ ] Reemplazar `Divider` con `HorizontalDivider` (actualizar Material Design 3)
- [ ] Agregar previews de Composables para vista en tiempo real en Android Studio
- [ ] Validación de formularios en Checkout

### Mediano Plazo
- [ ] Migrar a **Navigation Compose** para navegación más robusta
- [ ] Integrar **Coil** para cargar imágenes desde URLs
- [ ] Implementar **ViewModel** y **LiveData** para gestión de estado
- [ ] Agregar **Room Database** para persistencia local de carrito

### Largo Plazo
- [ ] Backend con **Retrofit** + API REST
- [ ] Autenticación con Firebase o servicio propio
- [ ] Integración con pasarelas de pago (Stripe, PayPal)
- [ ] Búsqueda y filtrado de productos
- [ ] Historial de pedidos
- [ ] Sistema de reseñas y valoraciones

---

## Estructura de Archivos Detallada

### `app/src/main/java/uni/edu/ni/ExamenPOO2/`

- **`MainActivity.kt`** (47 líneas)
  - Entry point de la aplicación
  - Configura tema y lanza `ShopApp()`

### `ui/model/`

- **`Product.kt`** (21 líneas)
  - Data class `Product` con propiedades
  - Lista `sampleProducts` con 3 ejemplos

### `ui/components/`

- **`Components.kt`** (85 líneas)
  - `TopApp()` - Barra superior personalizada
  - `BottomNavigationBar()` - Navegación inferior
  - `ProductCard()` - Tarjeta reutilizable de producto

### `ui/screens/`

- **`ShopApp.kt`** (39 líneas)
  - Orquestador principal
  - Gestión de estado y navegación

- **`HomeScreen.kt`** (24 líneas)
  - Pantalla de listado de productos

- **`ProductDetailScreen.kt`** (83 líneas)
  - Vista detallada de un producto
  - Selectores de color y talla

- **`CartScreen.kt`** (51 líneas)
  - Carrito de compras
  - Resumen de totales

- **`CheckoutScreen.kt`** (88 líneas)
  - Formularios de envío
  - Formularios de pago
  - Resumen final

### `ui/theme/`

- **`Color.kt`** (11 líneas)
  - Definiciones de colores Material 3

- **`Theme.kt`** (58 líneas)
  - Configuración del tema global

- **`Type.kt`** (34 líneas)
  - Estilos de tipografía

---

## Compilación y Testing

### Compilación
```bash
# Debug
.\gradlew.bat assembleDebug

# Release
.\gradlew.bat assembleRelease

# Clean + Build
.\gradlew.bat clean build
```

### Ejecutar Tests (si existen)
```bash
# Tests unitarios
.\gradlew.bat test

# Tests instrumentados (en dispositivo/emulador)
.\gradlew.bat connectedAndroidTest
```

---

## Licencia

Esta aplicación fue desarrollada como un proyecto educativo (Examen POO2). 
Puedes usarla, modificarla y distribuirla según lo requiera tu institución educativa.

---

## Autor

**Desarrollado por:** Kenneth  
**Plataforma:** Android Studio  
**Lenguaje:** Kotlin + Jetpack Compose  
**Fecha:** Mayo 2026

---

## Soporte y Contribuciones

Para reportar errores o sugerencias de mejora:
1. Abre un Issue en el proyecto
2. Describe claramente el problema o sugerencia
3. Proporciona pasos para reproducir (si es un error)

---

## Propósito Educativo

Esta aplicación fue desarrollada como proyecto final para demostrar:
- ✅ Arquitectura modular en Android
- ✅ Uso de Jetpack Compose
- ✅ Material Design 3
- ✅ Composables reutilizables
- ✅ Gestión de estado en Compose
- ✅ Navegación y flujo de aplicación
- ✅ Buenas prácticas de desarrollo Kotlin

---

## Recursos Adicionales

- [Documentación oficial de Android](https://developer.android.com/)
- [Jetpack Compose Docs](https://developer.android.com/jetpack/compose)
- [Material Design 3](https://m3.material.io/)
- [Kotlin Official Documentation](https://kotlinlang.org/docs/)

---

**¡Gracias por revisar ShopElite!** 💜

