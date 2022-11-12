package application;

import java.io.File;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class AddAlbums extends AddMedia {

	GridPane albums = new GridPane();

	AddAlbums(MediaRental a, File moviesInfo, File albumInfo, File gameInfo) {
		super(a, moviesInfo, albumInfo, gameInfo);
		this.setTitle("Album Adding ");
		this.setScene(new Scene(albums, 600, 400));
		Label idM = new Label("Media ID");
		TextField enterId = new TextField();

		albums.add(idM, 0, 0);
		albums.add(enterId, 1, 0);

		Label titleM = new Label("Media Title");
		TextField enternameM = new TextField();
		enternameM.setDisable(true);
		enterId.setOnKeyTyped(t -> {
			enternameM.setDisable(false);
		});
		albums.add(titleM, 0, 1);
		albums.add(enternameM, 1, 1);

		Label copiesM = new Label("Copies Available");
		TextField enterCopies = new TextField();
		enterCopies.setDisable(true);
		enternameM.setOnKeyTyped(t -> {
			enterCopies.setDisable(false);
		});

		albums.add(copiesM, 0, 2);
		albums.add(enterCopies, 1, 2);

		Label artistA = new Label("Enter Artist Name ");
		TextField enterAr = new TextField();
		enterAr.setDisable(true);
		enterCopies.setOnKeyTyped(e -> {
			enterAr.setDisable(false);
		});
		albums.add(artistA, 0, 3);
		albums.add(enterAr, 1, 3);

		Label songsAl = new Label("Enter Songs");
		TextField enterAl = new TextField();
		enterAl.setDisable(true);
		enterAr.setOnKeyTyped(t -> {
			enterAl.setDisable(false);
		});

		albums.add(songsAl, 0, 4);
		albums.add(enterAl, 1, 4);

		Button add = new Button("Add Album");
		ImageView addA = new ImageView(new Image("https://img.icons8.com/dusk/26/add-song.png"));
		HBox addButton = new HBox(add, addA);
		albums.add(addButton, 1, 5);

		Button returnS = new Button("Return");
		ImageView returnB = new ImageView(new Image("https://img.icons8.com/material-outlined/1x/return.png"));
		HBox returnButton = new HBox(returnS, returnB);
		albums.setScaleX(1.2);
		albums.setScaleY(1.2);

		Label test = new Label("Enter your Data ");
		albums.add(test, 0, 5);

		albums.add(returnButton, 3, 5);
		albums.setAlignment(Pos.CENTER);
		albums.setVgap(20);
		albums.setHgap(20);

		this.centerOnScreen();

		returnS.setOnAction(t -> {
			new AddMedia(a, moviesInfo, albumInfo, gameInfo);
			this.close();

		});

		add.setOnAction(t -> {
			if ((enterId.getText() != null && !enterId.getText().isEmpty())) {

				int copies = Integer.parseInt(enterCopies.getText().trim());

				a.addAlbum(enterId.getText().trim(), enternameM.getText().trim(), copies, enterAr.getText(),
						enterAl.getText());

				System.out.println(a.getAllMediaInfo());
				test.setText(enterId.getText() + " " + enternameM.getText() + ", " + "Added");

			}
			// System.out.println(a.getAllMediaInfo());
			else {
				test.setText("Please Enter all info");
			}
		});

		this.show();
	}

}
