import java.util.Arrays;

public class Task135 {
    public static int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        int size = ratings.length;
        if (candies.length == 1) {
            return 1;
        }
        if (ratings[1] >= ratings[0]) {
            candies[0] = 1;
        }
        if (ratings[size - 2] >= ratings[size - 1]) {
            candies[size - 1] = 1;
        }
        for (int i = 0; i < candies.length; i++) {
            if (i > 0 && i < candies.length - 1
                    && ratings[i - 1] >= ratings[i] && ratings[i + 1] >= ratings[i]) {
                candies[i] = 1;
            }
        }
        if (candies[0] == 0) {
            int nearZeroIndex = -1;
            for (int i = 1; i < size; i++) {
                if (candies[i] == 1) {
                    nearZeroIndex = i;
                    break;
                }
            }
            candies[0] = nearZeroIndex + 1;
        }
        if (candies[size - 1] == 0) {
            int nearZeroIndex = -1;
            for (int i = size - 2; i >= 0; i--) {
                if (candies[i] == 1) {
                    nearZeroIndex = i;
                    break;
                }
            }
            System.out.println("nearSize " + nearZeroIndex);
            candies[size - 1] = size - nearZeroIndex;
        }
        System.out.println("rating: " + Arrays.toString(ratings));
        System.out.println("candis: " + Arrays.toString(candies));


        for (int i = 1; i < ratings.length - 1; i++) {
            if (candies[i] != 0) {
                continue;
            }
            if (ratings[i - 1] < ratings[i]) {
                candies[i] = candies[i - 1] + 1;
            } else if (ratings[i + 1] < ratings[i]) {
                int nearZeroIndex = -1;
                for (int index = i; index < size; index++) {
                    if (candies[index] == 1) {
                        nearZeroIndex = index;
                        break;
                    }
                }
                System.out.println("i " + i + " nearZero " + nearZeroIndex);
                candies[i] = nearZeroIndex - i + 1;
                if (ratings[i - 1] > ratings[i] && candies[i - 1] <= candies[i]) {
                    candies[i - 1] = candies[i] + 1;
                }
            }
        }

        System.out.println("candis: " + Arrays.toString(candies));

        return Arrays.stream(candies).sum();
    }

    public static void main(String[] args) {
        System.out.println(candy(new int[]{1,2,3}));
    }
}
