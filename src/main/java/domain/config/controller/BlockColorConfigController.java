package domain.config.controller;

import domain.config.dao.BlockColorConfigDao;
import domain.config.entity.BlockColorConfig;

public class BlockColorConfigController {

    private static BlockColorConfigController INSTANCE = new BlockColorConfigController();

    public static BlockColorConfigController getInstance() {
        return INSTANCE;
    }

    private final BlockColorConfigDao blockColorConfigDao = BlockColorConfigDao.getInstance();
    
    public BlockColorConfig getDefault() {
        return new BlockColorConfig();
    }

    public BlockColorConfig getProtanopia() {
        return new BlockColorConfig();
    }

    public BlockColorConfig getTritanopia() {
        return new BlockColorConfig();
    }

    public BlockColorConfig getCurrentConfig() {
        return blockColorConfigDao.read();
    }

    public void update(BlockColorConfig object) {
        blockColorConfigDao.write(object);
    }
}
