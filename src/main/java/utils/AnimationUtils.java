package utils;

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class AnimationUtils {

    /**
     * Adds a fade-in effect to a given Node.
     *
     * @param node     The Node to animate
     * @param duration The duration of the animation in milliseconds
     */
    public static void addFadeInEffect(Node node, int duration) {
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(duration), node);
        fadeTransition.setFromValue(0.0);
        fadeTransition.setToValue(1.0);
        fadeTransition.play();
    }

    /**
     * Adds a scale effect (zoom-in or zoom-out) to a given Node.
     *
     * @param node     The Node to animate
     * @param duration The duration of the animation in milliseconds
     * @param scale    The scaling factor (e.g., 1.1 for zoom-in)
     */
    public static void addScaleEffect(Node node, int duration, double scale) {
        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(duration), node);
        scaleTransition.setToX(scale);
        scaleTransition.setToY(scale);
        scaleTransition.play();
    }
}