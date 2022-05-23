package view.frame.config;

import org.junit.jupiter.api.Test;
import view.abstractComponent.frame.DefaultFrame;

import static org.junit.jupiter.api.Assertions.*;

class ConfigFrameTest {
    @Test
    void ConfigFrame() {
        ConfigFrame frame = new ConfigFrame();
        assertTrue(frame instanceof DefaultFrame);
    }
}