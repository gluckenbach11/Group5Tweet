/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Group5;


import static Group5.Model.Tweet;
import static Group5.Model.GetTimeline;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.TextFlow;
import twitter4j.Status;
import twitter4j.TwitterException;

/**
 * FXML Controller class
 *
 * @author gluck
 */
public class Controller {
    @FXML
    Label titleLabel;
    @FXML
    Label charCountLabel;
    @FXML
    TextArea tweetInput;
    @FXML
    Button tweetButton;
    @FXML
    Button statusButton;
    @FXML
    ListView<Status> statusListView;
    
    Model model = new Model();
    
  

    @FXML
    private void handleTweetButtonAction(ActionEvent event) throws TwitterException {
        if(!tweetInput.getText().isEmpty()){
        String outgoingTweet = tweetInput.getText();
        Tweet(outgoingTweet);
        tweetInput.clear();
        }
    }
    
    @FXML
    private void handleStatusButtonAction(ActionEvent event) throws TwitterException 
    {
        statusListView = new ListView<Status>();
        statusListView.setItems((ObservableList<Status>) GetTimeline());
    }
    
    @FXML
    private void handleTweetInputAction(KeyEvent event) 
    { 
        charCountLabel.setText(Integer.toString(tweetInput.getLength()+1) + "/140");
    }
}
