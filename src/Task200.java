public class Task200 {
    public static void main(String[] args) {
        char[][] grid = grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '1', '0'}
        };
        System.out.println(numIslands(grid));
    }


    public static int numIslands(char[][] grid) {
        int countIsl = 0;
        for (int x = 0; x < grid[0].length; x++) {
            for (int y = 0; y < grid.length; y++) {
                if (grid[y][x] == '0') continue;
                walker(grid, x, y, grid[0].length - 1, grid.length - 1);
                countIsl++;
            }
        }
        return countIsl;
    }


    // рекурсивно обнуляет все связанные единицы, "утопляя" остров
    public static void walker(char[][] grid, int x, int y, int xMax, int yMax) {
        grid[y][x] = '0';
        if (x + 1 <= xMax && grid[y][x+1] == '1') {
            walker(grid, x+1, y, xMax, yMax);
        }
        if (x - 1 >= 0 && grid[y][x-1] == '1') {
            walker(grid, x-1, y, xMax, yMax);
        }
        if (y + 1 <= yMax && grid[y+1][x] == '1' ) {
            walker(grid, x, y+1, xMax, yMax);
        }
        if (y - 1 >= 0 && grid[y-1][x] == '1') {
            walker(grid, x, y-1, xMax, yMax);
        }
    }
}
