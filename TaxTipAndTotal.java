//package project9;

/*
 * 
 * Name: TaxTipAndTotal.java
 * Purpose: Calculates Tax, Tip, and Total for an inputed price
 * Author: grivera64
 * Date: 04/27/2021
 * 
 */

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import java.util.UnknownFormatConversionException;


public class TaxTipAndTotal extends Application
{
	
	/* Start of JavaFX Application */
	public void start(Stage primaryStage)
	{
		
		/* Create centered top HBox for input */
		Label chargeLabel = new Label("Meal Charge:");
		TextField input = new TextField();
		HBox horizontal = new HBox(10, chargeLabel, input);
		horizontal.setAlignment(Pos.CENTER);
		
		/* Create single-item labels */
		Label tipLabel = new Label("Tip:");
		Label taxLabel = new Label("Tax:");
		Label totalLabel = new Label("Total:");
		
		/* Create a centered button */
		Button btn = new Button("Calculate");
		btn.setAlignment(Pos.CENTER);
		
		/* Calculate the data when button is pressed */
		btn.setOnAction((event) ->
		{
			
			/* Get the charge from user */
			double charge;
			try
			{
				
				charge = Double.parseDouble(input.getText());
			
			}
			/* If there is an error reading the double, try int */
			catch (UnknownFormatConversionException e)
			{
				
				charge = Integer.parseInt(input.getText());
				
			}
			/* If the data is not a number, set to 0.00 as default */
			catch (NumberFormatException e)
			{
				
				input.setText("0.00");
				charge = 0.0;
				
			}
			
			/* Calculate info and display */
			double tip = charge * 0.21; 
			tipLabel.setText(String.format("Tip: $%.2f", tip));
			
			double tax = charge * 0.09;
			taxLabel.setText(String.format("Tax: $%.2f", tax));
			
			totalLabel.setText(String.format("Total: $%.2f", (double) (charge + tip + tax)));
			
		});
		
		/* Store Button in a centered HBox */
		HBox btnBox = new HBox(btn);
		btnBox.setAlignment(Pos.CENTER);
		
		/* Store everything in one super-VBox */
		VBox vertical = new VBox(10, horizontal, tipLabel, taxLabel, totalLabel, btnBox);
		vertical.setPadding(new Insets(10, 10, 10, 10));
		
		/* Create the scene with the super-VBox */
		Scene scene = new Scene(vertical);
		
		/* Add the scene to the stage */
		primaryStage.setScene(scene);
		
		/* Setup for primary stage settings */
		primaryStage.setTitle("Tax, Tip, and Total");
		primaryStage.setResizable(false);
		primaryStage.show();
		
	}
	
	/* Driver Function */
	public static void main(String[] args)
	{
		
		/* Launch the JavaFX Application */
		launch(args);
		
	}
	
}