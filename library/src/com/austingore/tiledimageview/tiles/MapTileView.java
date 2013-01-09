package com.austingore.tiledimageview.tiles;

import android.content.Context;
import android.widget.ImageView;

public class MapTileView extends ImageView {

	private MapTile tile;
	
	public MapTileView(Context context) {
		super(context);
		setAdjustViewBounds(false);
		setScaleType(ScaleType.MATRIX);
	}
	
	public MapTile getTile(){
		return tile;
	}
	
	public void setTile(MapTile tile){
		tile.view = this;		
		setImageBitmap(tile.bitmap);
	}

}
