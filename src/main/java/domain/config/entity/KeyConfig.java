package domain.config.entity;

import java.util.EnumMap;

import domain.config.constant.key.KeyType;

import java.awt.event.KeyEvent;

public class KeyConfig {

    private static int P1_DEFAULT_BLOCK_ROTATE = KeyEvent.VK_L;
    private static int P1_DEFAULT_BLOCK_MOVE_DOWN = KeyEvent.VK_DOWN;
    private static int P1_DEFAULT_BLOCK_MOVE_DOWN_AT_ONCE = KeyEvent.VK_UP;
    private static int P1_DEFAULT_BLOCK_MOVE_LEFT = KeyEvent.VK_LEFT;
    private static int P1_DEFAULT_BLOCK_MOVE_RIGHT = KeyEvent.VK_RIGHT;

    private static int P2_DEFAULT_BLOCK_ROTATE = KeyEvent.VK_T;
    private static int P2_DEFAULT_BLOCK_MOVE_DOWN = KeyEvent.VK_S;
    private static int P2_DEFAULT_BLOCK_MOVE_DOWN_AT_ONCE = KeyEvent.VK_W;
    private static int P2_DEFAULT_BLOCK_MOVE_LEFT = KeyEvent.VK_A;
    private static int P2_DEFAULT_BLOCK_MOVE_RIGHT = KeyEvent.VK_D;

    
    private EnumMap<KeyType, Integer> keyMap;


    public KeyConfig(EnumMap<KeyType, Integer> keyMap) {
        this.keyMap = keyMap;
    }

    public KeyConfig() {
        initDefaultKeyMap();
    }


    private EnumMap<KeyType, Integer> initDefaultKeyMap() {
        keyMap = new EnumMap<>(KeyType.class);

        setDefaultPlayerOneKey();
        setDefaultPlayerTwoKey();

        return keyMap;
    }
    
    private void setDefaultPlayerOneKey() {
            keyMap.put(KeyType.P1_BLOCK_ROTATE, P1_DEFAULT_BLOCK_ROTATE);
            keyMap.put(KeyType.P1_BLOCK_MOVE_DOWN, P1_DEFAULT_BLOCK_MOVE_DOWN);
            keyMap.put(KeyType.P1_BLOCK_MOVE_DOWN_AT_ONCE, P1_DEFAULT_BLOCK_MOVE_DOWN_AT_ONCE);
            keyMap.put(KeyType.P1_BLOCK_MOVE_LEFT, P1_DEFAULT_BLOCK_MOVE_LEFT);
            keyMap.put(KeyType.P1_BLOCK_MOVE_RIGHT, P1_DEFAULT_BLOCK_MOVE_RIGHT);
    }

    private void setDefaultPlayerTwoKey() {
        keyMap.put(KeyType.P2_BLOCK_ROTATE, P2_DEFAULT_BLOCK_ROTATE);
        keyMap.put(KeyType.P2_BLOCK_MOVE_DOWN, P2_DEFAULT_BLOCK_MOVE_DOWN);
        keyMap.put(KeyType.P2_BLOCK_MOVE_DOWN_AT_ONCE, P2_DEFAULT_BLOCK_MOVE_DOWN_AT_ONCE);
        keyMap.put(KeyType.P2_BLOCK_MOVE_LEFT, P2_DEFAULT_BLOCK_MOVE_LEFT);
        keyMap.put(KeyType.P2_BLOCK_MOVE_RIGHT, P2_DEFAULT_BLOCK_MOVE_RIGHT);
    }

    public int get(KeyType key) {
        return keyMap.get(key);
    }

    public void put(KeyType key, int value) {
        keyMap.put(key, value);
    }

    public EnumMap<KeyType, Integer> getKeyMap() {
        return keyMap;
    }

    public void setKeyMap(EnumMap<KeyType, Integer> keyMap) {
        this.keyMap = keyMap;
    }
}
