package com.example.shoppingapp

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shoppingapp.ui.theme.Black
import com.example.shoppingapp.ui.theme.White


@Composable
fun homeUI(){
    Box(modifier = Modifier
        .fillMaxWidth()
        .background(Color.White)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                modifier = Modifier
                    .background(Black)
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Buttons(icon = R.drawable.baseline_menu_24,Color.White)
                Column(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(text = "Shopping App",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.W700,
                            color = Color.White
                        ))
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Buttons(icon = R.drawable.baseline_manage_search_24,Color.White)
                }
            }

                LazyVerticalGrid(columns = GridCells.Fixed(2), content = {
                    items(Data.datalist) {
                        ShowData(data = it)
                    }
                })

        }

    }
}

@Composable
fun Buttons(
    @DrawableRes icon : Int,
    tint : Color = Color.Unspecified,

){
    IconButton(onClick = { /*TODO*/ }) {
        Icon(painter = painterResource(id = icon), contentDescription = "",
            tint = White)
    }
}

@Composable
fun ShowData(data : Data.Demo){
    Card(
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier
            .width(175.dp)
            .height(300.dp)
            .padding(vertical = 5.dp, horizontal = 5.dp)
    ) {
        Box(modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 5.dp, horizontal = 5.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(painter = painterResource(id = data.image), contentDescription = "",
                    modifier = Modifier
                        .size(109.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop

                )

                Text(text = data.price, style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.W400,
                    color = Color.Black),
                    textAlign = TextAlign.Center)

                Text(text = data.title, style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W300),
                    textAlign = TextAlign.Center)

                Text(text = data.disp, style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W300),
                    textAlign = TextAlign.Center)
                
                Button(onClick = { /*TODO*/ },
                    modifier = Modifier.width(91.dp),
                    shape = RoundedCornerShape(18.dp),
                    colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                        containerColor = Color.Black,
                        contentColor = Color.White
                    )) {
                    Text(text = "Add",style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.W600,
                        color = Color.White
                    ), textAlign = TextAlign.Center)
                }
            }
        }

    }
}