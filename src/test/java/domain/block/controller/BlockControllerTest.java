package domain.block.controller;

import org.junit.jupiter.api.Test;

import domain.block.entity.Block;
import domain.block.entity.itemBlock.BombItem;
import domain.block.entity.itemBlock.BonusScoreItem;
import domain.block.entity.itemBlock.DrillItem;
import domain.block.entity.itemBlock.LineRemoverItem;
import domain.block.entity.itemBlock.WeightItem;
import domain.block.entity.tetromino.IBlock;
import domain.block.entity.tetromino.JBlock;
import domain.block.entity.tetromino.LBlock;
import domain.block.entity.tetromino.OBlock;
import domain.block.entity.tetromino.TBlock;
import domain.board.entity.Board;
import global.matrix.IntMatrixUtil;

import static org.junit.jupiter.api.Assertions.*;
class BlockControllerTest {

    @Test
    void getRandomBlock() {
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

            Block value = getRandomItem();

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
    void getBlockColor() {
        assertTrue(blockColorConfig.getiBlockColor(), 0x00ffff);
        assertTrue(blockColorConfig.getjBlockColor(), 0x0000ff);
        assertTrue(blockColorConfig.getlBlockColor(), 0xff7f00);
        assertTrue(blockColorConfig.getoBlockColor(), 0xffff00);
        assertTrue(blockColorConfig.getsBlockColor(), 0x00ff00);
        assertTrue(blockColorConfig.gettBlockColor(), 0x800080);
        assertTrue(blockColorConfig.getzBlockColor(), 0xff0000);
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

            Block value = getRandomItem();

            if(value instanceof BombItem){
                Bombcnt++;
            }else if(value instanceof BonusScoreItem){
                Bonuscnt++;
            }else if(value instanceof DrillItem){
                Drillcnt++;
            }else if(value instanceof LineRemoverItem){
                Linecnt++;
            }else if(value instanceof WeightItem){
                Weightcnt++;
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
        Block value = getLineRemoverItem();

        int[][] shape = value.getShape();
        boolean res = false;

        for(int x=0;x<shape.length;x++){
            for(int y=0;j<shape[x].length;y++){
                if(shpe[x][y] = Board.TYPE_LINE_REMOVER){
                    res = true;
                }
            }
        }
        assertTrue(res);
    }
}