package com.example.contador

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.contador.ui.theme.ContadorTheme
import com.example.contador.views.Maingui_viewModel
import com.example.contador.views.Maingui

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: Maingui_viewModel = Maingui_viewModel()

        enableEdgeToEdge()
        setContent {
            ContadorTheme {
              Scaffold (modifier = Modifier.fillMaxSize() ){innerPadding ->
                  Maingui(modifier = Modifier.padding(innerPadding),viewModel = viewModel)
              }

            }
        }
    }
}
