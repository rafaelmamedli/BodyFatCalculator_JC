package com.example.bodyfatcalculatorjc.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bodyfatcalculatorjc.ui.theme.BodyFatCalculatorJCTheme
import kotlin.math.log10






@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BodyFatCalculatorJCTheme {
        BodyFatCalculator()
    }


}

var btcResult:Double = 0.0
@Composable
fun ProCalculator(navController: NavController? = null) {
    var isChecked by remember { mutableStateOf(false) }
    val btcResult = remember { mutableStateOf(0) }
    val height = remember { mutableStateOf("") }
    val weight = remember { mutableStateOf("") }
    val neck = remember { mutableStateOf("") }
    val abdomen = remember { mutableStateOf("") }


    Surface(modifier = Modifier
        .fillMaxSize()
        .background(Color.Gray)) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.padding(6.dp))

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

            Button(string = "Calculate", abdomenValue = abdomen.value, neckValue = neck.value, heightValue = height.value,btcResult)

            ResultText(resultText = btcResult )



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
fun Button(string: String,abdomenValue:String,neckValue:String,heightValue:String,result0 : MutableState<Int>){
    androidx.compose.material.Button(
        onClick = { btcResult =  82.3 * log10((abdomenValue.toDouble() - neckValue.toDouble())) - 70.041 * log10(heightValue.toDouble()) + 36.76
              result0.value = btcResult.toInt()
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
fun ResultText(resultText: MutableState<Int>){
    Text("Your body fat : ${resultText.value} %", fontSize = 16.sp, modifier = Modifier
        .fillMaxWidth(0.35f)
        .padding(top = 12.dp, start = 2.dp))

}

