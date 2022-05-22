package view.keyListener.config;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.abstractComponent.panel.config.ConfigPanel;
import view.frame.config.ConfigFrame;

import java.awt.*;
import java.awt.event.KeyEvent;

import static org.junit.jupiter.api.Assertions.*;

class ConfigKeyListenerTest {
    ConfigKeyListener listener;
    ConfigFrame frame;

    @Test
    @DisplayName("아래 키 테스트")
    void keyPressed() {
        frame = new ConfigFrame();
        listener = new ConfigKeyListener(frame);
        frame.addKeyListener(listener);
        KeyEvent key = new KeyEvent(frame, KeyEvent.KEY_PRESSED, System
                .currentTimeMillis(), 0, KeyEvent.VK_DOWN, 'a');
        listener.keyPressed(key);
        listener.keyPressed(key);
        listener.keyPressed(key);
        assertEquals(3, frame.getFocusIndex());
    }
    @Test
    @DisplayName("위 키 테스트")
    void keyPressed1() {
        frame = new ConfigFrame();
        listener = new ConfigKeyListener(frame);
        frame.addKeyListener(listener);
        KeyEvent key = new KeyEvent(frame, KeyEvent.KEY_PRESSED, System
                .currentTimeMillis(), 0, KeyEvent.VK_UP, 'a');
        listener.keyPressed(key);
        listener.keyPressed(key);
        assertEquals(4, frame.getFocusIndex());
    }
    @Test
    @DisplayName("왼쪽 키 테스트")
    void keyPressed2() {
        frame = new ConfigFrame();
        listener = new ConfigKeyListener(frame);
        frame.addKeyListener(listener);
        KeyEvent key = new KeyEvent(frame, KeyEvent.KEY_PRESSED, System
                .currentTimeMillis(), 0, KeyEvent.VK_LEFT, 'a');
        listener.keyPressed(key);
        ConfigPanel[] configPanels = frame.getConfigPanels();
        assertEquals(2, configPanels[frame.getFocusIndex()].getFocusIndex());
    }
    @Test
    @DisplayName("오른쪽 키 테스트")
    void keyPressed3() {
        frame = new ConfigFrame();
        listener = new ConfigKeyListener(frame);
        frame.addKeyListener(listener);
        KeyEvent key = new KeyEvent(frame, KeyEvent.KEY_PRESSED, System
                .currentTimeMillis(), 0, KeyEvent.VK_RIGHT, 'a');
        listener.keyPressed(key);
        listener.keyPressed(key);
        ConfigPanel[] configPanels = frame.getConfigPanels();
        assertEquals(2, configPanels[frame.getFocusIndex()].getFocusIndex());
    }
}