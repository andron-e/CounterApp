package edu.temple.counterapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import edu.temple.counterapp.ui.theme.CounterAppTheme

// scaffolding fills the screen
class MainActivity : ComponentActivity() {


    val counterViewModel by viewModels<CounterViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CounterAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Counter(
                        counterViewModel,
                        modifier = Modifier.padding(innerPadding)
                    )       // calls fun Greeting, Modifier.padding(innerPadding) is a modifier that adds padding to the Greeting composable
                }
            }
        }
    }
}

// textView, text Composable accomplishes the same thing (Greeting is UpperCase)
// Greeting is a Composable function
// Modifier = Modifier is a parameter that is a modifier that is used to modify the composable that is calling it
//
@Composable
fun Counter(counterViewModel: CounterViewModel, modifier: Modifier = Modifier) {

    //var countValue by rememberSaveable() { mutableIntStateOf(0) }           // watch video if no understand
    // google jetpack compose dependency
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = {
            counterViewModel.counterValue.intValue++
        }) { Text("Up") }

        Text(
            text = counterViewModel.counterValue.intValue.toString(), // diff in delegating vs remember: countValue.value.toString()
            modifier = modifier,
            fontSize = 48.sp) // text will have its own modifier passed in from the Greeting function

        Button(onClick = {
            if (counterViewModel.counterValue.intValue > 0)
                counterViewModel.counterValue.intValue--
        }) { Text("Down") }
    }

}

// GreetingPreview is a Composable function
// GreetingPreview is a preview of Greeting, meaning it will show up in the previewer, not the app
// @Preview is an annotation
// @Preview(showBackground = true) is an attribute
// @Composable is an annotation
@Preview(showBackground = true)
@Composable
fun CounterPreview() {
    CounterAppTheme {
        //Counter()
    }
}

@Preview(showBackground = true)
@Composable
fun CounterPreview2() {
    CounterAppTheme {
        //Counter()
    }
}