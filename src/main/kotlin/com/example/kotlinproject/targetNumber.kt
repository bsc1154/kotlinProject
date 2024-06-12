package com.example.kotlinproject

class targetNumber {

    //[1, 1, 1, 1, 1] // 3
    var answer = 0;

    fun solution(numbers:IntArray, target:Int) :Int{
        var n = numbers.size

        fun dfs(index:Int, result:Int){
            if(index == n){
                if(result == target){
                    answer+=1
                }
            }else{
                dfs(index+1,result-numbers[index])
                dfs(index+1,result+numbers[index])
            }
        }

        dfs(0,0)

        return answer
    }
}