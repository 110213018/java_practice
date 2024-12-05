// �m�W:���Ŷ{
// �Ǹ�:110213018
import java.util.Scanner;
public class Fruit{
    public static void main(String[] argv){
        Scanner input = new Scanner(System.in);
        // money: �{���{��
        // n: ���h�������G�n�R
        // species: �n�R�X�ؤ��G
        // prices: ���G������(��ư}�C)
        int money = input.nextInt(), n = input.nextInt(), species = input.nextInt();
        int[] prices = new int[species]; // �зs�Ŷ�
        for (int i=0; i<species; i++) // �b�Ŷ����C�Ӧ�m����J���G����(���)
            prices[i] = input.nextInt();
        System.out.println(findSol(money, n, species, prices)); // ��X���X�ظѵ�
    }
    // return true if found solution, otherwise false
    public static int findSol(int money, int n, int species, int[] prices){
        return findSol(money, n, species, prices, 0, new int[species]);
    }
    // kind:�ڭt�d�R�����G����
    // result:���G�x���C�@�����G�R�n���ƶq
    // return true if found at least one solution, false otherwise
    public static int findSol(int money, int n, int species, int[] prices, int kind, int[] result){
        if (n==0){ // �R���F(�䧹�@�ضR�k����, �N�^��1, ��found+1)
            return 1;
        }
        // �ƻ�����䤣��ѵ�(found+0)
        if (kind == species) // �S�����G�i�H�R�F
            return 0;
        int found = 0; // ���X�ظѵ�
        // ���ڶRkind�o�ؤ��G, �ڦ��X�ضR�k
        for (int c=0; c<= (money/prices[kind]<=n?money/prices[kind]:n); c++){ // buy this kind c fruits
            result[kind] = c; // �O���R�Fkind���Gc��
            found += findSol( money-c*prices[kind], n-c, species, prices, kind+1, result); // �C���@�ضR�k, found+1(26��))
            result[kind] = 0; // �䧹�@�ضR�k����, �O���R�Fkind���G0��(�]���n��U�@�ӶR�k, �ҥH�O�����W0)
        }
        return found; // �^�ǧ��X�ظѵ�
    }
}