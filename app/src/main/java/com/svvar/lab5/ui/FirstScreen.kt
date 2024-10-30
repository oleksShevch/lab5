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
fun FirstScreen() {
    var eleOff by remember { mutableStateOf("") }
    var line by remember { mutableStateOf("") }
    var transformer by remember { mutableStateOf("") }
    var connections by remember { mutableStateOf("") }
    var switch by remember { mutableStateOf("") }
    var addSwitch by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }


    fun calculate() {
        try {
            val nEleOff = eleOff.toInt()
            val nLine = line.toDouble()
            val nTransformer = transformer.toInt()
            val nConnections = connections.toInt()
            val nSwitch = switch.toInt()
            val nAddSwitch = addSwitch.toInt()

            val system1 = 0.01 * nEleOff + 0.007 * nLine + 0.015 * nTransformer + 0.03 * nConnections + 0.02 * nSwitch
            val t1 = (0.01 * nEleOff * 30 + 0.007 * nLine * 10 + 0.015 * nTransformer * 100 + 0.03 * nConnections * 2 + 0.02 * nSwitch *15) / system1

            val k1 = system1 * t1 / 8760
            val k2 = 1.2 * 43 / 8760


            val system2 = 2 * system1 * (k1 + k2) + 0.02 * nAddSwitch

            result = "Частота відмов одноколової системи: ${"%.3f".format(system1)}\n" +
                    "Середня тривалість відновлення: ${"%.2f".format(t1)}\n" +
                    "Коефіцієнт аварійного простою одноколової системи: ${"%.5f".format(k1)}\n" +
                    "Коефіцієнт планового простою одноколової системи: ${"%.5f".format(k2)}\n" +
                    "Частота відмов двоколової системи (+вимикачі): ${"%.4f".format(system2)}"

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
            Text(text = "Одноколова система", fontSize = 20.sp, color = Color.Black)

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Елегазовий вимикач 110кВ ", fontSize = 18.sp, color = Color.Black)
                Spacer(modifier = Modifier.width(16.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    BasicTextField(
                        textStyle = TextStyle(fontSize = 22.sp),
                        value = eleOff,
                        onValueChange = { eleOff = it },
                        modifier = Modifier
                            .width(50.dp)
                            .background(Color(0xFFF0F0F0))
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "шт", fontSize = 18.sp, color = Color.Black) }

            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "ПЛ-110 кВ ", fontSize = 18.sp, color = Color.Black)
                Spacer(modifier = Modifier.width(16.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    BasicTextField(
                        textStyle = TextStyle(fontSize = 22.sp),
                        value = line,
                        onValueChange = { line = it },
                        modifier = Modifier
                            .width(50.dp)
                            .background(Color(0xFFF0F0F0))
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "км", fontSize = 18.sp, color = Color.Black)
                }

            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Трансформатор 110/10 кВ ", fontSize = 18.sp, color = Color.Black)
                Spacer(modifier = Modifier.width(16.dp))
                Row (
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    BasicTextField(
                        textStyle = TextStyle(fontSize = 22.sp),
                        value = transformer,
                        onValueChange = { transformer = it },
                        modifier = Modifier
                            .width(50.dp)
                            .background(Color(0xFFF0F0F0))
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "шт", fontSize = 18.sp, color = Color.Black)
                }

            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Приєднання по 10 кВ ", fontSize = 18.sp, color = Color.Black)
                Spacer(modifier = Modifier.width(16.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    BasicTextField(
                        textStyle = TextStyle(fontSize = 22.sp),
                        value = connections,
                        onValueChange = { connections = it },
                        modifier = Modifier
                            .width(50.dp)
                            .background(Color(0xFFF0F0F0))
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "шт", fontSize = 18.sp, color = Color.Black)
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Вимикач ", fontSize = 18.sp, color = Color.Black)
                Spacer(modifier = Modifier.width(16.dp))
                Row (
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    BasicTextField(
                        textStyle = TextStyle(fontSize = 22.sp),
                        value = switch,
                        onValueChange = { switch = it },
                        modifier = Modifier
                            .width(50.dp)
                            .background(Color(0xFFF0F0F0))
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "шт", fontSize = 18.sp, color = Color.Black)
                }
            }


            Spacer(modifier = Modifier.height(35.dp))

            Text(text = "Двоколова система", fontSize = 20.sp, color = Color.Black)
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Двоколова система складається з 2х одноколових, що описані вище",
                softWrap = true,
                fontSize = 18.sp,
                color = Color.Black)
            Spacer(modifier = Modifier.height(16.dp))

            Row (
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Додаткові вимикачі ", fontSize = 18.sp, color = Color.Black)
                Spacer(modifier = Modifier.width(16.dp))
                Row (
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    BasicTextField(
                        textStyle = TextStyle(fontSize = 22.sp),
                        value = addSwitch,
                        onValueChange = { addSwitch = it },
                        modifier = Modifier
                            .width(50.dp)
                            .background(Color(0xFFF0F0F0))
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "шт", fontSize = 18.sp, color = Color.Black)
                }
            }

            Spacer(modifier = Modifier.height(20.dp))


            Button(onClick = { calculate() }) {
                Text("Розрахувати надійність", fontSize = 18.sp)
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(text = result, fontSize = 20.sp, color = Color.Blue)
        }
    }
}