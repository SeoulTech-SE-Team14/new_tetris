package domain.config.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domain.config.constant.key.KeyType;
import domain.config.entity.KeyConfig;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.event.KeyEvent;

class KeyConfigControllerTest {

    @Test
    void getDefault() {
        KeyConfigController keyConfigController = KeyConfigController.getInstance();
        KeyConfig keyConfig = keyConfigController.getDefault();

        assertEquals(keyConfig.get(KeyType.P1_BLOCK_MOVE_DOWN), KeyEvent.VK_DOWN);
        assertEquals(keyConfig.get(KeyType.P1_BLOCK_MOVE_DOWN_AT_ONCE), KeyEvent.VK_UP);
        assertEquals(keyConfig.get(KeyType.P1_BLOCK_MOVE_LEFT), KeyEvent.VK_LEFT);
        assertEquals(keyConfig.get(KeyType.P1_BLOCK_MOVE_RIGHT), KeyEvent.VK_RIGHT);
        assertEquals(keyConfig.get(KeyType.P1_BLOCK_ROTATE), KeyEvent.VK_L);
        assertEquals(keyConfig.get(KeyType.P2_BLOCK_MOVE_DOWN), KeyEvent.VK_S);
        assertEquals(keyConfig.get(KeyType.P2_BLOCK_MOVE_DOWN_AT_ONCE), KeyEvent.VK_W);
        assertEquals(keyConfig.get(KeyType.P2_BLOCK_MOVE_LEFT), KeyEvent.VK_A);
        assertEquals(keyConfig.get(KeyType.P2_BLOCK_MOVE_RIGHT), KeyEvent.VK_D);
        assertEquals(keyConfig.get(KeyType.P2_BLOCK_ROTATE), KeyEvent.VK_T);
    }

    @Test
    void getKeyEvent() {
        KeyConfigController keyConfigController = KeyConfigController.getInstance();
        KeyConfig keyConfig = keyConfigController.getDefault();

        assertEquals(keyConfigController.getKeyEvent(keyConfig, KeyType.P1_BLOCK_MOVE_DOWN), KeyEvent.VK_DOWN);
        assertEquals(keyConfigController.getKeyEvent(keyConfig, KeyType.P1_BLOCK_MOVE_DOWN_AT_ONCE), KeyEvent.VK_UP);
        assertEquals(keyConfigController.getKeyEvent(keyConfig, KeyType.P1_BLOCK_MOVE_LEFT), KeyEvent.VK_LEFT);
        assertEquals(keyConfigController.getKeyEvent(keyConfig, KeyType.P1_BLOCK_MOVE_RIGHT), KeyEvent.VK_RIGHT);
        assertEquals(keyConfigController.getKeyEvent(keyConfig, KeyType.P1_BLOCK_ROTATE), KeyEvent.VK_L);
        assertEquals(keyConfigController.getKeyEvent(keyConfig, KeyType.P2_BLOCK_MOVE_DOWN), KeyEvent.VK_S);
        assertEquals(keyConfigController.getKeyEvent(keyConfig, KeyType.P2_BLOCK_MOVE_DOWN_AT_ONCE), KeyEvent.VK_W);
        assertEquals(keyConfigController.getKeyEvent(keyConfig, KeyType.P2_BLOCK_MOVE_LEFT), KeyEvent.VK_A);
        assertEquals(keyConfigController.getKeyEvent(keyConfig, KeyType.P2_BLOCK_MOVE_RIGHT), KeyEvent.VK_D);
        assertEquals(keyConfigController.getKeyEvent(keyConfig, KeyType.P2_BLOCK_ROTATE), KeyEvent.VK_T);
    }

