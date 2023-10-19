import kotlin.math.pow

fun main(args: Array<String>) {
    val arr = intArrayOf(1,2,5)
    println(canPartition(arr))
    val n = 5
    println(pascalTriangle(n))
}

fun smallestNonNeg(arr: IntArray, N: Int) {
    var smNonNeg = 0
    val hash = BooleanArray(N + 1) { false }

    for (i in 0 until N) {
        if (arr[i] >= 0 && arr[i] < N) {
            hash[arr[i]] = true
        }

        while (hash[smNonNeg]) {
            smNonNeg++
        }

        print("$smNonNeg ")
    }
}

fun minNumberForEach(arr:Array<Int>):List<Int>{
    var maxInArr = 1
    var minInArr = 0
    var resultArr = mutableListOf<Int>()

    for(i in arr.indices){
        if (arr[i] != minInArr){
            resultArr.add(minInArr)
            if (arr[i] > maxInArr){
                maxInArr = arr[i]
            }
        }
        else{
            minInArr = maxInArr +1
            resultArr.add(minInArr)
        }
    }
    return resultArr
}

fun findMaxJumps(arr:IntArray):Int{
    var maxJumps = 0
    var currentJumps = 0

    for(i in arr.indices){
        if (i==0||arr[i]>arr[i-1]){
            currentJumps++
        }else{
            maxJumps = maxOf(maxJumps,currentJumps)
            currentJumps = 1
        }
    }
    return maxOf(maxJumps,currentJumps)
}

//leetcode 1143
fun longestCommonSubsequence(text1: String, text2: String): Int {
    val dp = Array(text1.length + 1) { IntArray(text2.length + 1) }

    for (i in text1.length - 1 downTo 0) {
        for (j in text2.length - 1 downTo 0) {
            if (text1[i] == text2[j]) {
                dp[i][j] = 1 + dp[i + 1][j + 1]
            } else {
                dp[i][j] = maxOf(dp[i][j + 1], dp[i + 1][j])
            }
        }
    }

    return dp[0][0]
}
//leetcode413
fun canPartition(nums: IntArray): String {
    val sum = nums.sum()
    if (sum % 2 != 0) {
        return "NO"
    }

    val dp = mutableSetOf<Int>()
    dp.add(0)
    val target = sum / 2

    for (i in nums.indices.reversed()) {
        val nextDP = mutableSetOf<Int>()
        for (t in dp) {
            if (t * nums[i] == target) {
                return "YES"
            }
            nextDP.add(t + nums[i])
            nextDP.add(t)
        }
        dp.clear()
        dp.addAll(nextDP)
    }

    return if (target in dp) "YES" else "NO"
}
//leetcode118
fun pascalTriangle(numRows: Int): List<List<Int>> {
    val res = mutableListOf<List<Int>>()

    if (numRows <= 0) {
        return res
    }

    res.add(listOf(1))

    for (i in 1 until numRows) {
        val prevRow = res[i - 1]
        val currRow = mutableListOf<Int>()
        currRow.add(1)

        for (j in 1 until i) {
            currRow.add(prevRow[j - 1] + prevRow[j])
        }

        currRow.add(1)
        res.add(currRow)
    }

    return res
}



















