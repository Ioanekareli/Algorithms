package convertation

class Numbers {
    fun numberToDigits(num: Int): List<Int> {
        return num.toString().map { it.toString().toInt() }
    }

//    this func calculates persistence,
//    which means ,number of times you need to multiply the digits of a number
//    until you reach a single digit.
    fun persistence(num: Int): Int {
        var num = num
        var count = 0
        while (num >= 10) {
            val digits = numberToDigits(num)
            num = digits.reduce { a, b -> a * b }
            count++
        }
        return count
    }

    fun decompose(m:Int):String {
        var n = m
        val res = mutableListOf<Int>()
        for (i in 2..n){
            while (n % i == 0){
                res+=i
                n/=i
            }
        }
        return res.toString()
    }

    fun multiplicationTable(size: Int): Array<IntArray> {
//    1|2|3 |4 |5  ---> first arr
//    2|4|6 |8 |10 ---> second arr
//    3|6|9 |12|15 ---exmp --->12=8*(9/6)
//    4|8|12|16|20 ---exmp --->8=6*(4/3)--->fourth_arr[1]=third_arr[1]*(fourth_arr[0]/third_arr[0])--->
//    second_arr_ellements=first_arr_elements*(second_arr[0]/first_arr[0])
        val arr = Array(size){IntArray(size)}
        for (i in 0 until size){
            for (j in 0 until size){
                arr[i][j] = (i+1)*(j+1)
            }
        }
//    matrics ---> arr[0][0] = [1][1]
//                 arr[0][1] = [1][2]
//                 arr[0][n] = [0+1][n+1] = [1][(0+1)*(n+1)--->(n+1)]
        return arr
    }

}