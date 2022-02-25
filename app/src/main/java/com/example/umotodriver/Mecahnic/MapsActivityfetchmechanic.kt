package com.example.umotodriver.Mecahnic

import android.app.DownloadManager
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

import com.example.umotodriver.R
import com.example.umotodriver.databinding.ActivityMapsActivityfetchmechanicBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_maps_activityfetchmechanic.*
import okhttp3.OkHttpClient
import okhttp3.Request

class MapsActivityfetchmechanic : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var databaseRef: DatabaseReference
    private lateinit var binding: ActivityMapsActivityfetchmechanicBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsActivityfetchmechanicBinding.inflate(layoutInflater)
        setContentView(binding.root)

        accept.setOnClickListener {
            generateRout()
        }

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        databaseRef = Firebase.database.reference
        databaseRef.addValueEventListener(logListener)

        val location = LatLng(27.1767, 78.0081)
    }

    private fun generateRout() {

    }

    



    val logListener = object : ValueEventListener {
        override fun onCancelled(error: DatabaseError) {
            Toast.makeText(applicationContext, "Could not read from database", Toast.LENGTH_LONG).show()
        }

        //     @SuppressLint("LongLogTag")
        override fun onDataChange(dataSnapshot: DataSnapshot) {
            if (dataSnapshot.exists()) {

                val locationlogging = dataSnapshot.child("userlocation").getValue(Locatitonloggin::class.java)
                var driverLat= locationlogging?.Latitude
                var driverLong=locationlogging?.Longitude
                //Log.d("Latitude of driver", driverLat.toString())
                //    Log.d("Longitude read from database", driverLong.toString())

                if (driverLat !=null  && driverLong != null) {
                    // val driverLoc = LatLng(driverLong, driverLat)
                    val driverLoc = LatLng(driverLat, driverLong)

                    val markerOptions = MarkerOptions().position(driverLoc)
                    mMap.addMarker(markerOptions)
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(driverLoc, 16f))
                    //Zoom level - 1: World, 5: Landmass/continent, 10: City, 15: Streets and 20: Buildings

                    Toast.makeText(applicationContext, "Locations accessed from the database", Toast.LENGTH_LONG).show()
                }
            }
        }
    }



    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-34.0, 151.0)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }
}