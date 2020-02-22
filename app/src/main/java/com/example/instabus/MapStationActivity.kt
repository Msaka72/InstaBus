package com.example.instabus

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

data class Localisation(val id: Int, val street_name: String, val lat: Float, val lon: Float)

class MapStationActivity : Fragment (), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    companion object {
        var mapFragment : SupportMapFragment?=null
        val TAG: String = MapStationActivity::class.java.simpleName
        fun newInstance() = MapStationActivity()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var rootView = inflater.inflate(R.layout.fragment_map_station, container, false)

        mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(this)

        return rootView
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        mMap = googleMap!!
        // Add a markers and move the camera
        val location1 = LatLng(41.3985182,2.1917991)
        mMap.addMarker(MarkerOptions().position(location1).title("My Location"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(location1))
    }

    /*
    lateinit var googleMap: GoogleMap

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?

        if (mapFragment != null){
            mapFragment.getMapAsync(OnMapReadyCallback {
                googleMap = it

            })
        }
        else {}

        return inflater.inflate(R.layout.fragment_map_station, container, false)

    }

    override fun onMapReady(p0: GoogleMap) {
        googleMap = p0


        val location1 = LatLng(41.3985182,2.1917991)
        googleMap.addMarker(MarkerOptions().title("My Location").position(location1))

    }

     */
}