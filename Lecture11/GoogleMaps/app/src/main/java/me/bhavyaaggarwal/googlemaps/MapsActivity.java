package me.bhavyaaggarwal.googlemaps;

import android.annotation.SuppressLint;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    public static final String TAG = "MAP";

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


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
    @SuppressLint("MissingPermission")
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng cb = new LatLng(28.696891, 77.142350);
        mMap.addMarker(new MarkerOptions().position(cb).title("Marker in Coding Blocks"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(cb, 20));
        mMap.addPolygon(new PolygonOptions().add(
                new LatLng(28.696831, 77.142347),
                new LatLng(28.696935, 77.142406),
                new LatLng(28.696964, 77.142309),
                new LatLng(28.696856, 77.142260)
        ));

        final PolylineOptions polylineOptions = new PolylineOptions();

        LocationManager locMan = (LocationManager) getSystemService(LOCATION_SERVICE);
        LocationListener locLis = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                Log.d(TAG, "onLocationChanged: latitude = " + location.getLatitude());
                Log.d(TAG, "onLocationChanged: longitude = " + location.getLongitude());
                Log.d(TAG, "onLocationChanged: altitude = " + location.getAltitude());
                Log.d(TAG, "onLocationChanged: accuracy = " + location.getAccuracy());

                mMap.clear();
                polylineOptions.add(new LatLng(location.getLatitude(), location.getLongitude()));
                mMap.addPolyline(polylineOptions);

            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };

        locMan.requestLocationUpdates(
                LocationManager.NETWORK_PROVIDER,
                1000,
                10,
                locLis
        );


    }


}
