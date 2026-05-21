package uni.edu.ni.ExamenPOO2.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import uni.edu.ni.ExamenPOO2.ui.model.Product
import uni.edu.ni.ExamenPOO2.ui.theme.Purple40

@Composable
fun ProductFormScreen(
    product: Product?,
    onSave: (Product) -> Unit,
    onCancel: () -> Unit
) {
    val isEditing = product != null

    var title by remember(product?.id) { mutableStateOf(product?.title.orEmpty()) }
    var category by remember(product?.id) { mutableStateOf(product?.category.orEmpty()) }
    var priceText by remember(product?.id) { mutableStateOf(product?.price?.toString().orEmpty()) }
    var ratingText by remember(product?.id) { mutableStateOf(product?.rating?.toString().orEmpty()) }
    var isNew by remember(product?.id) { mutableStateOf(product?.isNew ?: false) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    fun saveProduct() {
        val trimmedTitle = title.trim()
        val trimmedCategory = category.trim()
        val priceValue = priceText.replace(',', '.').toDoubleOrNull()
        val ratingValue = ratingText.replace(',', '.').toDoubleOrNull()

        errorMessage = when {
            trimmedTitle.isEmpty() -> "El nombre del producto es obligatorio."
            trimmedCategory.isEmpty() -> "La categoría es obligatoria."
            priceValue == null || priceValue <= 0.0 -> "Ingresa un precio válido mayor que 0."
            ratingValue == null || ratingValue < 0.0 || ratingValue > 5.0 -> "La valoración debe estar entre 0 y 5."
            else -> null
        }

        if (errorMessage == null && priceValue != null && ratingValue != null) {
            onSave(
                Product(
                    id = product?.id ?: 0,
                    title = trimmedTitle,
                    category = trimmedCategory,
                    price = priceValue,
                    rating = ratingValue,
                    isNew = isNew
                )
            )
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = if (isEditing) "Editar producto" else "Nuevo producto",
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(Modifier.height(16.dp))

        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Nombre") }
        )
        Spacer(Modifier.height(8.dp))

        OutlinedTextField(
            value = category,
            onValueChange = { category = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Categoría") }
        )
        Spacer(Modifier.height(8.dp))

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            OutlinedTextField(
                value = priceText,
                onValueChange = { priceText = it },
                modifier = Modifier.weight(1f),
                label = { Text("Precio") },
                singleLine = true
            )
            OutlinedTextField(
                value = ratingText,
                onValueChange = { ratingText = it },
                modifier = Modifier.weight(1f),
                label = { Text("Valoración") },
                singleLine = true
            )
        }

        Spacer(Modifier.height(12.dp))

        Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
            Checkbox(checked = isNew, onCheckedChange = { isNew = it })
            Text("Marcar como nuevo")
        }

        errorMessage?.let {
            Spacer(Modifier.height(8.dp))
            Text(it, color = MaterialTheme.colorScheme.error)
        }

        Spacer(Modifier.height(24.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            OutlinedButton(
                onClick = onCancel,
                modifier = Modifier.weight(1f)
            ) {
                Text("Cancelar")
            }
            Button(
                onClick = { saveProduct() },
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(containerColor = Purple40)
            ) {
                Text("Guardar", color = Color.White)
            }
        }
    }
}


