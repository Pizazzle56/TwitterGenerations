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
	ConfigurationBuilder cb;
	Twitter twitter;
	ArrayList<User> followers;
	ArrayList<FollowerImage> fImage;
	User originalUser;
	
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
		visUtility = new VisUtility(this);
		
		time = millis();
		followers = new ArrayList<User>();
		fImage = visUtility.loadFollowers("DepressedLinux");
		cb = new ConfigurationBuilder();
		cb.setOAuthConsumerKey("POhVTI0HbMy0AyjWfkXTDUnQa");
		cb.setOAuthConsumerSecret("Vkziw0BVwZLZ6uRCdXHf90yDgoNChabsEPzjv6HMIttd35SpTv");
		cb.setOAuthAccessToken("2239613238-wrVMW49XcaWBZTxu2oMn3txSRBDJsKUKqSi8znB");
		cb.setOAuthAccessTokenSecret("SEJva2Ai8nhWgsnxTt3w85QPYy0wsL7GEs8aRQ09ByhoA");
		twitter = new TwitterFactory(cb.build()).getInstance();
	}
	
	public void draw() {
		background(millis()/300,millis()/300,millis()/300);


		FollowerCircle firstGen = new FollowerCircle(fImage, width/2, height/2, circleRadius);
		firstGen.draw(this);

		textSize(12);
		text("Twitter Generations v0.1b",0,12);
		text("Created by Pizazzle56", width/2 - 32, height-12);
	}
	
	
}
