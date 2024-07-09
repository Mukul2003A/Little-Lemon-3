package com.example.littlelemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope

@Composable
fun DishDetails(id: Int){
    val dish = requireNotNull(DishRepository.getDish(id))
    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        val drawerState = DrawerState(initialValue = DrawerValue.Closed)
        val scope = CoroutineScope(MainScope().coroutineContext)
        TopAppBar(drawerState = drawerState, scope = scope)
        Image(painter = painterResource(id = dish.imageResource), contentDescription = "", modifier = Modifier.fillMaxWidth(), contentScale = ContentScale.FillWidth)
        Column(verticalArrangement = Arrangement.spacedBy(10.dp), modifier = Modifier.padding(start = 10.dp, end = 10.dp)) {
            Text(text = dish.name, fontSize = 26.sp, fontWeight = FontWeight.Bold, color = LittleLemonColor.green)
            Text(text = dish.description, color = LittleLemonColor.green)
            ItemOrder()
            Button(onClick = { }, modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()) {
                Text(text = stringResource(id = R.string.add_for) + " ${dish.price}", textAlign = TextAlign.Center, modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically))
            }
        }
    }
}