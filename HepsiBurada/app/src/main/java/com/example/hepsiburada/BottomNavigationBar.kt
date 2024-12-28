package com.example.hepsiburada

import androidx.compose.foundation.layout.*
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hepsiburada.R

@Composable
fun BottomNavigationBar(modifier: Modifier = Modifier) {
    NavigationBar(
        containerColor = Color.White,
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp) // Yükseklik optimize edildi
    ) {
        val items = listOf(
            Pair("Ana Sayfam", R.drawable.home),
            Pair("Listelerim", R.drawable.heart),
            Pair("Sepetim", R.drawable.cart),
            Pair("Hesabım", R.drawable.user),
            Pair("Kategoriler", R.drawable.category)
        )

        items.forEachIndexed { index, item ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        painter = painterResource(id = item.second),
                        contentDescription = item.first,
                        modifier = Modifier.size(25.dp),
                        tint = if (index == 0) Color(0xFFFF5722) else Color.Gray // "Ana Sayfam" turuncu, diğerleri gri
                    )
                },
                label = {
                    Text(
                        text = item.first,
                        fontSize = 7.sp, // Yazı boyutu optimize edildi
                        color = if (index == 0) Color(0xFFFF5722) else Color.Gray, // "Ana Sayfam" yazısı turuncu, diğerleri gri
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                selected = index == 0, // İlk öğe seçili
                onClick = { /* Şimdilik manuel, dinamik seçim eklenebilir */ },
                alwaysShowLabel = true
            )
        }
    }
}
