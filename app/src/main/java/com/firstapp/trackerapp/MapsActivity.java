//package com.firstapp.trackerapp;
//
//import androidx.annotation.NonNull;
//import androidx.core.app.ActivityCompat;
//import androidx.fragment.app.FragmentActivity;
//
//import android.Manifest;
//import android.content.Intent;
//import android.content.pm.PackageManager;
//import android.location.Address;
//import android.location.Geocoder;
//import android.location.Location;
//import android.location.LocationListener;
//import android.location.LocationManager;
//import android.os.Bundle;
//import android.widget.CheckBox;
//import android.widget.EditText;
//import android.widget.Toast;
//
//import com.google.android.gms.maps.CameraUpdateFactory;
//import com.google.android.gms.maps.GoogleMap;
//import com.google.android.gms.maps.OnMapReadyCallback;
//import com.google.android.gms.maps.SupportMapFragment;
//import com.google.android.gms.maps.model.BitmapDescriptorFactory;
//import com.google.android.gms.maps.model.LatLng;
//import com.google.android.gms.maps.model.MarkerOptions;
//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.android.gms.maps.model.BitmapDescriptorFactory;
//
//
//
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import static com.firstapp.trackerapp.R.id.seats;
//
//public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
//
//    private GoogleMap mMap;
//    LocationManager locationManager;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_maps);
//        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
//        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
//                .findFragmentById(R.id.map);
//        assert mapFragment != null;
//        mapFragment.getMapAsync(this);
//
//        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
//        Intent intent = getIntent();
//        //get busId from login screen
//        final String busName = intent.getStringExtra(HomeActivity.busId);
//
//        final CheckBox cBox = (CheckBox) findViewById(seats);
////        final Boolean check_seats = cBox.isChecked();
//
//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_BACKGROUND_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            // TODO: Consider calling
//            //    ActivityCompat#requestPermissions
//            // here to request the missing permissions, and then overriding
//            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//            //                                          int[] grantResults)
//            // to handle the case where the user grants the permission. See the documentation
//            // for ActivityCompat#requestPermissions for more details.
//            return;
//        }
//        //if app has location access permission then
//
//        if (locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)){
//            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, new LocationListener() {
//                @Override
//                public void onLocationChanged(Location location) {
//                    double latitude = location.getLatitude();
//                    double longitude = location.getLongitude();
//
//                    LocationHelper helper = new LocationHelper(location.getLongitude(),location.getLatitude());
//
//                    //get id from userid
//                    String ID = busName;
//                    ID = busName.substring(5);
//                    ID = ID.replaceAll("s", "$0 ");
//
//                    //pass coordinates to database
//                    FirebaseDatabase.getInstance().getReference(ID.toUpperCase()).setValue(helper);
//                    //get checkbox value
//                    final CheckBox cBox = (CheckBox) findViewById(seats);
//                    //pass checkbox value to db(T/F)
//                    HashMap<String, Object> result = new HashMap<>();
//                    result.put("seats",cBox.isChecked());
//                    FirebaseDatabase.getInstance().getReference(ID.toUpperCase()).updateChildren(result);
//
////                    DatabaseReference ref=FirebaseDatabase.getInstance().getReference(ID.toUpperCase());
////                    Map<String, Object> updates = new HashMap<String,Object>();
////                    updates.put("seats", cBox.isChecked());
////                    ref.updateChildren(updates);
//
//                    //INSIDE THE MAP
//                    //get  coordinates
//                    LatLng latLng = new LatLng(latitude,longitude);
//                    Geocoder geocoder = new Geocoder(getApplicationContext());
//                    try {
//                        List<Address> addressList = geocoder.getFromLocation(latitude, longitude,1);
//                        //display locality
//                        String str = addressList.get(0).getLocality();
//                        mMap.addMarker(new MarkerOptions().position(latLng).title(str));
//                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,20.0f));   //move cam on getting coordinates
//                    }
//                    catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//                @Override
//                public void onStatusChanged(String provider,int status,Bundle extras){
//
//                }
//                @Override
//                public void onProviderEnabled(String provider){
//
//                }
//                @Override
//                public void onProviderDisabled(String provider){
//
//                }
//            });
//        }
//    }
//
//    /**
//     * Manipulates the map once available.
//     * This callback is triggered when the map is ready to be used.
//     * This is where we can add markers or lines, add listeners or move the camera. In this case,
//     * we just add a marker near Sydney, Australia.
//     * If Google Play services is not installed on the device, the user will be prompted to install
//     * it inside the SupportMapFragment. This method will only be triggered once the user has
//     * installed Google Play services and returned to the app.
//     */
//    @Override
//    public void onMapReady(GoogleMap googleMap) {
//        mMap = googleMap;
//
//    }
//}

package com.firstapp.trackerapp;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;



import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.firstapp.trackerapp.R.id.seats;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    LocationManager locationManager;
    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        assert mapFragment != null;
        mapFragment.getMapAsync(this);

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        Intent intent = getIntent();

        //get busId from login screen
        final String busName = intent.getStringExtra(HomeActivity.busId);
        //get checkbox value
        final CheckBox cBox = (CheckBox) findViewById(seats);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_BACKGROUND_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        //if app has location access permission then
        if (locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)){
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, new LocationListener() {
                @Override
                public void onLocationChanged(Location location) {
                    double latitude = location.getLatitude();
                    double longitude = location.getLongitude();

                    LocationHelper helper = new LocationHelper(location.getLongitude(),location.getLatitude());

                    //get id from userid
                    String ID = busName;
                    ID = busName.substring(5);
                    ID = ID.replaceAll("s", "$0 ");

                    //pass realtime coordinates to database
                    FirebaseDatabase.getInstance().getReference(ID.toUpperCase()).setValue(helper);
                    //get checkbox value
                    final CheckBox cBox = (CheckBox) findViewById(seats);
                    //pass checkbox value to db(T/F)
                    HashMap<String, Object> result = new HashMap<>();
                    result.put("seats",cBox.isChecked());
                    FirebaseDatabase.getInstance().getReference(ID.toUpperCase()).updateChildren(result);

                    //INSIDE THE MAP
                    //get  coordinates
                    LatLng latLng = new LatLng(latitude,longitude);
                    Geocoder geocoder = new Geocoder(getApplicationContext());
                    try {
                        List<Address> addressList = geocoder.getFromLocation(latitude, longitude,1);
                        //display locality
                        String str = addressList.get(0).getLocality();
                        mMap.clear();
                        mMap.addMarker(new MarkerOptions().position(latLng).title(str).draggable(true).icon(BitmapDescriptorFactory.fromResource(R.drawable.markerm)));
                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,16.6f));   //move cam on getting coordinates
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                @Override
                public void onStatusChanged(String provider,int status,Bundle extras){

                }
                @Override
                public void onProviderEnabled(String provider){

                }
                @Override
                public void onProviderDisabled(String provider){

                }
            });
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

    }
}