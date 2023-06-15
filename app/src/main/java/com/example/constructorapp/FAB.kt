package com.example.constructorapp

import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyFab() {
    FloatingActionButton(
        onClick = { /* Handle FAB click event */ },
        contentColor = Color.White,
        containerColor = Colors.fabColor,
        shape = RoundedCornerShape(32.dp)
    ) {
        Icon(Icons.Default.Add, contentDescription = "Add Icon")
    }
}
