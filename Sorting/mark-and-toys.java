import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int maximumToys(int[] prices, int k) {
        for(int i=1;i<prices.length;i++){
            int value = prices[i];
            int j = i-1;
            while(j>=0 && prices[j] > value){
                prices[j+1] = prices[j];
                j = j-1;
            }
            prices[j+1] = value;
        }
        int count =0;
        while(k>0){
            k -= prices[count];
            count++;
        }
        return count-1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] prices = new int[n];
        for(int prices_i = 0; prices_i < n; prices_i++){
            prices[prices_i] = in.nextInt();
        }
        int result = maximumToys(prices, k);
        System.out.println(result);
        in.close();
    }
}
