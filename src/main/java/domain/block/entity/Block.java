package domain.block.entity;


public abstract class Block {
    
    protected int[][] shape;

    protected boolean isRotatable;
    protected boolean isMovable;
    protected boolean isPassable;

    public Block() {
        shape = new int[][] {
            {0, 0},
            {0, 0}
        };


        isRotatable = true;
        isMovable = true;
        isPassable = false;
    }

    public int[][] getShape() {
        return shape;
    }

    public void setShape(int[][] shape) {
        this.shape = shape;
    }

    public boolean isMovable() {
        return isMovable;
    }

    public boolean isRotatable() {
        return isRotatable;
    }

    public boolean isPassable() {
        return isPassable;
    }

    public void setMovable(boolean b) {
        isMovable = b;
    }

    public void setRotatable(boolean b) {
        isRotatable = b;
    }
}
