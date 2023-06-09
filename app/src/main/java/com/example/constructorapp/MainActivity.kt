package com.example.constructorapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.constructorapp.ui.theme.ConstructorAppTheme
import com.example.constructorapp.CheckBoxParameters

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConstructorAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column() {
                        RoundedCornersBoxesScrollableColumn()
                    }
                }
            }
        }
    }
}

@Composable
fun getColorForTitle(title: String): Color {
    return when (title) {
        "Business Text Holder" -> Colors.businessColor
        "Personal Text Holder" -> Colors.personalColor
        "Other Text Holder" -> Colors.otherColor
        else -> Colors.appBackgroundColor
    }
}

@Composable
fun getCheckBoxOptions(titles: List<String>): List<CheckBoxParameters> {
    return titles.map { title ->
        var stateOfCheckBoxParameters by rememberSaveable { mutableStateOf(false) }
        val checkedColor = getColorForTitle(title)
        val uncheckedColor = getColorForTitle(title)
        CheckBoxParameters(
            title = title,
            isChecked = stateOfCheckBoxParameters,
            onCheckedChanged = { stateOfCheckBoxParameters = it },
            checkedColor = checkedColor,
            uncheckedColor = uncheckedColor
        )
    }
}

@Composable
fun ScrollableRow() {
    LazyRow {
        items(3) { index ->
            Box(
                modifier = Modifier
                    .width(200.dp)
                    .height(100.dp)
                    .padding(8.dp)
                    .background(Color.Blue)
                    .clip(RoundedCornerShape(16.dp))
            ) {
                Text(
                    text = "Item $index",
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }

}

@Composable
fun RoundedCornersBoxCategories(title: String, divColor: Color) {
    Box(
        modifier = Modifier
            .size(height = 100.dp, width = 200.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.Blue)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = title,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(start = 8.dp, top = 24.dp)
            )
            Divider(
                Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, top = 4.dp, end = 8.dp),
                color = divColor
            )
        }
    }
}

@Composable
fun RoundedCornersBoxTasks(checkBoxParameters: CheckBoxParameters) {

    Box(
        modifier = Modifier
            .size(height = 50.dp, width = 300.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.Blue)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Checkbox(
                checked = checkBoxParameters.isChecked,
                onCheckedChange = { checkBoxParameters.onCheckedChanged(!checkBoxParameters.isChecked) },
                enabled = true,
                colors = CheckboxDefaults.colors(
                    checkedColor = checkBoxParameters.checkedColor,
                    uncheckedColor = checkBoxParameters.checkedColor
                )
            )
            Text(
                text = checkBoxParameters.title,
                color = Color.White,
//                textAlign = TextAlign.Center,
//                modifier = Modifier.padding(start = 8.dp, top = 24.dp)
            )

        }
    }
    Spacer(modifier = Modifier.height(16.dp))
}

@Composable
fun RoundedCornersBoxesScrollableRow() {
    Row(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
            .horizontalScroll(rememberScrollState())
    ) {
        RoundedCornersBoxCategories("BUSINESS", Color.Red)
        Spacer(modifier = Modifier.width(16.dp))
        RoundedCornersBoxCategories("PERSONAL", Color.Cyan)
        Spacer(modifier = Modifier.width(16.dp))
        RoundedCornersBoxCategories("OTHER", Color.Yellow)
    }

}

@Composable
fun RoundedCornersBoxesScrollableColumn() {
    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        var titles = listOf(
            "Business Text Holder",
            "Personal Text Holder",
            "Other Text Holder",
        )
        val myCheckBoxOptions =
            getCheckBoxOptions(titles)
        myCheckBoxOptions.forEach {
            RoundedCornersBoxTasks(it)
        }
    }
}

@Composable
fun ScrollableRowOfBoxes() {
    val boxColors = listOf(Color.Red, Color.Blue, Color.Green, Color.Yellow)

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(boxColors.size) { index ->
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(boxColors[index])
                    .padding(16.dp)
                    .clip(RoundedCornerShape(16.dp))
            )
        }
    }
}

@Composable
fun ScrollableRowWithBoxes() {
    val boxColors = listOf(Color.Red, Color.Blue, Color.Green)

    Row(
        modifier = Modifier.horizontalScroll(rememberScrollState())
    ) {
        boxColors.forEach { color ->
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(color)
                    .padding(16.dp)
            )
        }
    }
}


//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    ConstructorAppTheme {
//        Greeting("Android")
//    }
//}