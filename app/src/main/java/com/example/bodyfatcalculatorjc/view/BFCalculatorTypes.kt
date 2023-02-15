package com.example.bodyfatcalculatorjc.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bodyfatcalculatorjc.Screen


@Composable
fun CalculatorTypes(navController: NavController) {
    Surface(modifier = Modifier
        .fillMaxSize()
        .background(Color.Gray)) {

        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            Spacer(modifier = Modifier.padding(8.dp))
            Title(string = "Let's choose calculator and calculate your body fat")
            Spacer(modifier = Modifier.padding(100.dp))

            Row(verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,) {
                Button(
                    onClick = { navController.navigate(Screen.SimpleBFC.toString()) },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue,
                        contentColor = Color.White),
                    shape = RoundedCornerShape(20),
                    border = BorderStroke(1.dp, Color.Blue),
                    modifier = Modifier
                        .size(180.dp, 180.dp)
                        .padding(12.dp)
                        ,
                ) {
                    Text("Simple BFC", fontSize = 22.sp,textAlign = TextAlign.Center,)
                }
                Button(
                    onClick = { navController.navigate(Screen.ProBFC.toString()) },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue, contentColor = Color.White),
                    shape = RoundedCornerShape(20),
                    border = BorderStroke(1.dp, Color.Blue),

                    modifier = Modifier
                        .size(180.dp, 180.dp)
                        .padding(12.dp)
                        .align((Alignment.CenterVertically))
                    ,

                ) {
                    Text("Pro BFC", fontSize = 22.sp)
                }

            }
        }


    }


}



@Composable
fun Title(string: String) {
    Modifier.fillMaxWidth()
    Text( string,
    style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold),
    modifier = Modifier.padding(14.dp))
}