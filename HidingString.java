// 姓名: 陳宣閔
// 學號: 110213018
import java.util.Scanner;
public class HidingString{
    public static void main(String[] argv){
        // n: n行字串 / n個數字
        // data: 字串
        // num: 要取每行字串(第一行開始依序往下)的第幾個字
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String[] data = new String[n];
        int[] num = new int[n];
        for (int i=0; i<n; i++)
            data[i] = input.next();
        for (int i=0; i<n; i++)
            num[i] = input.nextInt();
        findString(n, data,  num);
    }
    // 找出將數字對應到字串之後的結果
    public static void findString(int n, String[] data, int[] num){
        for (int i=0; i<n; i++){
            char CharInString = data[i].charAt(num[i]); // 找出這個字串的第幾個字
            System.out.print(CharInString); // 每找到一個數字對應到字串之後的結果, 就輸出(不能換行)
        }
    }
}