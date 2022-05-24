package domain.block.controller;

import domain.block.entity.tetromino.*;
import domain.board.controller.BoardController;
import domain.config.controller.DifficultyConfigController;
import domain.config.entity.BlockColorConfig;
import domain.config.entity.DifficultyConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.block.entity.Block;
import domain.block.entity.itemBlock.BombItem;
import domain.block.entity.itemBlock.BonusScoreItem;
import domain.block.entity.itemBlock.DrillItem;
import domain.block.entity.itemBlock.LineRemoverItem;
import domain.block.entity.itemBlock.WeightItem;
import domain.board.entity.Board;
import global.matrix.IntMatrixUtil;

import static org.junit.jupiter.api.Assertions.*;
class BlockControllerTest {

    DifficultyConfig difficultyConfig;
    BlockColorConfig blockColorConfig;

    @BeforeEach
    void beforeEach() {
        difficultyConfig = new DifficultyConfig();
        blockColorConfig = new BlockColorConfig();
    }
    @Test
    @DisplayName("이지모드 블럭생성")
    void testGetEasyModeRandomBlock() {
        difficultyConfig = DifficultyConfigController.getInstance().getEasy();

        final int COUNT = 1000;
        
        int icnt = 0;
        int jcnt = 0;
        int lcnt = 0;
        int ocnt = 0;
        int scnt = 0;
        int tcnt = 0;
        int zcnt = 0;

        double percentage = (double)COUNT / 7;
        percentage-=3;
        double criteria = (double)COUNT / 100 * 5;

        for(int i=0;i<COUNT;i++){

            Block value = BlockController.getInstance().getRandomBlock(difficultyConfig);

            if(value instanceof IBlock){
                icnt++;
            }else if(value instanceof JBlock){
                jcnt++;
            }else if(value instanceof LBlock){
                lcnt++;
            }else if(value instanceof OBlock){
                ocnt++;
            }else if(value instanceof SBlock){
                scnt++;
            }else if(value instanceof TBlock){
                tcnt++;
            }else if(value instanceof ZBlock){
                zcnt++;
            }
        }
        assertTrue(Math.abs((double)icnt-percentage) * 0.8 <=criteria);
        assertTrue(Math.abs((double)jcnt-percentage)<=criteria);
        assertTrue(Math.abs((double)lcnt-percentage)<=criteria);
        assertTrue(Math.abs((double)ocnt-percentage)<=criteria);
        assertTrue(Math.abs((double)scnt-percentage)<=criteria);
        assertTrue(Math.abs((double)tcnt-percentage)<=criteria);
        assertTrue(Math.abs((double)zcnt-percentage)<=criteria);

    }
    @Test
    @DisplayName("일반모드 블럭생성")
    void testGetNormalModeRandomBlock() {
         difficultyConfig = DifficultyConfigController.getInstance().getNormal();
        
        final int COUNT = 1000;
        
        int icnt = 0;
        int jcnt = 0;
        int lcnt = 0;
        int ocnt = 0;
        int scnt = 0;
        int tcnt = 0;
        int zcnt = 0;

        double percentage = (double)COUNT / 7;
        double criteria = (double)COUNT / 100 * 5;

        for(int i=0;i<COUNT;i++){

            Block value = BlockController.getInstance().getRandomBlock(difficultyConfig);

            if(value instanceof IBlock){
                icnt++;
            }else if(value instanceof JBlock){
                jcnt++;
            }else if(value instanceof LBlock){
                lcnt++;
            }else if(value instanceof OBlock){
                ocnt++;
            }else if(value instanceof SBlock){
                scnt++;
            }else if(value instanceof TBlock){
                tcnt++;
            }else if(value instanceof ZBlock){
                zcnt++;
            }
        }
        assertTrue(Math.abs((double)icnt-percentage)<=criteria);
        assertTrue(Math.abs((double)jcnt-percentage)<=criteria);
        assertTrue(Math.abs((double)lcnt-percentage)<=criteria);
        assertTrue(Math.abs((double)ocnt-percentage)<=criteria);
        assertTrue(Math.abs((double)scnt-percentage)<=criteria);
        assertTrue(Math.abs((double)tcnt-percentage)<=criteria);
        assertTrue(Math.abs((double)zcnt-percentage)<=criteria);
    }
    @Test
    @DisplayName("하드모드 블럭생성")
    void testGetHardModeRandomBlock() {
        difficultyConfig = DifficultyConfigController.getInstance().getHard();
        
        final int COUNT = 1000;
        
        int icnt = 0;
        int jcnt = 0;
        int lcnt = 0;
        int ocnt = 0;
        int scnt = 0;
        int tcnt = 0;
        int zcnt = 0;

        double percentage = (double)COUNT / 7;
        percentage+=3;
        double criteria = (double)COUNT / 100 * 5;

        for(int i=0;i<COUNT;i++){

            Block value = BlockController.getInstance().getRandomBlock(difficultyConfig);

            if(value instanceof IBlock){
                icnt++;
            }else if(value instanceof JBlock){
                jcnt++;
            }else if(value instanceof LBlock){
                lcnt++;
            }else if(value instanceof OBlock){
                ocnt++;
            }else if(value instanceof SBlock){
                scnt++;
            }else if(value instanceof TBlock){
                tcnt++;
            }else if(value instanceof ZBlock){
                zcnt++;
            }
        }
        assertTrue(Math.abs((double)icnt-percentage)*1.2<=criteria);
        assertTrue(Math.abs((double)jcnt-percentage)<=criteria);
        assertTrue(Math.abs((double)lcnt-percentage)<=criteria);
        assertTrue(Math.abs((double)ocnt-percentage)<=criteria);
        assertTrue(Math.abs((double)scnt-percentage)<=criteria);
        assertTrue(Math.abs((double)tcnt-percentage)<=criteria);
        assertTrue(Math.abs((double)zcnt-percentage)<=criteria);
    }