    @Test
    void setKeyConfig() {
        KeyConfigController keyConfigController = KeyConfigController.getInstance();
        KeyConfig keyConfig = keyConfigController.getDefault();

        assertEquals(keyConfigController.getKeyEvent(keyConfig, KeyType.P1_BLOCK_MOVE_DOWN), KeyEvent.VK_DOWN);
        keyConfigController.setKeyConfig(keyConfig, KeyType.P1_BLOCK_MOVE_DOWN, KeyEvent.VK_5);
        assertEquals(keyConfigController.getKeyEvent(keyConfig, KeyType.P1_BLOCK_MOVE_DOWN), KeyEvent.VK_5);

        assertEquals(keyConfigController.getKeyEvent(keyConfig, KeyType.P1_BLOCK_MOVE_DOWN_AT_ONCE), KeyEvent.VK_UP);
        keyConfigController.setKeyConfig(keyConfig, KeyType.P1_BLOCK_MOVE_DOWN_AT_ONCE, KeyEvent.VK_8);
        assertEquals(keyConfigController.getKeyEvent(keyConfig, KeyType.P1_BLOCK_MOVE_DOWN_AT_ONCE), KeyEvent.VK_8);

        assertEquals(keyConfigController.getKeyEvent(keyConfig, KeyType.P1_BLOCK_MOVE_LEFT), KeyEvent.VK_LEFT);
        keyConfigController.setKeyConfig(keyConfig, KeyType.P1_BLOCK_MOVE_LEFT, KeyEvent.VK_4);
        assertEquals(keyConfigController.getKeyEvent(keyConfig, KeyType.P1_BLOCK_MOVE_LEFT), KeyEvent.VK_4);

        assertEquals(keyConfigController.getKeyEvent(keyConfig, KeyType.P1_BLOCK_MOVE_RIGHT), KeyEvent.VK_RIGHT);
        keyConfigController.setKeyConfig(keyConfig, KeyType.P1_BLOCK_MOVE_RIGHT, KeyEvent.VK_6);
        assertEquals(keyConfigController.getKeyEvent(keyConfig, KeyType.P1_BLOCK_MOVE_RIGHT), KeyEvent.VK_6);

        assertEquals(keyConfigController.getKeyEvent(keyConfig, KeyType.P1_BLOCK_ROTATE), KeyEvent.VK_L);
        keyConfigController.setKeyConfig(keyConfig, KeyType.P1_BLOCK_ROTATE, KeyEvent.VK_P);
        assertEquals(keyConfigController.getKeyEvent(keyConfig, KeyType.P1_BLOCK_ROTATE), KeyEvent.VK_P);

        assertEquals(keyConfigController.getKeyEvent(keyConfig, KeyType.P2_BLOCK_MOVE_DOWN), KeyEvent.VK_S);
        keyConfigController.setKeyConfig(keyConfig, KeyType.P2_BLOCK_MOVE_DOWN, KeyEvent.VK_F);
        assertEquals(keyConfigController.getKeyEvent(keyConfig, KeyType.P2_BLOCK_MOVE_DOWN), KeyEvent.VK_F);

        assertEquals(keyConfigController.getKeyEvent(keyConfig, KeyType.P2_BLOCK_MOVE_DOWN_AT_ONCE), KeyEvent.VK_W);
        keyConfigController.setKeyConfig(keyConfig, KeyType.P2_BLOCK_MOVE_DOWN_AT_ONCE, KeyEvent.VK_R);
        assertEquals(keyConfigController.getKeyEvent(keyConfig, KeyType.P2_BLOCK_MOVE_DOWN_AT_ONCE), KeyEvent.VK_R);

        assertEquals(keyConfigController.getKeyEvent(keyConfig, KeyType.P2_BLOCK_MOVE_LEFT), KeyEvent.VK_A);
        keyConfigController.setKeyConfig(keyConfig, KeyType.P2_BLOCK_MOVE_LEFT, KeyEvent.VK_D);
        assertEquals(keyConfigController.getKeyEvent(keyConfig, KeyType.P2_BLOCK_MOVE_LEFT), KeyEvent.VK_D);

        assertEquals(keyConfigController.getKeyEvent(keyConfig, KeyType.P2_BLOCK_MOVE_RIGHT), KeyEvent.VK_D);
        keyConfigController.setKeyConfig(keyConfig, KeyType.P2_BLOCK_MOVE_RIGHT, KeyEvent.VK_G);
        assertEquals(keyConfigController.getKeyEvent(keyConfig, KeyType.P2_BLOCK_MOVE_RIGHT), KeyEvent.VK_G);

        assertEquals(keyConfigController.getKeyEvent(keyConfig, KeyType.P2_BLOCK_ROTATE), KeyEvent.VK_T);
        keyConfigController.setKeyConfig(keyConfig, KeyType.P2_BLOCK_ROTATE, KeyEvent.VK_Q);
        assertEquals(keyConfigController.getKeyEvent(keyConfig, KeyType.P2_BLOCK_ROTATE), KeyEvent.VK_Q);

    }

