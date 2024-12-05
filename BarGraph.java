// 姓名: 陳宣閔
// 學號: 110213018
import java.util.Scanner;
public class BarGraph{
    // n: 長條圖的x軸有幾個數字
    // data: 在長條圖上顯示的數值
    public static void main(String[] argv){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] data = new int[n];
        for (int i=0; i<n; i++)
            data[i] = input.nextInt();
        findRow(n, data);
    }
    // 找出y軸的最高值(data的最高值+2)
    // row: y軸的最高值
    public static void findRow(int n, int[] data){
        int row = 0;
        for (int i=0; i<n; i++){
            if (data[i]>row) // 比較大小, 最大值變成row
                row = data[i];
        }
        row = row + 2;
        findGraph(n, data, row);
    }
    public static void findGraph(int n, int[] data, int row){
        for (int r=row; r>0; r--){
            for (int c=0; c<n; c++){
                if (c==0){ // 輸出y軸
                    // 當這個y軸的值位數比y軸的最高值少就補0, 再輸出y軸的值跟空白; 反之, 只要輸出軸的值跟空白
                    if (r/10 < 1){
                        System.out.print("0"+ r +" ");
                    }else{
                        System.out.print( r +" ");
                    }
                }
                // 找出##和..
                // 如果data[i]<y軸的值, 就輸出..; 反之, 輸出##
                if(data[c]<r)
                    System.out.print(".."+" ");
                else
                    System.out.print("##"+" ");
            }
            System.out.println(); // 輸完一列就換行
        }
        // 輸出x軸
        // 當這個x軸的值位數比x軸的最高值少就補0, 再輸出x軸的值跟空白; 反之, 只要輸出x軸的值跟空白
        for (int i=0; i<=n; i++){
            if (i/10 < 1)
                System.out.print("0"+i+" ");
            else
                System.out.print(i+" ");
        }
    }
}