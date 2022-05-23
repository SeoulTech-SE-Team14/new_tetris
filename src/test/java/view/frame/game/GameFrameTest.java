package view.frame.game;

import org.junit.jupiter.api.Test;
import view.abstractComponent.frame.DefaultFrame;

import static org.junit.jupiter.api.Assertions.*;

class GameFrameTest {
    @Test
    void GameFrameTest(){
        GameFrame frame = new GameFrame();
        assertTrue(frame instanceof DefaultFrame);
    }

}