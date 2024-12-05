// 姓名: 陳宣閔
// 學號: 110213018
import java.util.Scanner;
public class Fold{
    public static void main(String[] argv){
        Scanner input = new Scanner(System.in);
        int row = input.nextInt(), col = input.nextInt(), d = input.nextInt(); // row:幾列 col:幾行 d:摺疊幾次
        int[][] data = new int[row][col]; // 準備row列col行的陣列空間, data: 陣列名字
        // 輸入row列col行的測資
        for(int r = 0; r < row; r++){
            for (int c = 0; c < col; c++)
                data[r][c]=input.nextInt();
        }
        int[] op = new int[d]; // 準備長度為d的陣列空間, op:對折方向
        // 輸入op的陣列
        for(int i = 0; i < d; i++){
            op[i]=input.nextInt();
        }
        findAns(row, col, d, data, op);
    }
    public static void findAns(int row, int col, int d, int[][] data, int[] op){
        for (int i = 0; i < op.length; i++){ // 按照op陣列的順序折疊
            if (op[i] == 0){ // 如果是上下摺疊,就執行
                int[][] newData = new int[(row+1)/2][col]; // 準備上下摺疊過後的陣列空間( (row+1)/2 : 上下摺疊過後的列長度)
                for (int r = 0; r < ((row+1)/2); r++){ 
                    for (int c = 0; c < col; c++)
                        if (r+1!=(row/2)+1){ // 如果不是中間那一列就加, newData[r][c]: 用來放加過的數字
                            newData[r][c] = data[r][c]+data[row-r-1][c]; // data[row-r-1][c]: 摺疊過後相應的數字
                        }else{ // 如果是中間那一列就不用加, 數字丟到newData[r][c]儲存
                            newData[r][c] = data[r][c]; // 數字不變
                        }
                }
                data = newData; // 摺疊過後的資料, 變回data, 才能繼續摺疊相加
                row = (row + 1)/2; // 上下摺疊過後的資料row要砍半
            }else{ // 如果是左右摺疊就執行
                int[][] newData = new int[row][(col+1)/2]; // 準備左右摺疊過後的陣列空間
                for (int r = 0; r < row; r++){
                    for (int c = 0; c < ((col+1)/2); c++)
                        if (c+1!=(col/2)+1){ // 如果不是中間那一行就加, newData[r][c]: 用來放加過的數字
                            newData[r][c] = data[r][c]+data[r][col-c-1]; // data[r][col-c-1]: 摺疊過後相應的數字 
                        }else{// 如果是中間那一行就不用加, 數字丟到newData[r][c]儲存
                            newData[r][c] = data[r][c]; // 數字不變
                        }
                }
                data = newData;// 摺疊過後的資料, 變回data, 才能繼續摺疊相加
                col = (col + 1)/2; // 左右摺疊過後的資料col要砍半
            }
        }
        // 輸出正解
        for(int r = 0; r < row; r++) { 
            for(int c = 0; c < col; c++) 
                System.out.print(data[r][c] + " "); // 一列一列輸出, 然後數字之間要隔一個空白
            System.out.println(); // 第一列輸完, 下一列要換列(println: 換列輸出)
        } 
    }
}