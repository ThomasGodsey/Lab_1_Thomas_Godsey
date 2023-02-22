/** These are all of our imported classes and our package statement */
package com.zybooks.pizzapartyapp
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import org.w3c.dom.Text
import java.lang.Math.ceil

/** The number of slices per pizza.*/
const val SLICES_PER_PIZZA = 8
/** The main activity of the Pizza Party App. (Where everything happens, for the most part) */
class MainActivity : AppCompatActivity() {

    /**  Variables that we "wire" to our UI elements. */
    private lateinit var editText: EditText
    private lateinit var radioButtonHunger: RadioGroup
    private lateinit var textView3: TextView

    /** Called when the activity is starting or first run.*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

/** We use our previously created variables and "wire" them to their respective UI widgets here */
        radioButtonHunger = findViewById(R.id.radio_group)
        editText = findViewById(R.id.editText)
        val buttonClick = findViewById<Button>(R.id.button)
        textView3 = findViewById<TextView>(R.id.textView3)
        buttonClick.setOnClickListener{
            calculateClick()
        }
    }

    /** Calculates the number of pizzas required and updates the UI accordingly. */
    fun calculateClick(){

/** Get the number of people from the EditText. */
        val numOfPeople = editText.text.toString()
        var numOfP: Int = 0

/** We use a try/catch block to prevent any possible NumberFormatExceptions */
        try{
            numOfP = numOfPeople.toInt();
        }
        catch (e: NumberFormatException){
            throw NumberFormatException("Invalid Input: Must be a valid number.")
        }

        /**  This is where we use the user's input (radio buttons + number of people) to calculate
         * the number of pizzas needed */
        val hungerToSlices = when (radioButtonHunger.checkedRadioButtonId){
            R.id.light_radio_button -> 2
            R.id.medium_radio_button -> 3
            else -> 4
        }
        val totalPizzas = ceil(numOfP * hungerToSlices / SLICES_PER_PIZZA.toDouble()).toInt()

        /** This code updates our "Total Pizzas" text view with the correct amount */
        textView3.text = "Number of Pizzas: $totalPizzas"
    }
}