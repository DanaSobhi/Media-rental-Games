package application;


import java.io.File;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;


public class UpdateMedia extends MediaShows {

	Pane medias = new Pane();
	 UpdateMedia(MediaRental m,File moviesInfo,File albumInfo,File gameInfo) {
		
		super (m,moviesInfo, albumInfo, gameInfo);
		this.setTitle("Media Update");
		this.setScene(new Scene(medias, 500, 400));
		Button returne = new Button("Return");
		Image arrow = new Image("https://img.icons8.com/material-outlined/1x/return.png");
		ImageView returnB = new ImageView(arrow);

		HBox returnSection = new HBox(returne, returnB);
		
		returnSection.setLayoutX(400);
		returnSection.setLayoutY(350);
		


		Button addMovies = new Button("UPDATE Movie");
		ImageView addS = new ImageView(new Image("https://img.icons8.com/dusk/36/clips-apperance.png"));
		HBox addSection = new HBox(addMovies, addS);
		addMovies.setScaleX(1.4);
		addMovies.setScaleY(1.4);
		addSection.setSpacing(30);
		addSection.setMaxWidth(300);
		addSection.setLayoutX(150);
		addSection.setLayoutY(50);
		
		addMovies.setTextFill(Color.DODGERBLUE);
		
		addSection.setAlignment(Pos.CENTER);
		
		
		Button addAlbumes = new Button("UPDATE Album");
		ImageView addSA = new ImageView(new Image("https://img.icons8.com/dusk/36/musical-notes.png"));
		HBox addSectionAlbums = new HBox(addAlbumes, addSA);
		addAlbumes.setScaleX(1.4);
		addAlbumes.setScaleY(1.4);
		addSectionAlbums.setMaxWidth(300);
		addSectionAlbums.setLayoutX(150);
		addSectionAlbums.setLayoutY(130);
		addSectionAlbums.setSpacing(30);
		
		addAlbumes.setTextFill(Color.GOLDENROD);
		
		
		addSectionAlbums.setAlignment(Pos.CENTER);
		
		Button addGames = new Button("UPDATE Game");
		ImageView addSG = new ImageView(new Image("https://img.icons8.com/dusk/36/approve-and-update.png"));
		HBox addSectionGame = new HBox(addGames, addSG);
		addGames.setScaleX(1.4);
		addGames.setScaleY(1.4);
		addSectionGame.setMaxWidth(300);
		addSectionGame.setLayoutX(150);
		addSectionGame.setLayoutY(210);
		addSectionGame.setSpacing(30);
		
		addGames.setTextFill(Color.	INDIANRED);
		
		addSectionGame.setAlignment(Pos.CENTER);
		

		

		medias.getChildren().add(returnSection);
		medias.getChildren().add(addSection);
		medias.getChildren().add(addSectionAlbums);
		medias.getChildren().add(addSectionGame);
		
		this.centerOnScreen();
		
		this.show();
		returne.setOnAction(t -> {new MediaShows(m,moviesInfo, albumInfo, gameInfo);
			this.close();
		});
		addMovies.setOnAction(e ->{new  UpdateMovies(m,moviesInfo, albumInfo, gameInfo);
		this.close();
		});
		addAlbumes.setOnAction(r -> {new UpdateAblums(m,moviesInfo, albumInfo, gameInfo);
		this.close();
		});
		addGames.setOnAction(g ->{ new UpdateGames(m,moviesInfo, albumInfo, gameInfo);
		this.close();
		});
	}
}
