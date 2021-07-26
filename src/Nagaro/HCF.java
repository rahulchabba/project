package Nagaro;

import java.util.LinkedHashMap;
import java.util.Stack;

public class HCF {
     public static void main(String[] args) {
        int size = 3;
        int count =0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(gcd(i,j)==1){
                    count+=1;
                }
            }
        }
        System.out.println(count);
         LinkedHashMap map = new LinkedHashMap();
    }
    static int gcd(int a, int b)
    {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }


}
