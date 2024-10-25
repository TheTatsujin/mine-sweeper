package basics.graphics;

import basics.model.Dimension;
import basics.model.Settings;

/**
 * @param displayDimensions in Pixels
 */
public record DisplaySettings(Dimension displayDimensions) implements Settings {

    @Override
    public void loadDefault() {

    }
}
