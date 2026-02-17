public class Task69 {
    public int mySqrt(int x) {
        long lx = x;
        long sqrt = 0;
        int plus = 131_072;
        while (sqrt*sqrt <= x) {
            while((sqrt + plus) * (sqrt + plus) > lx && plus != 1) {
                plus = plus >> 1;
            }
            sqrt += plus;
        }
        return (int) --sqrt;
    }
}
