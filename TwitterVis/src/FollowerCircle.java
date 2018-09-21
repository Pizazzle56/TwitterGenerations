import java.util.ArrayList;

import processing.core.PApplet;

public class FollowerCircle {
	private ArrayList<FollowerImage> fImage;
	private float posCenterX;
	private float posCenterY;
	private int circleRadius;
	

	
	public FollowerCircle(ArrayList<FollowerImage> fImage, float posCenterX, float posCenterY, int circleRadius) {
		this.fImage = fImage;
		this.posCenterX = posCenterX;
		this.posCenterY = posCenterY;
		this.circleRadius = circleRadius;
		
	}
	
	public void draw(PApplet parentApplet) {
		for(int i = 0; i < fImage.size(); i++) {
			fImage.get(i).getImage().resize(fImage.get(i).getImageWidth(), fImage.get(i).getImageHeight());
			double circleChunk =((360 / fImage.size()) / (180 / Math.PI));
			fImage.get(i).setxPos(posCenterX + parentApplet.cos((float) (circleChunk * i)+ ((float) .001 * parentApplet.millis()))*circleRadius);
			fImage.get(i).setyPos(posCenterY + parentApplet.sin((float) circleChunk * i + ((float) .001 * parentApplet.millis()))*circleRadius);

			parentApplet.image(fImage.get(i).getImage(), fImage.get(i).getxPos(), fImage.get(i).getyPos());
		}


	}

}
