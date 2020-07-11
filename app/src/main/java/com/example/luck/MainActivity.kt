package com.example.luck

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var luck=Luck(this)

        var constraintLayout: ConstraintLayout=findViewById(R.id.rootlayout);

        constraintLayout.addView(luck);

    }
}
