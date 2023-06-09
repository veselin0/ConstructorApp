package com.example.constructorapp

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CheckBoxToggle(checkBoxParameters: CheckBoxParameters) {
    var isChecked by remember { mutableStateOf(false) }
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = isChecked,
            onCheckedChange = { isChecked = it },
            enabled = true,
            colors = CheckboxDefaults.colors(
                checkedColor = Colors.businessColor,
                uncheckedColor = Colors.businessColor,
//                checkmarkColor = Color.Black
            ),
            modifier = Modifier.padding(end = 8.dp)
        )
        Text(text = "Gocho")
    }
}
