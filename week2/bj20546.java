import java.util.Scanner;

public class bj20546 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int initialCash = sc.nextInt();
        int[] prices = new int[14];
        for (int i = 0; i < 14; i++) {
            prices[i] = sc.nextInt();
        }

        // 준현 (BNP)
        int cashJunhyun = initialCash;
        int stockJunhyun = 0;
        for (int price : prices) {
            if (cashJunhyun >= price) {
                stockJunhyun += cashJunhyun / price;
                cashJunhyun %= price;
            }
        }

        // 성민 (TIMING)
        int cashSungmin = initialCash;
        int stockSungmin = 0;
        int upCount = 0, downCount = 0;

        for (int i = 1; i < 14; i++) {
            if (prices[i] > prices[i - 1]) {
                upCount++;
                downCount = 0;
            } else if (prices[i] < prices[i - 1]) {
                downCount++;
                upCount = 0;
            } else {
                upCount = 0;
                downCount = 0;
            }

            if (downCount >= 3 && cashSungmin >= prices[i]) {  // 3일 연속 하락 시 매수
                stockSungmin += cashSungmin / prices[i];
                cashSungmin %= prices[i];
            } else if (upCount >= 3 && stockSungmin > 0) {  // 3일 연속 상승 시 매도
                cashSungmin += stockSungmin * prices[i];
                stockSungmin = 0;
            }
        }

        // 최종 자산 계산
        int finalAssetJunhyun = cashJunhyun + stockJunhyun * prices[13];
        int finalAssetSungmin = cashSungmin + stockSungmin * prices[13];

        if (finalAssetJunhyun > finalAssetSungmin) {
            System.out.println("BNP");
        } else if (finalAssetJunhyun < finalAssetSungmin) {
            System.out.println("TIMING");
        } else {
            System.out.println("SAMESAME");
        }
    }
}
