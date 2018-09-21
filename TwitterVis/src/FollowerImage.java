import processing.core.PImage;

public class FollowerImage {
	private PImage image;
	private float yPos;
	private float xPos;
	
	public FollowerImage(PImage img, float xPosition, float yPosition) {
		image = img;
		xPos = xPosition;
		yPos = yPosition;
	}
	
	public FollowerImage(PImage img) {
		image = img;
	}
	
	public void setImage(PImage img) {image = img;}
	public PImage getImage() {return image;}
	
	public void setxPos(float xPosition) {xPos = xPosition;}
	public float getxPos() {return xPos;}
	
	public void setyPos(float yPosition) {yPos = yPosition;}
	public float getyPos() {return yPos;}
}
