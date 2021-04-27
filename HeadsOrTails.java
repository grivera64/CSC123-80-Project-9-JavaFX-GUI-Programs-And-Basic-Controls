package project9;

/*
 * 
 * Name: HeadsOrTails.java
 * Purpose: JavaFX application that flips a coin
 * 
 */

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import java.util.Random;

public class HeadsOrTails extends Application
{
	
	private Random random = new Random((new Random()).nextLong());
	
	private ImageView coin;
	
	public void start(Stage primaryStage)
	{
		
		coin = new ImageView();
		
		this.coin.setFitHeight(200);
		this.coin.setFitWidth(200);
		
		Button btn = new Button("Toss");
		
		btn.setOnAction((event) ->
		{
			
			int ranGen = this.random.nextInt(2);
			
			if (ranGen == 0)
				this.coin.setImage(new Image("file:img/heads1.png"));
			else
				this.coin.setImage(new Image("file:img/tails1.png"));
			
			primaryStage.show();
			
		});
		
		VBox box = new VBox(10, this.coin, btn);
		
		box.setAlignment(Pos.CENTER);
		box.setPadding(new Insets(10, 10, 10, 10));
		
		Scene scene = new Scene(box);
		
		primaryStage.setScene(scene);
		
		primaryStage.setTitle("Heads Or Tails?");
		primaryStage.setResizable(false);
		primaryStage.show();
		
	}
	
	public static void main(String[] args)
	{
		
		launch(args);
		
	}
	
}