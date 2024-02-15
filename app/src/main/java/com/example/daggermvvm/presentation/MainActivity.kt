package com.example.daggermvvm.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.example.daggermvvm.DaggerApplication
import com.example.daggermvvm.presentation.ui.components.TopBar
import com.example.daggermvvm.presentation.ui.screen.ProductListingScreen
import com.example.daggermvvm.presentation.ui.theme.DaggerMVVMTheme
import com.example.daggermvvm.presentation.viewmodel.ProductsListViewModel
import com.example.daggermvvm.presentation.viewmodel.ViewModelFactory
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    private lateinit var productsListViewModel: ProductsListViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelFactory


    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as DaggerApplication).appComponent.inject(this)
        productsListViewModel =
            ViewModelProvider(this, viewModelFactory)[ProductsListViewModel::class.java]


        setContent {
            DaggerMVVMTheme {
                Scaffold(
                    topBar = {
                        TopBar()
                    }
                ) {
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(it),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        ProductListingScreen(productsListViewModel)
                    }
                }

                // A surface container using the 'background' color from the theme

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
    DaggerMVVMTheme {
        Greeting("Android")
    }
}