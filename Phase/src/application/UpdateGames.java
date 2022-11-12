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

public class UpdateGames extends UpdateMedia {

	GridPane games = new GridPane();
	 UpdateGames(MediaRental g,File moviesInfo,File albumInfo,File gameInfo) {
		super(g,moviesInfo, albumInfo, gameInfo);
		this.setTitle("Update Games");
		this.setScene(new Scene(games,500,400));
		Label idM = new Label("Media ID");
		TextField enterId = new TextField();
		
		games.add(idM, 0, 0);
		games.add(enterId, 1, 0);
		
		Label titleM = new Label("Media Title");
		TextField enternameM = new TextField();

		games.add(titleM, 0, 1);
		games.add(enternameM, 1, 1);
		
		
		Label copiesM = new Label("Copies Available");
		TextField enterCopies = new TextField();

		
		games.add(copiesM, 0, 2);
		games.add(enterCopies, 1, 2);
		
		Label weightG = new Label("Enter Weight");
		TextField enterWe= new TextField();

		
		games.add(weightG, 0, 3);
		games.add(enterWe, 1, 3);
		
		Button add = new Button("Update Game");
		ImageView addA = new ImageView(new Image("https://img.icons8.com/dusk/26/approve-and-update.png"));
		HBox addButton = new HBox(add,addA);

		addButton.setAlignment(Pos.CENTER);
		
		games.add(addButton, 1, 5);

		
		Button returnS = new Button("Return");
		ImageView returnB = new ImageView( new Image("https://img.icons8.com/material-outlined/1x/return.png"));
		HBox returnButton = new HBox(returnS,returnB);
		
		Label test = new Label("Enter data to update");
		
		games.setScaleX(1.2);
		games.setScaleY(1.2);
		
		games.add(returnButton, 3, 5);
		games.setAlignment(Pos.CENTER);
		games.add(test, 0, 5);

		games.setVgap(20);
		games.setHgap(20);
		this.centerOnScreen();
		

		add.setOnAction(t ->{
			 if ((enterId.getText() != null && !enterId.getText().isEmpty()) ) {
			int copies = Integer.parseInt(enterCopies.getText().trim());
			double weights = Double.parseDouble(enterWe.getText().trim());

			g.upDateGame(enternameM.getText().trim(), enternameM.getText().trim(), copies, weights);
			 System.out.println(g.getAllMediaInfo());
			 test.setText(enterId.getText() + " " + enternameM.getText() + ", "+ "Updated");

			 }
			 else {
				 test.setText("Please Enter all info");
			 }
		});
		returnS.setOnAction(t -> {
			
			new UpdateMedia(g,moviesInfo, albumInfo, gameInfo);
			this.close();
		});
		
		this.show();
		
	}

}
