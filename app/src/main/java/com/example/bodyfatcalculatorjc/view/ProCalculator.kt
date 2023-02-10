package com.example.bodyfatcalculatorjc.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlin.math.log10

@Composable
fun ProCalculator(navController: NavController? = null) {
    val height = remember { mutableStateOf("") }
    val weight = remember { mutableStateOf("") }
    val neck = remember { mutableStateOf("") }
    val abdomen = remember { mutableStateOf("") }





    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            SpecialTextField(string = height.value, hint = "in cm","Height") {
                height.value = it
                println(height.value)
            }
            Spacer(modifier = Modifier.padding(6.dp))
            SpecialTextField(string = weight.value,"in kg","Weight") {
                weight.value = it
                println(weight.value)
            }
            Spacer(modifier = Modifier.padding(6.dp))

            SpecialTextField(string = neck.value,"in cm","Neck") {
                neck.value = it
                println(neck.value)
            }
            Spacer(modifier = Modifier.padding(6.dp))

            SpecialTextField(string = abdomen.value,"in cm", "Abdomen") {
                abdomen.value = it
                println(abdomen.value)
            }
            Spacer(modifier = Modifier.padding(6.dp))


        }

    }
}

@Composable
fun SpecialTextField(string: String,hint:String,title:String, function: (String) -> Unit) {

    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Text(title, fontSize = 18.sp, modifier = Modifier
            .fillMaxWidth(0.25f)
            .padding(start = 12.dp))

        TextField(
            value = string, onValueChange = function,
            Modifier.width(230.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number,
            ),placeholder = { Text(hint) })
    }
    
}

@Composable
fun Button(string: String,abdomenValue:Int,neckValue:Int,heightValue:Int,){
    androidx.compose.material.Button(
        onClick = {   val pro =  82.3 * log10((abdomenValue - neckValue).toDouble()) - 70.041 * log10(heightValue.toDouble()) + 36.76
            println(pro)
        },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Blue,
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(20),
        border = BorderStroke(1.dp, Color.Blue),
        modifier = Modifier
            .padding(12.dp),
    ) {
        Text(string, fontSize = 22.sp)
    }
}


@Composable
fun ResultText(resultText: String){
    Text(resultText, fontSize = 18.sp, modifier = Modifier
        .fillMaxWidth(0.25f)
        .padding(top = 12.dp, start = 2.dp))

}
