package com.example.imlogin.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.baidu.mapapi.map.MapView;
import com.example.imlogin.R;

public class MapActivity extends AppCompatActivity {

    private MapView mMapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        initView();
    }

    private void initView() {
        mMapView = (MapView) findViewById(R.id.mapView);

    }

    @Override
    protected void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }
}
