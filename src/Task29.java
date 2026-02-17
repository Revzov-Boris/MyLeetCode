public class Task29 {
    public int divide(int dividend, int divisor) {
        if (dividend == 0) return 0;
        if (divisor == 1) return dividend;
        boolean type =  !((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0));

        long div = dividend;
        long del = divisor;

        div = Math.abs(div);
        del = Math.abs(del);

        int result = 0;
        long sum = 0;
        long k = 100_000_000;
        while (sum <= div) {
            while (k != 1 && del*k + sum > div) {
                k /= 10;
            }
            // это обрабатывет ситуацию (-2147483648, -1) нужно выдать 2147483647 это бред, но это считается правильным ответом
            if (result == 2147483647 && !type) {
                if (type) return -result;
                return result;
            }
            result += k;
            sum += del * k;
        }
        if (type) return -(result - 1);
        return (result - 1);
    }
}
