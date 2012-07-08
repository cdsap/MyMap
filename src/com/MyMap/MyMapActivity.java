package com.MyMap;

import java.util.List;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

public class MyMapActivity extends MapActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        MapView mapView = (MapView) findViewById(R.id.mapview);
        mapView.setBuiltInZoomControls(true);    
        MapController myController = mapView.getController();
        List<Overlay> mapOverlays = mapView.getOverlays();
        Drawable drawable = this.getResources().getDrawable(R.drawable.ic_launcher);
        HelloItemizedOverlay itemizedOverlay = new HelloItemizedOverlay(drawable,this);
        GeoPoint point = new GeoPoint(4129694,206722);
        OverlayItem overlayitem = new OverlayItem(point,"BCN","I'm in Barcelona");
        itemizedOverlay.addOverlay(overlayitem);
        myController.setZoom(8);
        myController.animateTo(point);
        
        
        mapOverlays.add(itemizedOverlay);  
}

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
}