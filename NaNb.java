// �m�W:���Ŷ{
// �y��:110213018
import java.util.Scanner;
public class NaNb{
    public static void main (String [] argv ){
        // ori: ���T���Ʀr
        // num: ��J�����n�q���Ʀr
        Scanner input = new Scanner(System.in);
        String ori = input.next();
        String[] num = new String[5];
        for (int i=0; i<5; i++){
            findNaNb(ori, input.next());
        }
    }
    public static void findNaNb(String ori, String num){
        // aNum:�q���Ʀr�򥿽T���Ʀr���۵��B��m�@�˪��� ���ƶq
        // bNum:�p�G�q���Ʀr�򥿽T���Ʀr���۵�����m���@�˪��� ���ƶq
        int aNum=0;
        int bNum=0;
        // ��String�ରint�}�C
        // intOri: ���T���Ʀr(��ư}�C)
        // intNum: �q���Ʀr(��ư}�C)
        int[] intOri = new int[4];
        int[] intNum = new int[4];
        for (int v=0; v<4; v++){
            // �N�r���ন���
            intOri[v] = ori.charAt(v) - '0';
            intNum[v] = num.charAt(v) - '0';
        }
        for (int i=0; i<4; i++){
            for (int j=0; j<4; j++){
                // �p�G�q���Ʀr�򥿽T���Ʀr���۵��B��m�@�˪���, aNum+1
                if( intOri[i]==intNum[j] && i==j)
                    aNum+=1;
                // �p�G�q���Ʀr�򥿽T���Ʀr���۵�����m���@�˪���, bNum+1
                if (intOri[i]==intNum[j] && i!=j)
                    bNum+=1;
            }
        }
        // ��X�Xa�Xb
        System.out.println(aNum+"A"+bNum+"B");
    }
}