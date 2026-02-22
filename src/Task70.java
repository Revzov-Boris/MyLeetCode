public class Task70 {
    public static int climbStairs(int n) {
        // если 1-2 ступени, то столько и способов
        if (n <= 2) {
            return n;
        }
        // создаём массив ступеней,
        // в 0-ю можно попасть одним способом (подняться на одну ступень),
        // в 1-ю - двумя способами (2 раза по 1 или 1 раз по 2)
        // в каждую дальнейшую i-ю можно попасть levels[i - 1] + levels[i - 2] способами
        int[] levels = new int[n];
        levels[0] = 1;
        levels[1] = 2;
        for (int i = 2; i < n; i++) {
            levels[i] = levels[i - 2] + levels[i - 1];
        }
        return levels[n - 1];
    }
}
