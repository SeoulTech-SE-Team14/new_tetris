package domain.config.controller;

import domain.config.dao.WindowSizeConfigDao;
import domain.config.entity.WindowSizeConfig;

public class WindowSizeConfigController {

    private static WindowSizeConfigController INSTANCE = new WindowSizeConfigController();

    public static WindowSizeConfigController getInstance() {
        return INSTANCE;
    }

    
    private WindowSizeConfigDao windowSizeConfigDao = WindowSizeConfigDao.getInstance();


    private WindowSizeConfigController() {

    }


    public WindowSizeConfig getDefault() {
        return new WindowSizeConfig();
    }

    public WindowSizeConfig getW800_H600() {
        return new WindowSizeConfig(800, 600);
    }

    public WindowSizeConfig getW1000_H800() {
        return new WindowSizeConfig(1000, 800);
    }

    public WindowSizeConfig getW1280_H960() {
        return new WindowSizeConfig(1280, 960);
    }

    public WindowSizeConfig getW1920_H1080() {
        return new WindowSizeConfig(1920, 1080);
    }

    public WindowSizeConfig getW1440_H900() {
        return new WindowSizeConfig(1440, 900);
    }

    public WindowSizeConfig getCurrentConfig() {
        return windowSizeConfigDao.read();
    }

    public void update(WindowSizeConfig object) {
        windowSizeConfigDao.write(object);
    }
}