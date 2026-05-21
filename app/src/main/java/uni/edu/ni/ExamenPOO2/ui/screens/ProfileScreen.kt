package uni.edu.ni.ExamenPOO2.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import uni.edu.ni.ExamenPOO2.ui.model.User
import uni.edu.ni.ExamenPOO2.ui.theme.Purple40

@Composable
fun ProfileScreen(user: User, onEdit: () -> Unit = {}, onLogout: () -> Unit = {}) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(Modifier.height(8.dp))

        Box(modifier = Modifier
            .size(110.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xFFEFEFF4)), contentAlignment = Alignment.Center) {
            Text(user.name.takeIf { it.isNotBlank() } ?: "Avatar", color = Color.Gray)
        }

        Spacer(Modifier.height(12.dp))

        Text(user.name.ifBlank { "Nombre de Usuario" }, style = MaterialTheme.typography.titleLarge)
        Text(user.email.ifBlank { "usuario@ejemplo.com" }, style = MaterialTheme.typography.bodyMedium, color = Color.Gray)

        Spacer(Modifier.height(18.dp))

        Card(modifier = Modifier.fillMaxWidth(), elevation = CardDefaults.cardElevation(4.dp)) {
            Column(modifier = Modifier.padding(12.dp)) {
                Text("Información", style = MaterialTheme.typography.titleMedium)
                Spacer(Modifier.height(8.dp))
                Text("Dirección: ${user.address}", style = MaterialTheme.typography.bodyMedium)
                Text("Teléfono: ${user.phone}", style = MaterialTheme.typography.bodyMedium)
            }
        }

        Spacer(Modifier.height(18.dp))

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            OutlinedButton(onClick = onEdit, modifier = Modifier.weight(1f)) { Text("Editar perfil") }
            Button(onClick = onLogout, modifier = Modifier.weight(1f), colors = ButtonDefaults.buttonColors(containerColor = Purple40)) {
                Text("Cerrar sesión", color = Color.White)
            }
        }
    }
}

