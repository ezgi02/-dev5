package com.example.hepsiburada

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.hepsiburada.ui.theme.Orange
import com.example.hepsiburada.R
import com.example.hepsiburada.ui.theme.Gri
import com.example.hepsiburada.ui.theme.Gri2
import com.example.hepsiburada.ui.theme.archivo


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Anasayfa() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .weight(1f) // İçeriği yukarı itmek için
                .verticalScroll(rememberScrollState())
        ) {
            TopBar()
            PromoBar()
            PhotoGallery()
            OfferGridWithImages()
            ProductList()
        }

        // Alt bar sabit
        BottomNavigationBar(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        )
    }
}


//TopBar Kısmı
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 4.dp, vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Arama çubuğu
        TextField(
            value = "",
            onValueChange = {},
            placeholder = {
                Text(
                    text = "Ürün, kategori veya marka ara",
                    color = Color.Gray,
                    fontSize = 13.sp
                )
            },
            modifier = Modifier
                .weight(1f)
                .height(50.dp)
                .background(Color.White, RoundedCornerShape(8.dp))
                .border(1.dp, Gri, RoundedCornerShape(8.dp))
                .drawBehind {
                    // Çizgi renkleri
                    val colors =
                        listOf(Orange, Color.Blue, Color.Green, Color.Yellow, Color.Magenta)
                    val lineWidth = size.width / colors.size
                    val lineHeight = 2.dp.toPx()

                    // Renkli alt çizgi çizimi
                    colors.forEachIndexed { index, color ->
                        drawRect(
                            color = color,
                            topLeft = Offset(
                                x = index * lineWidth,
                                y = size.height - lineHeight
                            ),
                            size = Size(
                                width = lineWidth,
                                height = lineHeight
                            )
                        )
                    }
                },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(8.dp),
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.search),
                    contentDescription = "Search Icon",
                    modifier = Modifier.size(24.dp)
                )
            },
            trailingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.camera),
                    contentDescription = "Camera Icon",
                    modifier = Modifier.size(30.dp)
                )
            }
        )

        Spacer(modifier = Modifier.width(8.dp))

        // Konum kutusu
        Box(
            modifier = Modifier
                .height(50.dp)
                .width(70.dp)
                .background(Color.White, shape = RoundedCornerShape(8.dp))
                .border(
                    width = 1.dp,
                    color = Gri,
                    shape = RoundedCornerShape(8.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.location1),
                        contentDescription = "Location Icon",
                        modifier = Modifier.size(16.dp),
                        tint = Orange
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "Konum",
                        color = Orange,
                        fontSize = 12.sp
                    )
                }
                Text(
                    text = "Lütfen k...",
                    color = Color.Gray,
                    fontSize = 12.sp
                )
            }
        }
    }
}

