package com.example.kotlinproject

import java.util.*
class bracketConversion {
    fun result( w : String ) : String{ //결과 반환
        var r = 0; var l = 0;
        var u : String = ""; var v : String = ""; var s : String = "";

        if(w.length == 0 ) return ""

        if( check(w) ){//올바른 문자열
            return w
        }
        else{//균형잡힌 문자열
            for( i in w){
                when(i){
                    '('->l+=1
                    ')'->r+=1
                }
                if( r==l ) {
                    if( r+l != w.length){
                        u = w.substring(0, r+l)
                        v = w.substring(r+l, w.length)
                        break
                    }
                    else{
                        u = w.substring(0, r+l)
                        break
                    }
                }
            }
        }

        if(check(u)){ s = u + result(v) }
        else{ s = "(" + result(v) + ")" + tmp(u.substring(1,u.length-1)) }

        return s
    }

    fun tmp( w: String) : String{ //문자열 뒤집기
        var s = ""
        if(w.length >1){
            for( i in w){
                if( i == '(') s+=")"
                else s+="("
            }
        }
        return s
    }

    fun check( w : String) : Boolean{// 올바른 괄호 문자열 판별
        var stack = Stack<Char>()
        for( i in w){
            if( i == '(') stack.push(i)
            else{
                if(stack.isNotEmpty()) stack.pop()
                else return false
            }
        }
        return true
    }

    fun solution(p: String): String {
        return result(p)
    }
}