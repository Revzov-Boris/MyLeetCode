public class Task62 {
    public static int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) return 1;
        int[][] mas = new int[m][n];
        for (int x = 0; x < m; x++) {
            mas[x][0] = 1;
        }
        for (int y = 0; y < n; y++) {
            mas[0][y] = 1;
        }

        for (int x = 1; x < m; x++) {
            for (int y = 1; y < n; y++) {
                mas[x][y] = mas[x - 1][y] + mas[x][y - 1];
            }
        }
        return mas[m - 1][n - 1];
    }
}
