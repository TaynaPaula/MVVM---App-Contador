package com.example.contador.views

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun Maingui(modifier: Modifier = Modifier, viewModel: Maingui_viewModel) {
    val contadorValueState: Int by viewModel.contador.observeAsState(0)


    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .border(BorderStroke(2.dp, Color(0xFF6A0DAD)), shape = androidx.compose.foundation.shape.RoundedCornerShape(16.dp))
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(text = "AUTORAS BRASILEIRAS", color = Color(0xFF6A0DAD), fontSize = 24.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
            Text(text = "Djamila Ribeiro", color = Color(0xFF6A0DAD), textAlign = TextAlign.Center)
            Text(text = "Carolina Maria de Jesus", color = Color(0xFF6A0DAD), textAlign = TextAlign.Center)
            Text(text = "Conceição Evaristo", color = Color(0xFF6A0DAD), textAlign = TextAlign.Center)
            Text(text = "Ana Maria Gonçalves", color = Color(0xFF6A0DAD), textAlign = TextAlign.Center)
            Text(text = "Maria Firmina dos Reis", color = Color(0xFF6A0DAD), textAlign = TextAlign.Center)

            Spacer(modifier = Modifier.height(20.dp))

            Box(
                modifier = Modifier
                    .padding(16.dp)
                    .background(Color(0xFFE6E6FA), shape = androidx.compose.foundation.shape.RoundedCornerShape(16.dp))
                    .padding(16.dp)
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text(text = "QUANTOS LIVROS VOCÊ JÁ LEU?", color = Color(0xFF6A0DAD), fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    BasicTextField(
                        value = contadorValueState.toString(),
                        onValueChange = {},
                        modifier = Modifier
                            .padding(vertical = 8.dp)
                            .background(Color.White, shape = androidx.compose.foundation.shape.RoundedCornerShape(8.dp))
                            .padding(16.dp)
                    )

                    Button(
                        onClick = { viewModel.incrementaContador() },
                        modifier = Modifier.padding(vertical = 8.dp),
                        colors = androidx.compose.material3.ButtonDefaults.buttonColors(containerColor = Color(0xFF6A0DAD))
                    ) {
                        Text(text = "Incrementar: $contadorValueState", color = Color.White)
                    }
                }
            }
        }
    }
}
