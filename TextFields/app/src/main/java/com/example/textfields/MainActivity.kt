package com.example.textfields

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.textfields.ui.theme.TextFieldsTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var textFieldState by remember {
                mutableStateOf("")
            }
            val snackbar = remember{ SnackbarHostState()}
            val scope = rememberCoroutineScope()
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                 snackbarHost = {SnackbarHost(snackbar)}){
                Column(modifier = Modifier
                    .padding(it)
                    .fillMaxSize(),
                   horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center) {
                    TextField(
                        value = textFieldState,
                        onValueChange = {textFieldState = it},
                        label = {
                            Text(text = "Enter your name")
                        }, singleLine = true, modifier = Modifier.fillMaxWidth())
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(onClick = {
                        scope.launch {
                            snackbar.showSnackbar("Hello $textFieldState,Welcome to our site")
                        }
                    }) {
                        Text(text = "Please, greet me")
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
    var textFieldState by remember {
        mutableStateOf("")
    }
    val snackbar = remember{ SnackbarHostState()}
    val scope = rememberCoroutineScope()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        snackbarHost = {SnackbarHost(snackbar)}){
        Column(modifier = Modifier
            .padding(it)
            .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            TextField(
                value = textFieldState,
                onValueChange = {textFieldState = it},
                label = {
                    Text(text = "Enter your name")
                }, singleLine = true, modifier = Modifier.fillMaxWidth())
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                scope.launch {
                    snackbar.showSnackbar("Hello $textFieldState,Welcome to our site")
                }
            }) {
                Text(text = "Please, greet me")
            }
        }
    }
}