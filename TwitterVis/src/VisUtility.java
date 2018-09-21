import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;
import twitter4j.PagableResponseList;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.conf.ConfigurationBuilder;

public class VisUtility {

	private ConfigurationBuilder cb;
	private Twitter twitter;
	private PApplet parentApplet;

	public VisUtility(PApplet parentApplet) {
		this.parentApplet = parentApplet;
		cb = new ConfigurationBuilder();
		cb.setOAuthConsumerKey("POhVTI0HbMy0AyjWfkXTDUnQa");
		cb.setOAuthConsumerSecret("Vkziw0BVwZLZ6uRCdXHf90yDgoNChabsEPzjv6HMIttd35SpTv");
		cb.setOAuthAccessToken("2239613238-wrVMW49XcaWBZTxu2oMn3txSRBDJsKUKqSi8znB");
		cb.setOAuthAccessTokenSecret("SEJva2Ai8nhWgsnxTt3w85QPYy0wsL7GEs8aRQ09ByhoA");
		twitter = new TwitterFactory(cb.build()).getInstance();
		
	}
	
	public PImage getUserImage(String userName) {
		User user = null;
		PImage userImage = null;
		try {
			user = twitter.showUser(userName);
		} catch (TwitterException e) {
			System.out.println("Something went wrong getting the user or there was a rate limit hit.");
		}
		if(user !=null) {
			userImage = parentApplet.loadImage(user.get400x400ProfileImageURL());
			userImage.resize(500/8,  500/8);
		} else {
			System.out.println("User not found");
		}
		return userImage;
	}
	public ArrayList<FollowerImage> loadFollowers(String originalUser) {
		ArrayList<FollowerImage> fImage = new ArrayList<FollowerImage>();
		
		try {
			PagableResponseList<User> statuse = twitter.getFollowersList(originalUser, -1);
				for (User follower : statuse) {
						fImage.add(new FollowerImage(parentApplet.loadImage(follower.get400x400ProfileImageURL())));
			    }
		} catch(TwitterException te) {
			System.out.println("Probably just hit the rate limit");
			te.printStackTrace();
		}
		
		return fImage;
	}
	
}
