package convertation

import kotlin.math.pow

class NumericalSystem {

    //    leetcode 12
    fun toRoman(num: Int): String{
        val numbers = mapOf(
            1000 to "M",
            900 to "CM",
            500 to "D",
            100 to "C",
            90 to "XC",
            50 to "L",
            40 to "XL",
            10 to "X",
            5 to "V",
            1 to "I"
        )
        var num = num
        var str = ""
        for((key,value) in numbers){
            while (num >= key){
                num-=key
                str+=value
            }
        }
        return str
    }

    //    leetcode13
    fun fromRoman(str:String):Int{
        val numbers = mapOf(
            'I' to 1,
            'V' to 5,
            'X' to 10,
            'L' to 50,
            'C' to 100,
            'D' to 500,
            'M' to 1000
        )
        var res = 0
        for (i in str.indices){
            if (i + 1 < str.length && numbers[str[i]]!! < numbers[str[i + 1]]!!){
                res -= numbers[str[i]]!!
            }
            else{
                res+= numbers[str[i]]!!
            }
        }
        return res
    }

    //    from base four to decimal
    fun fromBaseFour(str:String):Int{
        var res = 0
        for (i in str.indices){
            val num = str[(str.length - 1)- i].toString().toInt()
            res += num * 4.0.pow(i.toDouble()).toInt()
        }
        return res
    }

    //    from decimal to base three
    fun toBaseThree(n:Int):String{
        var num = n
        var str = ""
        while(num>0){
            str = (num%3).toString() + str
            num/=3
        }
        return str.ifEmpty { "" }
    }
}