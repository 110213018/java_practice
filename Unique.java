// 姓名: 陳宣閔
// 學號: 110213018
// 著色數獨
// input: 81 ints between 0-8 表示每個位置所屬的區塊
// then 81 ints 表示每個位置已知的數字, 若微可任意填入的空白, 則以0表示
// 0 0 0 1 1 1 2 2 2
// 0 0 0 1 1 1 2 2 2
// 0 0 0 1 1 1 2 2 2
// 3 3 3 4 4 4 5 5 5
// 3 3 3 4 4 4 5 5 5
// 3 3 3 4 4 4 5 5 5
// 6 6 6 7 7 7 8 8 8
// 6 6 6 7 7 7 8 8 8
// 6 6 6 7 7 7 8 8 8
// 000122222000111222033331112003444411333345555664444577866655557888666777888886777
// 300000004002060100010908020005000600020000010009000800080304060004010900500000007

// output:
// 358196274
// 492567138
// 613978425
// 175842693
// 826453719
// 249731856
// 987324561
// 734615982
// 561289347
import java.util.Scanner;
public class Unique{
    // m: 色塊範圍
    // d: 數獨上存在的數字, 0代表此格為空格
    public static void findSol(String map, String data){
        int[] m = new int[81];
        int[] d = new int[81];
        for (int i=0; i<81; i++){
            m[i] = map.charAt(i) - '0'; // 把char變成int EX: '0'-'0'=0
            d[i] = data.charAt(i) - '0';
        }
        boolean[][] row = new boolean[9][9], col = new boolean[9][9], block = new boolean[9][9];// 創空間
        for (int pos=0; pos<81; pos++){
            if (d[pos] != 0){ // 題目已經填入數字了, 標記為true
            // row[pos/9][d[pos]-1]: 第幾列的第幾個數字
            // col[pos%9][d[pos]-1]: 第幾行的第幾個數字
            // block[m[pos]][d[pos]-1]: block中的第幾行第幾列
                row[pos/9][d[pos]-1] = col[pos%9][d[pos]-1] = block[m[pos]][d[pos]-1] = true;
            }
        }
        findSol(m, d, 0, row, col, block);
    }
    // map: 每個位置所屬的區塊
    // data: 每個位置已填入的數字, 0代表未填, 1~9表示已填
    // pos: 我負責哪個位置(從0開始)
    // row: boolean[9][9],row[r][d]代表第r個row的數字d是否有用過, true用過了, false沒用過
    // col: boolean[9][9],col[c][d]代表第c個col的數字d是否有用過, true用過了, false沒用過
    // block: boolean[9][9],col[b][d]代表第b個block的數字d是否有用過, true用過了, false沒用過
    public static void findSol(int[] map, int[] data, int pos, boolean[][] row, boolean[][] col, boolean[][] block){
        if (pos == 81){ // 前面的同學都幫我填完了阿
            // print data
            for (int i=0; i<81; i++){
                // System.out.print((i+1)%9==0?data[i]+"/n":data[i]);
                // 如果輸完一列, 就換列
                System.out.print(data[i]);
                if ((i+1)%9 ==0)
                    System.out.println();
            }
            return; // 回上一步
        }
        if (data[pos] == 0){ // 此位置空白
            for (int d=1; d<=9; d++){
                // d-1: 陣列範圍是0~1, 所以要-1, 才能找到正確位置
                if (row[pos/9][d-1]==false && col[pos%9][d-1]==false && block[map[pos]][d-1]==false){ // if 可填入數字 d, that is pos所屬的row, col, block其數字d燈沒填過
                    data[pos] = d; // 在data[pos]放入數字
                    row[pos/9][d-1] = col[pos%9][d-1] = block[map[pos]][d-1] = true; // 放入數字後的位置, 標記為true
                    findSol(map, data, pos+1, row, col, block); // 換測下一個位置
                    data[pos] = 0; // 復原空白
                    row[pos/9][d-1] = col[pos%9][d-1] = block[map[pos]][d-1] = false; // 標記復原
                }
            }
        }else
            findSol(map, data, pos+1, row, col, block); // 此位置已有數字, 就換測下一個位置
    }
    public static void main(String[] argv){
        Scanner input = new Scanner(System.in);
        findSol(input.next(), input.next());
    }
}