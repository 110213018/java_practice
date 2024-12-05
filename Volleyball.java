// �m�W: ���Ŷ{
// �Ǹ�: 110213018
import java.util.Scanner;
public class Volleyball{
    public static void main(String[] argv){
        Scanner input = new Scanner(System.in);
        // A: A����l�y���I��
        // B: B����l�y���I��
        // n: ��n��
        // win: �����o��
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
        // ��X���ɫe
        System.out.println("Before:");
        // ��XA������(�n�qlist���̫�@�Ӷ}�l)
        for (int i=5; i>=0; i--){
            // �C�ӭI���иɪťզܨC�ӭI���L�X���O�T��
            System.out.print(String.format("%3s",A[i]));
            // �Ĥ@�G�C�駹�n����
            if (i%3==0)
                System.out.println();
        }
        // ��X�y��
        System.out.println("===========");
        // ��XB������(�n�qlist���Ĥ@�Ӷ}�l)
        for (int i=0; i<6; i++){
            // �C�ӭI���иɪťզܨC�ӭI���L�X���O�T��
            System.out.print(String.format("%3s",B[i]));
            // �Ĥ@�G�C�駹�n����
            if (i==2 || i==5)
                System.out.println();
        }
        System.out.println(0+":"+0); // ��X���ɫe���
        // At: A�����W
        // Bt: B�����W
        // Apoint: A���o��
        // Bpoint: B���o��
        String At = new String("A");
        String Bt = new String("B");
        int Apoint = 0, Bpoint = 0;
        for (int i=0; i<n; i++){
            // �p�GB�o��A�N��,�B���s��
            if (win[i].equals(Bt) && !win[i].equals(win[i-1])){
                B = newList(B);
                Bpoint++;
            }
            // �p�GA�o���B���O�Ĥ@�y�B���s��, A���N����l��[��
            else if (win[i].equals(At) && i!=0 && !win[i].equals(win[i-1])){
                A = newList(A);
                Apoint++;
            }
            // �p�GA�o���B���Ĥ@�y�B�s��, A��������l���[��
            else if ((win[i].equals(At) && i==0) || (win[i].equals(At) && win[i].equals(win[i-1]))){
                Apoint++;
            }
            // �p�GB�o���B���Ĥ@�y�B�s��, B��������l���[��
            else if ((win[i].equals(Bt) && i==0) || (win[i].equals(Bt) && win[i].equals(win[i-1]))){
                Bpoint++;
            }
        }
        // ��X���ɫ�
        System.out.println("After:");
        // ��XA������(�n�qlist���̫�@�Ӷ}�l)
        for (int i=5; i>=0; i--){
            // �C�ӭI���иɪťզܨC�ӭI���L�X���O�T��
            System.out.print(String.format("%3s",A[i]));
            // �Ĥ@�G�C�駹�n����
            if (i%3==0)
                System.out.println();
        }
        // ��X�y��
        System.out.println("===========");
        // ��XB������(�n�qlist���Ĥ@�Ӷ}�l)
        for (int i=0; i<6; i++){
            // �C�ӭI���иɪťզܨC�ӭI���L�X���O�T��
            System.out.print(String.format("%3s",B[i]));
            // �Ĥ@�G�C�駹�n����
            if (i==2 || i==5)
                System.out.println();
        }
        // ��X�̫���
        System.out.println(Apoint+":"+Bpoint);
    }
    // ����l
    public static int[] newList(int[] data){
        // result: �񴫦�l���᪺list
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