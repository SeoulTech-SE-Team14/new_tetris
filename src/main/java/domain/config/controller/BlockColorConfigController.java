package domain.config.controller;

import domain.config.dao.BlockColorConfigDao;
import domain.config.entity.BlockColorConfig;
import domain.config.constant.blockColor.ProtanopiaBlockColor;
import domain.config.constant.blockColor.TritanopiaBlockColor;

public class BlockColorConfigController {

    private static BlockColorConfigController INSTANCE = new BlockColorConfigController();

    public static BlockColorConfigController getInstance() {
        return INSTANCE;
    }


    private final BlockColorConfigDao blockColorConfigDao = BlockColorConfigDao.getInstance();


    private BlockColorConfigController() {

    }

    
    public BlockColorConfig getDefault() {
        return new BlockColorConfig();
    }

    public BlockColorConfig getProtanopia() {
        int iBlockColor = ProtanopiaBlockColor.IBLOCK.getColor();
        int jBlockColor = ProtanopiaBlockColor.JBLOCK.getColor();
        int lBlockColor = ProtanopiaBlockColor.LBLOCK.getColor();
        int oBlockColor = ProtanopiaBlockColor.OBLOCK.getColor();
        int sBlockColor = ProtanopiaBlockColor.SBLOCK.getColor();
        int tBlockColor = ProtanopiaBlockColor.TBLOCK.getColor();
        int zBlockColor = ProtanopiaBlockColor.ZBLOCK.getColor();

        return new BlockColorConfig(iBlockColor, jBlockColor, lBlockColor
            , oBlockColor, sBlockColor, tBlockColor, zBlockColor);
    }

    public BlockColorConfig getTritanopia() {
        int iBlockColor = TritanopiaBlockColor.IBLOCK.getColor();
        int jBlockColor = TritanopiaBlockColor.JBLOCK.getColor();
        int lBlockColor = TritanopiaBlockColor.LBLOCK.getColor();
        int oBlockColor = TritanopiaBlockColor.OBLOCK.getColor();
        int sBlockColor = TritanopiaBlockColor.SBLOCK.getColor();
        int tBlockColor = TritanopiaBlockColor.TBLOCK.getColor();
        int zBlockColor = TritanopiaBlockColor.ZBLOCK.getColor();

        return new BlockColorConfig(iBlockColor, jBlockColor, lBlockColor
            , oBlockColor, sBlockColor, tBlockColor, zBlockColor);
    }

    public BlockColorConfig getCurrentConfig() {
        return blockColorConfigDao.read();
    }

    public void update(BlockColorConfig object) {
        blockColorConfigDao.write(object);
    }
}
