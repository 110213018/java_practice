// �m�W: ���Ŷ{
// �Ǹ�: 110213018
import java.util.Scanner;
public class BarGraph{
    // n: �����Ϫ�x�b���X�ӼƦr
    // data: �b�����ϤW��ܪ��ƭ�
    public static void main(String[] argv){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] data = new int[n];
        for (int i=0; i<n; i++)
            data[i] = input.nextInt();
        findRow(n, data);
    }
    // ��Xy�b���̰���(data���̰���+2)
    // row: y�b���̰���
    public static void findRow(int n, int[] data){
        int row = 0;
        for (int i=0; i<n; i++){
            if (data[i]>row) // ����j�p, �̤j���ܦ�row
                row = data[i];
        }
        row = row + 2;
        findGraph(n, data, row);
    }
    public static void findGraph(int n, int[] data, int row){
        for (int r=row; r>0; r--){
            for (int c=0; c<n; c++){
                if (c==0){ // ��Xy�b
                    // ��o��y�b���Ȧ�Ƥ�y�b���̰��ȤִN��0, �A��Xy�b���ȸ�ť�; �Ϥ�, �u�n��X�b���ȸ�ť�
                    if (r/10 < 1){
                        System.out.print("0"+ r +" ");
                    }else{
                        System.out.print( r +" ");
                    }
                }
                // ��X##�M..
                // �p�Gdata[i]<y�b����, �N��X..; �Ϥ�, ��X##
                if(data[c]<r)
                    System.out.print(".."+" ");
                else
                    System.out.print("##"+" ");
            }
            System.out.println(); // �駹�@�C�N����
        }
        // ��Xx�b
        // ��o��x�b���Ȧ�Ƥ�x�b���̰��ȤִN��0, �A��Xx�b���ȸ�ť�; �Ϥ�, �u�n��Xx�b���ȸ�ť�
        for (int i=0; i<=n; i++){
            if (i/10 < 1)
                System.out.print("0"+i+" ");
            else
                System.out.print(i+" ");
        }
    }
}