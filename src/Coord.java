public class Coord {
    int row;
    int col;

    public Coord(int x, int y) {
        row = x;
        col = y;
    }
    public String toString() {
        return "First letter position ---> " + row + ", " + col;
    }
}
