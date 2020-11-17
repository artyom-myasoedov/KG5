package sample;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

public class Earth {

    private double radius;
    private Circle circle;
    private Point2D center;
    private StarPane starPane;
    private List<ImagePattern> images = new ArrayList<>();
    private int count = 0;

    public Earth(StarPane starPane) throws MalformedURLException {
        this.radius = 2;
        center = new Point2D(450, 375);
        circle = new Circle(center.getX(), center.getY(), radius, Color.LIGHTBLUE);
        Class<?> clazz = Earth.class;
        InputStream inputStream = clazz.getResourceAsStream("\\earth1.jpg");
        images.add(new ImagePattern(new Image(inputStream)));
        circle.setFill(images.get(0));
        images.add(new ImagePattern(new Image(clazz.getResourceAsStream("\\earth2.jpg"))));
        images.add(new ImagePattern(new Image(clazz.getResourceAsStream("\\earth3.jpg"))));
        images.add(new ImagePattern(new Image(clazz.getResourceAsStream("\\earth4.jpg"))));
        images.add(new ImagePattern(new Image(clazz.getResourceAsStream("\\earth5.jpg"))));
        images.add(new ImagePattern(new Image(clazz.getResourceAsStream("\\earth6.jpg"))));
        images.add(new ImagePattern(new Image(clazz.getResourceAsStream("\\earth9.jpg"))));

        this.starPane = starPane;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (radius < 100) {
            this.radius = radius;
            update();
        } else starPane.stop();
    }

    public Circle getCircle() {
        return circle;
    }

    public Point2D getCenter() {
        return center;
    }

    private void update() {
        circle.setRadius(radius);

    }

    public void setImage() {
        if (count > 6) {
            count = 0;
        }
        circle.setFill(images.get(count++));
    }

    public void setReverseImage() {
        if (count < 0) {
            count = 6;
        }
        circle.setFill(images.get(count--));
    }
}
