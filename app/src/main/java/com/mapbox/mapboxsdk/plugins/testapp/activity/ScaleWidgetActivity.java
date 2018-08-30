package com.mapbox.mapboxsdk.plugins.testapp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;

import com.example.plugin_scale.ScaleWidgetPlugin;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.plugins.testapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import timber.log.Timber;

public class ScaleWidgetActivity extends AppCompatActivity implements OnMapReadyCallback {
  @BindView(R.id.mapView)
  MapView mapView;

  private ScaleWidgetPlugin scaleWidgetPlugin;
  private MapboxMap mapboxMap;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_scale_widget);
    ButterKnife.bind(this);
    mapView.onCreate(savedInstanceState);
    mapView.getMapAsync(this);
  }

  @Override
  public void onMapReady(MapboxMap mapboxMap) {
    this.mapboxMap = mapboxMap;
    this.scaleWidgetPlugin = new ScaleWidgetPlugin(mapView, mapboxMap, getScreenWidth());
  }

  private int getScreenWidth() {
    DisplayMetrics displayMetrics = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
    return displayMetrics.widthPixels;
  }

  @OnClick(R.id.fabScaleWidget)
  public void onScaleFabClicked() {
    if (mapboxMap != null) {
      scaleWidgetPlugin.setEnabled(!scaleWidgetPlugin.isEnabled());
      Timber.e("Traffic plugin is enabled :%s", scaleWidgetPlugin.isEnabled());
    }
  }


  @Override
  protected void onStart() {
    super.onStart();
    mapView.onStart();
  }

  @Override
  protected void onResume() {
    super.onResume();
    mapView.onResume();
  }

  @Override
  protected void onPause() {
    super.onPause();
    mapView.onPause();
  }

  @Override
  protected void onStop() {
    super.onStop();
    mapView.onStop();
  }

  @Override
  protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    mapView.onSaveInstanceState(outState);
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    mapView.onDestroy();
  }

  @Override
  public void onLowMemory() {
    super.onLowMemory();
    mapView.onLowMemory();
  }
}
