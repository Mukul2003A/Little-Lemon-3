package com.example.littlelemon

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ItemOrder(){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth(),
    ) {
        var counter by remember {
            mutableStateOf(1)
        }
        TextButton(
            onClick = {
                if(counter>1){
                    counter--
                }
            }
        ) {
            androidx.compose.material.Text(
                text = "-",
                style = MaterialTheme.typography.h2
            )
        }
        androidx.compose.material.Text(
            text = counter.toString(),
            style = MaterialTheme.typography.h2,
            modifier = Modifier.padding(16.dp)
        )
        TextButton(
            onClick = {
                counter++
            }
        ) {
            androidx.compose.material.Text(
                text = "+",
                style = MaterialTheme.typography.h2
            )
        }
    }
}

