package sample;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Star {
    private double radius;
    private double phi;
    private Circle circle;
    private double y;
    private double x;
    private double yReal;
    private double xReal;
    private Point2D center;
    private int earthRadius;
    private final static double oneAngle = Math.PI / 180;

    public Star(double radius, double phi, Point2D point) {
        this.radius = radius;
        this.phi = phi;
        center = point;
        x = radius * Math.sin(phi * oneAngle);
        y = radius * Math.cos(phi * oneAngle);
        xReal = center.getX() / 2 + x;
        yReal = center.getY() / 2 + y;
        circle = new Circle(xReal, yReal, Math.random() * 2, Color.WHITE);
        update(1);
        earthRadius = (int) (Math.random() * 40) + 10;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius, double animationSpeed) {
        this.radius = radius;
        update(animationSpeed);

    }

    public int getEarthRadius() {
        return earthRadius;
    }

    public void setEarthRadius(int earthRadius) {
        this.earthRadius = earthRadius;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getPhi() {
        return phi;
    }

    public void setPhi(double phi) {
        this.phi = phi;
    }

    public Circle getCircle() {
        return circle;
    }

    private void update(double animationSpeed) {
        if (Math.abs(x) > 450 || Math.abs(y) > 375) {
            radius = (int) (Math.random() * 300 + 50);
            phi = (int) (Math.random() * 360);

        }

        if ((Math.abs(x) < earthRadius || Math.abs(y) < earthRadius) && animationSpeed < 0) {
            radius = (int) (Math.random() * 400 + 200);
            phi = (int) (Math.random() * 360);
        }

        x = radius * Math.sin(phi * oneAngle);
        y = radius * Math.cos(phi * oneAngle);
        xReal = center.getX() / 2 + x;
        yReal = center.getY() / 2 + y;
        circle.setCenterX(xReal);
        circle.setCenterY(yReal);
    }
}
