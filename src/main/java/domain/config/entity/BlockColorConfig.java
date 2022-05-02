package domain.config.entity;

public class BlockColorConfig {
    private static final int DEFAULT_IBLOCK_COLOR = 0x00ffff; // CYAN
    private static final int DEFAULT_JBLOCK_COLOR = 0x0000ff; // BLUE
    private static final int DEFAULT_LBLOCK_COLOR = 0xff7f00; // ORANGE
    private static final int DEFAULT_OBLOCK_COLOR = 0xffff00; // YELLOW
    private static final int DEFAULT_SBLOCK_COLOR = 0x00ff00; // GREEN
    private static final int DEFAULT_TBLOCK_COLOR = 0x800080; // PURPLE;
    private static final int DEFAULT_ZBLOCK_COLOR = 0xff0000; // RED
    
    
    private int iBlockColor;
    private int jBlockColor;
    private int lBlockColor;
    private int oBlockColor;
    private int sBlockColor;
    private int tBlockColor;
    private int zBlockColor;


    public BlockColorConfig(int iBlockColor, int jBlockColor, int lBlockColor, int oBlockColor,
        int sBlockColor, int tBlockColor, int zBlockColor) {
        
        this.iBlockColor = iBlockColor;
        this.jBlockColor = jBlockColor;
        this.lBlockColor = lBlockColor;
        this.oBlockColor = oBlockColor;
        this.sBlockColor = sBlockColor;
        this.tBlockColor = tBlockColor;
        this.zBlockColor = zBlockColor;
    }

    public BlockColorConfig() {
        this(DEFAULT_IBLOCK_COLOR, DEFAULT_JBLOCK_COLOR, DEFAULT_LBLOCK_COLOR, DEFAULT_OBLOCK_COLOR, 
            DEFAULT_SBLOCK_COLOR, DEFAULT_TBLOCK_COLOR, DEFAULT_ZBLOCK_COLOR);
    }


    public int getiBlockColor() {
        return iBlockColor;
    }

    public int getjBlockColor() {
        return jBlockColor;
    }

    public int getlBlockColor() {
        return lBlockColor;
    }

    public int getoBlockColor() {
        return oBlockColor;
    }

    public int getsBlockColor() {
        return sBlockColor;
    }

    public int gettBlockColor() {
        return tBlockColor;
    }

    public int getzBlockColor() {
        return zBlockColor;
    }
}
