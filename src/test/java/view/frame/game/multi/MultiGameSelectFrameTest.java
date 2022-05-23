package view.frame.game.multi;

import org.junit.jupiter.api.Test;
import view.abstractComponent.frame.ButtonMoveFrame;

import static org.junit.jupiter.api.Assertions.*;

class MultiGameSelectFrameTest {
    @Test
    void MultiGameSelectFrame(){
        MultiGameSelectFrame frame = new MultiGameSelectFrame();
        assertTrue(frame instanceof ButtonMoveFrame);
    }
}