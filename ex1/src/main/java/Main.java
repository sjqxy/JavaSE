import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();

        int b = sc.nextInt();
        List<int[]> re=solution(a,b);
        re.forEach(res ->{
            System.out.println(res[0]+" "+res[1]+" "+res[2]);
        });
    }

    private static List<int[]> solution(int a, int b) {
        List res = new ArrayList();
        for (int i = a; i <b-2 ; ++i) {
            for (int j = i+1; j <b-1 ; ++j) {
                double c = Math.sqrt(Math.pow(i,2)+Math.pow(j,2));
                long c2= (long) c;

                if (c-c2==0&&c<=b&&isPrim(i,j)&&isPrim(i,(int)c)&&isPrim(j,(int)c)){
                    res.add(new int[]{i,j,(int) c});
                }else if(c>b){
                    break;
                }

            }

        }
        return res;
    }

    private static boolean isPrim(int i, int j) {
        if (i<j){
            int temp=i;
            i=j;
            j=temp;

        }
        int c ;
        while ((c=i%j)!=0){
            i=j;
            j=c ;

        }
        return j==1;
    }
}
