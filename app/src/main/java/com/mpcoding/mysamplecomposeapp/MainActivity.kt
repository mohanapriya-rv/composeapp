package com.mpcoding.mysamplecomposeapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mpcoding.mysamplecomposeapp.data.DataProvider
import com.mpcoding.mysamplecomposeapp.data.MySampleModel
import com.mpcoding.mysamplecomposeapp.model.Screen
import com.mpcoding.mysamplecomposeapp.ui.navigation.Navigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Navigation()
        }
    }

    @Composable
    fun MainScreen(navController: NavController) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
                .background(color = Color(0xFFF2F2f2))
        ) {
            MyImageView()
            MyRecyclerView(navController)
        }
    }

    @Composable
    fun MyImageView() {
        Image(
            painterResource(
                id = R.drawable.food
            ), modifier = Modifier
                .height(150.dp)
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

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    @Composable
    private fun MyRecyclerView(navController: NavController) {
        Scaffold(content = {
            MyRecyclerViewContent(navController)
        })
    }

    @Composable
    fun MyRecyclerViewContent(navController: NavController) {
        val recyclerviewList = remember { DataProvider.list }
        LazyColumn(contentPadding = PaddingValues(horizontal = 10.dp, vertical = 8.dp)) {
            items(
                items = recyclerviewList,
                itemContent = {
                    RecyclerViewItem(item = it) {
                        navController.navigate(Screen.DetailScreen.route)
                    }
                })
        }
    }


    @OptIn(ExperimentalMaterialApi::class)
    @Composable
    fun RecyclerViewItem(item: MySampleModel, link: () -> Unit) {
        Row {
            Surface(onClick = {
                link()
            }) {
                Column {
                    val painter = painterResource(id = R.drawable.images)
                    val description = "Sample compose project"
                    val title = "my first compose application"
                    Box(
                        modifier = Modifier.fillMaxSize(0.7f)
                    ) {
                        ImageCard(painter, title, description)
                    }
                    Text(text = item.name, style = typography.h6)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "VIEW DETAIL",
                        style = typography.caption,
                        modifier = Modifier.align(Alignment.Start)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }

    /**
     * @ box-- will stack each other over the card view
     * here gradient and text
     */
    @Composable
    fun ImageCard(
        painter: Painter,
        title: String,
        contentDescription: String,
        modifier: Modifier = Modifier
    ) {
        Card(
            modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(10.dp),
            shape = RoundedCornerShape(15.dp),
            elevation = 5.dp
        ) {
            Box(modifier = Modifier.height(200.dp)) {
                Image(
                    painter = painter,
                    contentDescription = contentDescription,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxHeight()
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(
                                    Color.Transparent,
                                    Color.Black
                                ),
                                startY = 90f
                            )
                        )
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(12.dp),
                    contentAlignment = Alignment.BottomStart
                ) {
                    Text(text = title, style = TextStyle(color = Color.Green, fontSize = 16.sp))
                }

            }
        }
    }


    /**
     * vertical arrangement
     * horizontal alignment
     */
    @Composable
    fun DetailScreen(name: String?) {
        Box(Modifier.padding(20.dp)) {
            Column(
                modifier = Modifier
                    .background(Color.Green)
                    .width(300.dp)
                    .border(5.dp, Color.DarkGray)
                    .padding(5.dp),
//                    .border(5.dp, Color.Magenta)
//                    .padding(5.dp)
//                    .border(5.dp, Color.Blue)
//                    .padding(5.dp)
//                    .height(200.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
//            Text(text = "Hello", modifier = Modifier.offset(0.dp,20.dp))
//            // spacer allocates space
//            Text(text = "welcome to Android",modifier = Modifier.offset(0.dp,20.dp) )
                Text(text = "Hello", Modifier.clickable {})
                Spacer(Modifier.height(50.dp))
                Text(text = "welcome to Android")
            }
        }
    }

}
