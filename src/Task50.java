public class Task50 {
    public static void main(String[] args) {
        System.out.println(myPow(2, -2147483648));
    }


    public static double myPow(double x, long n) {
        if (n == 0 || x == 1) return 1;
        if (n == 1) return x;
        if (x == -1) return n % 2 == 0 ? 1 : -1;
        double result = 1;
        for (int c = 0; c < Math.abs(n); c++) {
            if (n > 0) {
                result *= x;
            } else {
                result /= x;
            }
            if (result == 0.0) break;
        }
        return result;
    }
}
