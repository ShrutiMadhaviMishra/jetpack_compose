package com.example.ui_elements

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui_elements.ui.theme.UI_elementsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            UI_elementsTheme {

                UIDemo()



                }
            }
        }
    }
//@Composable
//fun CardMinimalExample() {
//    Card() {
//        Text(text = "Hello, world!")
//    }
//}
//@Composable
//fun ChipSample(text: String) {
//    Surface(
//        modifier = Modifier.padding(8.dp),
//        shape = RoundedCornerShape(16.dp),
//        color = MaterialTheme.colors.primary
//    ) {
//        Text(
//            text = text,
//            modifier = Modifier.padding(8.dp),
//            color = Color.White
//        )
//    }
//}

@Composable
fun UIDemo() {
    Column(
        modifier = Modifier
            .background(Color.Magenta)
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(horizontalArrangement = Arrangement.spacedBy(30.dp))
        {
            TextButton(onClick = { },Modifier.background(Color.Gray)) {
                Text("Text Button")
            }
            ElevatedButton(onClick = { }) {
                Text(text = "Elevated")
            }
            IconButton(onClick = { }) {
                Icon(Icons.Filled.Email, contentDescription = "Favorite")
            }
        }
        FloatingActionButton(onClick = { }) {
            Icon(Icons.Filled.Call, contentDescription = "")

        }
        Row(horizontalArrangement = Arrangement.spacedBy(30.dp))
        {
            Button(onClick = { }) {
                Text("Filled")
            }
            FilledTonalButton(onClick = { }, shape = RectangleShape) {
                Text(text = "Tonal")
            }
            OutlinedButton(onClick = { }, shape = RoundedCornerShape(30)) {
                Text("Outlined")
            }
        }

        Row(horizontalArrangement = Arrangement.spacedBy(20.dp))
        {
            AssistChip(
                onClick = { },
                label = { Text("Assist Chip") }
            )
            SuggestionChip(
                onClick = { Log.d("Suggestion chip", "hello world") },
                label = { Text("Suggestion chip") }
            )
        }

        Card(
            modifier = Modifier
                .background(Color.Gray)
                .padding(8.dp)
                .size(width = 200.dp, height = 150.dp),
            elevation = CardDefaults.cardElevation(10.dp)
        ) {
            Text(
                text = "I am a Card",
                modifier = Modifier.padding(55.dp)
            )
        }


        HorizontalDivider(
            modifier = Modifier.padding(vertical = 8.dp),
            thickness = 5.dp,
            color = Color.Gray
        )
        Slider()

        var checked by remember { mutableStateOf(true) }
        Switch(
            checked = checked,
            onCheckedChange = {
                checked = it
            }
        )

        Column(verticalArrangement = Arrangement.spacedBy(40.dp)){
            LinearProgressIndicator()
            LinearProgressIndicator(
                progress = { .6f },
            )

        }
        Row(horizontalArrangement = Arrangement.spacedBy(20.dp)) {
            CircularProgressIndicator()
            CircularProgressIndicator(
                progress = { .8f }
            )

        }
    }
}

@Composable
fun Slider() {
    var sliderPosition by remember { mutableFloatStateOf(0f) }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it }
        )
        Text(text = sliderPosition.toString())
    }
}
