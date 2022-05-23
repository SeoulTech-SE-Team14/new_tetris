package domain.config.controller;

import domain.config.entity.WindowSizeConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WindowSizeConfigControllerTest {
    WindowSizeConfig windowSizeConfig;

    @Test
    void getW800_H600() {
        windowSizeConfig = WindowSizeConfigController.getInstance().getW800_H600();
        assertEquals(800, windowSizeConfig.getWidth());
        assertEquals(600, windowSizeConfig.getHeight());
    }

    @Test
    void getW1000_H800() {
        windowSizeConfig = WindowSizeConfigController.getInstance().getW1000_H800();
        assertEquals(1000, windowSizeConfig.getWidth());
        assertEquals(800, windowSizeConfig.getHeight());
    }

    @Test
    void getW1280_H960() {
        windowSizeConfig = WindowSizeConfigController.getInstance().getW1280_H960();
        assertEquals(1280, windowSizeConfig.getWidth());
        assertEquals(960, windowSizeConfig.getHeight());
    }

    @Test
    void getW1920_H1080() {
        windowSizeConfig = WindowSizeConfigController.getInstance().getW1920_H1080();
        assertEquals(1920, windowSizeConfig.getWidth());
        assertEquals(1080, windowSizeConfig.getHeight());
    }

    @Test
    void getW1440_H900() {
        windowSizeConfig = WindowSizeConfigController.getInstance().getW1440_H900();
        assertEquals(1440, windowSizeConfig.getWidth());
        assertEquals(900, windowSizeConfig.getHeight());
    }
}