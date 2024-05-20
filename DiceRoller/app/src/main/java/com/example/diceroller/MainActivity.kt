package com.example.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.diceroller.ui.theme.DiceRollerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DiceRollerApp()
                }
            }
        }
    }
}

@Preview
@Composable
fun DiceRollerApp() {
    DiceWithButtonAndImage(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
    )
}

@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
    var result by remember { mutableStateOf(1) }
    var sum by remember { mutableStateOf(0) }
    var sixCounter by remember { mutableStateOf(0) }
    var counterExecution by remember { mutableStateOf(0) }
    val imageResource = when(result) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(imageResource), contentDescription = result.toString())

        Button(

            onClick = {
                result = (1..6).random()
                sum += result
                if (result == 6) {
                    sixCounter += 1
                }
                counterExecution++;
            },

        ) {
            Text(text = stringResource(R.string.roll), fontSize = 24.sp)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Soma: $sum", fontSize = 24.sp, modifier = Modifier.align(Alignment.CenterHorizontally))
        Text(text = "Quantidade de 6's: $sixCounter", fontSize = 24.sp, modifier = Modifier.align(Alignment.CenterHorizontally))
        Text(text = "Quantidade de execuções: $counterExecution", fontSize = 24.sp, modifier = Modifier.align(Alignment.CenterHorizontally))

        Spacer(modifier = Modifier.height(80.dp))

        Button(
            onClick = {
               result = 1
                sum = 0
                sixCounter = 0
                counterExecution = 0
            },
        ) {
            Text(text = "Clear", fontSize = 24.sp)
        }
    }
}
