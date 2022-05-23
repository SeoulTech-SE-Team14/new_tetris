package view.keyListener.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.frame.game.GameFrame;
import view.frame.game.GameModeSelectFrame;
import view.frame.game.GamePauseFrame;

import java.awt.event.KeyEvent;

import static org.junit.jupiter.api.Assertions.*;

class GamePauseListenerTest {
    GamePauseFrame frame;
    GamePauseListener listener;
    GameFrame gameFrame;
    @Test
    @DisplayName("아래 키 테스트")
    void keyPressed() {
        gameFrame = new GameFrame();
        frame = new GamePauseFrame(gameFrame);
        listener = new GamePauseListener(frame, gameFrame);
        frame.addKeyListener(listener);
        KeyEvent key = new KeyEvent(frame, KeyEvent.KEY_PRESSED, System
                .currentTimeMillis(), 0, KeyEvent.VK_DOWN, 'a');
        listener.keyPressed(key);
        assertEquals(1, frame.getFocusIndex());
    }
    @Test
    @DisplayName("위 키 테스트")
    void keyPressed1() {
        gameFrame = new GameFrame();
        frame = new GamePauseFrame(gameFrame);
        listener = new GamePauseListener(frame, gameFrame);
        frame.addKeyListener(listener);
        KeyEvent key = new KeyEvent(frame, KeyEvent.KEY_PRESSED, System
                .currentTimeMillis(), 0, KeyEvent.VK_UP, 'a');
        listener.keyPressed(key);
        assertEquals(1, frame.getFocusIndex());
    }
}