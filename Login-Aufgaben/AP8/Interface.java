package App;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Interface extends Application {
	public void start (Stage primaryStage){
		final ImageView glassFrame = new ImageView();
		
		//background
		final Image background = new Image(getClass().getResourceAsStream("maxresdefault.jpg"));
		final ImageView backFrame = new ImageView();
		backFrame.setImage(background);
		backFrame.setFitHeight(720);
		backFrame.setFitWidth(1080);
		
		//hero
		final Image hero = new Image(getClass().getResourceAsStream("Superhero.png"));
		final ImageView heroview = new ImageView();
		heroview.setImage(hero);
		heroview.setFitHeight(400);
		heroview.setFitWidth(200);
		heroview.setLayoutX(750);
		heroview.setLayoutY(150);
		
		//star
		final Image star = new Image(getClass().getResourceAsStream("star.png"));
		final ImageView starview = new ImageView();
		starview.setImage(star);
		starview.setFitHeight(200);
		starview.setFitWidth(200);
		starview.setLayoutX(150);
		starview.setLayoutY(100);
		
		//coin
		final Image coin = new Image(getClass().getResourceAsStream("coin.png"));
		final ImageView coinview = new ImageView();
		coinview.setImage(coin);
		coinview.setFitHeight(200);
		coinview.setFitWidth(200);
		coinview.setLayoutX(150);
		coinview.setLayoutY(350);
		
		//buttons
		final Button b1 = new Button("Statistik/History");
		b1.setLayoutX(100);
		b1.setLayoutY(600);
		b1.setMinWidth(250);
		
		final Button b2 = new Button("Einstellungen");
		b2.setLayoutX(780);
		b2.setLayoutY(50);
		b2.setMinWidth(200);
		
		final Button b3 = new Button("Profil teilen");
		b3.setLayoutX(780);
		b3.setLayoutY(600);
		b3.setMinWidth(200);
		
		final Button b4 = new Button("Superhero Editor");
		b4.setLayoutX(760);
		b4.setLayoutY(120);
		b4.setMinWidth(200);
		b4.setMinHeight(450);
		b4.setBackground(null);
		
		final Button b5 = new Button("Starte Spiel");
		b5.setLayoutX(450);
		b5.setLayoutY(270);
		b5.setMinWidth(200);
		b5.setMinHeight(200);
		b5.setOnAction(null);
		
		//Punkte
		final Label l1 = new Label("Punkte");
		l1.setLayoutX(215);
		l1.setLayoutY(430);
		l1.setFont(new Font("Arial", 25));
		
		//Level
		final Label l2 = new Label("Level");
		l2.setLayoutX(215);
		l2.setLayoutY(185);
		l2.setFont(new Font("Arial", 25));
		
		//Username
		final Label l3 = new Label("World of Heroes - Hero");
		l3.setLayoutX(50);
		l3.setLayoutY(30);
		l3.setFont(new Font("Tw Cen MT Condensed", 60));
		
		Pane root =new Pane();
		root.getChildren().addAll(backFrame, heroview, starview, coinview, b1, b2, b3, b4, b5, l1, l2, l3);
		
		Scene scene = new Scene(root, 1080,720);
		primaryStage.setTitle("Superhero Profil");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	public static void main(String[] args) {
		
		launch(args);
	}
}
