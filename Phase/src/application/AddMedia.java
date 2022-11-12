package application;

import java.io.File;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class AddMedia extends MediaShows {

	Pane medias = new Pane();

	AddMedia(MediaRental m, File moviesInfo, File albumInfo, File gameInfo) {
		
		super(m, moviesInfo, albumInfo, gameInfo);
		this.setTitle("Add Media");
		this.setScene(new Scene(medias, 500, 400));
		Button returne = new Button("Return");
		ImageView returnB = new ImageView(new Image("https://img.icons8.com/material-outlined/1x/return.png"));

		HBox returnSection = new HBox(returne, returnB);
		returnSection.setLayoutX(390);
		returnSection.setLayoutY(360);

		Button addMovies = new Button("Add Movie");
		ImageView addS = new ImageView(new Image(
				"https://img.icons8.com/external-sbts2018-flat-sbts2018/26/external-clapperboard-social-media-sbts2018-flat-sbts2018.png"));
		HBox addSection = new HBox(addMovies, addS);
		addSection.setScaleX(1.3);
		addSection.setScaleY(1.3);

		addSection.setLayoutX(160);
		addSection.setLayoutY(50);
		addMovies.setTextFill(Color.DARKSLATEBLUE);

		Button addAlbumes = new Button("Add Album");
		ImageView addSA = new ImageView(new Image(
				"https://img.icons8.com/external-wanicon-flat-wanicon/26/external-music-app-smartphone-application-wanicon-flat-wanicon.png"));
		HBox addSectionAlbums = new HBox(addAlbumes, addSA);
		addSectionAlbums.setScaleX(1.3);
		addSectionAlbums.setScaleY(1.3);

		addSectionAlbums.setLayoutX(160);
		addSectionAlbums.setLayoutY(120);
		addAlbumes.setTextFill(Color.DARKSLATEGREY);

		Button addGames = new Button("Add Game");
		ImageView addSG = new ImageView(new Image(
				"https://img.icons8.com/external-wanicon-flat-wanicon/26/external-mobile-game-smartphone-application-wanicon-flat-wanicon.png"));
		HBox addSectionGame = new HBox(addGames, addSG);
		addSectionGame.setScaleX(1.3);
		addSectionGame.setScaleY(1.3);
		addSectionGame.setLayoutX(160);
		addSectionGame.setLayoutY(190);

		addGames.setTextFill(Color.GOLDENROD);

		medias.getChildren().add(returnSection);
		medias.getChildren().add(addSection);
		medias.getChildren().add(addSectionAlbums);
		medias.getChildren().add(addSectionGame);

		this.centerOnScreen();
		this.show();
		returne.setOnAction(t -> {
			new MediaShows(m, moviesInfo, albumInfo, gameInfo);
			this.close();
		});
		addMovies.setOnAction(e -> {
			new AddMoviees(m, moviesInfo, albumInfo, gameInfo);
			this.close();
		});
		addAlbumes.setOnAction(r -> {
			new AddAlbums(m, moviesInfo, albumInfo, gameInfo);
			this.close();
		});
		addGames.setOnAction(g -> {
			new AddGame(m, moviesInfo, albumInfo, gameInfo);
			this.close();
		});
	}

}
