package sample;

import javafx.scene.control.Alert;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

public class MyTimerTask extends TimerTask {
    private final List<Star> stars = new ArrayList<>();
    private final StarPane starPane;
    private final Earth earth;


    public MyTimerTask(List<Star> list, StarPane starPane, Earth earth) {
        stars.addAll(list);
        this.starPane = starPane;
        this.earth = earth;
    }

    public Earth getEarth() {
        return earth;
    }

    public List<Star> getStars() {
        return stars;
    }

    public StarPane getStarPane() {
        return starPane;
    }

    @Override
    public void run() {
        stars.forEach(s -> {
            s.setRadius(s.getRadius() + starPane.getAnimationSpeed() * 3 * (Math.abs(s.getX()) + Math.abs(s.getY())) / 100, getStarPane().getAnimationSpeed());
        });
        if (starPane.isEarthShowed()) {
            earth.setRadius(earth.getRadius() + 1 * starPane.getAnimationSpeed() * 2);

            if (starPane.getAnimationSpeed() > 0) {
                earth.setImage();
            } else if (starPane.getAnimationSpeed() < 0) {
                earth.setReverseImage();
            }
        }
    }
}
