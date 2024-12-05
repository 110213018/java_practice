// �m�W: ���Ŷ{
// �Ǹ�: 110213018
import java.util.Scanner;
public class Fold{
    public static void main(String[] argv){
        Scanner input = new Scanner(System.in);
        int row = input.nextInt(), col = input.nextInt(), d = input.nextInt(); // row:�X�C col:�X�� d:�P�|�X��
        int[][] data = new int[row][col]; // �ǳ�row�Ccol�檺�}�C�Ŷ�, data: �}�C�W�r
        // ��Jrow�Ccol�檺����
        for(int r = 0; r < row; r++){
            for (int c = 0; c < col; c++)
                data[r][c]=input.nextInt();
        }
        int[] op = new int[d]; // �ǳƪ��׬�d���}�C�Ŷ�, op:����V
        // ��Jop���}�C
        for(int i = 0; i < d; i++){
            op[i]=input.nextInt();
        }
        findAns(row, col, d, data, op);
    }
    public static void findAns(int row, int col, int d, int[][] data, int[] op){
        for (int i = 0; i < op.length; i++){ // ����op�}�C�����ǧ��|
            if (op[i] == 0){ // �p�G�O�W�U�P�|,�N����
                int[][] newData = new int[(row+1)/2][col]; // �ǳƤW�U�P�|�L�᪺�}�C�Ŷ�( (row+1)/2 : �W�U�P�|�L�᪺�C����)
                for (int r = 0; r < ((row+1)/2); r++){ 
                    for (int c = 0; c < col; c++)
                        if (r+1!=(row/2)+1){ // �p�G���O�������@�C�N�[, newData[r][c]: �Ψө�[�L���Ʀr
                            newData[r][c] = data[r][c]+data[row-r-1][c]; // data[row-r-1][c]: �P�|�L��������Ʀr
                        }else{ // �p�G�O�������@�C�N���Υ[, �Ʀr���newData[r][c]�x�s
                            newData[r][c] = data[r][c]; // �Ʀr����
                        }
                }
                data = newData; // �P�|�L�᪺���, �ܦ^data, �~���~��P�|�ۥ[
                row = (row + 1)/2; // �W�U�P�|�L�᪺���row�n��b
            }else{ // �p�G�O���k�P�|�N����
                int[][] newData = new int[row][(col+1)/2]; // �ǳƥ��k�P�|�L�᪺�}�C�Ŷ�
                for (int r = 0; r < row; r++){
                    for (int c = 0; c < ((col+1)/2); c++)
                        if (c+1!=(col/2)+1){ // �p�G���O�������@��N�[, newData[r][c]: �Ψө�[�L���Ʀr
                            newData[r][c] = data[r][c]+data[r][col-c-1]; // data[r][col-c-1]: �P�|�L��������Ʀr 
                        }else{// �p�G�O�������@��N���Υ[, �Ʀr���newData[r][c]�x�s
                            newData[r][c] = data[r][c]; // �Ʀr����
                        }
                }
                data = newData;// �P�|�L�᪺���, �ܦ^data, �~���~��P�|�ۥ[
                col = (col + 1)/2; // ���k�P�|�L�᪺���col�n��b
            }
        }
        // ��X����
        for(int r = 0; r < row; r++) { 
            for(int c = 0; c < col; c++) 
                System.out.print(data[r][c] + " "); // �@�C�@�C��X, �M��Ʀr�����n�j�@�Ӫť�
            System.out.println(); // �Ĥ@�C�駹, �U�@�C�n���C(println: ���C��X)
        } 
    }
}