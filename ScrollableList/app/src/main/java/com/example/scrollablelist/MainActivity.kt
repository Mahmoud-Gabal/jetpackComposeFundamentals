package com.example.scrollablelist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.scrollablelist.ui.theme.ScrollableListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                itemsIndexed(
                    listOf(R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4,R.drawable.a5,
                        R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4,R.drawable.a5)
                ){index, item ->
                    Image(painter = painterResource(id = item)
                        , contentDescription ="this is photo number ${index+1}"
                        , modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 12.dp),
                        contentScale = ContentScale.Crop)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
   LazyColumn(modifier = Modifier.fillMaxSize()) {
        itemsIndexed(
            listOf(R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4,R.drawable.a5,
                R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4,R.drawable.a5)
        ){index, item ->
            Image(painter = painterResource(id = item)
                , contentDescription ="this is photo number ${index+1}"
                    , modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp),
                contentScale = ContentScale.Crop)
        }
   }
}