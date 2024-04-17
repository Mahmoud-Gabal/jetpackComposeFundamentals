package com.example.stateclickable

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxHeight

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.stateclickable.ui.theme.StateClickableTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Column(modifier = Modifier.fillMaxSize()) {
                val color1 = remember {
                    mutableStateOf(Color.Black)
                }
                ClickBox(
                    Modifier
                        .background(color1.value)
                        .fillMaxWidth()
                        .fillMaxHeight(.5f),
                    Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(1f)
                ){
                    color1.value = it
                }
            }

        }
    }
}

@Composable
fun ClickBox(
    modifier1: Modifier = Modifier
    , modifier2:Modifier = Modifier,
   UpadteColor1 : (Color) -> Unit ){

        val color2 = remember {
            mutableStateOf(Color.Red)
        }
        Box (modifier = modifier1
            .clickable {
                 color2.value = Color(Random.nextFloat(),Random.nextFloat(),Random.nextFloat(),1f)
            }
        )
        Box (modifier = modifier2
            .background(color2.value)
            .clickable {
                UpadteColor1(Color(Random.nextFloat(), Random.nextFloat(), Random.nextFloat(), 1f))
            }
        )

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

}