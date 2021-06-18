package com.example.viewbinding

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.text.isDigitsOnly
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(),View.OnClickListener {
    var int=0
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvTextView.apply {
            isVisible=false
           text="100"
           setTextColor(getColor(R.color.design_default_color_on_primary))
        }
        etEditText.apply {
            hint="Enter your name"
            setText("Prateek Singh")
            addTextChangedListener {
                Log.i("ViewBinding", it.toString())
                if (it.toString()
                        .isNotEmpty() && it.toString().length > 6 && it.toString().length < 20


                ) {
                    //Toast.makeText(this@MainActivity, "Enter Name", Toast.LENGTH_SHORT).show()
                    btnButton.isEnabled = true
                } else {

                    btnButton.isEnabled = false


                }

                ///We cak write above line in this way
                //btnButton.isEnabled = it.toString().isNotEmpty() && it.toString().length > 6 && it.toString().length < 20
            }

        }
               /////////-----------First way to set on click listener-------------------//
        btnButton.setOnClickListener {
            int ++
            Toast.makeText(it.context,"Button clicked $int",Toast.LENGTH_SHORT).show()

        }


        /////////-----------Second way to set on click listener-------------------//

        btnButton.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                Toast.makeText(v?.context,"Button clicked $int",Toast.LENGTH_SHORT).show()

            }
        })

        /////---------Fourth way to set onClickListener---------------------//
        //----------By inheritance View.OnClickListener and overriding the onCLick Function-----//


    }

    override fun onClick(v: View?) {
        Toast.makeText(v?.context, "Button clicked by interface $int", Toast.LENGTH_SHORT).show()

    }

    /////////-----------Third way to set on click listener-------------------//
        ////////---------------------Add onClick on xml--------- -----------------//


//    fun showToast(view: View) {
//        int++
//        Toast.makeText(this@MainActivity,"Button clicked $int",Toast.LENGTH_SHORT).show()
//
//    }
}