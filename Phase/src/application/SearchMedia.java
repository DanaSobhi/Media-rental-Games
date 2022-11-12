package application;


import java.io.File;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class SearchMedia extends MediaShows {
	
	
	Pane medias = new Pane();
	SearchMedia(MediaRental m,File moviesInfo,File albumInfo,File gameInfo) {
	super(m,moviesInfo, albumInfo, gameInfo);
	this.setTitle("Media Search");
		this.setScene(new Scene(medias, 400, 400));
		Button returne = new Button("Return");
		Image arrow = new Image("https://img.icons8.com/material-outlined/1x/return.png");
		ImageView returnB = new ImageView(arrow);

		HBox returnSection = new HBox(returne, returnB);
		returnSection.setLayoutX(300);
		returnSection.setLayoutY(350);
		
		Label idM = new Label("Media ID");
		TextField enterId = new TextField();
		HBox idBox = new HBox(idM, enterId);
		idBox.setSpacing(44);

		Label MInfo = new Label("Media informations");
		Text informations = new Text("enter ID to search");
		informations.setFill(Color.DARKMAGENTA);
		
		HBox infoBox = new HBox(MInfo,informations);
		infoBox.setSpacing(10);


		VBox data = new VBox(idBox, infoBox);
		data.setSpacing(10);
		data.setLayoutX(30);
		data.setLayoutY(40);

		Button searchMedia = new Button("Search");
		ImageView addS = new ImageView(new Image("https://img.icons8.com/nolan/26/search.png"));
		HBox searchSection = new HBox(searchMedia, addS);
		searchSection.setLayoutY(350);
		searchSection.setLayoutX(20);
		searchSection.setAlignment(Pos.CENTER);
		
		
		
		
		medias.getChildren().add(data);
		medias.getChildren().add(returnSection);
		medias.getChildren().add(searchSection);
		
		this.centerOnScreen();
		this.show();
		returne.setOnAction(t -> {new MediaShows(m,moviesInfo, albumInfo, gameInfo);
			this.close();
		});
		
		searchMedia.setOnAction(s -> {
			 if ((enterId.getText() != null && !enterId.getText().isEmpty()) ) {

			informations.setText(m.searchMedia(enterId.getText()).toString());
			 System.out.println(m.searchMedia(enterId.getText()));
			 }
			 
		});
		
	}

}
