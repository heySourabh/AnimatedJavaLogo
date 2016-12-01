package main;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import screenshots.ScreenshotUtility;

public class AnimatedJavaLogo extends Application {

    final static double IMG_WIDTH = 500;
    final static double IMG_HEIGHT = 400;

    static Image javaImage;

    public static void main(String[] args) {
        javaImage = new Image(AnimatedJavaLogo.class
                .getResourceAsStream("/images/java-logo-vector_1.png"),
                IMG_WIDTH, IMG_HEIGHT, true, true);
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ImageView javaImageView = new ImageView(javaImage);
        Group group = new Group(javaImageView);

        group.getChildren().add(getFirstAnimatedSteamPath());
        group.getChildren().add(getSecondAnimatedSteamPath());

        Scene scene = new Scene(group);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        //ScreenshotUtility.screenshotThread(scene, 2).start();
    }

    private SteamPath getFirstAnimatedSteamPath() {
        SimpleDoubleProperty startX = new SimpleDoubleProperty(200);
        SimpleDoubleProperty control1X = new SimpleDoubleProperty(115);
        SimpleDoubleProperty control2X = new SimpleDoubleProperty(255);
        SimpleDoubleProperty endX = new SimpleDoubleProperty(225);
        SteamPath firstSteamPath = new SteamPath(
                startX, new SimpleDoubleProperty(150),
                control1X, new SimpleDoubleProperty(80),
                control2X, new SimpleDoubleProperty(70),
                endX, new SimpleDoubleProperty(8));

        Timeline tl1 = new Timeline(new KeyFrame(Duration.seconds(5.25),
                new KeyValue(startX, 190, Interpolator.EASE_BOTH),
                new KeyValue(endX, 150, Interpolator.EASE_BOTH)
        ));
        tl1.setAutoReverse(true);
        tl1.setCycleCount(Animation.INDEFINITE);
        tl1.play();
        Timeline tl2 = new Timeline(new KeyFrame(Duration.seconds(2.333),
                new KeyValue(control1X, 250, Interpolator.EASE_BOTH),
                new KeyValue(control2X, 150, Interpolator.EASE_BOTH)
        ));
        tl2.setAutoReverse(true);
        tl2.setCycleCount(Animation.INDEFINITE);
        tl2.play();

        return firstSteamPath;
    }

    private SteamPath getSecondAnimatedSteamPath() {
        SimpleDoubleProperty startX = new SimpleDoubleProperty(230);
        SimpleDoubleProperty control1X = new SimpleDoubleProperty(145);
        SimpleDoubleProperty control2X = new SimpleDoubleProperty(285);
        SimpleDoubleProperty endX = new SimpleDoubleProperty(255);
        SteamPath secondSteamPath = new SteamPath(
                startX, new SimpleDoubleProperty(155),
                control1X, new SimpleDoubleProperty(100),
                control2X, new SimpleDoubleProperty(80),
                endX, new SimpleDoubleProperty(60));

        Timeline tl1 = new Timeline(new KeyFrame(Duration.seconds(5.20),
                new KeyValue(startX, 210, Interpolator.EASE_BOTH),
                new KeyValue(endX, 230, Interpolator.EASE_BOTH)
        ));
        tl1.setAutoReverse(true);
        tl1.setCycleCount(Animation.INDEFINITE);
        tl1.play();
        Timeline tl2 = new Timeline(new KeyFrame(Duration.seconds(2.1),
                new KeyValue(control1X, 280, Interpolator.EASE_BOTH),
                new KeyValue(control2X, 180, Interpolator.EASE_BOTH)
        ));
        tl2.setAutoReverse(true);
        tl2.setCycleCount(Animation.INDEFINITE);
        tl2.play();

        return secondSteamPath;
    }
}
