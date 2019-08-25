package tw.org.iii.appps.brad38;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity {
    private GoogleMap googleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(new MyCallback());

    }

    public void test1(View view) {
        googleMap.animateCamera(CameraUpdateFactory.zoomIn());
    }
    public void test2(View view) {
        googleMap.animateCamera(CameraUpdateFactory.zoomOut());
    }

    private class MyCallback implements OnMapReadyCallback {
        @Override
        public void onMapReady(GoogleMap googleMap) {
            Log.v("brad", "OK");
            MainActivity.this.googleMap = googleMap;

            LatLng tw = new LatLng(23.476525, 120.449937);
            MainActivity.this.googleMap.moveCamera(CameraUpdateFactory.newLatLng(tw));
            googleMap.animateCamera(
                    CameraUpdateFactory.newLatLngZoom(tw, 12.0f));

            googleMap.setOnCameraChangeListener(new GoogleMap.OnCameraChangeListener() {
                @Override
                public void onCameraChange(CameraPosition cameraPosition) {
                    Log.v("brad", "zoom:" + cameraPosition.zoom);
                }
            });

        }
    }

}
