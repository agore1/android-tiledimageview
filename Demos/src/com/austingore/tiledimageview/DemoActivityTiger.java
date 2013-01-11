//Following example from https://github.com/moagrius/MapView/wiki/Example-Activity

package com.austingore.tiledimageview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;

import android.widget.Toast;

public class DemoActivityTiger extends Activity
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

        mapView.addZoomLevel(1600, 1200, "tiles/tiger/tiger1600/crop_%row%_%col%.png","downsamples/tiger/tiger400.jpg");
        mapView.addZoomLevel(800, 600, "tiles/tiger/tiger800/crop_%row%_%col%.png","downsamples/tiger/tiger400.jpg");
        mapView.addZoomLevel(400, 300,"tiles/tiger/tiger400/crop_%row%_%col%.png", "downsamples/tiger/tiger400.jpg");
        mapView.setMarkerAnchorPoints(0.5f, 1.0f);
        mapView.registerGeolocator(42.379676, -71.040280, 42.346550, -71.094919);
        mapView.initialize();


        //1st marker
        ImageView marker1 = new ImageView(this);
        marker1.setClickable(true);
        marker1.setImageResource(R.drawable.ic_launcher);

        marker1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CharSequence helloMessage = "Marker 1 clicked!";
                int duration = Toast.LENGTH_SHORT;
                Toast toast1 = Toast.makeText(getApplicationContext(), helloMessage, duration);
                toast1.show();
            }
        });
        mapView.addMarker(marker1, 42.34958, -71.083736);


        //2nd marker
        ImageView marker2 = new ImageView(this);
        marker2.setClickable(true);
        marker2.setImageResource(R.drawable.ic_launcher);

        marker2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CharSequence helloMessage = "Marker 2 clicked!";
                int duration = Toast.LENGTH_SHORT;
                Toast toast1 = Toast.makeText(getApplicationContext(), helloMessage, duration);
                toast1.show();
            }
        });
        mapView.addMarker(marker2, 42.34958, -71.063746);


        //3rd marker

        ImageView marker3 = new ImageView(this);
        marker3.setClickable(true);
        marker3.setImageResource(R.drawable.ic_launcher);

        marker3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CharSequence helloMessage = "Marker 3 clicked!";
                int duration = Toast.LENGTH_SHORT;
                Toast toast1 = Toast.makeText(getApplicationContext(), helloMessage, duration);
                toast1.show();
            }
        });
        mapView.addMarker(marker3, 42.36958, -71.063746);

        mapView.addOnReadyListener(new Runnable(){
            @Override
            public void run() {
                mapView.moveToAndCenter(42.35848, -71.063736);
            }


        });

        FrameLayout.LayoutParams mapViewLayout = new FrameLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, 2);
        frame.addView(mapView, mapViewLayout);

    }
}
