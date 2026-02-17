public class Task66 {
    public int[] plusOne(int[] digits) {

        int index = digits.length - 1;
        while (index >= 0) {
            digits[index]++;
            if (digits[index] == 10) {
                digits[index] = 0;
                index--;
            } else {
                return digits;
            }
        }
        int[] plusMas = new int[digits.length + 1];
        plusMas[0] = 1;
        for (int i = 1; i <= digits.length; i++) plusMas[i] = digits[i - 1];
        return plusMas;
    }
}
