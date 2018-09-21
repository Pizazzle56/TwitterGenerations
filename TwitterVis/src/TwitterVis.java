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
		
		//try {
			//originalUser = twitter.showUser("DepressedLinux");
		//} catch (TwitterException e) {
			//e.printStackTrace();
		//}
		
		//try {
			//PagableResponseList<User> statuse = twitter.getFollowersList(originalUser.getName(), -1);
				//for (User follower : statuse) {
					//	System.out.println(follower.get400x400ProfileImageURL());
					//	fImage.add(new FollowerImage(loadImage(follower.get400x400ProfileImageURL())));
					//	followers.add(follower);
					//	time = millis();					
			    //}
		//} catch(TwitterException te) {
			//System.out.println("Couldn't connect.");
			//te.printStackTrace();
		//}
	}
	
	public void draw() {
		background(millis()/100,millis()/100,millis()/100);
			
		FollowerCircle firstGen = new FollowerCircle(fImage, width/2, height/2, circleRadius);
		firstGen.draw(this);
		
		
	}
	
	
}
