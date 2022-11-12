package application;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.*;

public class MediaShows extends Stage {
	GridPane medias = new GridPane();

	MediaShows(MediaRental m, File moviesInfo, File albumInfo, File gameInfo) {

		this.setTitle("Media Operation");
		this.setScene(new Scene(medias, 400, 400));

		Button returne = new Button("Close");
		Image arrow = new Image("https://img.icons8.com/material-outlined/1x/return.png");
		ImageView returnB = new ImageView(arrow);
		HBox returnSection = new HBox(returne, returnB);
		returnSection.setLayoutX(250);
		returnSection.setLayoutY(300);

		Button addM = new Button("Add Media");
		addM.setMaxSize(3000, 40);
		addM.setMinWidth(120);
		addM.setScaleX(1.5);
		addM.setScaleY(1.5);
		addM.setTextFill(Color.INDIGO);
		ImageView addMe = new ImageView(new Image("https://img.icons8.com/nolan/70/add-property.png"));

		HBox addsetion = new HBox(addM, addMe);
		addsetion.setSpacing(30);
		addsetion.setAlignment(Pos.CENTER);
		addsetion.setMaxWidth(3000);

		Button findM = new Button("Delete Media");
		findM.setMaxSize(1800, 40);
		findM.setMinWidth(120);
		findM.setScaleX(1.5);
		findM.setScaleY(1.5);
		findM.setTextFill(Color.INDIGO);
		ImageView deleteMed = new ImageView(new Image("https://img.icons8.com/nolan/70/delete-forever.png"));

		HBox deletesection = new HBox(findM, deleteMed);
		deletesection.setSpacing(30);
		deletesection.setAlignment(Pos.CENTER);

		Button updateM = new Button("Update Media");
		updateM.setMaxSize(1000, 40);
		updateM.setMinWidth(120);
		updateM.setScaleX(1.5);
		updateM.setScaleY(1.5);
		updateM.setTextFill(Color.INDIGO);
		ImageView updateMe = new ImageView(new Image("https://img.icons8.com/nolan/70/approve-and-update.png"));

		HBox updateection = new HBox(updateM, updateMe);
		updateection.setSpacing(30);
		updateection.setAlignment(Pos.CENTER);

		Button SearchM = new Button("Search Media");
		SearchM.setMaxSize(1000, 40);
		SearchM.setMinWidth(120);
		SearchM.setScaleX(1.5);
		SearchM.setScaleY(1.5);
		SearchM.setTextFill(Color.INDIGO);

		ImageView searchMedi = new ImageView(new Image("https://img.icons8.com/nolan/70/search.png"));

		HBox searchSection = new HBox(SearchM, searchMedi);
		searchSection.setSpacing(30);
		searchSection.setAlignment(Pos.CENTER);

		medias.add(returnSection, 5, 5);
		medias.add(addsetion, 0, 0);
		medias.add(deletesection, 0, 1);
		medias.add(updateection, 0, 2);
		medias.add(searchSection, 0, 3);

		medias.setVgap(50);
		medias.setHgap(20);

		medias.setAlignment(Pos.CENTER);

		this.setMaximized(true);
		this.show();
		addM.setOnAction(a -> { // when clicking on add it open the add media window and close this one
			new AddMedia(m, moviesInfo, albumInfo, gameInfo);
			this.close();
		});
		findM.setOnAction(f -> { // open delete close this window
			new DeleteMedia(m, moviesInfo, albumInfo, gameInfo);
			this.close();
		});
		updateM.setOnAction(e -> { //open update and close this window
			new UpdateMedia(m, moviesInfo, albumInfo, gameInfo);
			this.close();
		});
		SearchM.setOnAction(c -> { //open search and close this window
			new SearchMedia(m, moviesInfo, albumInfo, gameInfo);
			this.close();
		});

		this.show();

		try {
			/* prepare a print writer for each file */
			PrintWriter moviePrint = new PrintWriter(moviesInfo);
			PrintWriter albumPrint = new PrintWriter(albumInfo);
			PrintWriter gamePrint = new PrintWriter(gameInfo);
			returne.setOnAction(t -> { //when clicking on close it save all the data
				this.close();

				for (int e = 0; e < m.mediaInfor.size(); e++) {
					Media temp = m.mediaInfor.get(e);

					if (temp instanceof Movie) { 
						Movie mvi = (Movie) temp;
						moviePrint.append(mvi.toString() + "\n"); //add it to movie file
						
					} else if (temp instanceof Album) {
						Album al = (Album) temp;
						albumPrint.append(al.toString() + "\n"); //add it to album file 
						
					} else if (temp instanceof Game) {
						Game gm = (Game) temp;
						gamePrint.append(gm.toString() + "\n"); //add it to game file 
						
					}
					
					

				}
				moviePrint.close();
				albumPrint.close();
				gamePrint.close();
				System.out.println(m.getAllMediaInfo());

			});

		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
