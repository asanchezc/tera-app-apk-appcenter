package com.bns.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.microsoft.appcenter.AppCenter;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.crashes.Crashes;
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.widget.Button
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        AppCenter.start(
            application, "7f1e9201-a548-41e9-8cd7-3e255fb3b1c9",
            Analytics::class.java, Crashes::class.java
        )

        setContentView(R.layout.activity_main)

        val btnCarrito = findViewById(R.id.btnCarrito) as Button
        val btnPromociones = findViewById(R.id.btnPromociones) as Button
        val btnError = findViewById(R.id.btnError) as Button

        btnCarrito.setOnClickListener {

            Analytics.trackEvent("VerCarrito");
            Toast.makeText(this@MainActivity, "Ver Mi Carrito.", Toast.LENGTH_SHORT).show()

        }


        btnPromociones.setOnClickListener {
            Analytics.trackEvent("VerPromociones");
            Toast.makeText(this@MainActivity, "Ver Promociones.", Toast.LENGTH_SHORT).show()

        }

        btnError.setOnClickListener{
            throw Exception("Error al buscar usuario...")
        }
    }
}
