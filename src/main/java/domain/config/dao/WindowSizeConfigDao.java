package domain.config.dao;

import domain.config.entity.WindowSizeConfig;
import global.dao.JsonDao;

public class WindowSizeConfigDao extends JsonDao<WindowSizeConfig> {

    private static WindowSizeConfigDao INSTANCE = new WindowSizeConfigDao();

    public static WindowSizeConfigDao getInstance() {
        return INSTANCE;
    }


    private WindowSizeConfigDao() {
        super(new WindowSizeConfig());
    }


    public WindowSizeConfig read() {
        return super.read(WindowSizeConfig.class);
    }
}

