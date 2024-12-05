// �m�W: ���Ŷ{
// �Ǹ�: 110213018
// �ۦ�ƿW
// input: 81 ints between 0-8 ��ܨC�Ӧ�m���ݪ��϶�
// then 81 ints ��ܨC�Ӧ�m�w�����Ʀr, �Y�L�i���N��J���ť�, �h�H0���
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
    // m: ����d��
    // d: �ƿW�W�s�b���Ʀr, 0�N���欰�Ů�
    public static void findSol(String map, String data){
        int[] m = new int[81];
        int[] d = new int[81];
        for (int i=0; i<81; i++){
            m[i] = map.charAt(i) - '0'; // ��char�ܦ�int EX: '0'-'0'=0
            d[i] = data.charAt(i) - '0';
        }
        boolean[][] row = new boolean[9][9], col = new boolean[9][9], block = new boolean[9][9];// �ЪŶ�
        for (int pos=0; pos<81; pos++){
            if (d[pos] != 0){ // �D�ؤw�g��J�Ʀr�F, �аO��true
            // row[pos/9][d[pos]-1]: �ĴX�C���ĴX�ӼƦr
            // col[pos%9][d[pos]-1]: �ĴX�檺�ĴX�ӼƦr
            // block[m[pos]][d[pos]-1]: block�����ĴX��ĴX�C
                row[pos/9][d[pos]-1] = col[pos%9][d[pos]-1] = block[m[pos]][d[pos]-1] = true;
            }
        }
        findSol(m, d, 0, row, col, block);
    }
    // map: �C�Ӧ�m���ݪ��϶�
    // data: �C�Ӧ�m�w��J���Ʀr, 0�N����, 1~9��ܤw��
    // pos: �ڭt�d���Ӧ�m(�q0�}�l)
    // row: boolean[9][9],row[r][d]�N���r��row���Ʀrd�O�_���ιL, true�ιL�F, false�S�ιL
    // col: boolean[9][9],col[c][d]�N���c��col���Ʀrd�O�_���ιL, true�ιL�F, false�S�ιL
    // block: boolean[9][9],col[b][d]�N���b��block���Ʀrd�O�_���ιL, true�ιL�F, false�S�ιL
    public static void findSol(int[] map, int[] data, int pos, boolean[][] row, boolean[][] col, boolean[][] block){
        if (pos == 81){ // �e�����P�ǳ����ڶ񧹤F��
            // print data
            for (int i=0; i<81; i++){
                // System.out.print((i+1)%9==0?data[i]+"/n":data[i]);
                // �p�G�駹�@�C, �N���C
                System.out.print(data[i]);
                if ((i+1)%9 ==0)
                    System.out.println();
            }
            return; // �^�W�@�B
        }
        if (data[pos] == 0){ // ����m�ť�
            for (int d=1; d<=9; d++){
                // d-1: �}�C�d��O0~1, �ҥH�n-1, �~���쥿�T��m
                if (row[pos/9][d-1]==false && col[pos%9][d-1]==false && block[map[pos]][d-1]==false){ // if �i��J�Ʀr d, that is pos���ݪ�row, col, block��Ʀrd�O�S��L
                    data[pos] = d; // �bdata[pos]��J�Ʀr
                    row[pos/9][d-1] = col[pos%9][d-1] = block[map[pos]][d-1] = true; // ��J�Ʀr�᪺��m, �аO��true
                    findSol(map, data, pos+1, row, col, block); // �����U�@�Ӧ�m
                    data[pos] = 0; // �_��ť�
                    row[pos/9][d-1] = col[pos%9][d-1] = block[map[pos]][d-1] = false; // �аO�_��
                }
            }
        }else
            findSol(map, data, pos+1, row, col, block); // ����m�w���Ʀr, �N�����U�@�Ӧ�m
    }
    public static void main(String[] argv){
        Scanner input = new Scanner(System.in);
        findSol(input.next(), input.next());
    }
}