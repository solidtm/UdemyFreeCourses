package com.solid.ufc.onboarding.view

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
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.solid.ufc.onboarding.R
import com.solid.ufc.onboarding.viewmodel.OnboardingViewModel
import com.solid.ufc.ui.theme.PrimaryCardColors
import com.solid.ufc.ui.theme.UFCTheme
import com.solid.ufc.ui.utils.UFCPreview
import com.solid.ufc.ui.utils.fourPadding
import com.solid.ufc.ui.utils.onePadding
import com.solid.ufc.ui.utils.threePadding
import com.solid.ufc.ui.utils.twoPadding
import kotlinx.coroutines.launch
import kotlin.math.min

data class PagerItemData(
    val title: String,
    val description: String,
    val image: Painter
)
@Composable
fun OnboardingScreen(
    viewModel: OnboardingViewModel,
    rootNavController: NavController
) {

    val items = listOf(
        PagerItemData(
            title= stringResource(R.string.pager_one_title),
            description=stringResource(R.string.pager_one_desc),
            image = painterResource(R.drawable.onb1)
    ),     PagerItemData(
            title= stringResource(R.string.pager_two_title),
            description=stringResource(R.string.pager_two_desc),
            image = painterResource(R.drawable.onb2)
    ),     PagerItemData(
            title= stringResource(R.string.pager_three_title),
            description=stringResource(R.string.pager_three_desc),
            image = painterResource(R.drawable.onb3)
    ),
    )
    val pagerState = rememberPagerState(pageCount = {
        items.size
    })
    val progress =(pagerState.currentPage +pagerState.currentPageOffsetFraction+1f) / (items.size )

    val coroutineScope = rememberCoroutineScope()
//    LaunchedEffect("goToHome") {
//        viewModel.goToHome(rootNavController) //you can comment this out when you want to implement going to the home screen
//    }

     Scaffold (
         topBar = {
             Row(
                 modifier = Modifier
                     .fillMaxWidth()
                     .fourPadding(),
                 horizontalArrangement = Arrangement.SpaceBetween
             ) {
                 Spacer(Modifier.height(3.dp))

                 Text(text = stringResource(R.string.skip))
             }
         },
bottomBar = {

   Box(
       contentAlignment = Alignment.Center,
       modifier = Modifier
           .fillMaxWidth()
           .padding(bottom = 70.dp)
   ){
//       CircularProgressIndicator(
//           progress = { (pagerState.currentPage +pagerState.currentPageOffsetFraction+1f) / (items.size ) },
//           modifier = Modifier.size(90.dp),
//           color = Color(0xFFB24D41),
//           strokeWidth = 4.dp,
//           trackColor = Color.Transparent,
//           strokeCap = StrokeCap.Round,
//
//       )
       Canvas(modifier = Modifier.size(90.dp)) {
           val strokeWidth = 4.dp.toPx()
           val size = min(size.width, size.height)
           val radius = (size - strokeWidth) / 2
           drawArc(
               color =  Color(0xFFB24D41),
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
                   if(pagerState.currentPage ==items.size-1){

                   }else{
                      coroutineScope.launch {
                          pagerState.animateScrollToPage(pagerState.currentPage+1,0f)
                      }
                   }
               }
       ) {
           if(pagerState.currentPage !=items.size-1 ){
               Image(
                   painter =painterResource(R.drawable.arrow_back),
                   contentDescription = null,
                   contentScale = ContentScale.Crop,
                   modifier = Modifier.size(24.dp)
               )
           }

           else{
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
                 Column(
                     modifier = Modifier
                         .fillMaxSize()
                         .padding(16.dp),
                     horizontalAlignment = Alignment.CenterHorizontally,
                     verticalArrangement = Arrangement.Center
                 ) {
                     Image(
                         painter = item.image,
                         contentDescription = null,
                         contentScale = ContentScale.Crop,
                         modifier = Modifier.size(320.dp)
                     )
                     Spacer(modifier = Modifier.height(16.dp))
                     Text(
                         text = item.title,
                         fontSize = 18.sp,
                         textAlign = TextAlign.Center
                     )
                     Spacer(modifier = Modifier.height(12.dp))
                     Text(
                         text = item.description,
                         fontSize = 14.sp,
                         textAlign = TextAlign.Center
                     )
                 }
             }
         }
     }
}

//@Composable
//@UFCPreview
//fun OnboardingScreenPreview() {
//    UFCTheme {
//        OnboardingScreen(
//            viewModel = OnboardingViewModel(),
//            rootNavController = NavController(LocalContext.current)
//        )
//    }
//}