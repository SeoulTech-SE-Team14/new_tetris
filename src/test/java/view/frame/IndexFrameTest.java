package view.frame;

import org.junit.jupiter.api.Test;
import view.abstractComponent.frame.ButtonMoveFrame;

import static org.junit.jupiter.api.Assertions.*;

class IndexFrameTest {
    @Test
    void IndexFrame(){
        IndexFrame frame = new IndexFrame();
        assertTrue(frame instanceof ButtonMoveFrame);
    }
}