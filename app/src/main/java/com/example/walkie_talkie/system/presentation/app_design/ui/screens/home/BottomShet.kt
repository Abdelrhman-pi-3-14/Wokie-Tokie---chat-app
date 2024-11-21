package com.example.walkie_talkie.system.presentation.app_design.ui.screens.home

import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.walkie_talkie.R
import com.example.walkie_talkie.system.presentation.feature_weather.viewModel.WeatherViewModel
import com.example.walkie_talkie.theme.darkBlue
import com.example.walkie_talkie.theme.lightBlue
import com.example.walkie_talkie.ui_thames.theme.digital

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheet(sheetState: SheetState , onDismiss: () -> Unit) {

    ModalBottomSheet(
        sheetState = sheetState ,
        onDismissRequest = {
            onDismiss()
        } ,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight() ,
        shape = RoundedCornerShape(topStart = 40.dp , topEnd = 40.dp) ,
        dragHandle = {
            BottomSheetDefaults.DragHandle()
        } ,
        containerColor = darkBlue
    ) {
        ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
            val (  city  , enterCity) = createRefs()
            var cityName by remember { mutableStateOf("") }
            val viewModel: WeatherViewModel = viewModel()





            Text(
                text = "Enter your country and city : " ,
                color = lightBlue ,
                fontSize = 20.sp ,
                fontFamily = digital ,
                modifier = Modifier
                    .constrainAs(city) {
                        top.linkTo(parent.top , margin = 16.dp)
                        start.linkTo(parent.start , margin = 16.dp)
                    }
            )
            TextField(value = cityName ,
                onValueChange = {
                    cityName = it
                } ,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done) ,
                keyboardActions = KeyboardActions(onDone = {
                    viewModel.GetData(cityName)
                    Log.i("Wea" , "onCreate: ${viewModel.weatherData.value}")
                }) ,
                enabled = true ,
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .clip(RoundedCornerShape(50.dp))
                    .border(
                        width = 1.dp ,
                        color = lightBlue ,
                        shape = RoundedCornerShape(50.dp)
                    )
                    .constrainAs(enterCity) {
                        top.linkTo(city.bottom , margin = 16.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom , margin = 64.dp)
                    } ,
                placeholder = {
                    Text(text = "Country , City" , style = TextStyle(color = Color.Gray))
                } ,
                maxLines = 50 ,
                colors = TextFieldDefaults.colors(
                    focusedTextColor = lightBlue ,
                    unfocusedTextColor = lightBlue ,
                    focusedContainerColor = darkBlue ,
                    unfocusedContainerColor = darkBlue ,
                    focusedIndicatorColor = darkBlue ,
                    unfocusedIndicatorColor = darkBlue ,
                    cursorColor = lightBlue
                ) ,
                singleLine = true ,

                textStyle = TextStyle(
                    color = Color.White ,
                    fontSize = 20.sp ,
                ) ,
                trailingIcon = {
                    if (cityName.isNotEmpty()) {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.close_ic) ,
                            modifier = Modifier.clickable {
                                cityName = ""
                            } ,
                            contentDescription = "Search" ,
                            tint = Color.Red
                        )
                    }

                }
            )

        }

    }
}
