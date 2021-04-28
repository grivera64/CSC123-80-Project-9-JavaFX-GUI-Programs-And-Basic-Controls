package project9;

/*
 * 
 * Name: TravelExpenses.java
 * Purpose: Calculates travel expenses for a particular place
 * Author: grivera64
 * Date: 04/28/2021
 * 
 */

/* Imports JavaFX */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class TravelExpenses extends Application
{
	
	/* Starts JavaFX Application */
	public void start(Stage primaryStage)
	{
		
		/* Create Text Fields with Labels */
		HBox days = makeHBoxWithField("Days on the trip:"),
			airfare = makeHBoxWithField("Airfare:"),
			rental = makeHBoxWithField("Car Rental:"),
			miles = makeHBoxWithField("Miles driven:"),
			parkingFees = makeHBoxWithField("Parking fees:"),
			taxiFees = makeHBoxWithField("Taxi Fees:"),
			registrationFees = makeHBoxWithField("Registration Fees:"),
			lodgingFees = makeHBoxWithField("Nightly Lodging Fees:");
		
		/* Create output labels */
		HBox totalExpenses = makeHBox("Total Expenses:"),
			allowableExpenses = makeHBox("Allowable Expenses:"),
			excessExpenses = makeHBox("Excess Expenses:"),
			savedExpenses = makeHBox("Saved Expenses:");
		
		/* Create button with action event */
		Button btn = new Button("Calculate Expenses");
		
		btn.setOnAction((event) ->
		{
			
			/* Final Values */
			final double PER_MEAL = 38.0,
					PER_PARKING = 25.0,
					PER_TAXI = 49.0,
					PER_LODGING = 215.0,
					PER_MILE = 0.49;
			
			/* Getting data from user */
			double dayN = parseHBoxDouble(days),
					lodge = parseHBoxDouble(lodgingFees),
					fare = parseHBoxDouble(airfare),
					carRent = parseHBoxDouble(rental),
					mileageCost = parseHBoxDouble(miles) * PER_MILE,
					parking = parseHBoxDouble(parkingFees),
					taxi = parseHBoxDouble(taxiFees),
					food = dayN * PER_MEAL,
					registration = parseHBoxDouble(registrationFees);
			
			/* Calculating the output text fields info and print */
			double total = 
					(dayN * lodge) + fare + carRent + mileageCost + parking + taxi +
					food + registration;
			
			double allowable =
					(dayN * PER_LODGING) + fare + carRent + 
					mileageCost + (dayN * PER_PARKING) + (dayN * PER_TAXI)
							+ food + registration;
			
			double excess = total - allowable;
			
			if (excess < 0.0001)
			{
				
				excess = 0.0;
				
			}
			
			double saved = allowable - total;
			
			if (saved < 0.0001)
			{
				
				saved = 0.0;
				
			}
			
			parseHBoxLabel(totalExpenses).setText(
					String.format("Total Expenses: %,.2f", total));
			parseHBoxLabel(allowableExpenses).setText(
					String.format("Allowable Expenses: %,.2f", allowable));
			parseHBoxLabel(excessExpenses).setText(
					String.format("Excess Expenses: %,.2f", excess));
			parseHBoxLabel(savedExpenses).setText(
					String.format("Saved Expenses: %,.2f", saved));
			
		});
		
		/* Add to main box */
		VBox mainBox = new VBox(10, 
				days, airfare, rental, miles, parkingFees, 
				taxiFees, registrationFees, lodgingFees,
				totalExpenses, allowableExpenses,
				excessExpenses, savedExpenses, btn);
		
		/* Set the formatting */
		mainBox.setPadding(new Insets(10, 10, 10, 10));
		mainBox.setAlignment(Pos.CENTER);
		
		/* Create a scene to add to the primary stage */
		Scene scene = new Scene(mainBox);
		primaryStage.setScene(scene);
		
		/* Basic set up for stage */
		primaryStage.setTitle("Travel Expenses");
		primaryStage.setResizable(false);
		primaryStage.setAlwaysOnTop(true);
		
		/* Displays the application */
		primaryStage.show();
	
	}
	
	/* Creates an HBbox with a label and Text Field */
	public static HBox makeHBoxWithField(String labelText)
	{
		
		Label currLabel = new Label(labelText);
		
		TextField textField = new TextField();
		
		HBox hBox = new HBox(10, currLabel, textField);
		
		hBox.setAlignment(Pos.CENTER);
	
		
		return hBox;
		
	}
	
	/* Creates a label in an HBox */
	public static HBox makeHBox(String labelText)
	{
		
		Label currLabel = new Label(labelText);
		
		HBox hBox = new HBox(10, currLabel);
		
		hBox.setAlignment(Pos.CENTER_LEFT);
	
		
		return hBox;
		
	}
	
	/* Reads an HBox's Text Field */
	public static double parseHBoxDouble(HBox hBox)
	{
		
		return Double.parseDouble(((TextField) hBox.getChildren().get(1)).getText());
		
	}
	
	/* Gets the label reference to the output labels */
	public static Label parseHBoxLabel(HBox hBox)
	{
		
		return (Label) hBox.getChildren().get(0);
		
	}
	
	/* Main Driver Method */
	public static void main(String[] args)
	{
		
		/* Start JavaFX Application */
		launch(args);
		
	}
	
}