    @Test
    void getCurrentConfig() {
        KeyConfigController keyConfigController = KeyConfigController.getInstance();
        KeyConfig keyConfig = keyConfigController.getDefault();

        assertEquals(keyConfigController.getKeyEvent(keyConfig, KeyType.P1_BLOCK_MOVE_DOWN), KeyEvent.VK_DOWN);
        keyConfigController.setKeyConfig(keyConfig, KeyType.P1_BLOCK_MOVE_DOWN, KeyEvent.VK_5);

        assertEquals(keyConfigController.getKeyEvent(keyConfig, KeyType.P1_BLOCK_MOVE_DOWN_AT_ONCE), KeyEvent.VK_UP);
        keyConfigController.setKeyConfig(keyConfig, KeyType.P1_BLOCK_MOVE_DOWN_AT_ONCE, KeyEvent.VK_8);

        assertEquals(keyConfigController.getKeyEvent(keyConfig, KeyType.P1_BLOCK_MOVE_LEFT), KeyEvent.VK_LEFT);
        keyConfigController.setKeyConfig(keyConfig, KeyType.P1_BLOCK_MOVE_LEFT, KeyEvent.VK_4);

        assertEquals(keyConfigController.getKeyEvent(keyConfig, KeyType.P1_BLOCK_MOVE_RIGHT), KeyEvent.VK_RIGHT);
        keyConfigController.setKeyConfig(keyConfig, KeyType.P1_BLOCK_MOVE_RIGHT, KeyEvent.VK_6);

        assertEquals(keyConfigController.getKeyEvent(keyConfig, KeyType.P1_BLOCK_ROTATE), KeyEvent.VK_L);
        keyConfigController.setKeyConfig(keyConfig, KeyType.P1_BLOCK_ROTATE, KeyEvent.VK_P);

        assertEquals(keyConfigController.getKeyEvent(keyConfig, KeyType.P2_BLOCK_MOVE_DOWN), KeyEvent.VK_S);
        keyConfigController.setKeyConfig(keyConfig, KeyType.P2_BLOCK_MOVE_DOWN, KeyEvent.VK_F);

        assertEquals(keyConfigController.getKeyEvent(keyConfig, KeyType.P2_BLOCK_MOVE_DOWN_AT_ONCE), KeyEvent.VK_W);
        keyConfigController.setKeyConfig(keyConfig, KeyType.P2_BLOCK_MOVE_DOWN_AT_ONCE, KeyEvent.VK_R);

        assertEquals(keyConfigController.getKeyEvent(keyConfig, KeyType.P2_BLOCK_MOVE_LEFT), KeyEvent.VK_A);
        keyConfigController.setKeyConfig(keyConfig, KeyType.P2_BLOCK_MOVE_LEFT, KeyEvent.VK_D);

        assertEquals(keyConfigController.getKeyEvent(keyConfig, KeyType.P2_BLOCK_MOVE_RIGHT), KeyEvent.VK_D);
        keyConfigController.setKeyConfig(keyConfig, KeyType.P2_BLOCK_MOVE_RIGHT, KeyEvent.VK_G);

        assertEquals(keyConfigController.getKeyEvent(keyConfig, KeyType.P2_BLOCK_ROTATE), KeyEvent.VK_T);
        keyConfigController.setKeyConfig(keyConfig, KeyType.P2_BLOCK_ROTATE, KeyEvent.VK_Q);

        
        keyConfigController.update(keyConfig);
        KeyConfig actual = keyConfigController.getCurrentConfig();
        assertEquals(actual.get(KeyType.P1_BLOCK_MOVE_DOWN), keyConfig.get(KeyType.P1_BLOCK_MOVE_DOWN));
        assertEquals(actual.get(KeyType.P1_BLOCK_MOVE_DOWN_AT_ONCE), keyConfig.get(KeyType.P1_BLOCK_MOVE_DOWN_AT_ONCE));
        assertEquals(actual.get(KeyType.P1_BLOCK_MOVE_LEFT), keyConfig.get(KeyType.P1_BLOCK_MOVE_LEFT));
        assertEquals(actual.get(KeyType.P1_BLOCK_MOVE_RIGHT), keyConfig.get(KeyType.P1_BLOCK_MOVE_RIGHT));
        assertEquals(actual.get(KeyType.P1_BLOCK_ROTATE), keyConfig.get(KeyType.P1_BLOCK_ROTATE));
        assertEquals(actual.get(KeyType.P2_BLOCK_MOVE_DOWN), keyConfig.get(KeyType.P2_BLOCK_MOVE_DOWN));
        assertEquals(actual.get(KeyType.P2_BLOCK_MOVE_DOWN_AT_ONCE), keyConfig.get(KeyType.P2_BLOCK_MOVE_DOWN_AT_ONCE));
        assertEquals(actual.get(KeyType.P2_BLOCK_MOVE_LEFT), keyConfig.get(KeyType.P2_BLOCK_MOVE_LEFT));
        assertEquals(actual.get(KeyType.P2_BLOCK_MOVE_RIGHT), keyConfig.get(KeyType.P2_BLOCK_MOVE_RIGHT));
        assertEquals(actual.get(KeyType.P2_BLOCK_ROTATE), keyConfig.get(KeyType.P2_BLOCK_ROTATE));
    }

