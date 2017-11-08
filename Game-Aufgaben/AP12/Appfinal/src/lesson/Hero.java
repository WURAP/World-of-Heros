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
import javafx.stage.Stage;

public class Hero extends Application {
		
		@Override
		public void start (Stage primaryStage) {
			
			final ImageView glassFrame = new ImageView();
			
		//background
			
			final Image backGround = new Image(getClass().getResourceAsStream("background/background.png"));
			final ImageView backFrame = new ImageView();
			backFrame.setImage(backGround);
			backFrame.setFitHeight(792); backFrame.setFitWidth(1224);
		//backFrame.setLayoutX(value); backFrame.setLayoutY(value);
			
			
		//characters
			 final Image myCharBoy = new Image(getClass().getResourceAsStream("superboy/superboyf.png"));
			 final Image myCharGirl = new Image(getClass().getResourceAsStream("supergirl/supergirlf.png"));
			 final ImageView myCharv = new ImageView();
			 myCharv.setImage(myCharBoy);
			 myCharv.setFitHeight(729); myCharv.setFitWidth(466.5);
			 myCharv.setLayoutX(650); myCharv.setLayoutY(25);
			 
		//shirt
			 final ImageView shirtFrame = new ImageView();
		//shirt
			 
		//pants
			 final ImageView pantsFrame = new ImageView();
		//pants
			 
		//colour
			 final ImageView colourFrame = new ImageView();
		//colour
			 
			 
		//charBox
			 final ComboBox charCombo = new ComboBox();
			 charCombo.setLayoutX(100); charCombo.setLayoutY(150);
			 charCombo.getItems(). addAll("Junge","Mädchen");
			 charCombo.setValue("Junge");
			 charCombo.setMinWidth(100);
		//charBox
			 
			 /*testButton
			 Image b1 = new Image("button/buttonleft.png");
			 final Button bo1 = new Button("",b1);
			 bo1.setLayoutX(100); bo1.setLayoutY(300);
			 */
			 
			 
			 /*buttonImage
			   
			 	Image button1=new Image("button/buttonleft.png");
			    ImageView iv1=new ImageView(button1);
			    iv1.setFitHeight(500);
			    iv1.setFitWidth(500);

			    Button button11=new Button("",iv1);
			 */
			 
			 
		//colour1Box
			 final ComboBox cbo1 = new ComboBox();
			 cbo1.setLayoutX(100); cbo1.setLayoutY(300);
			 cbo1.getItems().addAll("Auswählen","Blau","Grün","Gelb");
			 cbo1.setValue("Auswählen");
			 cbo1.setMinWidth(100);
		//colour1Box
			 
		//colour2Box
			 final ComboBox cbo2 = new ComboBox();
			 cbo2.setLayoutX(100); cbo2.setLayoutY(450);
			 cbo2.getItems().addAll("Auswählen","Rot","Grün","Blau");
			 cbo2.setValue("Auswählen");
			 cbo2.setMinWidth(100);
		//colour2Box
		
		//colour3Box
			 final ComboBox cbo3 = new ComboBox();
			 cbo3.setLayoutX(100); cbo3.setLayoutY(600);
			 cbo3.getItems().addAll("Auswählen","Schwarz","Rot","Türkis");
			 cbo3.setValue("Auswählen");
			 cbo3.setMinWidth(100);
		//colour3Box
			 
		//characters
			  charCombo.setOnAction(new EventHandler<ActionEvent>() {
				  
				  @Override
				  public void handle(ActionEvent event) {
					  
					  if(charCombo.getValue()=="Junge") 
					  {
						myCharv.setImage(myCharBoy);
						myCharv.setLayoutX(650);
						shirtFrame.setImage(null);
						cbo1.setValue("Auswählen");
						cbo2.setValue("Auswählen");
						cbo3.setValue("Auswählen");
					  }
					    else if(charCombo.getValue()=="Mädchen")
					  {
					     myCharv.setImage(myCharGirl);
					     myCharv.setLayoutX(650);
					     shirtFrame.setImage(null);
					     cbo1.setValue("Auswählen");
					     cbo2.setValue("Auswählen");
					     cbo3.setValue("Auswählen");
					  }
					  
				  }
			  
			  });
		//characters
		 
			  
		//colour1
			 final Image shirt = new Image(getClass().getResourceAsStream("dress/boycolour1blue.png"));
			 final Image shirt2 = new Image(getClass().getResourceAsStream("dress/boycolour1green.png"));
			 final Image shirt3 = new Image(getClass().getResourceAsStream("dress/boycolour1yellow.png")); 
			 final Image shirt4 = new Image(getClass().getResourceAsStream("dress/girlcolour1blue.png"));
			 final Image shirt5 = new Image(getClass().getResourceAsStream("dress/girlcolour1green.png"));
			 final Image shirt6 = new Image(getClass().getResourceAsStream("dress/girlcolour1yellow.png"));
			 shirtFrame.setImage(null);
			 shirtFrame.setFitHeight(729); shirtFrame.setFitWidth(466.5);
			 shirtFrame.setLayoutX(650); shirtFrame.setLayoutY(25);
			  
			  
			  
			 cbo1.setOnAction(new EventHandler<ActionEvent>() {
				  
				  @Override
				  public void handle(ActionEvent event) {
					  
					  if(cbo1.getValue()=="Blau" && charCombo.getValue()=="Junge")
					  {
						  shirtFrame.setImage(shirt);
						  shirtFrame.setLayoutX(650);
					  }
					  
					  else if(cbo1.getValue()=="Blau" && charCombo.getValue()=="Mädchen")
					  {
						  shirtFrame.setImage(shirt4);
						  shirtFrame.setLayoutX(650);
					  }
					  
					  else if(cbo1.getValue()=="Grün" && charCombo.getValue()=="Junge")
					  {
						  shirtFrame.setImage(shirt2);
						  shirtFrame.setLayoutX(650);
					  }
					  
					  else if(cbo1.getValue()=="Grün" && charCombo.getValue()=="Mädchen")
					  {
						  shirtFrame.setImage(shirt5);
						  shirtFrame.setLayoutX(650);
					  }
					  
					  else if(cbo1.getValue()=="Gelb" && charCombo.getValue()=="Junge")
					  {
						  shirtFrame.setImage(shirt3);
						  shirtFrame.setLayoutX(650);
					  }
					  
					  else if(cbo1.getValue()=="Gelb" && charCombo.getValue()=="Mädchen")
					  {
						  shirtFrame.setImage(shirt6);
						  shirtFrame.setLayoutX(650);
					  }
					  
					  else if(cbo1.getValue()=="Auswählen") 
					  {
						  shirtFrame.setImage(null);
					  }
					  
				  }
			  });
		//colour1
			  
		//colour2
			 final Image pants = new Image(getClass().getResourceAsStream("dress/boycolour2red.png"));
			 final Image pants2 = new Image(getClass().getResourceAsStream("dress/boycolour2green.png"));
			 final Image pants3 = new Image(getClass().getResourceAsStream("dress/boycolour2blue.png"));
			 final Image pants4 = new Image(getClass().getResourceAsStream("dress/girlcolour2red.png"));
			 final Image pants5 = new Image(getClass().getResourceAsStream("dress/girlcolour2green.png"));
			 final Image pants6 = new Image(getClass().getResourceAsStream("dress/girlcolour2blue.png")); 
			 pantsFrame.setImage(null);
			 pantsFrame.setFitHeight(729); pantsFrame.setFitWidth(466.5);
			 pantsFrame.setLayoutX(650); pantsFrame.setLayoutY(25);
			  
			  
			  
			 cbo2.setOnAction(new EventHandler<ActionEvent>() {
				  
				  @Override
				  public void handle(ActionEvent event) {
					  
					  if(cbo2.getValue()=="Rot" && charCombo.getValue()=="Junge")
					  {
						  pantsFrame.setImage(pants);
						  pantsFrame.setLayoutX(650);
					  }
					  
					  else if(cbo2.getValue()=="Rot" && charCombo.getValue()=="Mädchen")
					  {
						  pantsFrame.setImage(pants4);
						  pantsFrame.setLayoutX(650);
					  }
					  
					  else if(cbo2.getValue()=="Grün" && charCombo.getValue()=="Junge")
					  {
						  pantsFrame.setImage(pants2);
						  pantsFrame.setLayoutX(650);
					  }
					  
					  else if(cbo2.getValue()=="Grün" && charCombo.getValue()=="Mädchen")
					  {
						  pantsFrame.setImage(pants5);
						  pantsFrame.setLayoutX(650);
					  }
					  
					  else if(cbo2.getValue()=="Blau" && charCombo.getValue()=="Junge")
					  {
						  pantsFrame.setImage(pants3);
						  pantsFrame.setLayoutX(650);
					  }
					  
					  else if(cbo2.getValue()=="Blau" && charCombo.getValue()=="Mädchen")
					  {
						  pantsFrame.setImage(pants6);
						  pantsFrame.setLayoutX(650);
					  }
					  
					  else if(cbo2.getValue()=="Auswählen") 
					  {
						  pantsFrame.setImage(null);
					  }
					  
				  }
			  });
		//colour2
			  
			  
		//colour3
			 
			 final Image colour1 = new Image(getClass().getResourceAsStream("dress/boycolour3black.png"));
			 final Image colour2 = new Image(getClass().getResourceAsStream("dress/boycolour3red.png"));
			 final Image colour3 = new Image(getClass().getResourceAsStream("dress/boycolour3turquoise.png"));
			 final Image colour4 = new Image(getClass().getResourceAsStream("dress/girlcolour3black.png"));
			 final Image colour5 = new Image(getClass().getResourceAsStream("dress/girlcolour3red.png"));
			 final Image colour6 = new Image(getClass().getResourceAsStream("dress/girlcolour3turquoise.png"));
			 colourFrame.setImage(null);
			 colourFrame.setFitHeight(729); colourFrame.setFitWidth(466.5);
			 colourFrame.setLayoutX(650); colourFrame.setLayoutY(25);
			  
			  
			  
			 cbo3.setOnAction(new EventHandler<ActionEvent>() {
				  
				  @Override
				  public void handle(ActionEvent event) {
					  
					  if(cbo3.getValue()=="Schwarz" && charCombo.getValue()=="Junge")
					  {
						  colourFrame.setImage(colour1);
						  colourFrame.setLayoutX(650);
					  }
					  
					  else if(cbo3.getValue()=="Schwarz" && charCombo.getValue()=="Mädchen")
					  {
						  colourFrame.setImage(colour4);
						  colourFrame.setLayoutX(650);
					  }
					  
					  else if(cbo3.getValue()=="Rot" && charCombo.getValue()=="Junge")
					  {
						  colourFrame.setImage(colour2);
						  colourFrame.setLayoutX(650);
					  }
					  
					  else if(cbo3.getValue()=="Rot" && charCombo.getValue()=="Mädchen")
					  {
						  colourFrame.setImage(colour5);
						  colourFrame.setLayoutX(650);
					  }
					  
					  else if(cbo3.getValue()=="Türkis" && charCombo.getValue()=="Junge")
					  {
						  colourFrame.setImage(colour3);
						  colourFrame.setLayoutX(650);
					  }
					  
					  else if(cbo3.getValue()=="Türkis" && charCombo.getValue()=="Mädchen")
					  {
						  colourFrame.setImage(colour6);
						  colourFrame.setLayoutX(650);
					  }
					  
					  else if(cbo3.getValue()=="Auswählen") 
					  {
						  colourFrame.setImage(null);
					  }
					  
				  }
			  });
			  
			 
			 
		//colour3
			  
			 Pane root = new Pane();
			 root.getChildren().addAll(backFrame,myCharv,shirtFrame,pantsFrame,colourFrame,charCombo,cbo1,cbo2,cbo3/*,bo1*/);
			  
			 Scene scene = new Scene(root, 1224, 792);
			  
			 primaryStage.setTitle("Superhero Konfigurator");
			 primaryStage.setScene(scene);
			 primaryStage.show();
			
		}
		


		
		public static void main(String[] args) {
			
			launch(args);
		}
}
