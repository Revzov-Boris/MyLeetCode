
public class Task134 {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int[] road = new int[gas.length];
        int sum = 0;
        for (int i = 0; i < gas.length; i++) {
            road[i] = gas[i] - cost[i];
            sum += road[i];
        }
        if (sum < 0) return -1;

        boolean startConditionIsZero = false;
        for (int startIndex = 0; startIndex < road.length; startIndex++) {
            if (road[startIndex] < 0 || startConditionIsZero) {
                startConditionIsZero = road[startIndex] == 0;
                continue;
            }
            int bak = 0;
            int index = startIndex;
            while (true) {
                bak += road[index];
                if (bak < 0) {
                    break;
                }
                if (++index == road.length) {
                    index = 0;
                }
                if (index == startIndex) {
                    return startIndex;
                }
            }
            startConditionIsZero = road[startIndex] == 0;
        }
        return -1;

    }

    public static void main(String[] args) {
        //[1,2,3,4,5], cost = [3,4,5,1,2]
        int[] gas = new int[]{2,0,3};
        int[] cost = new int[]{1,2,2};
        System.out.println(canCompleteCircuit(gas, cost));
    }

}
