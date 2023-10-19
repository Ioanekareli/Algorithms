package random

class Random {

    fun repeatStr(r: Int, str: String) : String{
        var x = ""
        var r = r
        while (r>0){
            x+=str
            r-=1
        }
        return x
    }

    fun people(busStops: Map<Int,Int>) : Int {
        var kSum = 0
        var vSum = 0
        var res = 0
        var bus = busStops
        for (key in bus.keys){
            kSum+=key
        }
        for (value in bus.values){
            vSum+=value
        }
        res = kSum-vSum
        return if (res<0) res -1 else res
    }

    fun maps(x: IntArray): IntArray =
        x.map {
            it*2
        }.toIntArray()

    fun solution(number: Int): Int {
//    20 ---> 3,5,6,9,10,12,15,18 ---> 78
        var sum = 0
        for(i in number){
            if (i%3==0 || i%5==0){
                sum+=i
            }
        }
        return sum
    }

    operator fun Int.iterator():Iterator<Int>{
        return (1 until this+1).iterator()
    }

    fun reverseLetter(str: String): String {
        val str = str.filter {it.isLetter()}.reversed()
        var result = ""
        var letterIndex = 0
        for(i in str){
            if (i.isLetter()){
                result+=str[letterIndex++]
            }else{
                result+=i
            }
        }
        return result
    }

    fun equalSides(arr:IntArray):String{
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

    class DeletionLinkedList<T> {
        data class Node<T>(val value: T, var prev: Node<T>? = null, var next: Node<T>? = null)

        private val map = hashMapOf<T, Node<T>>()
        private var head: Node<T>? = null
        private var tail: Node<T>? = null

        fun remove(value: T) {
            val node = map[value] ?: return

            if (node.prev != null) {
                node.prev?.next = node.next
            } else {
                head = node.next
            }

            if (node.next != null) {
                node.next?.prev = node.prev
            } else {
                tail = node.prev
            }

            map.remove(value)
        }

    }
}