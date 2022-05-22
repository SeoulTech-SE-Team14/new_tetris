package view.frame.game;

import org.junit.jupiter.api.Test;
import view.abstractComponent.frame.ButtonMoveFrame;

import static org.junit.jupiter.api.Assertions.*;

class GameModeSelectFrameTest {
    @Test
    void GameModeSelectFrame(){
        GameModeSelectFrame frame = new GameModeSelectFrame();
        assertTrue(frame instanceof ButtonMoveFrame);
    }
}