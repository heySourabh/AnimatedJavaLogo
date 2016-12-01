package main;

import javafx.beans.property.DoubleProperty;
import javafx.scene.paint.Color;
import javafx.scene.shape.ClosePath;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.PathElement;

public class SteamPath extends Path {

    public SteamPath(DoubleProperty startX, DoubleProperty startY,
            DoubleProperty control1X, DoubleProperty control1Y,
            DoubleProperty control2X, DoubleProperty control2Y,
            DoubleProperty endX, DoubleProperty endY) {
        MoveTo start = new MoveTo();
        start.xProperty().bind(startX);
        start.yProperty().bind(startY);
        CubicCurveTo curve1 = new CubicCurveTo();
        curve1.controlX1Property().bind(control1X.add(10));
        curve1.controlY1Property().bind(control1Y);
        curve1.controlX2Property().bind(control2X.add(10));
        curve1.controlY2Property().bind(control2Y);
        curve1.xProperty().bind(endX);
        curve1.yProperty().bind(endY);
        
        CubicCurveTo curve2 = new CubicCurveTo();
        curve2.controlX1Property().bind(control2X.subtract(10));
        curve2.controlY1Property().bind(control2Y);
        curve2.controlX2Property().bind(control1X.subtract(10));
        curve2.controlY2Property().bind(control1Y);
        curve2.xProperty().bind(startX);
        curve2.yProperty().bind(startY);
        PathElement closePath = new ClosePath();
        this.getElements().addAll(start, curve1, curve2, closePath);
        this.setStroke(Color.BLACK);
        this.setFill(Color.BLUE);
    }
}
