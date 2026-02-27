import java.util.ArrayList;
import java.util.List;

public class Task994 {
    static int time = 0;
    static List<List<Integer>> areRotInLocal = new ArrayList();


    public static void main(String[] args) {
        int[][] mas = new int[][]{
                {2,1,1},
                {1,1,0},
                {0,0,1}};

        System.out.println("result: " + orangesRotting(mas));
    }


    public static int orangesRotting(int[][] grid) {
        int maxTime = 0;
        time = 0;
        areRotInLocal.clear();
        for (int x = 0; x < grid[0].length; x++) {
            for (int y = 0; y < grid.length; y++) {
                if (grid[y][x] <= 0) continue;
                walkerIn(x, y, grid[0].length - 1, grid.length - 1, grid);
                //System.out.println("источники заражения: " + areRotInLocal);
                if (areRotInLocal.isEmpty()) {
                    return -1;
                }
                rotter(grid, areRotInLocal);
                areRotInLocal.clear();
                //for (int[] submus : grid) System.out.println(Arrays.toString(submus));
                maxTime = Math.max(maxTime, time);
                time = 0;
            }
        }

        for (int x = 0; x < grid[0].length; x++) {
            for (int y = 0; y < grid.length; y++) {
                if (grid[y][x] == 1) return -1;
            }
        }
        return maxTime;
    }

    // заполоняет areRotInLocal координатами гнилых апельсинов на текущем "острове"
    public static void walkerIn(int x, int y, int mx, int my, int[][] grid) {
        if (grid[y][x] == 2) {
            areRotInLocal.add(List.of(x, y));
            grid[y][x] = -2; // теперь -2 это сгнивший апельсин
        } else {
            grid[y][x] = -1; // теперь -1 это свежий апельсин
        }
        if (x + 1 <= mx && grid[y][x+1] >= 1) {
            walkerIn(x+1, y, mx, my, grid);
        }
        if (x - 1 >= 0 && grid[y][x-1] >= 1) {
            walkerIn(x-1, y, mx, my, grid);
        }
        if (y + 1 <= my && grid[y+1][x] >= 1) {
            walkerIn(x, y+1, mx, my, grid);
        }
        if (y - 1 >= 0 && grid[y-1][x] >= 1) {
            walkerIn(x, y-1, mx, my, grid);
        }
    }


    // делает гнилым весь "остров апельсинов"
    public static void rotter(int[][] grid, List<List<Integer>> rotNow) {
        // лист с координатами апельсинов, которые сгниют на этом ходу
        List<List<Integer>> toAdd = new ArrayList();
        while (true) {
           // System.out.println("[IN] источники заражения: " + areRotInLocal);
            for (List<Integer> point : rotNow) {
                int x = point.get(0);
                int y = point.get(1);
                if (x + 1 < grid[0].length && grid[y][x+1] == -1) {
                    grid[y][x+1] = -2;
                    toAdd.add(List.of(x+1, y));
                }
                if (x - 1 >= 0 && grid[y][x-1] == -1) {
                    grid[y][x-1] = -2;
                    toAdd.add(List.of(x-1, y));
                }
                if (y + 1 < grid.length && grid[y+1][x] == -1) {
                    grid[y+1][x] = -2;
                    toAdd.add(List.of(x, y+1));
                }
                if (y - 1 >= 0 && grid[y-1][x] == -1) {
                    toAdd.add(List.of(x, y-1));
                    grid[y-1][x] = -2;
                }
            }
            if (toAdd.isEmpty()) {
                break;
            }
            time += 1;
            // удаляем сгнившие на предыдущих шагах
            rotNow.clear();
            // добавляем сгнившие на этом шаге
            rotNow.addAll(toAdd);
            toAdd.clear();
        }
    }
}
