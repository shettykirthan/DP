package isSubSet;

public class isSubSetRecursion {
    public static void main(String[] args) {
        System.out.println(isSubsetSum(new int[]{3, 34, 4, 12, 5}, 9));
    }

    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        return help(arr , sum , arr.length);
    }
    static Boolean help(int[] arr , int W , int n){
        if(n == 0 || W == 0) return false;
        if(W - arr[n-1] == 0){
            return true;
        }
        else if(W - arr[n-1] > 0){
            return help(arr , W - arr[n-1] , n-1) || help(arr , W , n-1);
        }
        else return help(arr , W , n-1);
    }
}