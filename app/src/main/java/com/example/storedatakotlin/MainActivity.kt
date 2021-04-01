package com.example.storedatakotlin

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // "this" always refers to the main activity
        val sharedPreferences = this.getSharedPreferences("com.example.storedatakotlin", Context.MODE_PRIVATE)

        var age = 40

      //  sharedPreferences.edit().putInt("userAge",age).apply() // data is stored but we can test that whether the data is stored or not
        // for testing  i am going to comment or remove the above line of code and write a new one.
        // code written below is for retrieving the stored data in sharedpreferences variable.

        val storedAge = sharedPreferences.getInt("userAge",0) // defvalue is "0" means if we dont find data in the sharedpreference variable it will give us 0 in return
        println("storedAge: $storedAge")

        //  if we can retrieve the data with this method mean we have successfull stored the data when we first ran the application

        //EDITING DATA
        // lets say the age is changed now and we need to edit the previous saved data
        age = 31
       // sharedPreferences.edit().putInt("userAge",age).apply() // by using this commad age is edited and now the age is 31.
        // if we comment the above line of code and change the value of age and run. the output will be the previous value of age stored in it not the new.
        val storedAge2 = sharedPreferences.getInt("userAge",0)
        println("storedAge2: $storedAge2")

        //REMOVING DATA7

        sharedPreferences.edit().remove("userAge").apply() // for removing the stored data
        val storedAge3 = sharedPreferences.getInt("userAge",0)
        println("storedAge3: $storedAge3")

        // now the data is removed and the output will be 0 for all variable of "stored age"
    }
}