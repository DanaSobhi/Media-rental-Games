package application;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class RentShow extends Stage {
	 GridPane rentings= new GridPane();
	 RentShow(MediaRental m){
		 this.setScene(new Scene(rentings, 400, 400));
			this.setMaximized(true);
			this.setTitle("Rent Operator");
		 
		 Button returne = new Button("Close");
			Image arrow = new Image("https://img.icons8.com/material-outlined/1x/return.png");
			ImageView returnB = new ImageView(arrow);
			HBox returnSection = new HBox(returne, returnB);
		//	returnSection.setLayoutX(300);
		//	returnSection.setLayoutY(350);
			
			
			Button viewRents = new Button("Cart");
				ImageView cartimg = new ImageView(new Image("https://img.icons8.com/external-icongeek26-linear-colour-icongeek26/200/external-cart-user-interface-icongeek26-linear-colour-icongeek26.png"));

				viewRents.setMaxSize(1000, 1000);
				viewRents.setTextFill(Color.DARKSLATEBLUE);
			VBox labels = new VBox(viewRents,cartimg);
			
			

			rentings.add(labels, 0, 0);
			rentings.setAlignment(Pos.CENTER);
			rentings.setVgap(20);
			rentings.setHgap(20);
			rentings.setScaleX(1.5);
			rentings.setScaleY(1.5);

			rentings.add(returnSection, 1, 4);
			this.show();
			viewRents.setOnAction(e -> {new Rental(m);
			this.close();
			});

			returne.setOnAction(t -> this.close());
	 }
}