package alebo611.boardgame.gui;


import alebo611.boardgame.Board;
import alebo611.boardgame.Shooter;
import alebo611.boardgame.Shooter.HitResult;
import javafx.application.*; 
import javafx.scene.*; 
import javafx.stage.*; 
import javafx.scene.layout.*; 
import javafx.scene.control.*; 
import javafx.event.*; 
import javafx.geometry.*; 
 
public class BattleshipGUI extends Application { 
 
  Label response; 
  Shooter sb;
  final int b = 50; //button size
  int size = 10;
  
  public static void main(String[] args) { 
 
    // Start the JavaFX application by calling launch(). 
    launch(args);   
  } 
 
  // Override the start() method. 
  public void start(Stage myStage) { 
 
    // Give the stage a title. 
    myStage.setTitle("Use JavaFX Buttons and Events."); 
 
    // Use a FlowPane for the root node. In this case, 
    // vertical and horizontal gaps of 10. 
    FlowPane rootNode = new FlowPane(10, 10); 
 
    // Center the controls in the scene. 
    rootNode.setAlignment(Pos.CENTER); 
 
    // Create a scene. 
    Scene myScene = new Scene(rootNode, b*size, b*size); 
 
    // Set the scene on the stage. 
    myStage.setScene(myScene); 
 
    // Create a label. 
    response = new Label("Push a Button"); 
 
    // Create two push buttons. 
    Button btnUp = new Button("Up"); 
    Button btnDown = new Button("Down"); 
 
    // Handle the action events for the Up button. 
    btnUp.setOnAction(new EventHandler<ActionEvent>() { 
      public void handle(ActionEvent ae) { 
        response.setText("You pressed Up."); 
        btnDown.setText("You pressed Up."); 
      } 
    }); 
 
    // Handle the action events for the Down button. 
    btnDown.setOnAction(new EventHandler<ActionEvent>() { 
      public void handle(ActionEvent ae) { 
        btnDown.setText("You pressed Down."); 
      } 
    }); 
    sb = new Board(size);
    sb.createAllBoats();
    
    VBox vbox = new VBox(0); // spacing = 8
    for(int i = 0; i < size; i++){
    	HBox hbox = new HBox(0); // spacing = 8
    	 for(int j = 0; j < size; j++){
    		 
    		 Button btn = new Button("?");
    		 int [] coordinate = {i,j};
    		 btn.setUserData(coordinate);
    		 btn.setMaxSize(b, b);
	    	 btn.setMinSize(b, b);
    		   btn.setOnAction(new EventHandler<ActionEvent>() { 
    			      public void handle(ActionEvent ae) { 
    			    	  
    			    	  Button btn = (Button)ae.getSource();
    			    	  btn.setMaxSize(b, b);
    			    	  btn.setMinSize(b, b);
    			    	  int [] coordinate =  (int [])btn.getUserData();
    			    	  
    			    	  int x = coordinate[0];
    			    	  int y = coordinate[1];
    						switch(sb.shoot(x, y)){
    						case HIT_SHIP_NOT_SUNK_YET:
    							btn.setText("O");
    							break;
    						case HIT_SHIP_SUNK:
    							btn.setText("T");
    							break;
    						case WATER:
    							btn.setText("W");
    							break;
    						case ALL_SHIPS_SUNK_GAME_OVER:
    							btn.setText("H");
    							break;
    						default:
    						}
    			    	} 
    			    }); 
    		 
    		 
    		 hbox.getChildren().add(btn);
    	 }
    	 vbox.getChildren().add(hbox);
    }
	 rootNode.getChildren().add(vbox);
    
   
        
 
    // Add the label and buttons to the scene graph. 
   
    // Show the stage and its scene. 
    myStage.show(); 
  } 
}
