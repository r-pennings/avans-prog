package Views;

import java.io.File;

import Controllers.GameController;
import Controllers.PlayerController;
import Models.MemoryFile;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class MainScene extends Scene {

	// Constants
	private static final String SAVE_DIR = "/savedgames";
	private static final String EXTENSION = "*.mem";

	// Instance Variables
	private GameController gameController;
	
	private FileChooser fileChooser;

	// Constructor
	public MainScene(GameController gameController, PlayerController playerController) {
		super(new Pane());

		this.gameController = gameController;

		// Initialise Root Pane
		BorderPane pane = new BorderPane();
		pane.setTop(initMenu());
		pane.setCenter(gameController.getFieldPane());
		pane.setBottom(playerController.getPane());

		setRoot(pane);

		// Initialise File Chooser
		fileChooser = new FileChooser();

		File savedGamesDir = new File(System.getProperty("user.dir") + SAVE_DIR);
		if (!savedGamesDir.exists())
			savedGamesDir.mkdir();

		fileChooser.getExtensionFilters().add(new ExtensionFilter("Memory Files (" + EXTENSION + ")", EXTENSION));
		fileChooser.setInitialDirectory(savedGamesDir);
	}

	/*
	 * Private Methods
	 */
	private MenuBar initMenu() {
		// Initialise Menu
		Menu menu = new Menu("Menu");

		// Initialise MenuItems
		MenuItem loadMenuItem = new MenuItem("Load...");
		MenuItem saveMenuItem = new MenuItem("Save...");
		MenuItem exitMenuItem = new MenuItem("Exit");

		// Add KeyCombinations
		loadMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.L, KeyCombination.ALT_DOWN));
		saveMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.ALT_DOWN));
		exitMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.X, KeyCombination.ALT_DOWN));

		// Add On Action Events
		loadMenuItem.setOnAction((event) -> {
			new MemoryFile().read(gameController, fileChooser.showOpenDialog(gameController.getStage()));
		});
		saveMenuItem.setOnAction((event) -> {
			new MemoryFile().create(gameController, fileChooser.showSaveDialog(gameController.getStage()));
		});
		exitMenuItem.setOnAction((event) -> System.exit(0));

		// Add MenuItems To Menu
		menu.getItems().add(loadMenuItem);
		menu.getItems().add(saveMenuItem);
		menu.getItems().add(exitMenuItem);

		// Initialise MenuBar
		MenuBar menubar = new MenuBar();

		// Add Menu To MenuBar
		menubar.getMenus().add(menu);

		return menubar;
	}
}
