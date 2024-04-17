package com.example.constraintlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.example.constraintlayout.ui.theme.ConstraintLayoutTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        setContent {
            val constraints = ConstraintSet{
                val image1 = createRefFor("ImageFirst")
                var EditText = createRefFor("et")
                var Buttun = createRefFor("btn")

                constrain(image1){
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                    start.linkTo(parent.start)
                    width = Dimension.value(150.dp)
                    height = Dimension.value(150.dp)
                }
                constrain(EditText){
                    top.linkTo(image1.bottom, margin = 12.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                constrain(Buttun){
                    top.linkTo(EditText.bottom, margin = 12.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
            }
                var textFieldState by remember {
                    mutableStateOf("")
                }
                val mysnapbar = remember {
                    SnackbarHostState()
                }
                val scope = rememberCoroutineScope()
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    snackbarHost = {SnackbarHost(mysnapbar)}
                ) {
                    Column(modifier = Modifier
                        .fillMaxSize()
                        .padding(it)) {
                        ConstraintLayout(constraints, modifier = Modifier.fillMaxSize()) {
                            Image(
                                painter = painterResource(id = R.drawable.n4)
                                , contentDescription = "photo",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.layoutId("ImageFirst")
                            )
                            TextField(
                                value = textFieldState,
                                onValueChange = {textFieldState = it},
                                label = { Text(text = "Enter your name")},
                                singleLine = true,
                                modifier = Modifier.layoutId("et")
                            )
                            Button(onClick = {
                                scope.launch {
                                    mysnapbar.showSnackbar("hello $textFieldState")
                                }
                            }, modifier = Modifier.layoutId("btn")) {
                                Text(text = "Please,greet me")
                            }
                        }
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
    val constraints = ConstraintSet{
        val image1 = createRefFor("ImageFirst")
        var EditText = createRefFor("et")
        var Buttun = createRefFor("btn")

        constrain(image1){
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            end.linkTo(parent.end)
            start.linkTo(parent.start)
            width = Dimension.value(150.dp)
            height = Dimension.value(150.dp)
        }
        constrain(EditText){
            top.linkTo(image1.bottom, margin = 12.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        constrain(Buttun){
            top.linkTo(EditText.bottom, margin = 12.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
    }
    ConstraintLayout(constraints, modifier = Modifier.fillMaxSize()) {
        var textFieldState by remember {
            mutableStateOf("")
        }
        val mysnapbar = remember {
            SnackbarHostState()
        }
        val scope = rememberCoroutineScope()
        Image(painter = painterResource(id = R.drawable.n4)
            , contentDescription = "this is a photo",
            contentScale = ContentScale.Crop, modifier = Modifier.layoutId("ImageFirst"))
        TextField(value = textFieldState, onValueChange ={textFieldState=it},
            modifier = Modifier.layoutId("et"), label = { Text(text = "Enter your name")},
            singleLine = true)
        Button(onClick = {
            scope.launch {
                mysnapbar.showSnackbar("hello $textFieldState")
            }
        }, modifier = Modifier.layoutId("btn")) {
            Text(text = "please, greet me")
        }
    }
}