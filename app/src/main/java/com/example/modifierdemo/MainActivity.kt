package com.example.modifierdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.Alignment
import androidx.compose.foundation.border
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.draw.clip
import com.example.modifierdemo.ui.theme.ModifierDemoTheme
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource



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
fun CustomImage(image: Int, modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = image),
        contentDescription = null,
        modifier
    )
}

@Composable
fun DemoScreen(modifier: Modifier = Modifier) {
    val mymodifier = Modifier
        .border(width = 2.dp, color = Color.Black)
        .padding(all = 10.dp)

    val secondModifier = Modifier.height(100.dp)

    val combinedModifier = mymodifier.then(secondModifier)

    Column(
        Modifier.padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Hello Compose",
            modifier = combinedModifier,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.height(16.dp))
        CustomImage(
            image = R.drawable.vacation,
            modifier = Modifier
                .padding(16.dp)
                .width(270.dp)
                .clip(RoundedCornerShape(30.dp))
        )
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ModifierDemoTheme {
        DemoScreen()
    }
}
