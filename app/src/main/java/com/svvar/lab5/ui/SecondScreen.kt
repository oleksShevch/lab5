package com.svvar.lab5.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun SecondScreen() {
    var emergencyFee by remember { mutableStateOf("") }
    var plannedFee by remember { mutableStateOf("") }

    var result by remember { mutableStateOf("") }

    fun calculate() {
        try {
            val nEmergencyFee = emergencyFee.toDouble()
            val nPlannedFee = plannedFee.toDouble()

            val totalFee = nEmergencyFee * 14900 + nPlannedFee * 132400

            result = "Математичне сподівання збитків від переривання електропостачання: ${"%.1f".format(totalFee)} грн\n"
        }
        catch (e: Exception) {
            result = "Введіть коректні дані"
            return
        }
    }


    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Питомі збитки у разі", fontSize = 24.sp, color = Color.Black)
            Spacer(modifier = Modifier.height(16.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "аварійних вимкнень", fontSize = 18.sp, color = Color.Black)
                Spacer(modifier = Modifier.width(16.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    BasicTextField(
                        textStyle = TextStyle(fontSize = 22.sp),
                        value = emergencyFee,
                        onValueChange = { emergencyFee = it },
                        modifier = Modifier
                            .width(70.dp)
                            .background(Color(0xFFF0F0F0))
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "грн/кВт*год", fontSize = 18.sp, color = Color.Black)
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "планових вимкнень", fontSize = 18.sp, color = Color.Black)
                Spacer(modifier = Modifier.width(16.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    BasicTextField(
                        textStyle = TextStyle(fontSize = 22.sp),
                        value = plannedFee,
                        onValueChange = { plannedFee = it },
                        modifier = Modifier
                            .width(70.dp)
                            .background(Color(0xFFF0F0F0))
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "грн/кВт*год", fontSize = 18.sp, color = Color.Black)
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Button(onClick = { calculate() }) {
                Text("Розрахувати збитки", fontSize = 18.sp)
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(text = result, fontSize = 20.sp, color = Color.Blue)
        }

    }
}