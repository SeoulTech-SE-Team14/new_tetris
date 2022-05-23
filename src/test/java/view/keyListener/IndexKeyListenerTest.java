package view.keyListener;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.frame.IndexFrame;

import java.awt.event.KeyEvent;

import static org.junit.jupiter.api.Assertions.*;

class IndexKeyListenerTest {
    IndexKeyListener listener;
    IndexFrame frame;

    @Test
    @DisplayName("아래 키 테스트")
    void keyPressed() {
        frame = new IndexFrame();
        listener = new IndexKeyListener(frame);
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
        frame = new IndexFrame();
        listener = new IndexKeyListener(frame);
        frame.addKeyListener(listener);
        KeyEvent key = new KeyEvent(frame, KeyEvent.KEY_PRESSED, System
                .currentTimeMillis(), 0, KeyEvent.VK_UP, 'a');
        listener.keyPressed(key);
        listener.keyPressed(key);
        assertEquals(2, frame.getFocusIndex());
    }
}