package view.keyListener.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.frame.IndexFrame;
import view.frame.game.GameFrame;
import view.frame.game.GameModeSelectFrame;
import view.keyListener.IndexKeyListener;

import java.awt.event.KeyEvent;

import static org.junit.jupiter.api.Assertions.*;

class GameModeSelectListenerTest {
    GameModeSelectListener listener;
    GameModeSelectFrame frame;

    @Test
    @DisplayName("아래 키 테스트")
    void keyPressed() {
        frame = new GameModeSelectFrame();
        listener = new GameModeSelectListener(frame);
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
        frame = new GameModeSelectFrame();
        listener = new GameModeSelectListener(frame);
        frame.addKeyListener(listener);
        KeyEvent key = new KeyEvent(frame, KeyEvent.KEY_PRESSED, System
                .currentTimeMillis(), 0, KeyEvent.VK_UP, 'a');
        listener.keyPressed(key);
        listener.keyPressed(key);
        assertEquals(2, frame.getFocusIndex());
    }
}