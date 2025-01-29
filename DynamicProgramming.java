import java.util.*;
public class dynamicprgm {
    public static void main(String args[]){
        Scanner s =new Scanner(System.in);
        int n=s.nextInt();
        int  ans =0;
        Integer[] dp=new Integer[n+10];
        ans=recfibo(n);
        ans=memo(n,dp);
        ans=tabu(n,dp);
    }
    public static int recfibo(int n,){
        if(n<=1){
            return n;
        }
        //condition before calling

        int sp1=recfibo(n-1,dp);
        int sp2=recfibo(n-2,dp);
        //store values
        dp[n]=sp1+sp2;

    }
    public static int memo(int n,Integer[] dp){
        if(n<=1){
            return n;
        }
        //condition before calling
        if(dp[n]!=null){
            return dp[n];
        }
        int sp1=memo(n-1,dp);
        int sp2=memo(n-2,dp);
        //store values
        dp[n]=sp1+sp2;
        return sp1+sp2;

    }
    public static int tabu(int n,Integer[] dp){
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            int sp1=dp[i-1];
            int sp2=dp[i-2];
            dp[i]=sp1+sp2;
        }
    }
}
