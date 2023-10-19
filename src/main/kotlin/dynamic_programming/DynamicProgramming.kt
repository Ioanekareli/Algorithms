package dynamic_programming

class DynamicProgramming {

    fun climbingStairs(n: Int): Int {
        val n = n
        var one = 1
        var two = 1
        var temp:Int

        for(i in 1 until n) {
            temp = one
            one += two
            two = temp
        }
        return one
    }

    fun climbingStairs2(n:Int):Int{
        return fib(n+1)
    }

    fun fib(n:Int):Int{
        val n = n
        return if (n<=1){
            n
        }
        else{
            fib(n-1)+fib(n-2)
        }
    }

//    leetcode 322
    fun coinChange(amount:Int): Int {
        val coins = arrayOf(1,5,10,20,50)
        val dp = IntArray(amount + 1) {amount +1}
        dp[0] = 0

        for (a in 1..amount){
            for (c in coins){
                if (a - c >= 0) dp[a] = minOf(dp[a],1+dp[a-c])
            }

        }
        return if (dp[amount] != amount + 1) dp[amount] else -1
    }

}