package com.example.simpleappcompose

import android.os.Bundle
import android.view.Gravity
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
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
import com.example.simpleappcompose.ui.theme.SimpleAppComposeTheme

class MainActivity : ComponentActivity() {
    private val font = FontFamily(
        Font(R.font.ana,FontWeight.Bold),
        Font(R.font.ana,FontWeight.Normal)
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ){
                Box(modifier = Modifier
                    .fillMaxWidth(.5f)
                    .padding(15.dp)){
                    ImageCard(title ="This is the burger" , desc = "Burger", painter = painterResource(id = R.drawable.burger))

                }
                Text(
                    text = buildAnnotatedString {
                        withStyle(style = SpanStyle(color = Color.Green, fontSize = 80.sp))
                        {
                            append("H")
                        }
                        append("ello ")
                        withStyle(style = SpanStyle(color = Color.Green, fontSize = 80.sp))
                        {
                            append("W")
                        }
                        append("orld")
                    },
                    fontSize = 60.sp,
                    fontFamily = font,
                    fontWeight = FontWeight.Bold,
                    textDecoration = TextDecoration.Underline,
                    textAlign = TextAlign.Center,
                    fontStyle = FontStyle.Italic,
                    color = Color.White
                )
            }

        }
    }
}

@Composable
fun ImageCard(
    title : String,
    desc : String,
    painter: Painter,
    modifier:Modifier = Modifier
){
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(5.dp)
    ) {
        Box (
            modifier = Modifier.height(200.dp)
        ){
            Image(painter = painter, contentDescription = desc, contentScale = ContentScale.Crop)
            Box(modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Color.Black),
                        startY = 300f
                    )
                ))
            Box (modifier = Modifier
                .fillMaxSize()
                .padding(12.dp), contentAlignment = Alignment.BottomStart){
                Text(
                    text = title,
                    style = TextStyle(fontSize = 12.sp, color = Color.White)
                )
            }
        }

    }
}



@Preview(showBackground = true)
@Composable
fun Preview() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ){
        Box(modifier = Modifier
            .fillMaxWidth(.5f)
            .padding(15.dp)){
            ImageCard(title ="This is the burger" , desc = "Burger", painter = painterResource(id = R.drawable.burger))

        }
        Text(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.Green, fontSize = 80.sp))
                {
                    append("H")
                }
                append("ello ")
                withStyle(style = SpanStyle(color = Color.Green, fontSize = 80.sp))
                {
                    append("W")
                }
                append("orld")
            },
            fontSize = 60.sp,
            fontFamily = FontFamily(Font(R.font.ana,FontWeight.Bold)),
            fontWeight = FontWeight.Bold,
            textDecoration = TextDecoration.Underline,
            textAlign = TextAlign.Center,
            fontStyle = FontStyle.Italic,
            color = Color.Black
        )
    }
}