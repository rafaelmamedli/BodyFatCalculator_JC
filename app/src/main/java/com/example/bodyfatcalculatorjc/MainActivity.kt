package com.example.bodyfatcalculatorjc

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bodyfatcalculatorjc.ui.theme.BodyFatCalculatorJCTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
        //    Greeting(name = "Kotlin")
        }


    }
}

@Composable
fun Greeting(name: String) {

    //Column, row, box

    Column() {
        Text(
            text = "Salam Meleykim!",
            color = Color.Magenta,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            modifier = Modifier
                .background(color = Color.Blue)
                .padding(top = 5.dp, end = 20.dp)
                .clickable {
                    println("PrintLn")
                }
                .fillMaxSize()
                .height(80.dp)
            ,
            text = "Assalamu Aleykum!",
            color = Color.Magenta,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
    }

//    Row {
//        Text(
//            text = "Salam Meleykim!",
//            color = Color.Magenta,
//            fontSize = 24.sp,
//            fontWeight = FontWeight.Bold
//        )
//
//        Text(
//            text = "Assalamu Aleykum!",
//            color = Color.Magenta,
//            fontSize = 24.sp,
//            fontWeight = FontWeight.Bold
//        )
//    }



}

@Composable
fun CustomText(text: String)  {
    Text(
        modifier = Modifier
            .background(color = Color.Blue)
            .padding(top = 5.dp, end = 20.dp)
            .clickable {
                println("PrintLn")
            }
            .fillMaxSize()
            .height(80.dp)
        ,
        text = "Assalamu $text!",
        color = Color.Magenta,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold
    )
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BodyFatCalculatorJCTheme {
        Greeting("Preview")
    }


}