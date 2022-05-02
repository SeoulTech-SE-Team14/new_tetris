package domain.config.entity;

public class WindowSizeConfig {
    
    private static final int DEFAULT_WIDTH = 800;
    private static final int DEFAULT_HEIGHT = 600;
    
    
    private int width;
    private int height;


    public WindowSizeConfig(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public WindowSizeConfig() {
        this(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }


    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
