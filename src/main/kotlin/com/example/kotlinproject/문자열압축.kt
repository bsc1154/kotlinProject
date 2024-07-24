package com.example.kotlinproject

class 문자열압축 {

    fun solution(s: String): Int{
        var level = 1
        val size = s.length
        var min = s.length

        while(level <= size){
            var str  = s.substring(0, level)
            var isChange = false
            val sb = StringBuilder()
            var cnt = 2
            var temp = ""

            var j = level
            while(j + level <= size){
                val sub = s.substring(j, j+ level)
                if(str == sub){
                    isChange = true
                    temp = cnt.toString() + str
                    cnt++
                }else{
                    sb.append(if(isChange) temp else str)
                    isChange = false
                    str = sub
                    cnt = 2
                    temp = ""
                }
                j += level
            }
            sb.append(if(temp.isEmpty())  s.substring(j-level, size) else temp + s.substring(j,size))
            min = minOf(min, sb.length)
            level++
        }
        return min
    }
}