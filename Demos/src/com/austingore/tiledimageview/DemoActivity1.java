//Following example from https://github.com/moagrius/MapView/wiki/Example-Activity

package com.austingore.tiledimageview;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class DemoActivity1 extends Activity
{
    private MapView mapView;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        FrameLayout frame = new FrameLayout(this);
        setContentView(frame);


        mapView = new MapView(this);
        mapView.setBackgroundColor(0xFFCD5C5C);
        mapView.setTileTranstionEnabled(true);
        mapView.setTileTransitionDuration(400);

        //add a tile set of images - first set to be added are the ones that will be used when all the way zoomed in on.
        //last tile set added will be the one used for most zoomed out view

        //word of caution: had to stitch together, then downsample my own downnsample: given one (alexis.jpg caused boundary between tiles to be shown)
        mapView.addZoomLevel(1365, 2048,"tiles/alexis/alexis100/alexis_100_%col%_%row%.jpg", "downsamples/alexis/alexis2.jpg");
        mapView.addZoomLevel(683, 1024,"tiles/alexis/alexis50/alexis_50_%col%_%row%.jpg", "downsamples/alexis/alexis2.jpg");
        mapView.addZoomLevel(341, 512,"tiles/alexis/alexis25/alexis_25_%col%_%row%.jpg", "downsamples/alexis/alexis2.jpg");

        mapView.setMarkerAnchorPoints(0.5f, 1.0f);
        mapView.registerGeolocator(42.379676, -71.040280, 42.346550, -71.094919);
        mapView.initialize();

        ImageView marker = new ImageView(this);
        marker.setImageResource(R.drawable.ic_launcher);
        mapView.addMarker(marker, 42.35848, -71.063736);


        mapView.addOnReadyListener(new Runnable(){
            @Override
            public void run() {
                mapView.moveToAndCenter(42.35848, -71.063736);
            }


        });

        FrameLayout.LayoutParams mapViewLayout = new FrameLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        frame.addView(mapView, mapViewLayout);

}
}
