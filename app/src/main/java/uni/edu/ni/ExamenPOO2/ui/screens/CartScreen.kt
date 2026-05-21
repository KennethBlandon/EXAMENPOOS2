package uni.edu.ni.ExamenPOO2.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.verticalScroll
import uni.edu.ni.ExamenPOO2.ui.components.ProductCard
import uni.edu.ni.ExamenPOO2.ui.model.Product
import uni.edu.ni.ExamenPOO2.ui.theme.Purple40

@Composable
fun CartScreen(products: List<Product>, onProceed: () -> Unit) {
    val subtotal = products.sumOf { it.price }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text("Tu Carrito", style = MaterialTheme.typography.titleLarge)
        Spacer(Modifier.height(12.dp))

        if (products.isEmpty()) {
            Text("No hay productos disponibles.")
        } else {
            products.forEach {
                ProductCard(product = it)
                Spacer(Modifier.height(6.dp))
            }
        }

        Spacer(Modifier.height(12.dp))

        Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(12.dp)) {
            Column(modifier = Modifier.padding(16.dp)) {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text("Subtotal")
                    Text("$${"%.2f".format(subtotal)}")
                }
                Spacer(Modifier.height(8.dp))
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text("Envío")
                    Text("GRATIS", color = MaterialTheme.colorScheme.primary)
                }
                Divider(modifier = Modifier.padding(vertical = 8.dp))
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text("Total", style = MaterialTheme.typography.titleMedium)
                    Text("$${"%.2f".format(subtotal)}", color = Purple40, style = MaterialTheme.typography.titleMedium)
                }
            }
        }

        Spacer(Modifier.height(24.dp))

        Button(
            onClick = onProceed,
            modifier = Modifier.fillMaxWidth().height(56.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Purple40),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text("Proceder al Pago", color = MaterialTheme.colorScheme.onPrimary)
        }
    }
}

