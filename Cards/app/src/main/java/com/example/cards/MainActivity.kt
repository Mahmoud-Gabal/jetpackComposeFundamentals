package com.example.cards

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cards.ui.theme.CardsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MakeCards()
        }
    }
}

@Composable
fun ImageCard(){
    Card(
        modifier = Modifier
            .width(150.dp)
            .height(150.dp)
            .padding(start = 10.dp, end = 10.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(15.dp)

    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(.8f),
                painter = painterResource(id = R.drawable.a5)
                , contentDescription ="This is a lion",
                contentScale = ContentScale.Crop
            )
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(1f),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ){
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                color = Color.Red,
                                fontSize = 18.sp
                            )
                        ){append("T")}
                        append("his ")
                        withStyle(
                            style = SpanStyle(
                                color = Color.Red,
                                fontSize = 18.sp
                            )
                        ){append("I")}
                        append("s ")
                        withStyle(
                            style = SpanStyle(
                                color = Color.Red,
                                fontSize = 18.sp
                            )
                        ){append("T")}
                        append("he ")
                        withStyle(
                            style = SpanStyle(
                                color = Color.Red,
                                fontSize = 18.sp
                            )
                        ){append("L")}
                        append("ion")
                    }
                    ,
                    color = Color.Black,fontFamily = FontFamily(Font(R.font.anat,FontWeight.Bold)), fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    textAlign = TextAlign.Center,
                    textDecoration = TextDecoration.Underline,
                    fontStyle = FontStyle.Italic
                )
            }
        }
    }
}
@Composable
fun MakeCards(){
        Row (modifier = Modifier.fillMaxSize().padding(20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Column(
                Modifier
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceEvenly) {
                ImageCard()
                ImageCard()
                ImageCard()
                ImageCard()
            }
            Column(
                Modifier
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceEvenly) {
                ImageCard()
                ImageCard()
                ImageCard()
                ImageCard()
            }
        }

}
@Preview(showBackground = true)
@Composable
fun Preview() {
    MakeCards()
}