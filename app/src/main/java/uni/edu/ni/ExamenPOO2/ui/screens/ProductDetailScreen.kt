package uni.edu.ni.ExamenPOO2.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.foundation.border
import androidx.compose.foundation.rememberScrollState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import uni.edu.ni.ExamenPOO2.ui.model.Product
import uni.edu.ni.ExamenPOO2.ui.theme.Purple40

@Composable
fun ProductDetailScreen(
    product: Product,
    onBack: () -> Unit,
    onAddToCart: () -> Unit,
    onEdit: () -> Unit,
    onDelete: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
            IconButton(onClick = onBack) { Icon(Icons.Default.FavoriteBorder, contentDescription = "back") }
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                OutlinedButton(onClick = onEdit) { Text("Editar") }
                OutlinedButton(onClick = onDelete) { Text("Eliminar") }
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(260.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Color(0xFFEFEFF4))
        )

        Spacer(Modifier.height(16.dp))

        Text(product.category, style = MaterialTheme.typography.labelSmall, color = Color.Gray)
        Text(product.title, style = MaterialTheme.typography.titleLarge)
        Text("$${"%.2f".format(product.price)}", color = Purple40, style = MaterialTheme.typography.titleMedium)
        Text("Valoración: ${"%.1f".format(product.rating)} / 5", style = MaterialTheme.typography.bodyMedium, color = Color.Gray)

        if (product.isNew) {
            Spacer(Modifier.height(6.dp))
            Text("Nuevo lanzamiento", color = Purple40, style = MaterialTheme.typography.labelMedium)
        }

        Spacer(Modifier.height(12.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            listOf(Color.Red, Color(0xFF1E1EFA), Color.Black, Color.Gray).forEach { c ->
                Box(modifier = Modifier
                    .size(28.dp)
                    .clip(CircleShape)
                    .background(c)
                    .border(width = 2.dp, color = Color.LightGray, shape = CircleShape))
            }
        }

        Spacer(Modifier.height(12.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            listOf("38", "39", "40", "41", "42").forEach { s ->
                OutlinedButton(onClick = {}) { Text(s) }
            }
        }

        Spacer(Modifier.height(12.dp))

        Text("Descripción", style = MaterialTheme.typography.titleMedium)
        Text(
            "Diseñado para atletas de alto rendimiento. La malla transpirable mantiene tus pies frescos mientras que la estructura reforzada ofrece estabilidad.",
            style = MaterialTheme.typography.bodyMedium,
            maxLines = 4
        )

        Spacer(Modifier.height(24.dp))

        Button(
            onClick = onAddToCart,
            modifier = Modifier.fillMaxWidth().height(56.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Purple40),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text("Añadir al carrito", color = Color.White)
        }
    }
}


