package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class AnimatedJavaLogo extends Application {

    final static double IMG_WIDTH = 500;
    final static double IMG_HEIGHT = 400;

    static Image javaImage;

    public static void main(String[] args) {
        javaImage = new Image(AnimatedJavaLogo.class
                .getResourceAsStream("/images/java-logo-vector.png"),
                IMG_WIDTH, IMG_HEIGHT, true, true);
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ImageView javaImageView = new ImageView(javaImage);
        StackPane stackPane = new StackPane(javaImageView);
        
        Scene scene = new Scene(stackPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
