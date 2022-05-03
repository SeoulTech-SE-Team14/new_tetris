package domain.config.controller;

import domain.config.constant.key.KeyType;
import domain.config.dao.KeyConfigDao;
import domain.config.entity.KeyConfig;

public class KeyConfigController {

    private static KeyConfigController INSTANCE = new KeyConfigController();

    public static KeyConfigController getInstance() {
        return INSTANCE;
    }

    
    private final KeyConfigDao keyConfigDao = KeyConfigDao.getInstance();


    private KeyConfigController() {

    }


    public KeyConfig getDefault() {
        return new KeyConfig();
    }

    public int getKeyEvent(KeyConfig keyConfig, KeyType keyType) {
        return keyConfig.get(keyType);
    }

    public void setKeyConfig(KeyConfig keyConfig, KeyType keyType, int keyEvent) {
        keyConfig.put(keyType, keyEvent);
    }

    public KeyConfig getCurrentConfig() {
        return keyConfigDao.read();
    }

    public void update(KeyConfig object) {
        keyConfigDao.write(object);
    }
}
