package sample;

import javafx.geometry.Point2D;
import javafx.scene.control.Alert;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;


public class StarPane extends Pane {
    private int numberOfStars;
    private double animationSpeed;
    private List<Star> stars;
    private Timer timer;
    private Earth earth = new Earth(this);
    private boolean isEarthShowed;

    public StarPane(int numberOfStars, double animationSpeed) throws MalformedURLException {
        this.numberOfStars = numberOfStars;
        this.animationSpeed = animationSpeed;
        stars = new ArrayList<>();
        setHeight(900);
        setWidth(750);
        timer = new Timer();


    }

    public int getNumberOfStars() {
        return numberOfStars;
    }

    public void setNumberOfStars(int numberOfStars) {
        this.numberOfStars = numberOfStars;
    }

    public Timer getTimer() {
        return timer;
    }

    public List<Star> getStars() {
        return stars;
    }

    public double getAnimationSpeed() {
        return animationSpeed;
    }

    public void setAnimationSpeed(double animationSpeed) {
        this.animationSpeed = animationSpeed;
    }

    public Earth getEarth() {
        return earth;
    }

    public boolean isEarthShowed() {
        return isEarthShowed;
    }

    public void showEarth() {
        isEarthShowed = true;
    }

    public void draw() {
        Rectangle rect = new Rectangle((int) getHeight(), (int) getWidth());
        rect.setFill(Color.BLACK);
        rect.setLayoutX(0);
        rect.setLayoutY(0);
        getChildren().add(rect);
        for (int i = 0; i < numberOfStars; i++) {
            stars.add(createStar());
            getChildren().add(stars.get(stars.size() - 1).getCircle());

        }

    }

    public Star createStar() {
        double phi = (int) (Math.random() * 360),
                r = (int) (Math.random() * 300 + 75);
        return new Star(r, phi, new Point2D(getHeight(), getWidth()));
    }

    public void start() {
        timer.schedule(new MyTimerTask(stars, this, earth), 0, 50);
    }

    public boolean stop() {
        timer.cancel();
        timer = new Timer();
        return true;
    }
}
