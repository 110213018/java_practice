// ﹎:朝秢
// 畒腹:110213018
import java.util.Scanner;
public class NaNb{
    public static void main (String [] argv ){
        // ori: タ絋计
        // num: 块きΩ璶瞦计
        Scanner input = new Scanner(System.in);
        String ori = input.next();
        String[] num = new String[5];
        for (int i=0; i<5; i++){
            findNaNb(ori, input.next());
        }
    }
    public static void findNaNb(String ori, String num){
        // aNum:瞦计蛤タ絋计Τ单竚妓计 计秖
        // bNum:狦瞦计蛤タ絋计Τ单竚ぃ妓计 计秖
        int aNum=0;
        int bNum=0;
        // рString锣int皚
        // intOri: タ絋计(俱计皚)
        // intNum: 瞦计(俱计皚)
        int[] intOri = new int[4];
        int[] intNum = new int[4];
        for (int v=0; v<4; v++){
            // 盢じ锣Θ俱计
            intOri[v] = ori.charAt(v) - '0';
            intNum[v] = num.charAt(v) - '0';
        }
        for (int i=0; i<4; i++){
            for (int j=0; j<4; j++){
                // 狦瞦计蛤タ絋计Τ单竚妓计, aNum+1
                if( intOri[i]==intNum[j] && i==j)
                    aNum+=1;
                // 狦瞦计蛤タ絋计Τ单竚ぃ妓计, bNum+1
                if (intOri[i]==intNum[j] && i!=j)
                    bNum+=1;
            }
        }
        // 块碭a碭b
        System.out.println(aNum+"A"+bNum+"B");
    }
}