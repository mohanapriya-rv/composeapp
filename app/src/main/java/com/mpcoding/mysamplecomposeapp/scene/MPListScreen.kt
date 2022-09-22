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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mpcoding.mysamplecomposeapp.R
import com.mpcoding.mysamplecomposeapp.data.DataProvider
import com.mpcoding.mysamplecomposeapp.data.MySampleModel


/**
 * created by Mohanapriya R on 16-09-2022
 */
@Composable
fun MPListScreen(navController: NavController, doNavigate: (MySampleModel) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(PaddingValues(15.dp, 75.dp, 15.dp, 15.dp))
            .background(color = Color(0xFFF2F2f2))
    ) {
        MyImageView()
        MyRecyclerView(navController) {
            doNavigate(it)
        }
    }
}

@Composable
fun MyImageView() {
    Image(
        painterResource(id = R.drawable.imagedemo), modifier = Modifier
            .height(120.dp)
            .fillMaxWidth(),
        contentDescription = "",
        contentScale = ContentScale.Fit
    )
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = stringResource(R.string.my_first_compose_app),
            style = TextStyle(
                color = Color.Black,
                fontSize = 22.sp
            )
        )
        Spacer(modifier = Modifier.padding(top = 5.dp))
        Text(text = stringResource(R.string.sample_text))
        Spacer(modifier = Modifier.padding(top = 5.dp))

    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
private fun MyRecyclerView(navController: NavController, doNavigate: (MySampleModel) -> Unit) {
    Scaffold(content = {
        MyRecyclerViewContent(navController = navController, doNavigate = {
            doNavigate(it)
        })
    })
}

@Composable
fun MyRecyclerViewContent(
    navController: NavController,
    doNavigate: (MySampleModel) -> Unit,
) {
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
                    doNavigate(it)
//                    redirectToCorrespondingScreen(navController, it.id)
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


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RecyclerViewItem(item: MySampleModel, doNavigate: () -> Unit) {
    Row {
        Surface(onClick = {
            doNavigate()
        }) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(10.dp),
                shape = RoundedCornerShape(15.dp), elevation = 5.dp
            ) {
                Box(modifier = Modifier.padding(20.dp)) {
                    Column {
                        Text(text = item.name, style = MaterialTheme.typography.h6)

                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = stringResource(id = R.string.view_detail),
                            style = MaterialTheme.typography.h4,
                            fontSize = 20.sp
                        )

                        Spacer(modifier = Modifier.height(4.dp))
                    }
                }
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
    title: String,
    contentDescription: String,
    modifier: Modifier = Modifier
) {

    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(40.dp)
            .padding(10.dp),
        shape = RoundedCornerShape(15.dp),
    ) {

        Box(modifier = Modifier.height(200.dp)) {

//            Image(
//                painter = painter,
//                contentDescription = contentDescription,
//                contentScale = ContentScale.Crop,
//                modifier = Modifier.fillMaxHeight()
//            )

//            Box(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .background(
//                        Brush.verticalGradient(
//                            colors = listOf(
//                                Color.Transparent,
//                                Color.Black
//                            ),
//                            startY = 90f
//                        )
//                    )
//            )

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

