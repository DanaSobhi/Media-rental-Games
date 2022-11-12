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


public class AddGame extends AddMedia {


	GridPane games = new GridPane();

	 AddGame(MediaRental g, File moviesInfo, File albumInfo, File gameInfo) {
		super(g, moviesInfo, albumInfo, gameInfo);
		this.setTitle("Add Game ");
		this.setScene(new Scene(games, 600, 400));
		Label idM = new Label("Media ID");
		TextField enterId = new TextField();

		games.add(idM, 0, 0);
		games.add(enterId, 1, 0);

		Label titleM = new Label("Media Title");
		TextField enternameM = new TextField();
		enternameM.setDisable(true);
		enterId.setOnKeyTyped(t -> {
			enternameM.setDisable(false);
		});
		games.add(titleM, 0, 1);
		games.add(enternameM, 1, 1);

		Label copiesM = new Label("Copies Available");
		TextField enterCopies = new TextField();
		enterCopies.setDisable(true);
		enternameM.setOnKeyTyped(t -> {
			enterCopies.setDisable(false);
		});

		games.add(copiesM, 0, 2);
		games.add(enterCopies, 1, 2);

		Label weightG = new Label("Enter Weight");
		TextField enterWe = new TextField();
		enterWe.setDisable(true);
		enterCopies.setOnKeyTyped(t -> {
			enterWe.setDisable(false);
		});

		games.add(weightG, 0, 3);
		games.add(enterWe, 1, 3);

		Button add = new Button("Add Game");
		ImageView addA = new ImageView(new Image("https://img.icons8.com/dusk/25/controller.png"));
		HBox addButton = new HBox(add, addA);
		games.add(addButton, 1, 5);

		Button returnS = new Button("Return");
		ImageView returnB = new ImageView(new Image("https://img.icons8.com/material-outlined/1x/return.png"));
		HBox returnButton = new HBox(returnS, returnB);
		games.setScaleX(1.2);
		games.setScaleY(1.2);

		Label test = new Label("Enter your Data ");

		games.add(test, 0, 4);

		games.setAlignment(Pos.CENTER);
		games.setVgap(20);
		games.setHgap(20);

		games.add(returnButton, 3, 5);

		add.setOnAction(t -> {
			if ((enterId.getText() != null && !enterId.getText().isEmpty())) {
				int copies = Integer.parseInt(enterCopies.getText().trim());
				double weights = Double.parseDouble(enterWe.getText().trim());

				g.addGame(enterId.getText().trim(), enternameM.getText().trim(), copies, weights);
				test.setText(enterId.getText() + " " + enternameM.getText() + ", " + "Added");

			

				System.out.println(g.getAllMediaInfo());
			} else {
				test.setText("Please Enter all info");

			}
		});

		returnS.setOnAction(t -> {
			new AddMedia(g, moviesInfo, albumInfo, gameInfo);
			this.close();

		});

		this.centerOnScreen();
		this.show();

	}

}
