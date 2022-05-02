package domain.config.dao;

import domain.config.entity.KeyConfig;
import global.dao.JsonDao;

public class KeyConfigDao extends JsonDao<KeyConfig> {

    private static KeyConfigDao INSTANCE = new KeyConfigDao();

    public static KeyConfigDao getInstance() {
        return INSTANCE;
    }

    private KeyConfigDao() {
        super(new KeyConfig());
    }
    
    public KeyConfig read() {
        return super.read(KeyConfig.class);
    }
}
