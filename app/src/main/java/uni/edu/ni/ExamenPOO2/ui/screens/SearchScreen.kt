package uni.edu.ni.ExamenPOO2.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import uni.edu.ni.ExamenPOO2.ui.components.ProductCard
import uni.edu.ni.ExamenPOO2.ui.model.Product
import androidx.compose.material3.TextField

@Composable
fun SearchScreen(products: List<Product>, onProductClick: (Product) -> Unit) {
    var query by remember { mutableStateOf("") }

    val filtered = remember(query, products) {
        if (query.isBlank()) products
        else products.filter { p ->
            p.title.contains(query, ignoreCase = true) || p.category.contains(query, ignoreCase = true)
        }
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {

        Text("Buscar", style = MaterialTheme.typography.titleLarge)
        Spacer(Modifier.height(8.dp))

        TextField(
            value = query,
            onValueChange = { query = it },
            placeholder = { Text("Buscar por nombre o categoría") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(12.dp))

        if (filtered.isEmpty()) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = androidx.compose.ui.Alignment.Center) {
                Text("No se encontraron productos que coincidan.")
            }
        } else {
            LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                items(filtered) { p ->
                    ProductCard(product = p, onClick = { onProductClick(p) })
                }
            }
        }
    }
}

