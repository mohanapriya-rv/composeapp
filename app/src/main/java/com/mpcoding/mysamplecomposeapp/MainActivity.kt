package com.mpcoding.mysamplecomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.mpcoding.mysamplecomposeapp.data.DataProvider
import com.mpcoding.mysamplecomposeapp.data.MySampleModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color(0xFFF2F2f2))
            ) {
                Box {
                    MyRecyclerView()
                    MyImageView()
                }
            }
        }
    }

    @Composable
    fun MyImageView() {
        Image(
            painterResource(
                id = R.drawable.food
            ), modifier = Modifier
                .height(200.dp)
                .padding(10.dp),
            contentDescription = "",
            contentScale = ContentScale.Crop
        )
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Happy Meal", style = TextStyle(
                    color = Color.Green, fontSize = TextUnit.Unspecified
                )
            )
            Spacer(modifier = Modifier.padding(top = 10.dp))
            Text(text = "1200 Calories ")
            Spacer(modifier = Modifier.padding(top = 10.dp))
            Text(text = "Rupee 10.0")
            Spacer(modifier = Modifier.padding(top = 10.dp))

        }
    }
}

@Composable
private fun MyRecyclerView() {
    Scaffold(content = {
        MyRecyclerViewContent()
    })
}

@Composable
fun MyRecyclerViewContent() {
    val recyclerviewList = remember { DataProvider.list }
    LazyColumn(contentPadding = PaddingValues(horizontal = 10.dp, vertical = 8.dp)) {
        items(
            items = recyclerviewList,
            itemContent = {
                RecyclerViewItem(item = it)
            })
    }
}

@Composable
fun RecyclerViewItem(item: MySampleModel) {
    Row {
        Column {

            Text(text = item.name, style = typography.h6)
            Text(text = "VIEW DETAIL", style = typography.caption)
        }

    }
}
