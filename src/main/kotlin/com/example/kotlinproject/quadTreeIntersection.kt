package com.example.kotlinproject

class quadTreeIntersection {
    private lateinit var map:Array<IntArray>
    fun solution(arr: Array<IntArray>): IntArray {
        map = arr
        // 길이가 2인 정수 배열을 초기화 하면서 dfs에 넘겨줌
        return IntArray(2).apply{ dfs(map.size, 0, 0, this) }
    }
    // n : 얼마난 크기를 확인할지, x : 시작 x좌표, y :시작 y좌표, answer : 정답
    fun dfs(n:Int, x:Int, y:Int, answer:IntArray){
        // 만일 크기가 제일 작은 1에 도달할 경우
        if(n == 1){
            // 해당하는 숫자 0또는 1의 값을 증가 후 dfs종료
            answer[map[y][x]]++
            return
        }
        // 만일 현재 크기의 사각형 안에 숫자가 모두 같을 경우 dfs 종료
        if(isSame(n,x,y,answer)) return
        // 4개의 면에 대하여 1/2크기로 나누어 dfs다시 진행
        dfs(n/2, x, y, answer)
        dfs(n/2, x, y + n / 2, answer)
        dfs(n/2, x + n / 2, y, answer)
        dfs(n/2, x + n / 2, y + n / 2, answer)
    }
    // n : 얼마난 크기를 확인할지, x : 시작 x좌표, y :시작 y좌표, answer : 정답
    fun isSame(n:Int, x:Int, y:Int, answer:IntArray):Boolean{
        // 모두 같은 숫자인지 비교할 값
        val first = map[y][x]
        for(i in y until y + n){
            for(j in x until x + n){
                // 중간에 다른 숫자가 나오면 false return
                if(first != map[i][j]) return false
            }
        }
        // 모두 같은 숫자일 경우 해당 숫자 증가 후 true return
        answer[first]++
        return true
    }
}