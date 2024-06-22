package com.example.kotlinproject

import kotlin.math.sqrt

class isPrimeNumber {
    val useList = mutableListOf<Int>()
    val primeSet = mutableSetOf<Int>()

    fun solution(numbers: String): Int {
        makeNumber(numbers, StringBuilder("0"))

        return primeSet.size
    }

    tailrec fun makeNumber(numbers: String, temp: StringBuilder) {
        val number: Int = temp.toString().toInt()
        if (number > 1 && isPrimeNumber(number)) primeSet.add(number)

        if (numbers.length > useList.size) {
            for ((i, value) in numbers.withIndex()) {
                if (useList.contains(i)) continue

                useList.add(i)
                makeNumber(numbers, temp.append(value))
                useList.removeLast()
                temp.deleteCharAt(temp.length - 1)
            }
        }
    }

    fun isPrimeNumber(number: Int): Boolean {
        val last = sqrt(number.toDouble()).toInt()
        val set = mutableSetOf<Int>()
        var flag = true

        for (i in 2..last) {
            if (set.contains(i)) continue

            if (number % i == 0) {
                flag = false
                break
            } else {
                (i..last)
                    .filter { it % i == 0 }
                    .forEach { set.add(it) }
            }
        }

        return flag
    }
}