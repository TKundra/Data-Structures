package Dynamic;

public class EditDistance {

    // find min of three
    static int minimum(int a, int b, int c){
        return Integer.min(a, Integer.min(b,c));
    }

    // worst time complexity
    static int distance(String x, int m, String y, int n){
        // base case
        if (m == 0)
            return n;
        if (n == 0)
            return m;
        // if last character of string matched
        int cost = x.charAt(m-1) == y.charAt(n-1) ? 0 : 1;
        return minimum(
                distance(x,m-1,y,n)+1, // deletion
                distance(x,m,y,n-1)+1, // insertion
                distance(x,m-1,y,n-1)+cost // replace
        );
    }

    // better than above
    static int distance(String x, String y, int m, int n){

        // table to store result of sub -problem
        int[][] d = new int[m+1][n+1];

        // fill in bottom up manner
        for (int i=0; i<=m; i++){
            for (int j=0; j<=n; j++){
                // if x is empty, only option is to insert all chars of y
                if (i==0)
                    d[i][j] = j;
                else if (j==0)
                    d[i][j] = i;
                // if last char is same, ignore last and recur for remaining
                else if (x.charAt(i-1) == y.charAt(j-1))
                    d[i][j] = d[i - 1][j - 1];
                // if last is different consider all possibilities and fin min
                else {
                    d[i][j] = 1 + minimum(
                            d[i][j-1], // insert
                            d[i-1][j], // remove
                            d[i-1][j-1] // replace
                    );
                }

            }
        }
        return d[m][n];
    }

    public static void main(String[] args) {
        String x = "cart";
        String y = "march";
        System.out.println(distance(x,y,x.length(),y.length()));
    }

}
