package com.mpcoding.mysamplecomposeapp.scene

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension

/**
 *constraint sets
 */
@Composable
fun MPConstraintLayoutScreen() {
    val constraints = ConstraintSet {
        val greenBox = createRefFor("green_box")
        val redBox = createRefFor("red_box")
        val guideLine = createGuidelineFromTop(0.5f)
        constrain(greenBox) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            width = Dimension.value(100.dp)
            height = Dimension.value(100.dp)
        }
        constrain(redBox) {
            top.linkTo(parent.top)
            start.linkTo(greenBox.end)
            width = Dimension.fillToConstraints
            height = Dimension.value(100.dp)
        }
        createHorizontalChain(greenBox, redBox, chainStyle = ChainStyle.Packed)
    }

    ConstraintLayout(
        constraints, modifier = Modifier
            .fillMaxSize()
            .padding(70.dp)
    ) {
        Box(
            modifier = Modifier
                .background(Color.Green)
                .layoutId("green_box")
        ) {}
        Box(
            modifier = Modifier
                .background(Color.Yellow)
                .layoutId("red_box")
        ) {}
    }
}