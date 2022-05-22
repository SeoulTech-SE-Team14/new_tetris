package view.frame.score;

import domain.score.entity.Score;
import org.junit.jupiter.api.Test;
import view.abstractComponent.frame.DefaultFrame;

import static org.junit.Assert.assertTrue;

class ScoreUsernameInputFrameTest {
    @Test
    void ScoreUsernameInputFrame(){
        ScoreUsernameInputFrame frame = new ScoreUsernameInputFrame(new Score());
        assertTrue(frame instanceof DefaultFrame);
    }

}