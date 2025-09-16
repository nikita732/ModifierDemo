package com.example.modifierdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.modifierdemo.ui.theme.ModifierDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ModifierDemoTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    DemoScreen(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun DemoScreen(modifier: Modifier = Modifier) {
    Text(
        text = "Hello Compose",
        fontSize = 40.sp,
        fontWeight = FontWeight.Bold,
        color = Color.Black,
        modifier = modifier.padding(16.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ModifierDemoTheme {
        DemoScreen()
    }
}
