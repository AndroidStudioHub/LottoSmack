/*
Description : This page is main page which shows randomly generated lotto numbers
with nav bar on bottom of page. Nav bar includes home, stats, settings
 */

package com.honeytip.lottosmack

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.MaterialTheme
import androidx.navigation.NavController
import androidx.compose.runtime.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star

@Composable
fun MainScreen(navController: NavController, modifier: Modifier = Modifier) {
    var lottoMaxNumbers by remember { mutableStateOf(generateRandomNumbers(7, 50).sorted()) }
    var lotto649Numbers by remember { mutableStateOf(generateRandomNumbers(6, 50).sorted()) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // LottoMax Button
        Button(
            onClick = { lottoMaxNumbers = generateRandomNumbers(7, 50).sorted() },
            modifier = Modifier.padding(bottom = 8.dp)
        ) {
            Text("LottoMax", style = MaterialTheme.typography.titleLarge)
        }
        Row(
            modifier = Modifier.padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            lottoMaxNumbers.forEach { number ->
                NumberCircle(number)
            }
        }

        // Lotto 6/49 Button
        Button(
            onClick = { lotto649Numbers = generateRandomNumbers(6, 50).sorted() },
            modifier = Modifier.padding(bottom = 8.dp)
        ) {
            Text("Lotto 6/49", style = MaterialTheme.typography.titleLarge)
        }
        Row(
            modifier = Modifier.padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            lotto649Numbers.forEach { number ->
                NumberCircle(number)
            }
        }
    }
}


@Composable
fun NumberCircle(number: Int) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(40.dp)
            .background(MaterialTheme.colorScheme.primaryContainer, shape = CircleShape)
            .padding(8.dp)
    ) {
        Text(text = number.toString(), color = MaterialTheme.colorScheme.onPrimaryContainer)
    }
}

fun generateRandomNumbers(count: Int, max: Int): List<Int> {
    return (1..max).shuffled().take(count)
}

