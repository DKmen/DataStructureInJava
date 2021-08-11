package codechef.JulyLongChallenge;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class XxOoRr {
    public static void main(String arr[]) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        while (testCase-- > 0) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            int array[] = new int[N];
            int P = 0;
            int Step = 0;
            for (int i = 0; i < array.length; i++) {
                array[i] = sc.nextInt();
            }
            HashMap<Integer, Integer> mapData = new HashMap<Integer, Integer>();
            for(int i=0;i<array.length;i++){
                String data=Integer.toBinaryString(array[i]);
                for(int j=data.length()-1;j>=0;j--){
                    if(data.charAt(j)=='1'){
                        if(mapData.containsKey(data.length()-j-1)){
                            mapData.put(data.length()-j-1,(mapData.get(data.length()-j-1)+1));
                        }else{
                            mapData.put(data.length()-j-1,1);
                        }
                    }
                }
            }
            for(Map.Entry m : mapData.entrySet()){
                if((int)m.getValue()%K==0){
                    Step+=((int)m.getValue()/K);
                }else{
                    Step+=((int)m.getValue()/K)+1;
                }
            }
            System.out.println(Step);
        }
    }
}
