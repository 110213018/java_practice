// 姓名: 陳宣閔
// 學號: 110213018
import java.util.Scanner;
public class Volleyball{
    public static void main(String[] argv){
        Scanner input = new Scanner(System.in);
        // A: A隊初始球員背號
        // B: B隊初始球員背號
        // n: 打n局
        // win: 哪隊得分
        int[] A = new int[6];
        for (int i=0; i<6; i++)
            A[i] = input.nextInt();
        int[] B = new int[6];
        for (int i=0; i<6; i++)
            B[i] = input.nextInt();
        int n = input.nextInt();
        String[] win = new String[n];
        for (int i=0; i<n; i++)
            win[i] = input.next();
        findAns(A, B, n, win);
    }
    public static void findAns(int[] A, int[] B, int n, String[] win){
        // 輸出比賽前
        System.out.println("Before:");
        // 輸出A隊站位(要從list的最後一個開始)
        for (int i=5; i>=0; i--){
            // 每個背號請補空白至每個背號印出都是三位
            System.out.print(String.format("%3s",A[i]));
            // 第一二列輸完要換行
            if (i%3==0)
                System.out.println();
        }
        // 輸出球網
        System.out.println("===========");
        // 輸出B隊站位(要從list的第一個開始)
        for (int i=0; i<6; i++){
            // 每個背號請補空白至每個背號印出都是三位
            System.out.print(String.format("%3s",B[i]));
            // 第一二列輸完要換行
            if (i==2 || i==5)
                System.out.println();
        }
        System.out.println(0+":"+0); // 輸出比賽前比分
        // At: A隊隊名
        // Bt: B隊隊名
        // Apoint: A隊得分
        // Bpoint: B隊得分
        String At = new String("A");
        String Bt = new String("B");
        int Apoint = 0, Bpoint = 0;
        for (int i=0; i<n; i++){
            // 如果B得分A就轉,且不連續
            if (win[i].equals(Bt) && !win[i].equals(win[i-1])){
                B = newList(B);
                Bpoint++;
            }
            // 如果A得分且不是第一球且不連續, A隊就換位子跟加分
            else if (win[i].equals(At) && i!=0 && !win[i].equals(win[i-1])){
                A = newList(A);
                Apoint++;
            }
            // 如果A得分且為第一球且連續, A隊不換位子但加分
            else if ((win[i].equals(At) && i==0) || (win[i].equals(At) && win[i].equals(win[i-1]))){
                Apoint++;
            }
            // 如果B得分且為第一球且連續, B隊不換位子但加分
            else if ((win[i].equals(Bt) && i==0) || (win[i].equals(Bt) && win[i].equals(win[i-1]))){
                Bpoint++;
            }
        }
        // 輸出比賽後
        System.out.println("After:");
        // 輸出A隊站位(要從list的最後一個開始)
        for (int i=5; i>=0; i--){
            // 每個背號請補空白至每個背號印出都是三位
            System.out.print(String.format("%3s",A[i]));
            // 第一二列輸完要換行
            if (i%3==0)
                System.out.println();
        }
        // 輸出球網
        System.out.println("===========");
        // 輸出B隊站位(要從list的第一個開始)
        for (int i=0; i<6; i++){
            // 每個背號請補空白至每個背號印出都是三位
            System.out.print(String.format("%3s",B[i]));
            // 第一二列輸完要換行
            if (i==2 || i==5)
                System.out.println();
        }
        // 輸出最後比分
        System.out.println(Apoint+":"+Bpoint);
    }
    // 換位子
    public static int[] newList(int[] data){
        // result: 放換位子之後的list
        int[] result = new int[6];
        result[0] = data[3];
        result[1] = data[0];
        result[2] = data[1];
        result[3] = data[4];
        result[4] = data[5];
        result[5] = data[2];
        return result;
    }
}