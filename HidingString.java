// �m�W: ���Ŷ{
// �Ǹ�: 110213018
import java.util.Scanner;
public class HidingString{
    public static void main(String[] argv){
        // n: n��r�� / n�ӼƦr
        // data: �r��
        // num: �n���C��r��(�Ĥ@��}�l�̧ǩ��U)���ĴX�Ӧr
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String[] data = new String[n];
        int[] num = new int[n];
        for (int i=0; i<n; i++)
            data[i] = input.next();
        for (int i=0; i<n; i++)
            num[i] = input.nextInt();
        findString(n, data,  num);
    }
    // ��X�N�Ʀr������r�ꤧ�᪺���G
    public static void findString(int n, String[] data, int[] num){
        for (int i=0; i<n; i++){
            char CharInString = data[i].charAt(num[i]); // ��X�o�Ӧr�ꪺ�ĴX�Ӧr
            System.out.print(CharInString); // �C���@�ӼƦr������r�ꤧ�᪺���G, �N��X(���ഫ��)
        }
    }
}