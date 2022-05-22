package view.frame.game.multi;

import org.junit.jupiter.api.Test;
import view.abstractComponent.frame.ButtonMoveFrame;

import static org.junit.jupiter.api.Assertions.*;

class MultiGamePauseFrameTest {
    @Test
    void MultiGamePauseFrame(){
        MultiGamePauseFrame frame = new MultiGamePauseFrame(new MultiGameFrame());
        assertTrue(frame instanceof ButtonMoveFrame);
    }
}