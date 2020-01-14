package brons_zilver;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.ListView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class ListViewPane extends VBox {

	ListView<String> listView = new ListView<String>();

	// constants
	private final String[] mycolorlist = { "GREENYELLOW", "FANTASY", "ORANGERED", "SADDLEBROWN", "DEEPSKYBLUE",
			"LAVENDER", "BISQUE", "FORESTGREEN" };

	public ListViewPane(ControlPane controlPane) {
		this.setPrefHeight(110);

		this.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));

		listView.getSelectionModel().selectedItemProperty().addListener(new MyListViewListener(controlPane));
		listView.setItems(FXCollections.observableArrayList(mycolorlist));

		this.getChildren().add(listView);
	}
}
