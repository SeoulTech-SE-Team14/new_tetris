package domain.config.controller;

import org.junit.jupiter.api.Test;

import domain.config.constant.blockColor.ProtanopiaBlockColor;
import domain.config.constant.blockColor.TritanopiaBlockColor;
import domain.config.entity.BlockColorConfig;

import static org.junit.jupiter.api.Assertions.*;

class BlockColorConfigControllerTest {

    @Test
    void getDefault() {
        BlockColorConfig blockColorConfig = BlockColorConfigController.getInstance().getDefault;
        assertTrue(blockColorConfig.getiBlockColor(), 0x00ffff);
        assertTrue(blockColorConfig.getjBlockColor(), 0x0000ff);
        assertTrue(blockColorConfig.getlBlockColor(), 0xff7f00);
        assertTrue(blockColorConfig.getoBlockColor(), 0xffff00);
        assertTrue(blockColorConfig.getsBlockColor(), 0x00ff00);
        assertTrue(blockColorConfig.gettBlockColor(), 0x800080);
        assertTrue(blockColorConfig.getzBlockColor(), 0xff0000);
    }

    @Test
    void getProtanopia() {
        BlockColorConfig blockColorConfig = BlockColorConfigController.getInstance().getDefault;
        assertTrue(blockColorConfig.getiBlockColor(), ProtanopiaBlockColor.IBlock.getColor());
        assertTrue(blockColorConfig.getjBlockColor(), ProtanopiaBlockColor.JBlock.getColor());
        assertTrue(blockColorConfig.getlBlockColor(), ProtanopiaBlockColor.LBlock.getColor());
        assertTrue(blockColorConfig.getoBlockColor(), ProtanopiaBlockColor.OBlock.getColor());
        assertTrue(blockColorConfig.getsBlockColor(), ProtanopiaBlockColor.SBlock.getColor());
        assertTrue(blockColorConfig.gettBlockColor(), ProtanopiaBlockColor.TBlock.getColor());
        assertTrue(blockColorConfig.getzBlockColor(), ProtanopiaBlockColor.ZBlock.getColor());
    }

    @Test
    void getTritanopia() {
        BlockColorConfig blockColorConfig = BlockColorConfigController.getInstance().getDefault;
        assertTrue(blockColorConfig.getiBlockColor(), TritanopiaBlockColor.IBlock.getColor());
        assertTrue(blockColorConfig.getjBlockColor(), TritanopiaBlockColor.JBlock.getColor());
        assertTrue(blockColorConfig.getlBlockColor(), TritanopiaBlockColor.LBlock.getColor());
        assertTrue(blockColorConfig.getoBlockColor(), TritanopiaBlockColor.OBlock.getColor());
        assertTrue(blockColorConfig.getsBlockColor(), TritanopiaBlockColor.SBlock.getColor());
        assertTrue(blockColorConfig.gettBlockColor(), TritanopiaBlockColor.TBlock.getColor());
        assertTrue(blockColorConfig.getzBlockColor(), TritanopiaBlockColor.ZBlock.getColor());
    }

    @Test
    void getCurrentConfig() {
        BlockColorConfig blockColorConfig = BlockColorConfigController.getInstance();
        BlockColorConfig value = blockColorConfig.getCurrentConfig();
        assertTrue(blockColorConfig.getiBlockColor(), value.getiBlockColor());
        assertTrue(blockColorConfig.getiBlockColor(), value.getjBlockColor());
        assertTrue(blockColorConfig.getiBlockColor(), value.getlBlockColor());
        assertTrue(blockColorConfig.getiBlockColor(), value.getoBlockColor());
        assertTrue(blockColorConfig.getiBlockColor(), value.getsBlockColor());
        assertTrue(blockColorConfig.getiBlockColor(), value.gettBlockColor());
        assertTrue(blockColorConfig.getiBlockColor(), value.getzBlockColor());
        value = blockColorConfig.getCurrentConfig();
        getProtanopia();
        assertTrue(blockColorConfig.getiBlockColor(), value.getiBlockColor());
        assertTrue(blockColorConfig.getiBlockColor(), value.getjBlockColor());
        assertTrue(blockColorConfig.getiBlockColor(), value.getlBlockColor());
        assertTrue(blockColorConfig.getiBlockColor(), value.getoBlockColor());
        assertTrue(blockColorConfig.getiBlockColor(), value.getsBlockColor());
        assertTrue(blockColorConfig.getiBlockColor(), value.gettBlockColor());
        assertTrue(blockColorConfig.getiBlockColor(), value.getzBlockColor());

    }

    @Test
    void update() {
        BlockColorConfig blockColorConfig = BlockColorConfigController.getInstance();
        BlockColorConfig value = blockColorConfig.getCurrentConfig();
        assertTrue(blockColorConfig.getiBlockColor(), value.getiBlockColor());
        assertTrue(blockColorConfig.getiBlockColor(), value.getjBlockColor());
        assertTrue(blockColorConfig.getiBlockColor(), value.getlBlockColor());
        assertTrue(blockColorConfig.getiBlockColor(), value.getoBlockColor());
        assertTrue(blockColorConfig.getiBlockColor(), value.getsBlockColor());
        assertTrue(blockColorConfig.getiBlockColor(), value.gettBlockColor());
        assertTrue(blockColorConfig.getiBlockColor(), value.getzBlockColor());
        value = blockColorConfig.getCurrentConfig();
        getProtanopia();
        assertTrue(blockColorConfig.getiBlockColor(), value.getiBlockColor());
        assertTrue(blockColorConfig.getiBlockColor(), value.getjBlockColor());
        assertTrue(blockColorConfig.getiBlockColor(), value.getlBlockColor());
        assertTrue(blockColorConfig.getiBlockColor(), value.getoBlockColor());
        assertTrue(blockColorConfig.getiBlockColor(), value.getsBlockColor());
        assertTrue(blockColorConfig.getiBlockColor(), value.gettBlockColor());
        assertTrue(blockColorConfig.getiBlockColor(), value.getzBlockColor());

    }
}