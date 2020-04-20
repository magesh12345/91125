import java.io.*; 
  
class FriendsLevel { 
  
    // Returns count of ways n people 
    // can remain single or paired up. 
    static int countFriendsPairings(int n) 
    { 
        int dp[] = new int[n + 1]; 
  
        // Filling dp[] in bottom-up manner using 
        // recursive formula explained above. 
        for (int i = 0; i <= n; i++) { 
            if (i <= 2) 
                dp[i] = i; 
            else
                dp[i] = dp[i - 1] + (i - 1) * dp[i - 2]; 
        } 
  
        return dp[n]; 
    } 
  
    // Driver code 
    public static void main(String[] args) 
    { 
        int n = 4; 
        System.out.println(countFriendsPairings(n)); 
    } 
} 


/*

Input  : n = 3
Output : 4

Explanation
{1}, {2}, {3} : all single
{1}, {2, 3} : 2 and 3 paired but 1 is single.
{1, 2}, {3} : 1 and 2 are paired but 3 is single.
{1, 3}, {2} : 1 and 3 are paired but 2 is single.
Note that {1, 2} and {2, 1} are considered same.

f(n) = ways n people can remain single 
       or pair up.

For n-th person there are two choices:
1) n-th person remains single, we recur 
   for f(n - 1)
2) n-th person pairs up with any of the 
   remaining n - 1 persons. We get (n - 1) * f(n - 2)

Therefore we can recursively write f(n) as:
f(n) = f(n - 1) + (n - 1) * f(n - 2)

*/
