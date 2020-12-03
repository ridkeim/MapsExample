package ru.ridkeim.mapsexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        mMap.isBuildingsEnabled = true
        // Add a marker in Sydney and move the camera
        val position1 = LatLng(52.743072, 41.451439)
        val position2 = LatLng(52.751044, 41.414929)

        mMap.uiSettings.setAllGesturesEnabled(true)
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(position1,15F))
        mMap.setOnMapLoadedCallback(){
            mMap.animateCamera(CameraUpdateFactory.zoomTo(10F),1000,null)
            val cameraPosition = CameraPosition.Builder()
                .target(position2)
                .zoom(16f)
                .bearing(0f)
                .tilt(45f)
                .build()
            mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition),4000,null)
        }
    }
}