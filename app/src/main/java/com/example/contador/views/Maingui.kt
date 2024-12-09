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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun Maingui(modifier: Modifier = Modifier, viewModel: Maingui_viewModel) {
    val contadorValueState: Int by viewModel.contador.observeAsState(0)


    var timeLeft by remember { mutableStateOf(60) }
    var isTimerRunning by remember { mutableStateOf(false) }


    LaunchedEffect(isTimerRunning) {
        if (isTimerRunning && timeLeft > 0) {
            delay(1000L)
            timeLeft -= 1
        }
    }


    fun startTimer() {
        if (!isTimerRunning) {
            isTimerRunning = true
        }
    }


    fun stopTimer() {
        isTimerRunning = false
    }

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
            Text(
                text = "QUANTOS CLIQUES VOCÊ CONSEGUE POR 1 MINUTO?",
                color = Color(0xFF6A0DAD),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(20.dp))

            Box(
                modifier = Modifier
                    .padding(16.dp)
                    .background(Color(0xFFE6E6FA), shape = androidx.compose.foundation.shape.RoundedCornerShape(16.dp))
                    .padding(16.dp)
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text(
                        text = "Preparar, vai...",
                        color = Color(0xFF6A0DAD),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    BasicTextField(
                        value = contadorValueState.toString(),
                        onValueChange = {},
                        modifier = Modifier
                            .padding(vertical = 8.dp)
                            .background(Color.White, shape = androidx.compose.foundation.shape.RoundedCornerShape(8.dp))
                            .padding(16.dp)
                    )

                    Button(
                        onClick = {
                            viewModel.incrementaContador()
                        },
                        modifier = Modifier.padding(vertical = 8.dp),
                        colors = androidx.compose.material3.ButtonDefaults.buttonColors(containerColor = Color(0xFF6A0DAD))
                    ) {
                        Text(text = "Clique: $contadorValueState", color = Color.White)
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Exibindo o cronômetro
                    Text(
                        text = "Tempo: ${timeLeft}s",
                        color = Color(0xFF6A0DAD),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Botões de iniciar e parar o cronômetro
                    if (isTimerRunning) {
                        Button(
                            onClick = { stopTimer() },
                            modifier = Modifier.padding(vertical = 8.dp),
                            colors = androidx.compose.material3.ButtonDefaults.buttonColors(containerColor = Color(0xFFFF5722))
                        ) {
                            Text(text = "Parar Cronômetro", color = Color.White)
                        }
                    } else {
                        Button(
                            onClick = { startTimer() },
                            modifier = Modifier.padding(vertical = 8.dp),
                            colors = androidx.compose.material3.ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50))
                        ) {
                            Text(text = "Iniciar Cronômetro", color = Color.White)
                        }
                    }
                }
            }
        }
    }
}
