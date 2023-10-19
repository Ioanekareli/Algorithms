package sequences

class Sequence {

    fun tribonacci(signature: DoubleArray,n:Int):DoubleArray{
        if (n<3){
            return doubleArrayOf()
        }
        val sign = DoubleArray(n-3)
        val result = signature+sign
        for (i in 3 until n){
            result[i] = result[i-1]+result[i-2]+result[i-3]
        }
        return result
    }

    fun geometricSequenceElements(a: Int, r: Int, n: Int): String {
        var sum = a * r
        var n = n - 2
        var str = "$a, $sum, "
        while (n > 0) {
            sum *= r
            str += "$sum, "
            n -= 1
        }

        return str.substring(0, str.length - 2)
    }

    fun summation(n:Int):Int {
//    f(n)=n+n-1+n-2..1
//    f(5)=5+(5-1)+(5-2)+(5-3)+(5-4)=5+4+3+2+1
//    f(5)=n+(n-1)+(n-2)+(n-3)+(n-4)=5+4+3+2+1 =
//    n+(4n-1-2-3-4)=
//    5n-10=
//    5n-f(4)=
//    f(n) = n*n-f(n-1)
        return when(n){
            0 -> 0
            1 -> 1
            else -> n*n-summation(n-1)
        }
    }
}