    @Test
    void getBlockColor() {
        assertEquals(BlockController.getInstance().getBlockColor(new IBlock(), blockColorConfig), 0x00ffff);
        assertEquals(BlockController.getInstance().getBlockColor(new JBlock(), blockColorConfig), 0x0000ff);
        assertEquals(BlockController.getInstance().getBlockColor(new LBlock(), blockColorConfig), 0xff7f00);
        assertEquals(BlockController.getInstance().getBlockColor(new OBlock(), blockColorConfig), 0xffff00);
        assertEquals(BlockController.getInstance().getBlockColor(new SBlock(), blockColorConfig), 0x00ff00);
        assertEquals(BlockController.getInstance().getBlockColor(new TBlock(), blockColorConfig), 0x800080);
        assertEquals(BlockController.getInstance().getBlockColor(new ZBlock(), blockColorConfig), 0xff0000);
    }

    @Test
    void getRandomItem() {
        final int COUNT = 1000;
        
        int Bombcnt = 0;
        int Bonuscnt = 0;
        int Drillcnt = 0;
        int Linecnt = 0;
        int Weightcnt = 0;

        double percentage = (double)COUNT / 5;
        double criteria = (double)COUNT / 100 * 5;

        for(int i=0;i<COUNT;i++){

            Block value = BlockController.getInstance().getRandomItem(difficultyConfig);

            if(value instanceof BombItem){
                Bombcnt++;
            }else if(value instanceof BonusScoreItem){
                Bonuscnt++;
            }else if(value instanceof DrillItem){
                Drillcnt++;
            }else if(value instanceof WeightItem){
                Weightcnt++;
            }else{
                int[][] shape = value.getShape();
                boolean res = false;
                for(int x=0;x<shape.length;x++){
                    for(int y=0;y<shape[x].length;y++){
                        if(shape[x][y] == Board.TYPE_LINE_REMOVER){
                            res = true;
                        }
                    }
                }
                if(res)
                    Linecnt++;
            }
        }
        assertTrue(Math.abs((double)Bombcnt-percentage)<=criteria);
        assertTrue(Math.abs((double)Bonuscnt-percentage)<=criteria);
        assertTrue(Math.abs((double)Drillcnt-percentage)<=criteria);
        assertTrue(Math.abs((double)Linecnt-percentage)<=criteria);
        assertTrue(Math.abs((double)Weightcnt-percentage)<=criteria);
    }

    @Test
    void getLineRemoverItem() {
        Block value = BlockController.getInstance().getLineRemoverItem(difficultyConfig);

        int[][] shape = value.getShape();
        boolean res = false;

        for(int x=0;x<shape.length;x++){
            for(int y=0;y<shape[x].length;y++){
                if(shape[x][y] == Board.TYPE_LINE_REMOVER){
                    res = true;
                }
            }
        }
        assertTrue(res);
    }
}