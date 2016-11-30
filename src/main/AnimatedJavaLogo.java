package main;

import javafx.application.Application;
import javafx.stage.Stage;

public class AnimatedJavaLogo extends Application {

    double width = 500;
    double height = 400;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setWidth(width);
        primaryStage.setHeight(height);
        
    }
}
