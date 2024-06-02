package com.example.kotlinproject
class triangleSnail {
    //4
    fun solution(n: Int): IntArray {
        val arr = Array(n){IntArray(n)}

        //방향을 나타내는 2차원 배열
        //3방향 배열 아마 대각선임
        val dir = arrayOf(arrayOf(1,0),arrayOf(0,1),arrayOf(-1,-1))
        //현재 방향으로 이동할 수 있는 최대 횟수
        var moveMax = n
        //현재 위치
        var r=0
        var c=0
        //현재방향
        var curDir = 0
        //삼각 달팽이 모양에 채워질 숫자
        var num=1
        //현재 방향으로 이동한 횟수
        var moveCnt=0


        while(moveMax!=0){
            arr[r][c] = num++
            moveCnt++
            //해당 방향의 최대 이동횟수 도달하면
            if(moveCnt==moveMax){
                //다음 방향의 최대 이동 횟수 감소
                moveMax--
                //이동 횟수 초기화
                moveCnt=0
                //방향 전환
                curDir++
            }
            r+= dir[curDir%3][0]
            c+= dir[curDir%3][1]
        }


        /*dir은 2차원 배열로, 각 행은 방향 벡터를 나타냅니다.
        curDir은 현재 방향을 나타내는 변수입니다.
        curDir%3은 현재 방향 인덱스를 3으로 나눈 나머지를 구하는 것입니다. 이는 3가지 방향(오른쪽, 아래, 왼쪽 대각선 아래)이 있기 때문입니다.
        dir[curDir%3]은 현재 방향에 해당하는 2차원 배열의 행을 가져오는 것입니다.
        dir[curDir%3][1]은 그 행의 두 번째 요소, 즉 열 방향 값을 가져오는 것입니다.
        이렇게 하면 현재 방향에 따라 적절한 열 방향 값을 가져올 수 있습니다. 예를 들어, 오른쪽 방향이면 (1, 0), 아래 방향이면 (0, 1), 왼쪽 대각선 아래 방향이면 (-1, -1)과 같은 값을 가져올 수 있습니다.
        */
        val answer = ArrayList<Int>()

        //마지막에 삼각형을 채워주는 로직
        for(i in 0 until n){
            for(j in 0 until n){
                if(arr[i][j]>0)
                    answer.add(arr[i][j])
            }
        }
        //출력
        return answer.toIntArray()
    }
}