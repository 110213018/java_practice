// �m�W: ���Ŷ{
// �Ǹ�: 110213018
import java.util.Scanner;
public class Checkers{
    // n: �ѽL�j�p
    // block: �L��
    // row: �_�I��m(�C)
    // col: �_�I��m(��)
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
        b[r][c] = 0; // �_�I
        // ����X��m�i�ܰʤ�V
        // ro = 1, -1, 0, 0, 1, 1, -1, -1   CF: 1=�U, -1=�W
        // co = 0, 0, 1, -1, 1, -1, 1, -1   CF: 1=�k, -1=��
        // ��m�ܰʤ�V      �U �W  �k �� �k�U ���U �k�W ���W
        int[] ro = new int[]{1, -1, 0,  0, 1,  1, -1, -1};
        int[] co = new int[]{0,  0, 1, -1, 1, -1,  1, -1};
        // ��X�i�ŦX����recursion���e
        // 0<= r+2*ro[i] <n           ���U�h����m����W�Lor�p��n������
        // 0<= c+2*co[i] <n           ���U�h����m����W�Lor�p��n������
        // b[r+ro[i]][c+co[i]]==1      �D�L�h���Ѭ�1(���Ѥl)
        // b[r+2*ro[i]][c+2*co[i]]==0  ���U�h����m��0(�S���Ѥl)
        int maxLen = 0; // �̪�������
        int thisLen = 0; // �{�b��������
        for (int i=0; i<8; i++){
            if ((0<=r+2*ro[i]) && (r+2*ro[i]<n) && (0<=c+2*co[i]) && (c+2*co[i]<n) && (b[r+ro[i]][c+co[i]]==1) && (b[r+2*ro[i]][c+2*co[i]]==0)){
                b[r+ro[i]][c+co[i]] = 0; // �D�L�h���ѧאּ0
                thisLen = 1 + findAns(n, b, r+2*ro[i], c+2*co[i]);
                // �]���@�ӵ��G����, �}�l�@�B�@�B�_��
                // �^�_�@�B, tL+1, ����^�_�즳�s���u�i�H��, �A�}�l�p��s��tL
                b[r+ro[i]][c+co[i]] = 1; // �N�L���_��
                // ��o����쪺���פ񤧫e��쪺�̤j�����٭n��, maxLen�N���H��
                if (thisLen > maxLen){
                    maxLen = thisLen;
                }
            }
        }
        return maxLen; // �^��
    }
}