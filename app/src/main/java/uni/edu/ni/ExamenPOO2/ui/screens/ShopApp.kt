package uni.edu.ni.ExamenPOO2.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.ui.Modifier
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.saveable.rememberSaveable
import uni.edu.ni.ExamenPOO2.ui.components.BottomNavigationBar
import uni.edu.ni.ExamenPOO2.ui.components.TopApp
import uni.edu.ni.ExamenPOO2.ui.screens.SearchScreen
import uni.edu.ni.ExamenPOO2.ui.screens.ProfileScreen
import uni.edu.ni.ExamenPOO2.ui.screens.ProfileEditScreen
import uni.edu.ni.ExamenPOO2.ui.model.User
import uni.edu.ni.ExamenPOO2.ui.model.Product
import uni.edu.ni.ExamenPOO2.ui.model.sampleProducts

@Suppress("UNUSED_VALUE", "UNUSED_EXPRESSION")
@Composable
fun ShopApp() {
    var currentScreen by rememberSaveable { mutableStateOf("home") }
    var selectedProductId by rememberSaveable { mutableStateOf<Int?>(null) }
    var editingProductId by rememberSaveable { mutableStateOf<Int?>(null) }
    var pendingDeleteProductId by rememberSaveable { mutableStateOf<Int?>(null) }
    val products = remember { mutableStateListOf<Product>().apply { addAll(sampleProducts) } }

    val selectedProduct = selectedProductId?.let { id -> products.firstOrNull { it.id == id } }
    val productToDelete = pendingDeleteProductId?.let { id -> products.firstOrNull { it.id == id } }
    val cartTotal = products.sumOf { it.price }
    var user by remember { mutableStateOf(User(name = "Erika", email = "erika@example.com", address = "Calle Falsa 123", phone = "+505 8888-8888")) }

    Scaffold(
        topBar = { TopApp(title = "ShopElite", onCart = { currentScreen = "cart" }) },
        bottomBar = {
            BottomNavigationBar(currentScreen = currentScreen, onSelect = { destination ->
                if (destination == "home") {
                    selectedProductId = null
                }
                currentScreen = destination
            })
        },
        floatingActionButton = {
            if (currentScreen == "home") {
                FloatingActionButton(onClick = {
                    selectedProductId = null
                    editingProductId = null
                    currentScreen = "form"
                }) {
                    Icon(Icons.Default.Add, contentDescription = "Agregar producto")
                }
            }
        }
    ) { innerPadding ->
        Box(modifier = Modifier.fillMaxSize().padding(innerPadding)) {
            when (currentScreen) {
                "home" -> HomeScreen(products = products, onProductClick = { p -> selectedProductId = p.id; currentScreen = "detail" })
                "detail" -> selectedProduct?.let { product ->
                    ProductDetailScreen(
                        product = product,
                        onBack = {
                            selectedProductId = null
                            currentScreen = "home"
                        },
                        onAddToCart = { currentScreen = "cart" },
                        onEdit = {
                            editingProductId = product.id
                            currentScreen = "form"
                        },
                        onDelete = {
                            pendingDeleteProductId = product.id
                        }
                    )
                }
                "form" -> {
                    val editingProduct = editingProductId?.let { id -> products.firstOrNull { it.id == id } }
                    ProductFormScreen(
                        product = editingProduct,
                        onCancel = {
                            editingProductId = null
                            currentScreen = if (selectedProduct != null) "detail" else "home"
                        },
                        onSave = { candidateProduct ->
                            if (editingProduct == null) {
                                val newId = (products.maxOfOrNull { it.id } ?: 0) + 1
                                val createdProduct = candidateProduct.copy(id = newId)
                                products.add(createdProduct)
                                selectedProductId = newId
                            } else {
                                val index = products.indexOfFirst { it.id == candidateProduct.id }
                                if (index >= 0) {
                                    products[index] = candidateProduct
                                }
                                selectedProductId = candidateProduct.id
                            }

                            editingProductId = null
                            currentScreen = "detail"
                        }
                    )
                }
                "cart" -> CartScreen(products = products, onProceed = { currentScreen = "checkout" })
                "search" -> SearchScreen(products = products, onProductClick = { p -> selectedProductId = p.id; currentScreen = "detail" })
                "profile" -> ProfileScreen(user = user, onEdit = { currentScreen = "profile_edit" }, onLogout = { /* Simular cierre */ currentScreen = "home" })
                "profile_edit" -> ProfileEditScreen(user = user, onCancel = { currentScreen = "profile" }, onSave = { updated -> user = updated; currentScreen = "profile" })
                "checkout" -> CheckoutScreen(subtotal = cartTotal, itemCount = products.size, onConfirm = {
                    selectedProductId = null
                    currentScreen = "home"
                })
                else -> HomeScreen(products = products, onProductClick = { p -> selectedProductId = p.id; currentScreen = "detail" })
            }

            productToDelete?.let { product ->
                AlertDialog(
                    onDismissRequest = { pendingDeleteProductId = null },
                    title = { Text("Eliminar producto") },
                    text = { Text("¿Deseas eliminar \"${product.title}\"? Esta acción no se puede deshacer.") },
                    confirmButton = {
                        TextButton(onClick = {
                            products.removeAll { it.id == product.id }
                            if (selectedProductId == product.id) {
                                selectedProductId = null
                            }
                            if (editingProductId == product.id) {
                                editingProductId = null
                            }
                            pendingDeleteProductId = null
                            currentScreen = "home"
                        }) {
                            Text("Eliminar")
                        }
                    },
                    dismissButton = {
                        TextButton(onClick = { pendingDeleteProductId = null }) {
                            Text("Cancelar")
                        }
                    }
                )
            }
        }
    }
}



