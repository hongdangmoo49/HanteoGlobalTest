package algorithm;

import java.util.Arrays;

public class HanteoGlobal {
    public static void main(String[] args) {
        int[] coins = {2, 5, 3, 6};
        int sum = 10;
        int result = coinChange(coins, sum);
        System.out.println("다음과 같은 조합으로 " + sum + "을 만들 수 있습니다: ");
        printCombinations(coins, sum); // 조합을 출력하는 함수 호출
        System.out.println("합계를 만드는 방법의 수: " + result);
    }

    public static int coinChange(int[] coins, int sum) {
        int[] dp = new int[sum+1]; // dp 배열 생성 (합계가 i일 때의 조합 수)
        dp[0] = 1; // 합계가 0일 때는 조합이 한 가지뿐이므로 1로 초기화

        for (int coin : coins) { // 동전 종류를 하나씩 고려한다.
            for (int i = coin; i <= sum; i++) { // 합계를 만들 수 있는 경우의 수를 계산한다.
                dp[i] += dp[i-coin]; // dp 배열을 갱신한다.
            }
        }

        return dp[sum]; // sum을 만들 수 있는 조합의 수를 반환한다
    }

    public static void printCombinations(int[] coins, int sum) {
        Arrays.sort(coins); // 동전 종류를 오름차순으로 정렬한다
        int[] combination = new int[sum]; // 조합을 저장하는 배열 생성
        printCombinationsHelper(coins, sum, combination, 0, 0); // 조합을 계산하고 출력하는 함수 호출
    }

    public static void printCombinationsHelper(int[] coins, int sum, int[] combination, int index, int start) {
        if (sum == 0) { // 합계가 0이면 조합이 완성된 것이므로 출력한다.
            System.out.println(Arrays.toString(Arrays.copyOf(combination, index)));
            return;
        }

        for (int i = start; i < coins.length; i++) { // 가능한 동전 종류를 하나씩 추가한다.
            if (coins[i] <= sum) { // 합계를 초과하지 않는 경우에만 추가한다.
                combination[index] = coins[i]; // 조합에 추가한다.
                printCombinationsHelper(coins, sum-coins[i], combination, index+1, i); // 재귀 호출
            }
        }
    }
}