package lesson;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Hero extends Application {
		
		@Override
		public void start (Stage primaryStage) {
			
			final ImageView glassFrame = new ImageView();
			
		//background
			
			final Image backGround = new Image(getClass().getResourceAsStream("background/backgroundfinal.png"));
			final ImageView backFrame = new ImageView();
			backFrame.setImage(backGround);
			backFrame.setFitHeight(960); backFrame.setFitWidth(1280);
		//backFrame.setLayoutX(value); backFrame.setLayoutY(value);
			
			
		//characters
			 final Image myCharBoy = new Image(getClass().getResourceAsStream("superboy/superboy.png"));
			 final Image myCharGirl = new Image(getClass().getResourceAsStream("supergirl/supergirl.png"));
			 final ImageView myCharv = new ImageView();
			 myCharv.setImage(myCharBoy);
			 myCharv.setFitHeight(729); myCharv.setFitWidth(466.5);
			 myCharv.setLayoutX(750); myCharv.setLayoutY(40);
			 
		//shirt
			 final ImageView shirtFrame = new ImageView();
		//shirt
			 
		//pants
			 final ImageView pantsFrame = new ImageView();
			 //pants
			 
			 
		//charBox
			 final ComboBox charCombo = new ComboBox();
			 charCombo.setLayoutX(100); charCombo.setLayoutY(200);
			 charCombo.getItems(). addAll("Boy","Girl");
			 charCombo.setValue("Boy");
			 charCombo.setMinWidth(100);
		//charBox
			 
		//fertigButton
			 Font myfont = new Font(24);
			 final Button bo1 = new Button("Fertig");
			 bo1.setLayoutX(550); bo1.setLayoutY(700);
			 bo1.setMinHeight(50);bo1.setMinWidth(80);
			 bo1.setFont(myfont);
		//fertigButton
			   
			/*buttontest 
			 	Image button1=new Image("button/buttonleft.png");
			    ImageView iv1=new ImageView(button1);
			    iv1.setFitHeight(500);
			    iv1.setFitWidth(500);

			    Button button11=new Button("",iv1);
			 */
			 
			 
		//shirtBox
			 final ComboBox cbo1 = new ComboBox();
			 cbo1.setLayoutX(100); cbo1.setLayoutY(400);
			 cbo1.getItems().addAll("None","Shirt 1","Shirt 2","Shirt 3");
			 cbo1.setValue("None");
			 cbo1.setMinWidth(100);
		//shirtBox
			 
		//pantsBox
			 final ComboBox cbo2 = new ComboBox();
			 cbo2.setLayoutX(100); cbo2.setLayoutY(600);
			 cbo2.getItems().addAll("None","Pants 1","Pants 2","Pants 3");
			 cbo2.setValue("None");
			 cbo2.setMinWidth(100);
		//pantsBox
		
		//characters
			  charCombo.setOnAction(new EventHandler<ActionEvent>() {
				  
				  @Override
				  public void handle(ActionEvent event) {
					  
					  if(charCombo.getValue()=="Boy") 
					  {
						myCharv.setImage(myCharBoy);
						myCharv.setLayoutX(750);
						shirtFrame.setImage(null);
						cbo1.setValue("None");
						cbo2.setValue("None");
					  }
					    else if(charCombo.getValue()=="Girl")
					  {
					     myCharv.setImage(myCharGirl);
					     myCharv.setLayoutX(750);
					     shirtFrame.setImage(null);
					     cbo1.setValue("None");
					     cbo2.setValue("None");
					  }
					  
				  }
			  
			  });
		//characters
		 
			  
		//shirt
			 final Image shirt = new Image(getClass().getResourceAsStream("dress/shirtblackm.png"));
			 final Image shirt2 = new Image(getClass().getResourceAsStream("dress/shirtbluem.png"));
			 final Image shirt3 = new Image(getClass().getResourceAsStream("dress/shirtgreenm.png")); 
			 final Image shirt4 = new Image(getClass().getResourceAsStream("dress/shirtgreenf.png"));
			 final Image shirt5 = new Image(getClass().getResourceAsStream("dress/shirtwhitef.png"));
			 final Image shirt6 = new Image(getClass().getResourceAsStream("dress/shirtpurplef.png"));
			 shirtFrame.setImage(null);
			 shirtFrame.setFitHeight(729); shirtFrame.setFitWidth(466.5);
			 shirtFrame.setLayoutX(750); shirtFrame.setLayoutY(40);
			  
			  
			  
			 cbo1.setOnAction(new EventHandler<ActionEvent>() {
				  
				  @Override
				  public void handle(ActionEvent event) {
					  
					  if(cbo1.getValue()=="Shirt 1" && charCombo.getValue()=="Boy")
					  {
						  shirtFrame.setImage(shirt);
						  shirtFrame.setLayoutX(750);
					  }
					  
					  else if(cbo1.getValue()=="Shirt 1" && charCombo.getValue()=="Girl")
					  {
						  shirtFrame.setImage(shirt4);
						  shirtFrame.setLayoutX(750);
					  }
					  
					  else if(cbo1.getValue()=="Shirt 2" && charCombo.getValue()=="Boy")
					  {
						  shirtFrame.setImage(shirt2);
						  shirtFrame.setLayoutX(750);
					  }
					  
					  else if(cbo1.getValue()=="Shirt 2" && charCombo.getValue()=="Girl")
					  {
						  shirtFrame.setImage(shirt5);
						  shirtFrame.setLayoutX(750);
					  }
					  
					  else if(cbo1.getValue()=="Shirt 3" && charCombo.getValue()=="Boy")
					  {
						  shirtFrame.setImage(shirt3);
						  shirtFrame.setLayoutX(750);
					  }
					  
					  else if(cbo1.getValue()=="Shirt 3" && charCombo.getValue()=="Girl")
					  {
						  shirtFrame.setImage(shirt6);
						  shirtFrame.setLayoutX(750);
					  }
					  
					  else if(cbo1.getValue()=="None") 
					  {
						  shirtFrame.setImage(null);
					  }
					  
				  }
			  });
		//shirt
			  
		//pants
			 final Image pants = new Image(getClass().getResourceAsStream("dress/pantsblack.png"));
			 final Image pants2 = new Image(getClass().getResourceAsStream("dress/pantsbrown.png"));
			 final Image pants3 = new Image(getClass().getResourceAsStream("dress/pantsgrey.png")); 
			 pantsFrame.setImage(null);
			 pantsFrame.setFitHeight(729); pantsFrame.setFitWidth(466.5);
			 pantsFrame.setLayoutX(750); pantsFrame.setLayoutY(40);
			  
			  
			  
			 cbo2.setOnAction(new EventHandler<ActionEvent>() {
				  
				  @Override
				  public void handle(ActionEvent event) {
					  
					  if(cbo2.getValue()=="Pants 1" && charCombo.getValue()=="Boy")
					  {
						  pantsFrame.setImage(pants);
						  pantsFrame.setLayoutX(750);
					  }
					  
					  else if(cbo2.getValue()=="Pants 1" && charCombo.getValue()=="Girl")
					  {
						  pantsFrame.setImage(pants);
						  pantsFrame.setLayoutX(750);
					  }
					  
					  else if(cbo2.getValue()=="Pants 2" && charCombo.getValue()=="Boy")
					  {
						  pantsFrame.setImage(pants2);
						  pantsFrame.setLayoutX(750);
					  }
					  
					  else if(cbo2.getValue()=="Pants 2" && charCombo.getValue()=="Girl")
					  {
						  pantsFrame.setImage(pants2);
						  pantsFrame.setLayoutX(750);
					  }
					  
					  else if(cbo2.getValue()=="Pants 3" && charCombo.getValue()=="Boy")
					  {
						  pantsFrame.setImage(pants3);
						  pantsFrame.setLayoutX(750);
					  }
					  
					  else if(cbo2.getValue()=="Pants 3" && charCombo.getValue()=="Girl")
					  {
						  pantsFrame.setImage(pants3);
						  pantsFrame.setLayoutX(750);
					  }
					  
					  else if(cbo2.getValue()=="None") 
					  {
						  pantsFrame.setImage(null);
					  }
					  
				  }
			  });
		//pants
			  
			  
			  
			  
			 Pane root = new Pane();
			 root.getChildren().addAll(backFrame,myCharv,shirtFrame,pantsFrame,charCombo,cbo1,cbo2,bo1);
			  
			 Scene scene = new Scene(root, 1280, 960);
			  
			 primaryStage.setTitle("Superhero Konfigurator");
			 primaryStage.setScene(scene);
			 primaryStage.show();
			
		}
		


		
		public static void main(String[] args) {
			
			launch(args);
		}
}
