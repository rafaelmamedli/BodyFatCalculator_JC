package com.example.bodyfatcalculatorjc.view


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import java.util.*
import kotlin.math.log10







@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ProCalculator(navController: NavController? = null) {

    var weight by remember { mutableStateOf("") }
    var height by remember { mutableStateOf("") }
    var neck by remember { mutableStateOf("") }
    var abdomen by remember { mutableStateOf("") }
    var bodyFat by remember { mutableStateOf("") }
    var isMale by remember { mutableStateOf(true) }
    var hip by remember { mutableStateOf("") }


    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Text(text = "Enter your weight in kilograms")
        OutlinedTextField(
            value = weight,
            onValueChange = { weight = it },
            label = { Text(text = "Weight (kg)") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Enter your height in centimeters")
        OutlinedTextField(
            value = height,
            onValueChange = { height = it },
            label = { Text(text = "Height (cm)") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Enter your neck circumference in centimeters")
        OutlinedTextField(
            value = neck,
            onValueChange = { neck = it },
            label = { Text(text = "Neck circumference (cm)") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Enter your abdomen circumference in centimeters")
        OutlinedTextField(
            value = abdomen,
            onValueChange = { abdomen = it },
            label = { Text(text = "Abdomen circumference (cm)") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
        )

        Text(text = "Enter your hip (for women)")
        OutlinedTextField(
            value = hip,
            onValueChange = { hip = it },
            label = { Text(text = "Abdomen circumference (cm)") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row {
            Text(text = "Gender:")
            Spacer(modifier = Modifier.width(8.dp))
            RadioButton(
                selected = isMale,
                onClick = { isMale = true },
                colors = RadioButtonDefaults.colors(selectedColor = MaterialTheme.colors.primary)
            )
            Text(text = "Male")
            Spacer(modifier = Modifier.width(16.dp))
            RadioButton(
                selected = !isMale,
                onClick = { isMale = false },
                colors = RadioButtonDefaults.colors(selectedColor = MaterialTheme.colors.primary)
            )
            Text(text = "Female")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            val w = weight.toDoubleOrNull() ?: 0.0
            val h = height.toDoubleOrNull() ?: 0.0
            val n = neck.toDoubleOrNull() ?: 0.0
            val a = abdomen.toDoubleOrNull() ?: 0.0
            val h2 =hip.toDoubleOrNull() ?: 0.0
            val bf = if (isMale) {
                //495 / (1.0324 - 0.19077 * log10(a - n) + 0.15456 * log10(h)) - 450
                82.3 * log10(a - n ) - 70.041 * log10(h) + 36.76
            } else {
                163.205 * log10(a + h2 - n) - 97.684 * log10(h) - 78.38
            }
            bodyFat = "${bf.toInt().toString()} %"
            //mTodoViewModel.addTodo(BodyFat(bodyFat))
        }) {
            Text(text = "Calculate body fat percentage")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Your body fat " + bodyFat ,
            style = MaterialTheme.typography.h4
        )
    }}

class InputViewModel : ViewModel() {
    private val _todo: MutableLiveData<String> = MutableLiveData("")
    val todo: LiveData<String> = _todo

    fun onInputChange(newName: String) {
        _todo.value = newName
    }
}



