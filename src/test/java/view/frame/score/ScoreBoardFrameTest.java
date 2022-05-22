package view.frame.score;

import org.junit.jupiter.api.Test;
import view.abstractComponent.frame.DefaultFrame;

import static org.junit.Assert.assertTrue;

class ScoreBoardFrameTest {
    @Test
    void ScoreBoardFrame(){
        ScoreBoardFrame frame = new ScoreBoardFrame();
        assertTrue(frame instanceof DefaultFrame);
    }
}