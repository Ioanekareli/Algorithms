package leetcode

class leetcode {

//    leetcode67
    fun addBinary(a: String, b: String): String {
        val revA = a.reversed()
        val revB = b.reversed()
        var result = ""
        var carry = 0
        for (i in 0 until revA.length.coerceAtLeast(revB.length)) {
            var sum = carry
            if (i < revA.length) sum += revA[i] - '0'
            if (i < revB.length) sum += revB[i] - '0'
            carry = sum / 2
            result += (sum % 2).toString()
        }
        if (carry > 0) result += "1"
        return result.reversed()
    }

//    leetcode41
    fun firstMissingPositive(nums: IntArray): Int {
        var i = 0

        while (i < nums.size) {
            val index = nums[i] - 1
            if (index in nums.indices && nums[index] != nums[i])
                nums[i] = nums[index].also { nums[index] = nums[i] }
            else
                i++
        }

        for (i in nums.indices) {
            if (nums[i] != i + 1)
                return i + 1
        }

        return nums.size + 1
    }

//    leetcode 724 :)
    fun pivot(arr:IntArray):String{
        val sum = arr.sum()
        var leftSum = 0
        for (i in arr.indices){
            val rightSum = sum -arr[i]-leftSum
            if (leftSum == rightSum){
                return "YES"
            }
            leftSum += arr[i]
        }
        return "NO"
    }

//    leetcode136
    fun singleNumber(numbers: List<Int>): Int {
        var res = 0
        for (num in numbers) {
            res = res xor num
        }
        return res
    }

//    leetcode 1281
    fun subtractProductAndSum(n: Int): Int {
        val digits = n.toString().map {
            it.toString().toInt()
        }
        var sum = sum(digits)
        var multiply = multiplication(digits)
        var result = multiply-sum
        return result
    }
    var sum:(List<Int>) -> Int = { list->
        var sum = 0
        for (i in list){
            sum+=i
        }
        sum
    }
    var multiplication:(List<Int>) -> Int = { list->
        var multiply = 1
        for (i in list){
            multiply*=i
        }
        multiply
    }



//    leetcode1920
//    public int[] buildArray(int[] nums) {
//        int n = nums.length;
//        int[] arr = new int[n];
//        for(int i = 0; i < n; i++){
//            arr[i] = nums[nums[i]];
//        }
//        return arr;
//    }

}