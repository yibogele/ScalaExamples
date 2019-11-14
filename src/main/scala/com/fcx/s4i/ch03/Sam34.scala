package com.fcx.s4i.ch03

/**
 * Author: Will Fan
 * Created: 2019/9/11 13:07
 * Description: 
 */
object Sam34 extends App{
  val a = Array(1, 2, 3, 4, 5, 6)
  val result = for (ele <- a) yield 2 * ele
  result.foreach(println)

  val res = for( ele <- a if ele % 2 == 0) yield ele
  res.foreach(println)

}
