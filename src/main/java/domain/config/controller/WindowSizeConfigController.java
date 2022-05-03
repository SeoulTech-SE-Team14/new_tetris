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
        return getDefault();
    }

    public WindowSizeConfig getW1280_H960() {
        return new WindowSizeConfig();
    }

    public WindowSizeConfig getW1920_H1080() {
        return new WindowSizeConfig();
    }

    public void update(WindowSizeConfig object) {
        windowSizeConfigDao.write(object);
    }
}