package domain.config.dao;

import domain.config.entity.BlockColorConfig;
import global.dao.JsonDao;

public class BlockColorConfigDao extends JsonDao<BlockColorConfig> {

    private static BlockColorConfigDao INSTANCE = new BlockColorConfigDao();

    public static BlockColorConfigDao getInstance() {
        return INSTANCE;
    }


    private BlockColorConfigDao() {
        super(new BlockColorConfig());
    }
    

    public BlockColorConfig read() {
        return super.read(BlockColorConfig.class);
    }
}
