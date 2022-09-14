
import java.util.HashMap;
import java.util.Scanner;

public class Solver {
    int row;
    int col;
    char[][] grid;
    String[] words;
    int numWords;
    HashMap<String, Coord> hashMap = new HashMap<>();

    public Solver() {
        Scanner in = new Scanner(System.in);
        System.out.println("enter puzzle length: ");
        row = in.nextInt();
        System.out.println("enter puzzle width: ");
        col = in.nextInt();

        // Get grid of chars
        grid = new char[row][col];
        char[] lines;

        System.out.println("enter in puzzle: ");
        for (int j = 0; j < col; j++) {
            String puzzle = in.next();
            lines = puzzle.toCharArray();
            grid[j] = lines;
        }
        // Get list of words
        System.out.println("How many words are there? ");
        numWords = in.nextInt();
        System.out.println("enter the words: ");
        words = new String[numWords];
        for (int i = 0; i < numWords; i++) {
            words[i] = (in.next());
        }
    }

    public void printWords() {
            for (String word : words) {
                System.out.println(word);
            }
        }

    /**
     * Prints out word search with labeled with indices
     */
    public void printGrid() {
        for (int i = 0; i < col; i++) {
            if (i == 0) {
                System.out.print("  "+ i + " ");
            }
            else {
                System.out.print(i + " ");
            }
        }
        System.out.println();
        for (int i = 0; i < row; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < col; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * initiates the solver
     */
    public void solve() {

        for (String word : words) {
            findWord(word);
        }
        printHashMap();
        System.out.println("--------------------");
        printGrid();
        System.out.println("--------------------");

    }

    public Coord getWord(String word) {
        return hashMap.get(word);
    }

    /**
     * prints out the word and the associating coordinate
     */
    public void printHashMap() {
        for (String words : hashMap.keySet()) {

            System.out.print(words + ": ");
            System.out.println(hashMap.get(words));

        }
    }

    /**
     * Runs through grid looking for matching first letter.
     * When it matches, it checks every possible direction for the word.
     * @param word the word it's searching for
     */
    public void findWord(String word) {

        char firstLetter = word.charAt(0);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (firstLetter == grid[i][j]) {
                    if (checkLeft(grid, word, i, j)) {
                        Coord begin = new Coord(i, j);
                        hashMap.put(word, begin);
                        break;
                    }
                    else if (checkRight(grid, word, i, j)) {
                        Coord begin = new Coord(i, j);
                        hashMap.put(word, begin);
                        break;
                    }
                    else if (checkUp(grid, word, i, j)) {
                        Coord begin = new Coord(i, j);
                        hashMap.put(word, begin);
                        break;
                    }
                    else if (checkDown(grid, word, i, j)) {
                        Coord begin = new Coord(i, j);
                        hashMap.put(word, begin);
                        break;
                    }
                    else if (checkUpLeft(grid, word, i, j)) {
                        Coord begin = new Coord(i, j);
                        hashMap.put(word, begin);
                        break;
                    }
                    else if (checkUpRight(grid, word, i, j)) {
                        Coord begin = new Coord(i, j);
                        hashMap.put(word, begin);
                        break;
                    }
                    else if (checkDownLeft(grid, word, i, j)) {
                        Coord begin = new Coord(i, j);
                        hashMap.put(word, begin);
                        break;
                    }
                    else if (checkDownRight(grid, word, i, j)) {
                        Coord begin = new Coord(i, j);
                        hashMap.put(word, begin);
                        break;
                    }
                }
            }
        }
    }

    /**
     * Checks if the second letter matches to the left, and so on.
     * @param grid The word search
     * @param word The word it's searching for
     * @param row The x value
     * @param col The y value
     * @return True if all the letters match.
     */
    public boolean checkLeft(char[][] grid, String word, int row, int col) {
        if (col - word.length() < 0) {
            return false;
        }
        for (int i = 1; i < word.length(); i++) {
            if (grid[row][col-i] != word.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    public boolean checkRight(char[][] grid, String word, int row, int col) {
        if (col + word.length() > grid[0].length) {
            return false;
        }
        for (int i = 1; i < word.length(); i++) {
            if (grid[row][col+i] != word.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    public boolean checkUp(char[][] grid, String word, int row, int col) {
        if (row - word.length() < 0) {
            return false;
        }
        for (int i = 1; i < word.length(); i++) {
            if (grid[row-i][col] != word.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    public boolean checkDown(char[][] grid, String word, int row, int col) {
        if (row + word.length() > grid.length) {
            return false;
        }
        for (int i = 1; i < word.length(); i++) {
            if (grid[row+i][col] != word.charAt(i)) {
                return false;
            }
        }
        return true;

    }
    public boolean checkUpLeft(char[][] grid, String word, int row, int col) {
        if (row - word.length() < 0 || col - word.length() < 0) {
            return false;
        }
        for (int i = 1; i < word.length(); i++) {
            if (grid[row-i][col-i] != word.charAt(i)) {
                return false;
            }
        }
        return true;

    }
    public boolean checkUpRight(char[][] grid, String word, int row, int col) {
        if (row - word.length() < 0 || col + word.length() > grid[0].length) {
            return false;
        }
        for (int i = 1; i < word.length(); i++) {
            if (grid[row-i][col+i] != word.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    public boolean checkDownLeft(char[][] grid, String word, int row, int col) {
        if (row + word.length() > grid.length || col - word.length() < 0) {
            return false;
        }
        for (int i = 1; i < word.length(); i++) {
            if (grid[row+i][col-i] != word.charAt(i)) {
                return false;
            }
        }
        return true;


    }
    public boolean checkDownRight(char[][] grid, String word, int row, int col) {
        if (col + word.length() > grid[0].length || row + word.length() > grid.length) {
            return false;
        }
        for (int i = 1; i < word.length(); i++) {
            if (grid[row+i][col+i] != word.charAt(i)) {
                return false;
            }
        }
        return true;

    }
}
