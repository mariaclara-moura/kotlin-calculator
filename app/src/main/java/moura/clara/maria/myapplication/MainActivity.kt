package moura.clara.maria.myapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import moura.clara.maria.myapplication.ui.theme.BasicCalculatorTheme
import moura.clara.maria.myapplication.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        createListeners()
//        setContent {
//            BasicCalculatorTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
//            }
//        }
    }
    override fun onStart(){
        super.onStart()
        Log.i("TAG_INFO", "onStart invocado!")
    }
    override fun onResume(){
        super.onResume()
        Log.i("TAG_INFO", "onResume invocado!")
    }
    override fun onPause(){
        super.onPause()
        Log.i("TAG_INFO", "onPause invocado!")
    }
    override fun onStop(){
        super.onStop()
        Log.i("TAG_INFO", "onStop invocado!")
    }
    override fun onDestroy(){
        super.onDestroy()
        Log.i("TAG_INFO", "onDestroy invocado!")
    }
    private fun createListeners(){
        binding.sum.setOnClickListener{operation(0)}
        binding.sub.setOnClickListener{operation(1)}
        binding.mul.setOnClickListener{operation(2)}
        binding.div.setOnClickListener{operation(3)}
    }
    private fun operation(option: Int){
        val value1 = binding.number1.text.toString().toDoubleOrNull() ?: 0.0
        val value2 = binding.number2.text.toString().toDoubleOrNull() ?: 0.0

        val result = when(option){
            0 -> value1 + value2
            1 -> value1 - value2
            2 -> value1 * value2
            3 -> if (value2 != 0.0) value1 / value2 else Double.NaN
            else -> { "operação não suportada" }
        }

        binding.result.text = result.toString()

    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BasicCalculatorTheme {
        Greeting("Android")
    }
}