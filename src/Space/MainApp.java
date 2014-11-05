package Space;


import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainApp extends Application {
	private static Stage primaryStage;
	private static BorderPane rootLayout;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Cowboys in Space");
		
		initRootLayout();
		showWelcomeScreen();
		
	}

	private void initRootLayout() {
		try {		
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
                    rootLayout = (BorderPane) loader.load();
                    rootLayout.setId("WelcomeScreen");
                    Scene scene = new Scene(rootLayout);
                    primaryStage.setScene(scene);
                    primaryStage.setFullScreen(true);
                    primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void showWelcomeScreen() {
	    try {
	        // Load person overview.
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(MainApp.class.getResource("view/WelcomeScreen.fxml"));
	        Pane welcomeScreen = (Pane) loader.load();	        
	        rootLayout.setCenter(welcomeScreen);

	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
   
        public static BorderPane getRootLayout() {
            return rootLayout;
        }
	public static Stage getPrimaryStage() {
		return primaryStage;
	}
        
        public static void setPrimaryStage(Stage stage) {
            primaryStage = stage;
        }
	public static void main(String[] args) {
		launch(args);
	}
}
