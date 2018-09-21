import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;
import twitter4j.PagableResponseList;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterVis extends PApplet {
		
	FollowerCircle firstGen;
	
	VisUtility visUtility;
	
	int time;
	int wait = 200;
	
	int circleRadius = 150;
	public static void main(String[] args) {
		PApplet.main("TwitterVis");

	}
	
	public void settings() {
		size(640, 480);
	}
	
	public void setup() {
		surface.setResizable(true);
		
		visUtility = new VisUtility(this);
		
		
		firstGen = new FollowerCircle(visUtility.loadFollowers("DepressedLinux"), 320, 240, circleRadius);
	}
	public void draw() {
		background(0,0,0);

		firstGen.draw(this);
		
		image(visUtility.getUserImage("DepressedLinux"), width/2, height/2);
		
		textSize(12);
		text("Twitter Generations v0.1b",0,12);
		text("Created by Pizazzle56", width/2 - 32, height-12);
	}
	
	
}
