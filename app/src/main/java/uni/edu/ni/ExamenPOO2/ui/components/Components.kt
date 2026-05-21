package uni.edu.ni.ExamenPOO2.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import uni.edu.ni.ExamenPOO2.ui.model.Product
import uni.edu.ni.ExamenPOO2.ui.theme.Purple40

@Composable
fun TopApp(title: String, onMenu: () -> Unit = {}, onCart: () -> Unit = {}) {
    Surface(tonalElevation = 2.dp) {
        Row(modifier = Modifier.fillMaxWidth().padding(12.dp), verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = onMenu) { Icon(Icons.Default.Menu, contentDescription = "menu") }
            Spacer(Modifier.width(8.dp))
            Text(title, style = MaterialTheme.typography.titleLarge, modifier = Modifier.weight(1f))
            IconButton(onClick = onCart) { Icon(Icons.Default.ShoppingCart, contentDescription = "cart") }
        }
    }
}

@Composable
fun BottomNavigationBar(currentScreen: String, onSelect: (String) -> Unit) {
    NavigationBar {
        NavigationBarItem(selected = currentScreen == "home", onClick = { onSelect("home") }, icon = { Text("Home") }, label = null)
        NavigationBarItem(selected = currentScreen == "search", onClick = { onSelect("search") }, icon = { Text("Search") }, label = null)
        NavigationBarItem(selected = currentScreen == "cart", onClick = { onSelect("cart") }, icon = { Text("Cart") }, label = null)
        NavigationBarItem(selected = currentScreen == "profile", onClick = { onSelect("profile") }, icon = { Text("Profile") }, label = null)
    }
}

@Composable
fun ProductCard(product: Product, onClick: () -> Unit = {}) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Row(modifier = Modifier.fillMaxSize().padding(12.dp), verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(96.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color(0xFFEFEFF4))
            )

            Spacer(Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.SpaceBetween) {
                Column {
                    Text(product.title, style = MaterialTheme.typography.titleMedium)
                    Text(product.category, style = MaterialTheme.typography.labelSmall, color = Color.Gray)
                    Text("Valoración: ${"%.1f".format(product.rating)}", style = MaterialTheme.typography.labelSmall, color = Color.Gray)
                    if (product.isNew) {
                        Text("Nuevo", style = MaterialTheme.typography.labelSmall, color = Purple40)
                    }
                }

                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                    Text("$${"%.2f".format(product.price)}", color = Purple40)
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        OutlinedButton(onClick = {}) { Text("-") }
                        Spacer(Modifier.width(8.dp))
                        Text("1")
                        Spacer(Modifier.width(8.dp))
                        OutlinedButton(onClick = {}) { Text("+") }
                    }
                }
            }
        }
    }
}


