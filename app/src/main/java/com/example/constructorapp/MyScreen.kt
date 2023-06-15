package com.example.constructorapp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyScreen() {
    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
        RoundedCornersBoxesScrollableColumn()
            // Scrollable content goes here


        Box(
            modifier = Modifier
                .offset(
                    x = maxWidth - (64.dp + 16.dp), // Adjust the values as needed
                    y = maxHeight - (64.dp + 16.dp)
                )
        ) {
            FloatingActionButton(
                onClick = { /* Handle FAB click event */ },
                contentColor = Color.Black,
                containerColor = Color.Cyan
            ) {
                Icon(Icons.Default.Add, contentDescription = "Icon")
            }
        }
    }
}
