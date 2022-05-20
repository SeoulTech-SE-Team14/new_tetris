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
        assertEquals(blockColorConfig.getiBlockColor(), 0x00ffff);
        assertEquals(blockColorConfig.getjBlockColor(), 0x0000ff);
        assertEquals(blockColorConfig.getlBlockColor(), 0xff7f00);
        assertEquals(blockColorConfig.getoBlockColor(), 0xffff00);
        assertEquals(blockColorConfig.getsBlockColor(), 0x00ff00);
        assertEquals(blockColorConfig.gettBlockColor(), 0x800080);
        assertEquals(blockColorConfig.getzBlockColor(), 0xff0000);
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

        BlockColorConfigController blockColorConfig = BlockColorConfigController.getInstance();
        BlockColorConfig value = blockColorConfig.getDefault();

        assertEquals(value.getiBlockColor(), 0x00ffff);
        assertEquals(value.getjBlockColor(), 0x0000ff);
        assertEquals(value.getlBlockColor(), 0xff7f00);
        assertEquals(value.getoBlockColor(), 0xffff00);
        assertEquals(value.getsBlockColor(), 0x00ff00);
        assertEquals(value.gettBlockColor(), 0x800080);
        assertEquals(value.getzBlockColor(), 0xff0000);

        blockColorConfig.update(blockColorConfig.getProtanopia());
        value = blockColorConfig.getCurrentConfig();

        assertEquals(value.getiBlockColor(), ProtanopiaBlockColor.IBLOCK.getColor());
        assertEquals(value.getjBlockColor(), ProtanopiaBlockColor.JBLOCK.getColor());
        assertEquals(value.getlBlockColor(), ProtanopiaBlockColor.LBLOCK.getColor());
        assertEquals(value.getoBlockColor(), ProtanopiaBlockColor.OBLOCK.getColor());
        assertEquals(value.getsBlockColor(), ProtanopiaBlockColor.SBLOCK.getColor());
        assertEquals(value.gettBlockColor(), ProtanopiaBlockColor.TBLOCK.getColor());
        assertEquals(value.getzBlockColor(), ProtanopiaBlockColor.ZBLOCK.getColor());

    }

    @Test
    void update() {

        BlockColorConfigController blockColorConfig = BlockColorConfigController.getInstance();
        BlockColorConfig value = blockColorConfig.getDefault();

        assertEquals(value.getiBlockColor(), 0x00ffff);
        assertEquals(value.getjBlockColor(), 0x0000ff);
        assertEquals(value.getlBlockColor(), 0xff7f00);
        assertEquals(value.getoBlockColor(), 0xffff00);
        assertEquals(value.getsBlockColor(), 0x00ff00);
        assertEquals(value.gettBlockColor(), 0x800080);
        assertEquals(value.getzBlockColor(), 0xff0000);

        blockColorConfig.update(blockColorConfig.getProtanopia());
        value = blockColorConfig.getCurrentConfig();

        assertEquals(value.getiBlockColor(), ProtanopiaBlockColor.IBLOCK.getColor());
        assertEquals(value.getjBlockColor(), ProtanopiaBlockColor.JBLOCK.getColor());
        assertEquals(value.getlBlockColor(), ProtanopiaBlockColor.LBLOCK.getColor());
        assertEquals(value.getoBlockColor(), ProtanopiaBlockColor.OBLOCK.getColor());
        assertEquals(value.getsBlockColor(), ProtanopiaBlockColor.SBLOCK.getColor());
        assertEquals(value.gettBlockColor(), ProtanopiaBlockColor.TBLOCK.getColor());
        assertEquals(value.getzBlockColor(), ProtanopiaBlockColor.ZBLOCK.getColor());
    }
}