package domain.config.constant.blockColor;

public enum ProtanopiaBlockColor {

    IBLOCK(0x54b5ec), // SKY_BLUE
    JBLOCK(0x0000ff), // BLUE
    LBLOCK(0xe59f01), // DW_ORANGE
    OBLOCK(0xf1e344), // DW_YELLOW
    SBLOCK(0xcc79a7), // BLUISH_GREEN
    TBLOCK(0xcc79a7), // REDDISH_PURPLE
    ZBLOCK(0xd65e00), // VERMILION
    ;


    private int color;

    private ProtanopiaBlockColor(int color) {
        this.color = color;
    }

    public int getColor() {
        return color;
    }
}
