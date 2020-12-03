package ru.ridkeim.mapsexample

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.buttonMapsApp).setOnClickListener {
            val geoUriString = "geo:52.728484,41.441705?z=18"
            val geoUri = Uri.parse(geoUriString)
            val mapIntent = Intent(Intent.ACTION_VIEW, geoUri)
            dispatchIntent(mapIntent)
        }
        findViewById<Button>(R.id.buttonMapsAppStreet).setOnClickListener {
            val geoUriString = "google.streetview:cbll=52.7285726,41.4424306&cbp=1,205,,0.8,-15.0&mz=18"
            val geoUri = Uri.parse(geoUriString)
            val mapIntent = Intent(Intent.ACTION_VIEW, geoUri)
            dispatchIntent(mapIntent)
        }
        findViewById<Button>(R.id.buttonMapsActivity).setOnClickListener {
            dispatchIntent(Intent(this,MapsActivity::class.java))
        }
    }

    @SuppressLint("QueryPermissionsNeeded")
    private fun dispatchIntent(intent: Intent){
        intent.resolveActivity(packageManager)?.also {
            startActivity(intent)
        }
    }
}