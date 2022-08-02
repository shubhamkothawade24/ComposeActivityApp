package com.example.jetpackcomposetutorial

import android.media.Image
import android.os.Bundle
import android.provider.Settings.Global.getString
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcomposetutorial.R.string
import com.example.jetpackcomposetutorial.ui.theme.JetpackComposeTutorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTutorialTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TopImage(heading = getString(string.heading), description = getString(string.description), message = getString(
                                            string.message))
                }
            }
        }
    }
}

@Composable
fun TutorialText (heading : String, description: String, message:String ) {
    Column(){
        Text(text = heading, fontSize = 24.sp, modifier = Modifier
            .wrapContentWidth(align = Alignment.CenterHorizontally)
            .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 16.dp))
        Text(text = description, textAlign = TextAlign.Justify, modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth(align = Alignment.CenterHorizontally)
            .padding(start = 16.dp, end = 16.dp))
        Text(text = message, textAlign = TextAlign.Justify, modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth(align = Alignment.CenterHorizontally)
            .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 16.dp))
    }
}

@Composable
fun TopImage (heading : String, description: String, message:String ){
    val image = painterResource(id = R.drawable.bg_compose_background)
//    Box {
//        Image(
//            painter = image,
//            contentDescription = null,
//            modifier = Modifier
//                .fillMaxWidth()
//        )
//        TutorialText(heading = heading, description = description, message = message)
//    }
    Column(){
        Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
            )
            TutorialText(heading = heading, description = description, message = message)
        }
}



@Preview(showBackground = true)
@Composable
fun JetpackComposeTutorialPreview() {
    JetpackComposeTutorialTheme {
        TopImage(heading = "heading", description = "description", message = "message")
    }
}