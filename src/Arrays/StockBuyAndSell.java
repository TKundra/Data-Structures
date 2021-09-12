package Arrays;

public class StockBuyAndSell {

    static int maxProfit(int[] prices, int start, int end){
        // if stock and be bought
        if (end<=start)
            return 0;
        // initial profit
        int profit = 0;
        // the day at which stock must be bought
        for (int i=start; i<end; i++){
            // the day at which stock must be sold
            for (int j=i+1; j<=end; j++){
                // if buying the stock at ith day and selling
                // it at jth day is profitable
                if (prices[j]>prices[i]){
                    // update current profit
                    int curr_profit = prices[j] - prices[i] +
                            maxProfit(prices, start, i-1) +
                            maxProfit(prices, j+1, end);
                    // update max profit so far
                    profit = Math.max(profit,curr_profit);
                }
            }
        }
        return profit;
    }

    // better
    static int maxProfit(int[] price){
        int n = price.length;
        // keep track of profit
        int profit = 0;
        // local minimum to the first element's index
        int j = 0;
        // start from 2nd element
        for (int i=1; i<price.length; i++){
            // update the local min if a decreasing sequence is found
            if (price[i-1]>price[i])
                j=i;
            // sell shares if current element is the peak
            // i.e (previous <= current > next
            if (price[i-1]<=price[i] && (i+1==price.length || price[i]>price[i+1])){
                profit += (price[i]-price[j]);
                System.out.printf("buy on day %d and sell on day %d\n",j+1,i+1);
            }
        }
        return profit;
    }

    public static void main(String[] args){
        int[] array = {100,180,260,310,40,535,695}; //1
        //System.out.println(maxProfit(array,0,array.length-1));
        System.out.println(maxProfit(array));
    }
}
