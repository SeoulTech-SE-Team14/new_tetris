package view.frame.game;

import org.junit.jupiter.api.Test;
import view.abstractComponent.frame.ButtonMoveFrame;

import static org.junit.jupiter.api.Assertions.*;

class GamePauseFrameTest {
    @Test
    void GamePauseFrame(){
        GamePauseFrame frame = new GamePauseFrame(new GameFrame());
        assertTrue(frame instanceof ButtonMoveFrame);
    }
}