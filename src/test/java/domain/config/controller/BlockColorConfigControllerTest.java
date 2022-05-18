package domain.config.controller;

import org.junit.jupiter.api.Test;

import domain.config.constant.blockColor.ProtanopiaBlockColor;
import domain.config.constant.blockColor.TritanopiaBlockColor;
import domain.config.entity.BlockColorConfig;

import static org.junit.jupiter.api.Assertions.*;

class BlockColorConfigControllerTest {

    @Test
    void getDefault() {
        BlockColorConfig blockColorConfig = BlockColorConfigController.getInstance().getDefault();
        assertEquals(0x00ffff, blockColorConfig.getiBlockColor());
        assertEquals(0x0000ff, blockColorConfig.getjBlockColor());
        assertEquals(0xff7f00, blockColorConfig.getlBlockColor());
        assertEquals(0xffff00, blockColorConfig.getoBlockColor());
        assertEquals(0x00ff00, blockColorConfig.getsBlockColor());
        assertEquals(0x800080, blockColorConfig.gettBlockColor());
        assertEquals(0xff0000, blockColorConfig.getzBlockColor());
    }

    @Test
    void getProtanopia() {
        BlockColorConfig blockColorConfig = BlockColorConfigController.getInstance().getProtanopia();
        assertEquals(ProtanopiaBlockColor.IBLOCK.getColor(), blockColorConfig.getiBlockColor());
        assertEquals(ProtanopiaBlockColor.JBLOCK.getColor(), blockColorConfig.getjBlockColor());
        assertEquals(ProtanopiaBlockColor.LBLOCK.getColor(), blockColorConfig.getlBlockColor());
        assertEquals(ProtanopiaBlockColor.OBLOCK.getColor(), blockColorConfig.getoBlockColor());
        assertEquals(ProtanopiaBlockColor.SBLOCK.getColor(), blockColorConfig.getsBlockColor());
        assertEquals(ProtanopiaBlockColor.TBLOCK.getColor(), blockColorConfig.gettBlockColor());
        assertEquals(ProtanopiaBlockColor.ZBLOCK.getColor(), blockColorConfig.getzBlockColor());
    }

    @Test
    void getTritanopia() {
        BlockColorConfig blockColorConfig = BlockColorConfigController.getInstance().getTritanopia();
        assertEquals(TritanopiaBlockColor.IBLOCK.getColor(), blockColorConfig.getiBlockColor());
        assertEquals(TritanopiaBlockColor.JBLOCK.getColor(), blockColorConfig.getjBlockColor());
        assertEquals(TritanopiaBlockColor.LBLOCK.getColor(), blockColorConfig.getlBlockColor());
        assertEquals(TritanopiaBlockColor.OBLOCK.getColor(), blockColorConfig.getoBlockColor());
        assertEquals(TritanopiaBlockColor.SBLOCK.getColor(), blockColorConfig.getsBlockColor());
        assertEquals(TritanopiaBlockColor.TBLOCK.getColor(), blockColorConfig.gettBlockColor());
        assertEquals(TritanopiaBlockColor.ZBLOCK.getColor(), blockColorConfig.getzBlockColor());
    }

    @Test
    void getCurrentConfig() {

//        BlockColorConfigController blockColorConfig = BlockColorConfigController.getInstance();
//        BlockColorConfig value = blockColorConfig.getCurrentConfig();
//        assertEquals(value.getiBlockColor(), blockColorConfig.getiBlockColor());
//        assertEquals(value.getjBlockColor(), blockColorConfig.getiBlockColor());
//        assertEquals(value.getlBlockColor(), blockColorConfig.getiBlockColor());
//        assertEquals(value.getoBlockColor(), blockColorConfig.getiBlockColor());
//        assertEquals(value.getsBlockColor(), blockColorConfig.getiBlockColor());
//        assertEquals(value.gettBlockColor(), blockColorConfig.getiBlockColor());
//        assertEquals(value.getzBlockColor(), blockColorConfig.getiBlockColor());
//        value = blockColorConfig.getCurrentConfig();
//        getProtanopia();
//        assertEquals(value.getiBlockColor(), blockColorConfig.getiBlockColor());
//        assertEquals(value.getjBlockColor(), blockColorConfig.getiBlockColor());
//        assertEquals(value.getlBlockColor(), blockColorConfig.getiBlockColor());
//        assertEquals(value.getoBlockColor(), blockColorConfig.getiBlockColor());
//        assertEquals(value.getsBlockColor(), blockColorConfig.getiBlockColor());
//        assertEquals(value.gettBlockColor(), blockColorConfig.getiBlockColor());
//        assertEquals(value.getzBlockColor(), blockColorConfig.getiBlockColor());

    }

    @Test
    void update() {
//        BlockColorConfig blockColorConfig = BlockColorConfigController.getInstance();
//        BlockColorConfig value = blockColorConfig.getCurrentConfig();
//        assertEquals(value.getiBlockColor(), blockColorConfig.getiBlockColor());
//        assertEquals(value.getjBlockColor(), blockColorConfig.getiBlockColor());
//        assertEquals(value.getlBlockColor(), blockColorConfig.getiBlockColor());
//        assertEquals(value.getoBlockColor(), blockColorConfig.getiBlockColor());
//        assertEquals(value.getsBlockColor(), blockColorConfig.getiBlockColor());
//        assertEquals(value.gettBlockColor(), blockColorConfig.getiBlockColor());
//        assertEquals(value.getzBlockColor(), blockColorConfig.getiBlockColor());
//        value = blockColorConfig.getCurrentConfig();
//        getProtanopia();
//        assertEquals(value.getiBlockColor(), blockColorConfig.getiBlockColor());
//        assertEquals(value.getjBlockColor(), blockColorConfig.getiBlockColor());
//        assertEquals(value.getlBlockColor(), blockColorConfig.getiBlockColor());
//        assertEquals(value.getoBlockColor(), blockColorConfig.getiBlockColor());
//        assertEquals(value.getsBlockColor(), blockColorConfig.getiBlockColor());
//        assertEquals(value.gettBlockColor(), blockColorConfig.getiBlockColor());
//        assertEquals(value.getzBlockColor(), blockColorConfig.getiBlockColor());
    }
}