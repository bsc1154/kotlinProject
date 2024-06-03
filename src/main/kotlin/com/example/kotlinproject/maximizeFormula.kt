package com.example.kotlinproject

import java.lang.IllegalArgumentException
import java.util.*
import kotlin.math.abs

class maximizeFormula {
    fun solution(expression: String): Long {
        var answer : Long = 0

        val priority = arrayOf(
            arrayOf('+', '-', '*'),
            arrayOf('+', '*', '-'),
            arrayOf('-', '+', '*'),
            arrayOf('-', '*', '+'),
            arrayOf('*', '+', '-'),
            arrayOf('*', '-', '+')
        )
        //연산자를
        for (case in priority) {
            println(Arrays.toString(case))
           // "100-200*300-500+20"
            answer = dfs(expression, 0, case).let { if(abs(it) > answer) {
                abs(it)
            } else answer }
        }

        return answer
    }

    fun dfs(expression : String, depth : Int, case : Array<Char>) : Long {
        if (expression.isLong()) return expression.toLong()
        val tokens = expression.split(case[depth])
        var result : Long? = null
        for (token in tokens) {
            val value = dfs(token, depth + 1, case)
            result = if (result == null) {
                value
            } else {
                calc(result, value, case[depth])
            }
        }
        return result!!
    }
}
fun String.isLong(): Boolean {
    return try {
        this.toLong()
        true
    } catch (e: Exception) {
        false
    }
}
fun calc(a : Long, b : Long, op : Char) : Long {
    return when (op) {
        '+' -> a + b
        '-' -> a - b
        '*' -> a * b
        else -> throw IllegalArgumentException()
    }
}