public class Task367 {
    public boolean isPerfectSquare(int num) {
        long lx = num;
        long sqrt = 0;
        int plus = 131_072;
        while (sqrt*sqrt < lx) {
            while((sqrt + plus) * (sqrt + plus) > lx && plus != 1) {
                plus = plus >> 1;
            }
            sqrt += plus;
        }
        return (sqrt*sqrt) == num;
    }
}
