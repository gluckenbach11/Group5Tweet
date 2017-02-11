/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Group5;

import java.util.Arrays;
import java.util.List;
import twitter4j.*;
import twitter4j.auth.AccessToken;
/**
 *
 * @author gluck
 */
public class Model
{
        
    public static void Tweet(String inputTweet) throws TwitterException
    {
        //Your Twitter App's Consumer Key
        String consumerKey = "wK7lQLpl3t8xvIABqpgoJzYYd";
        
        //Your Twitter App's Consumer Secret
        String consumerSecret = "4M5TgmNfS0EKeaSqna8eHTNaNi970Plq3dynX5gvYsh848j0mj";
 
        //Your Twitter Access Token
        String accessToken = "829891753473892361-7jkKyXLYc6HOStzCPGjWOnVoAVNU7cd";
 
        //Your Twitter Access Token Secret
        String accessTokenSecret = "ATidrzRzhVqAamuMbYiskcHBPSisB9MWsCsYYY2Bec4y9";
 
        //Instantiate a re-usable and thread-safe factory
        TwitterFactory twitterFactory = new TwitterFactory();
 
        //Instantiate a new Twitter instance
        Twitter twitter = twitterFactory.getInstance();
        //setup OAuth Consumer Credentials
        twitter.setOAuthConsumer(consumerKey, consumerSecret);
 
        //setup OAuth Access Token
        twitter.setOAuthAccessToken(new AccessToken(accessToken, accessTokenSecret));
 
        //Instantiate and initialize a new twitter status update
        StatusUpdate statusUpdate = new StatusUpdate(
                //your tweet or status message
                inputTweet);
 
        //tweet or update status
        Status status = twitter.updateStatus(statusUpdate);
 
        //response from twitter server
        System.out.println("status.toString() = " + status.toString());
        System.out.println("status.getInReplyToScreenName() = " + status.getInReplyToScreenName());
        System.out.println("status.getSource() = " + status.getSource());
        System.out.println("status.getText() = " + status.getText());
        
        System.out.println("status.getURLEntities() = " + Arrays.toString(status.getURLEntities()));
        System.out.println("status.getUserMentionEntities() = " + Arrays.toString(status.getUserMentionEntities()));
    }
    
    public static List GetTimeline() throws TwitterException
    {
        //Your Twitter App's Consumer Key
        String consumerKey = "wK7lQLpl3t8xvIABqpgoJzYYd";
        
        //Your Twitter App's Consumer Secret
        String consumerSecret = "4M5TgmNfS0EKeaSqna8eHTNaNi970Plq3dynX5gvYsh848j0mj";
 
        //Your Twitter Access Token
        String accessToken = "829891753473892361-7jkKyXLYc6HOStzCPGjWOnVoAVNU7cd";
 
        //Your Twitter Access Token Secret
        String accessTokenSecret = "ATidrzRzhVqAamuMbYiskcHBPSisB9MWsCsYYY2Bec4y9";
 
        //Instantiate a re-usable and thread-safe factory
        TwitterFactory twitterFactory = new TwitterFactory();
 
        //Instantiate a new Twitter instance
        Twitter twitter = twitterFactory.getInstance();
         //setup OAuth Consumer Credentials
        twitter.setOAuthConsumer(consumerKey, consumerSecret);
 
        //setup OAuth Access Token
        twitter.setOAuthAccessToken(new AccessToken(accessToken, accessTokenSecret));
        List<Status> statuses = twitter.getHomeTimeline();
        System.out.println("Showing home timeline.");
        for (Status status : statuses) 
        {
            System.out.println(status.getUser().getName() + ":" + status.getText());                          
        }
    return statuses;
    }
}
