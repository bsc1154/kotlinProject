package com.example.kotlinproject

import javafx.scene.Node
import java.util.*

class gameMap {

    fun solution(maps:Array<IntArray>):Int {
        data class Node(val x:Int, val y:Int)
        val q:Queue<Node> = LinkedList<Node>()

        val dx = intArrayOf(0, 1, 0, -1)
        val dy = intArrayOf(-1, 0, 1,0)
        var x = 0
        var y = 0

        q.offer(Node(x, y))

        while(q.isNotEmpty()){
            val node = q.poll()
            x = node.x
            y = node.y

            for(i in 0..3){
                val nx = x + dx[i]
                val ny = y + dy[i]

                if(nx in maps[0].indices && ny in maps.indices && ny in maps.indices && maps[ny][nx] ==1){
                    maps[ny][nx] +=maps[y][x]

                    q.offer(Node(nx, ny))
                }
            }
        }

        val answer = maps.last().last()

        return if(answer ==1) -1 else answer
    }

}