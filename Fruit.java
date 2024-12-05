// 姓名:陳宣閔
// 學號:110213018
import java.util.Scanner;
public class Fruit{
    public static void main(String[] argv){
        Scanner input = new Scanner(System.in);
        // money: 現有現金
        // n: 有多少顆水果要買
        // species: 要買幾種水果
        // prices: 水果的價錢(整數陣列)
        int money = input.nextInt(), n = input.nextInt(), species = input.nextInt();
        int[] prices = new int[species]; // 創新空間
        for (int i=0; i<species; i++) // 在空間的每個位置都輸入水果價格(整數)
            prices[i] = input.nextInt();
        System.out.println(findSol(money, n, species, prices)); // 輸出找到幾種解答
    }
    // return true if found solution, otherwise false
    public static int findSol(int money, int n, int species, int[] prices){
        return findSol(money, n, species, prices, 0, new int[species]);
    }
    // kind:我負責買的水果種類
    // result:水果籃內每一顆水果買好的數量
    // return true if found at least one solution, false otherwise
    public static int findSol(int money, int n, int species, int[] prices, int kind, int[] result){
        if (n==0){ // 買完了(找完一種買法之後, 就回傳1, 讓found+1)
            return 1;
        }
        // 甚麼條件算找不到解答(found+0)
        if (kind == species) // 沒有水果可以買了
            return 0;
        int found = 0; // 找到幾種解答
        // 讓我買kind這種水果, 我有幾種買法
        for (int c=0; c<= (money/prices[kind]<=n?money/prices[kind]:n); c++){ // buy this kind c fruits
            result[kind] = c; // 記錄買了kind水果c個
            found += findSol( money-c*prices[kind], n-c, species, prices, kind+1, result); // 每找到一種買法, found+1(26行))
            result[kind] = 0; // 找完一種買法之後, 記錄買了kind水果0個(因為要找下一個買法, 所以記錄先規0)
        }
        return found; // 回傳找到幾種解答
    }
}