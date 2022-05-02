package domain.config.controller;

import domain.config.dao.KeyConfigDao;
import domain.config.entity.KeyConfig;

public class KeyConfigController {

    private static KeyConfigController INSTANCE = new KeyConfigController();

    public static KeyConfigController getInstance() {
        return INSTANCE;
    }
    
    private final KeyConfigDao keyConfigDao = KeyConfigDao.getInstance();

    public KeyConfig getDefault() {
        return new KeyConfig();
    }

    public void setKeyConfig(KeyConfig keyConfig, int keyEvent, int key) {

    }

    public KeyConfig getCurrentConfig() {
        return keyConfigDao.read();
    }

    public void update(KeyConfig object) {
        keyConfigDao.write(object);
    }
}
