package view.keyListener.game.single;

import domain.block.entity.tetromino.TBlock;
import domain.config.constant.key.KeyType;
import domain.config.controller.KeyConfigController;
import domain.config.entity.KeyConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.frame.game.GameFrame;

import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class SingleGameKeyListenerTest {
    GameFrame gameFrame;
    SingleGameKeyListener listener;
    @Test
    @DisplayName("1초에 몇 번 움직임이 그려지는지 테스트")
    void keyPressed() throws  InterruptedException {
        KeyConfigController.getInstance().update(KeyConfigController.getInstance().getDefault());
        gameFrame = new GameFrame();
        listener = new SingleGameKeyListener(gameFrame);
        gameFrame.addKeyListener(listener);
        KeyEvent keyRight = new KeyEvent(gameFrame, KeyEvent.KEY_PRESSED, System
                .currentTimeMillis(), 0, KeyEvent.VK_RIGHT, 'a');
        KeyEvent keyLeft = new KeyEvent(gameFrame, KeyEvent.KEY_PRESSED, System
                .currentTimeMillis(), 0, KeyEvent.VK_LEFT, 'a');
        KeyEvent keyDown = new KeyEvent(gameFrame, KeyEvent.KEY_PRESSED, System
                .currentTimeMillis(), 0, KeyEvent.VK_DOWN, 'a');

        gameFrame.getGamePanel().getBoardPanel().updateNowBlock(new TBlock());
        int count = 0;
        // 화면 중간으로 옮기기.
        for(int i = 0; i < 5; i++) {
            listener.keyPressed(keyDown);
        }
        // 블럭 초기 위치
        int x = gameFrame.getGamePanel().getBoardPanel().getBoard().getCurX();
        int y = gameFrame.getGamePanel().getBoardPanel().getBoard().getCurY();

        long beforeTime = System.currentTimeMillis();
        // 아래로 한 칸 내려가기 전까지
        while (x == gameFrame.getGamePanel().getBoardPanel().getBoard().getCurX()) {
            // 1초가 넘어가면 끝.
            if((System.currentTimeMillis() - beforeTime) > 1000) break;
            // 오른쪽으로 옮기기
            if((count & 1) == 0){
                listener.keyPressed(keyRight);
                if(y + 1 != gameFrame.getGamePanel().getBoardPanel().getBoard().getCurY()) break;
                //assertEquals(y + 1, gameFrame.getGamePanel().getBoardPanel().getBoard().getCurY());
            }
           else {
                // 왼쪽으로 다시 옮기기
                listener.keyPressed(keyLeft);
                if(y != gameFrame.getGamePanel().getBoardPanel().getBoard().getCurY()) break;
                //assertEquals(y, gameFrame.getGamePanel().getBoardPanel().getBoard().getCurY());
            }
            count++;
            // 10ms 마다 한번 식 실행되도록 했음
            // busy waiting이 발생 할지도 모르지만 일단 되니까..
            TimeUnit.MILLISECONDS.sleep(10);
        }
        System.out.println(count);
        assertTrue(count >= 5);
    }

}