package BOJ.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B6236 {
    static int N, M;
    static int[] money;
    static int myMoney = 0;
    public static void main(String[] args) throws IOException {
        input();
        algo();
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        money = new int[N];
        for (int i = 0; i < N; i++) {
            money[i] = Integer.parseInt(br.readLine());
        }
    }
    public static void algo(){
       int l = 1;
       //ex N = 100000, M = 1, 금액이 10000원이라면? 한번에 10억 출금해야함
       int r = 1000000000;
        for (int i = 0; i < N; i++) {
            //남은 돈은 다시 집어넣고 K원만큼 인출한다. -> 하루에 쓸 돈 이상으로 출금을 해야함
            l = Math.max(l, money[i]);
        }
       int result = 0;

       while (l <= r){
           int mid = (l + r) / 2;
           if(isLife(mid)){
               result = mid;
               r = mid - 1;
           }
           else {
               l = mid + 1;
           }
       }
        System.out.println(result);
    }

    private static boolean isLife(int x) {
        int result = 0;
        for (int i = 0; i < N; i++) {
            if(myMoney >= money[i]){
                myMoney -= money[i];
            }
            else {
                myMoney = x;
                result++;
                while (myMoney - money[i] < 0){
                    myMoney += x;
                    result++;
                }
                myMoney -= money[i];
            }
        }
        myMoney = 0;
        return result <= M;
    }
}
