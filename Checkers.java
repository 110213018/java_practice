// 姓名: 陳宣閔
// 學號: 110213018
import java.util.Scanner;
public class Checkers{
    // n: 棋盤大小
    // block: 盤面
    // row: 起點位置(列)
    // col: 起點位置(行)
    public static void main(String[] argv){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int row = input.nextInt(), col = input.nextInt();
        int[][] block = new int[n][n];
        for (int r=0; r<n; r++){
            for (int c=0; c<n; c++)
                block[r][c] = input.nextInt();
        }
        System.out.print(findAns(n, block, row, col));
    }
    public static int findAns(int n, int[][] b, int r, int c){
        b[r][c] = 0; // 起點
        // 先找出位置可變動方向
        // ro = 1, -1, 0, 0, 1, 1, -1, -1   CF: 1=下, -1=上
        // co = 0, 0, 1, -1, 1, -1, 1, -1   CF: 1=右, -1=左
        // 位置變動方向      下 上  右 左 右下 左下 右上 左上
        int[] ro = new int[]{1, -1, 0,  0, 1,  1, -1, -1};
        int[] co = new int[]{0,  0, 1, -1, 1, -1,  1, -1};
        // 找出可符合條件的recursion內容
        // 0<= r+2*ro[i] <n           跳下去的位置不能超過or小於n的長度
        // 0<= c+2*co[i] <n           跳下去的位置不能超過or小於n的長度
        // b[r+ro[i]][c+co[i]]==1      躍過去的棋為1(有棋子)
        // b[r+2*ro[i]][c+2*co[i]]==0  跳下去的位置為0(沒有棋子)
        int maxLen = 0; // 最長的長度
        int thisLen = 0; // 現在測的長度
        for (int i=0; i<8; i++){
            if ((0<=r+2*ro[i]) && (r+2*ro[i]<n) && (0<=c+2*co[i]) && (c+2*co[i]<n) && (b[r+ro[i]][c+co[i]]==1) && (b[r+2*ro[i]][c+2*co[i]]==0)){
                b[r+ro[i]][c+co[i]] = 0; // 躍過去的棋改為0
                thisLen = 1 + findAns(n, b, r+2*ro[i], c+2*co[i]);
                // 跑完一個結果之後, 開始一步一步復原
                // 回復一步, tL+1, 直到回復到有新路線可以走, 再開始計算新的tL
                b[r+ro[i]][c+co[i]] = 1; // 將盤面復原
                // 當這次找到的長度比之前找到的最大長度還要長, maxLen就換人當
                if (thisLen > maxLen){
                    maxLen = thisLen;
                }
            }
        }
        return maxLen; // 回傳
    }
}