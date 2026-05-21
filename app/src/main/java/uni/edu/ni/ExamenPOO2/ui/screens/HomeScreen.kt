package uni.edu.ni.ExamenPOO2.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import uni.edu.ni.ExamenPOO2.ui.components.ProductCard
import uni.edu.ni.ExamenPOO2.ui.model.Product

@Composable
fun HomeScreen(products: List<Product>, onProductClick: (Product) -> Unit) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Nuevos Productos", style = MaterialTheme.typography.titleLarge)
        Spacer(Modifier.height(12.dp))

        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            products.forEach { p ->
                ProductCard(product = p, onClick = { onProductClick(p) })
            }
        }
    }
}