    @Test
    void update() {
        KeyConfigController keyConfigController = KeyConfigController.getInstance();
        KeyConfig keyConfig = keyConfigController.getDefault();

        assertEquals(keyConfigController.getKeyEvent(keyConfig, KeyType.P1_BLOCK_MOVE_DOWN), KeyEvent.VK_DOWN);
        keyConfigController.setKeyConfig(keyConfig, KeyType.P1_BLOCK_MOVE_DOWN, KeyEvent.VK_5);

        assertEquals(keyConfigController.getKeyEvent(keyConfig, KeyType.P1_BLOCK_MOVE_DOWN_AT_ONCE), KeyEvent.VK_UP);
        keyConfigController.setKeyConfig(keyConfig, KeyType.P1_BLOCK_MOVE_DOWN_AT_ONCE, KeyEvent.VK_8);

        assertEquals(keyConfigController.getKeyEvent(keyConfig, KeyType.P1_BLOCK_MOVE_LEFT), KeyEvent.VK_LEFT);
        keyConfigController.setKeyConfig(keyConfig, KeyType.P1_BLOCK_MOVE_LEFT, KeyEvent.VK_4);

        assertEquals(keyConfigController.getKeyEvent(keyConfig, KeyType.P1_BLOCK_MOVE_RIGHT), KeyEvent.VK_RIGHT);
        keyConfigController.setKeyConfig(keyConfig, KeyType.P1_BLOCK_MOVE_RIGHT, KeyEvent.VK_6);

        assertEquals(keyConfigController.getKeyEvent(keyConfig, KeyType.P1_BLOCK_ROTATE), KeyEvent.VK_L);
        keyConfigController.setKeyConfig(keyConfig, KeyType.P1_BLOCK_ROTATE, KeyEvent.VK_P);

        assertEquals(keyConfigController.getKeyEvent(keyConfig, KeyType.P2_BLOCK_MOVE_DOWN), KeyEvent.VK_S);
        keyConfigController.setKeyConfig(keyConfig, KeyType.P2_BLOCK_MOVE_DOWN, KeyEvent.VK_F);

        assertEquals(keyConfigController.getKeyEvent(keyConfig, KeyType.P2_BLOCK_MOVE_DOWN_AT_ONCE), KeyEvent.VK_W);
        keyConfigController.setKeyConfig(keyConfig, KeyType.P2_BLOCK_MOVE_DOWN_AT_ONCE, KeyEvent.VK_R);

        assertEquals(keyConfigController.getKeyEvent(keyConfig, KeyType.P2_BLOCK_MOVE_LEFT), KeyEvent.VK_A);
        keyConfigController.setKeyConfig(keyConfig, KeyType.P2_BLOCK_MOVE_LEFT, KeyEvent.VK_D);

        assertEquals(keyConfigController.getKeyEvent(keyConfig, KeyType.P2_BLOCK_MOVE_RIGHT), KeyEvent.VK_D);
        keyConfigController.setKeyConfig(keyConfig, KeyType.P2_BLOCK_MOVE_RIGHT, KeyEvent.VK_G);

        assertEquals(keyConfigController.getKeyEvent(keyConfig, KeyType.P2_BLOCK_ROTATE), KeyEvent.VK_T);
        keyConfigController.setKeyConfig(keyConfig, KeyType.P2_BLOCK_ROTATE, KeyEvent.VK_Q);

        
        keyConfigController.update(keyConfig);
        KeyConfig actual = keyConfigController.getCurrentConfig();
        assertEquals(actual.get(KeyType.P1_BLOCK_MOVE_DOWN), keyConfig.get(KeyType.P1_BLOCK_MOVE_DOWN));
        assertEquals(actual.get(KeyType.P1_BLOCK_MOVE_DOWN_AT_ONCE), keyConfig.get(KeyType.P1_BLOCK_MOVE_DOWN_AT_ONCE));
        assertEquals(actual.get(KeyType.P1_BLOCK_MOVE_LEFT), keyConfig.get(KeyType.P1_BLOCK_MOVE_LEFT));
        assertEquals(actual.get(KeyType.P1_BLOCK_MOVE_RIGHT), keyConfig.get(KeyType.P1_BLOCK_MOVE_RIGHT));
        assertEquals(actual.get(KeyType.P1_BLOCK_ROTATE), keyConfig.get(KeyType.P1_BLOCK_ROTATE));
        assertEquals(actual.get(KeyType.P2_BLOCK_MOVE_DOWN), keyConfig.get(KeyType.P2_BLOCK_MOVE_DOWN));
        assertEquals(actual.get(KeyType.P2_BLOCK_MOVE_DOWN_AT_ONCE), keyConfig.get(KeyType.P2_BLOCK_MOVE_DOWN_AT_ONCE));
        assertEquals(actual.get(KeyType.P2_BLOCK_MOVE_LEFT), keyConfig.get(KeyType.P2_BLOCK_MOVE_LEFT));
        assertEquals(actual.get(KeyType.P2_BLOCK_MOVE_RIGHT), keyConfig.get(KeyType.P2_BLOCK_MOVE_RIGHT));
        assertEquals(actual.get(KeyType.P2_BLOCK_ROTATE), keyConfig.get(KeyType.P2_BLOCK_ROTATE));
    }
}