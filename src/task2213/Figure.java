package task2213;

public class Figure {
    private int x;
    private int y;
    private int[][] matrix = new int[3][3];

    public void left() {
        if (isCurrentPositionAvailable())
            x -= 1;
    }

    public void right() {
        if (isCurrentPositionAvailable())
            x += 1;
    }

    public void up() {
        y -= 1;
    }

    public void down() {
        y += 1;
    }

    public void rotate() {}

    public void downMaximum() {}

    public boolean isCurrentPositionAvailable() {return true;}

    public void landed() {}

    public Figure(int x, int y, int[][] matrix) {
        this.x = x;
        this.y = y;
        this.matrix = matrix;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int[][] getMatrix() {
        return matrix;
    }
}
