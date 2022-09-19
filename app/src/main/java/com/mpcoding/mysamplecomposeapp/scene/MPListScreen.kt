package com.mpcoding.mysamplecomposeapp.scene

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
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
import com.mpcoding.mysamplecomposeapp.R
import com.mpcoding.mysamplecomposeapp.data.DataProvider
import com.mpcoding.mysamplecomposeapp.data.MySampleModel
import com.mpcoding.mysamplecomposeapp.model.Screen


/**
 * created by Mohanapriya R on 16-09-2022
 */
@Composable
fun MPListScreen(navController: NavController) {
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
        painterResource(id = R.drawable.food), modifier = Modifier
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
    /**
     * lazy column -> will automatically handles the scrolling
     * column -> won't automatically scroll we need to add modifier.vertical scroll
     * TO enable smooth Scrolling
     */
    LazyColumn(contentPadding = PaddingValues(horizontal = 10.dp, vertical = 8.dp)) {
        items(
            items = recyclerviewList,
            itemContent = {
                RecyclerViewItem(item = it) {
                    redirectToCorrespondingScreen(navController, it.id)
                }
            })
    }

    /**
     * using item indexed we can pass list of string along with index and String
     */
//    LazyColumn() {
//        itemsIndexed(listOf("this", "is", "my", "sample", "compose")) { index: Int, item: String ->
//            Text(
//                text = item,
//                Modifier
//                    .fillMaxWidth()
//                    .padding(24.dp),
//                fontSize = 20.sp,
//                textDecoration = TextDecoration.None,
//                textAlign = TextAlign.Start,
//                fontWeight = FontWeight.ExtraLight
//            )
//
//        }
//    }
}

fun redirectToCorrespondingScreen(navController: NavController, id: Int) {
    if (id == 1) {
        navController.navigate(Screen.TextStylesScreen.route)
    } else if (id == 2) {
        navController.navigate(Screen.StateDetailScreen.route)
    } else if (id == 3) {
        navController.navigate(Screen.ConstraintLayoutDetailScreen.route)
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

                Text(text = item.name, style = MaterialTheme.typography.h6)

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "VIEW DETAIL",
                    style = MaterialTheme.typography.caption,
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
            )
            {
                Text(text = title, style = TextStyle(color = Color.Green, fontSize = 16.sp))
            }

        }
    }
}

