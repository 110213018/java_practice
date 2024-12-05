// 姓名: 陳宣閔
// 學號: 110213018
// how many primes between x and y
import java.util.Scanner;
public class CountPrime{
    public static boolean isPrime(int y){
        int i=2; // 找質數從2開始除
        while (i<y || y==1){ // 除式要小於被除式,且1不是質數
            if (y%i==0 || y==1){ // if (現在要測的值,除以小於自己的數,然後餘式為零)or(現在要測的值為1) -->不是質數
                return false; // 不是質數就回傳false
            }
            i = i+1; // 除以2後,發現餘式不為0,就繼續除以下一個數,直到找出非質數或質數
        }
        return true; // 是質數就回傳true
        }
    // 如果起始值>終止值,就交換順序
    public static int countPrime(int start, int end){
        if (start > end){
            // 設start=9, end=3
            // tmp = 9(start)
            // start = 3
            // end = 9
            int tmp = start;
            start = end;
            end = tmp;
        }
        int y = start; // y: 現在要測的數字
        int count = 0; // count: 現在總共有幾個質數
        while (y <= end){ // 如果現在要測的值<=輸入的最後一個值
            if (isPrime(y)){ // 如果找到質數,count+1
                count = count + 1;
            }
            y = y + 1; // 測完一個數字後,就進入到下一數字
        }
        return count; // 回傳總共有幾個質數
    }
    public static void main(String[] argv){
        Scanner input = new Scanner(System.in);
        int x = input.nextInt();
        int y = input.nextInt();
        System.out.println(countPrime(x,y));
    }
}