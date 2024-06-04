package com.example.kotlinproject

class Tuple{
    fun solution(s:String):IntArray{
        //문자열을 분해한다.
        val str = s.substring(2,s.length-2).split("},{").sortedBy { it.length }
        val answer = mutableListOf<Int>()

        //,기준으로 반복 답안에 현재숫자가 포함되어있지 않으면 하나 더 추가해서 답안을 완성
        str.forEach{row -> row.split(",").forEach{if(!answer.contains(it.toInt())) answer.add(it.toInt())}}

        return answer.toIntArray()

    }

}