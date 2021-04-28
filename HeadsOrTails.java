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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import java.util.Random;

public class HeadsOrTails extends Application
{
	
	/* Private Fields */
	private Random random = new Random((new Random()).nextLong());
	private ImageView coin;
	
	/* Start of JavaFX Application */
	public void start(Stage primaryStage)
	{
		
		/* Set up coin image view */
		coin = new ImageView();
		this.coin.setFitHeight(200);
		this.coin.setFitWidth(200);
		
		/* Set up button */
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
		
		/* Set up the positioning of the VBox to add to scene and stage */
		VBox box = new VBox(10, this.coin, btn);
		box.setAlignment(Pos.CENTER);
		box.setPadding(new Insets(10, 10, 10, 10));
		
		/* Add to scene and add to stage */
		Scene scene = new Scene(box);
		primaryStage.setScene(scene);
		
		/* Setup stage (window) and display */
		primaryStage.setTitle("Heads Or Tails?");
		primaryStage.setResizable(false);
		primaryStage.show();
		
	}
	
	/* Driver function */
	public static void main(String[] args)
	{
		
		/* Start JavaFX Application */
		launch(args);
		
	}
	
}