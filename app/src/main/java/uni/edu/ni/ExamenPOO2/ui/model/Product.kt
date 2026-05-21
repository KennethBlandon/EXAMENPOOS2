package uni.edu.ni.ExamenPOO2.ui.model

data class Product(
    val id: Int,
    val title: String,
    val category: String,
    val price: Double,
    val rating: Double,
    val isNew: Boolean = false
)

val sampleProducts = listOf(
    Product(1, "Pro Runner X1", "CALZADO DEPORTIVO", 129.0, 4.9),
    Product(2, "HydroSteel Elite", "ACCESORIOS", 45.0, 4.6),
    Product(3, "SonicWave Pro", "ELECTRÓNICA", 199.0, 4.8)
)

