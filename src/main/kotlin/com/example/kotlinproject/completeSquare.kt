package com.example.kotlinproject

class Solution {
    fun solution(w: Int, h: Int): Long {
        return (0L until w.toLong()).reduce { total, i -> total + (h.toLong() * i) / w } * 2
    }

}