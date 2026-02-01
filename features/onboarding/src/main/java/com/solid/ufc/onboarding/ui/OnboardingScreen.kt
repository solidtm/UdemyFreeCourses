package com.solid.ufc.onboarding.ui

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.solid.ufc.onboarding.R
import com.solid.ufc.ui.theme.SpacingTheme
import com.solid.ufc.ui.utils.UFCPreview
import com.solid.ufc.ui.utils.fourPadding
import kotlinx.coroutines.launch
import kotlin.math.abs

data class PagerItemData(
    val title: String,
    val description: String,
    val image: Painter
)

@Composable
fun OnboardingScreen() {
    val coroutineScope = rememberCoroutineScope()
    val items = listOf(
        PagerItemData(
            title = stringResource(R.string.pager_one_title),
            description = stringResource(R.string.pager_one_desc),
            image = painterResource(R.drawable.onb1)
        ),
        PagerItemData(
            title = stringResource(R.string.pager_two_title),
            description = stringResource(R.string.pager_two_desc),
            image = painterResource(R.drawable.onb2)
        ),
        PagerItemData(
            title = stringResource(R.string.pager_three_title),
            description = stringResource(R.string.pager_three_desc),
            image = painterResource(R.drawable.onb3)
        ),
    )
    val pagerState = rememberPagerState( pageCount = { items.size } )
    val progress = (pagerState.currentPage + pagerState.currentPageOffsetFraction + 1f) / (items.size)

    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fourPadding(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Spacer(Modifier.height(SpacingTheme.oneQuarter))

                Text(text = stringResource(R.string.skip))
            }
        },
        bottomBar = {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = SpacingTheme.four * 2 + SpacingTheme.one)
            ) {
                Canvas(modifier = Modifier.size((SpacingTheme.four - 2.dp) * 3)) {
                    val strokeWidth = 4.dp.toPx()
                    drawArc(
                        color = Color(0xFFB24D41),
                        startAngle = 270f,
                        sweepAngle = -360 * progress, // Negative for anticlockwise
                        useCenter = false,
                        style = Stroke(strokeWidth, cap = StrokeCap.Round)
                    )
                }
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(66.dp)
                        .background(
                            color = Color(0xFF446EA6),
                            shape = CircleShape
                        )
                        .clickable {
                            if (pagerState.currentPage != items.size - 1) {
                                coroutineScope.launch {
                                    pagerState.animateScrollToPage(
                                        pagerState.currentPage + 1,
                                        animationSpec = tween(
                                            durationMillis = 400, // Custom duration (1000ms = 1 second)
                                            easing = LinearOutSlowInEasing // Easing for a smooth effect
                                        )
                                    )
                                }
                            }
                        }
                ) {
                    if (pagerState.currentPage != items.size - 1) {
                        Image(
                            painter = painterResource(R.drawable.arrow_back),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.size(SpacingTheme.three)
                        )
                    } else {
                        Text(
                            text = stringResource(R.string.start),
                            color = Color.White
                        )
                    }
                }
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(MaterialTheme.colorScheme.background)
        ) {
            HorizontalPager(state = pagerState) { page ->
                val item = items[page]
                PagerItem(item, page, pagerState)
            }
        }
    }
}

@Composable
fun PagerItem(
    item: PagerItemData,
    page: Int,
    pagerState: PagerState
) {
    val pageOffset = (pagerState.currentPage - page) + pagerState.currentPageOffsetFraction
    val scale = 1f - (0.5f * abs(pageOffset))

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(SpacingTheme.two)
            .scale(scale.coerceIn(0.5f, 1f)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = item.image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(SpacingTheme.four * 10)
        )

        Spacer(modifier = Modifier.height(SpacingTheme.two))

        Text(
            text = item.title,
            fontSize = 18.sp,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(SpacingTheme.one + SpacingTheme.oneHalf))

        Text(
            text = item.description,
            fontSize = 14.sp,
            textAlign = TextAlign.Center
        )
    }
}


@Composable
@UFCPreview
fun OnboardingPreview() {
    OnboardingScreen()
}