//Premium ve HepsiPay Kısmı
@Composable
fun PromoBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Premium Kart
        Box(
            modifier = Modifier
                .width(170.dp)
                .height(61.dp)
                .padding(end = 4.dp) // Kartlar arasında boşluk
                .background(
                    Color(0xFF9C27B0),
                    shape = RoundedCornerShape(8.dp)
                ) // Arka plan ve köşeler
                .padding(10.dp) // Kart içeriği için boşluk
        ) {
            Row( verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()) {
                Column {
                    Text(
                        text = "P R E M I U M",
                        color = Color.White,
                        fontFamily = archivo,
                        fontSize = 16.sp
                    )
                    Text(
                        text = "Kargo bedava",
                        color = Color.White,
                        fontSize = 12.sp
                    )
                }
                Icon(
                    painter = painterResource(id = R.drawable.baseline_arrow_forward_ios_24), // Ok ikonu kaynağı
                    contentDescription = "Back Arrow",
                    tint = Color.White,
                    modifier = Modifier
                        .size(24.dp)
                        .padding(start = 7.dp)
                )
            }

        }

        // HepsiPay Kart
        Box(
            modifier = Modifier
                .weight(1f)
                .padding(start = 4.dp)
                .background(
                    Color.Transparent,
                    shape = RoundedCornerShape(8.dp)
                ) // Arka plan rengi değiştirildi
                .border(
                    width = 1.dp,
                    color = Color.Gray,
                    shape = RoundedCornerShape(8.dp)
                ) // Border rengi değiştirildi
                .padding(10.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically // Dikey hizalama
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "hepsipay",
                        color = Color(0xFFFF5722), // Turuncu renk
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold // Yazı tipi kalınlaştırıldı
                    )
                    Text(
                        text = "Her yerde %3 kazan",
                        color = Color.Gray,
                        fontSize = 12.sp
                    )
                }
                Icon(
                    painter = painterResource(id = R.drawable.baseline_arrow_forward_ios_24), // Sağ oka benzer bir ikon
                    contentDescription = null,
                    tint = Color(0xFF9C27B0), // İkon rengi
                    modifier = Modifier.size(20.dp)
                )
                Spacer(
                    modifier = Modifier
                        .width(1.dp) // Çizginin genişliği
                        .height(40.dp) // Çizginin yüksekliği (ikonlarla aynı)
                        .background(Color.Gray) // Çizginin rengi
                )
                Spacer(modifier = Modifier.width(8.dp))
                Icon(
                    painter = painterResource(id = R.drawable.qr_code),
                    contentDescription = null,
                    tint=Color(0xFF9C27B0),
                    modifier = Modifier.size(24.dp)
                )
            }
        }

    }
}
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PhotoGallery() {
    val images = listOf(
        R.drawable.photogalery3 ,
        R.drawable.photogaleri1,
        R.drawable.photogaleri2,
         // Üçüncü resim
    )

    val pagerState = rememberPagerState()

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(3.dp)
            .height(130.dp) // Yükseklik
    ) {
        HorizontalPager(
            count = images.size,
            state = pagerState,
            modifier = Modifier.fillMaxSize()
        ) { page ->
            Image(
                painter = painterResource(id = images[page]),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }

        // Sayfa numarası göstergesi
        Text(
            text = "${pagerState.currentPage + 1}/${images.size}", // Geçerli sayfa/Toplam sayfa
            color = Color.Black,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier
                .align(Alignment.BottomStart) // Sağ alt köşe yerine sol alt köşe
                .padding(8.dp)
        )
    }
}
@Composable
fun OfferGridWithImages() {
    val items = listOf(
        Pair("Alışverişe Başla", R.drawable.bite2),
        Pair("SüperMarket", R.drawable.photo3),
        Pair("Acele Et Kaçırma", R.drawable.bite3),
        Pair("Hepsipay", R.drawable.photo5),
        Pair("Honor Magic V3", R.drawable.photo6),
        Pair("Aradığın Fırsatlar", R.drawable.photo7),
        Pair("HepsiPay", R.drawable.bite4),
        Pair("Küçük Ev Aletleri", R.drawable.bite5)
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(4), // 4 sütunlu grid
        modifier = Modifier
            .fillMaxWidth()
            .height(220.dp)
            .padding(4.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(items) { item ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(4.dp)
            ) {
                // Görsel
                Image(
                    painter = painterResource(id = item.second),
                    contentDescription = null,
                    modifier = Modifier
                        .size(75.dp) // Görsel boyutu
                        .align(Alignment.CenterHorizontally),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.height(2.dp))

                // Metin
                Text(
                    text = item.first, // Tek metin
                    fontSize = 10.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
fun ProductList(){
    val sampleProducts = listOf(
        Product(
            imageRes = R.drawable.mendil,
            title = "Magic Water Painting - Lisanslı Disney Harika Kanatlar",
            price = "149,90 TL"
        ),
        Product(
            imageRes = R.drawable.fincan,
            title = "Maylo Puf Mendil 150'li Tek Paket",
            price = "43,50 TL"
        ),
        Product(
            imageRes = R.drawable.cipsi,
            title = "Oral-B Diş Fırçası Seti",
            price = "89,90 TL"
        )
    )
    Row (modifier= Modifier
        .fillMaxWidth()
        .padding(1.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
        ){
        Text(text = "Popüler ürünlerden seçtik",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.weight(1f))
        TextButton(onClick = { /* Tümü butonuna tıklandığında yapılacaklar */ }) {
            Text(text = "Tümü >", color = Orange)
        }
    }
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(horizontal = 10.dp)
    ) {
        items(sampleProducts) { product ->
            ProductCard(product = product)
        }
    }
}
@Composable
fun ProductCard(product: Product) {
    Box(
        modifier = Modifier
            .padding(2.dp)
            .background(Color.White, shape = RoundedCornerShape(8.dp))
            .border(1.dp, Color.Gray, shape = RoundedCornerShape(8.dp))
            .padding(8.dp)
            .width(120.dp)
    ) {
        // Görsel ve içerik
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
            ) {
                // Ürün görseli
                Image(
                    painter = painterResource(id = product.imageRes),
                    contentDescription = product.title,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(8.dp))
                )

                IconButton(
                    onClick = { /* Favorilere ekleme işlemi */ },
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .offset(x = 16.dp, y = (-13).dp)
                ) {
                    Box(
                        modifier = Modifier
                            .background(color = Gri2, shape = CircleShape) // Gri yuvarlak arka plan
                            .size(30.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.FavoriteBorder,
                            contentDescription = "Add to Favorites",
                            tint = Color.Gray,
                            modifier = Modifier.align(Alignment.Center) // İkonu merkeze hizala
                        )
                    }
                }

            }

            Spacer(modifier = Modifier.height(8.dp))

            // Ürün başlığı
            Text(
                text = product.title,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(4.dp))

            // Ürün fiyatı
            Text(
                text = product.price,
            )

            Spacer(modifier = Modifier.height(4.dp))

            // Beğeni ve derecelendirme
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "Rating",
                    tint = Color.Yellow,
                    modifier = Modifier.size(16.dp)
                )
                Text(
                    text = "4.5 (60)",
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}
