package Nagaro;

public class Main
{
    public static int numDecodings(String input) {
        int n=input.length();
        int[] dp=new int[n+1];
        dp[n]=1;
        if(input.charAt(n-1)!='0'){       //if the last chararcter is not zero then we have one way to decode it
            dp[n-1]=1;
        }
        for(int i=n-2;i>=0;i--){
            dp[i]=0;
            if(input.charAt(i)!='0'){
                dp[i]+=dp[i+1];
            }
            if(input.charAt(i)=='1'){
                dp[i]+=dp[i+2];
            }
            if(input.charAt(i)=='2'){
                if(input.charAt(i+1)<='6'){
                    dp[i]+=dp[i+2];
                }
            }
        }
        return dp[0];
    }
  public static void main(String[] args) {
      String s="121";
    System.out.println("The number of ways to decode the given string is: "+numDecodings(s));
  }
}
