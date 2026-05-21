package uni.edu.ni.ExamenPOO2.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import uni.edu.ni.ExamenPOO2.ui.components.BottomNavigationBar
import uni.edu.ni.ExamenPOO2.ui.components.TopApp
import uni.edu.ni.ExamenPOO2.ui.model.sampleProducts

@Composable
fun ShopApp() {
    var currentScreen by remember { mutableStateOf("home") }
    var selectedProductId by remember { mutableStateOf<Int?>(null) }

    Scaffold(
        topBar = { TopApp(title = "ShopElite", onCart = { currentScreen = "cart" }) },
        bottomBar = { BottomNavigationBar(onSelect = { currentScreen = it }) }
    ) { innerPadding ->
        Box(modifier = Modifier.fillMaxSize().padding(innerPadding)) {
            when (currentScreen) {
                "home" -> HomeScreen(products = sampleProducts, onProductClick = { p -> selectedProductId = p.id; currentScreen = "detail" })
                "detail" -> selectedProductId?.let { id ->
                    val p = sampleProducts.firstOrNull { it.id == id }
                    p?.let { ProductDetailScreen(product = it, onBack = { currentScreen = "home" }, onAddToCart = { currentScreen = "cart" }) }
                }
                "cart" -> CartScreen(onProceed = { currentScreen = "checkout" })
                "checkout" -> CheckoutScreen(onConfirm = { currentScreen = "home" })
                else -> HomeScreen(products = sampleProducts, onProductClick = { p -> selectedProductId = p.id; currentScreen = "detail" })
            }
        }
    }
}



