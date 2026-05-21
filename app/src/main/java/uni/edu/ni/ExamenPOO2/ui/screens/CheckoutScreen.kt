package uni.edu.ni.ExamenPOO2.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.clickable
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp

import uni.edu.ni.ExamenPOO2.ui.theme.Purple40

@Composable
fun CheckoutScreen(subtotal: Double, itemCount: Int, onConfirm: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text("Información de Envío", style = MaterialTheme.typography.titleLarge)
        Spacer(Modifier.height(12.dp))

        var name by remember { mutableStateOf("") }
        var address by remember { mutableStateOf("") }
        var city by remember { mutableStateOf("") }
        var postal by remember { mutableStateOf("") }

        OutlinedTextField(value = name, onValueChange = { name = it }, placeholder = { Text("Ej. Juan Pérez") }, modifier = Modifier.fillMaxWidth())
        Spacer(Modifier.height(8.dp))
        OutlinedTextField(value = address, onValueChange = { address = it }, placeholder = { Text("Calle, número, departamento") }, modifier = Modifier.fillMaxWidth())
        Spacer(Modifier.height(8.dp))

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            OutlinedTextField(value = city, onValueChange = { city = it }, placeholder = { Text("Ciudad") }, modifier = Modifier.weight(1f))
            OutlinedTextField(value = postal, onValueChange = { postal = it }, placeholder = { Text("Código Postal") }, modifier = Modifier.width(120.dp))
        }

        Spacer(Modifier.height(16.dp))
        Text("Método de Pago", style = MaterialTheme.typography.titleMedium)
        Spacer(Modifier.height(8.dp))

        var selected by remember { mutableStateOf("card") }
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            Card(modifier = Modifier.weight(1f).clickable { selected = "card" }, colors = CardDefaults.cardColors(containerColor = if (selected == "card") Purple40.copy(alpha = 0.12f) else MaterialTheme.colorScheme.surface), shape = RoundedCornerShape(12.dp)) {
                Row(modifier = Modifier.padding(12.dp), verticalAlignment = Alignment.CenterVertically) {
                    Text("Tarjeta")
                }
            }
            Card(modifier = Modifier.weight(1f).clickable { selected = "paypal" }, shape = RoundedCornerShape(12.dp)) {
                Row(modifier = Modifier.padding(12.dp), verticalAlignment = Alignment.CenterVertically) { Text("PayPal") }
            }
        }

        Spacer(Modifier.height(12.dp))
        var cardNumber by remember { mutableStateOf("") }
        var expiry by remember { mutableStateOf("") }
        var cvv by remember { mutableStateOf("") }

        OutlinedTextField(value = cardNumber, onValueChange = { cardNumber = it }, placeholder = { Text("0000 0000 0000 0000") }, modifier = Modifier.fillMaxWidth())
        Spacer(Modifier.height(8.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            OutlinedTextField(value = expiry, onValueChange = { expiry = it }, placeholder = { Text("MM/AA") }, modifier = Modifier.weight(1f))
            OutlinedTextField(value = cvv, onValueChange = { cvv = it }, placeholder = { Text("CVV") }, modifier = Modifier.width(100.dp))
        }

        Spacer(Modifier.height(24.dp))

        Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(12.dp)) {
            Column(modifier = Modifier.padding(12.dp)) {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text("Subtotal ($itemCount items)")
                    Text("$${"%.2f".format(subtotal)}")
                }
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text("Envío")
                    Text("Gratis", color = MaterialTheme.colorScheme.primary)
                }
                HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text("Total")
                    Text("$${"%.2f".format(subtotal)}", color = Purple40, style = MaterialTheme.typography.titleMedium)
                }
            }
        }

        Spacer(Modifier.height(12.dp))

        Button(onClick = onConfirm, modifier = Modifier.fillMaxWidth().height(56.dp), colors = ButtonDefaults.buttonColors(containerColor = Purple40), shape = RoundedCornerShape(12.dp)) {
            Text("Confirmar Compra", color = MaterialTheme.colorScheme.onPrimary)
        }
    }
}




