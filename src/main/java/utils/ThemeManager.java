package utils;

import javafx.scene.Scene;

public class ThemeManager {

    private static final String DARK_THEME_CSS = "-fx-background-color: #333333; -fx-text-fill: white;";
    private static final String LIGHT_THEME_CSS = "-fx-background-color: #f4f4f4; -fx-text-fill: black;";
    private static final String HIGH_CONTRAST_CSS = "-fx-background-color: black; -fx-text-fill: yellow;";

    /**
     * Applies a dark theme to the given scene.
     *
     * @param scene The scene to style
     */
    public static void applyDarkTheme(Scene scene) {
        scene.getRoot().setStyle(DARK_THEME_CSS);
    }

    /**
     * Applies a light theme to the given scene.
     *
     * @param scene The scene to style
     */
    public static void applyLightTheme(Scene scene) {
        scene.getRoot().setStyle(LIGHT_THEME_CSS);
    }

    /**
     * Applies a high-contrast theme to the given scene.
     *
     * @param scene The scene to style
     */
    public static void applyHighContrastTheme(Scene scene) {
        scene.getRoot().setStyle(HIGH_CONTRAST_CSS);
    }
}