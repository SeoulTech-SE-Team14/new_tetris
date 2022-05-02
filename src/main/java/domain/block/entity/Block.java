package domain.block.entity;

import domain.config.controller.BlockColorConfigController;

public abstract class Block {
    
    protected int[][] shape;
    protected int color;

    protected boolean isRotatable;
    protected boolean isMovable;

    public Block() {

    }

    public Block(BlockColorConfigController colorSet) {
        shape = new int[][] {
            {0, 0},
            {0, 0}
        };

        color = colorSet.getCurrentConfig().getiBlockColor();

        isRotatable = true;
        isMovable = true;
    }

    public int[][] getShape() {
        return shape;
    }

    public int getColor() {
        return color;
    }

    public void setShape(int[][] shape) {
        this.shape = shape;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public boolean isMovable() {
        return isMovable;
    }

    public boolean isRotatable() {
        return isRotatable;
    }

    public void setMovable(boolean b) {
        isMovable = b;
    }

    public void setRotatable(boolean b) {
        isRotatable = b;
    }
}
