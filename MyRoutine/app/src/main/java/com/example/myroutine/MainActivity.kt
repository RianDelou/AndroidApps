package com.example.myroutine

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myroutine.ui.theme.MyRoutineTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyRoutineTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)) {
                        Greeting(name = "Rian Lima Delou (textos fictícios)")
                        RoutineTexts()
                        RoutineImage()
                        AdditionalText(message = "'Exemplo de uma citação' ~Criador da citação")
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
            text = name,
            modifier =  Modifier.padding(bottom = 10.dp)
    )
}

@Composable
fun RoutineTexts(modifier: Modifier = Modifier) {
    Column {

        Text(
            text = "Rotina",
            modifier = Modifier.padding(bottom = 10.dp)
        )
        Text(
            text = "Eu acordo, tenho aulas pela manhã, estudo à tarde, participação em atividades extracurriculares, prática de exercícios no início da noite, jantar, revisão de estudos, tempo livre à noite para relaxar, preparo para dormir por volta das 22:30.",
            modifier = Modifier.padding(bottom = 10.dp)
        )
        Text(
            text = "Flexibilidade nos finais de semana para sociais, descanso e hobbies. Consistência com adaptações quando necessário."
        )
    }
}

@Composable
fun RoutineImage(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.whatsapp_image_2024_05_02_at_18_06_09_removebg_preview)
    Image(
        painter = image,
        contentDescription = null
    )

}

@Composable
fun AdditionalText(message: String, modifier:Modifier = Modifier) {
    Text(
        modifier = Modifier.padding(top = 50.dp),
        text = message
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyRoutineTheme {
        Column(modifier = Modifier.fillMaxSize()) {
            Greeting("Rian Lima Delou")
            RoutineTexts()
            RoutineImage()
        }
    }
}