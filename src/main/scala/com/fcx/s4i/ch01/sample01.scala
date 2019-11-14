package com.fcx.s4i.ch01

/**
  * Author: Will Fan
  * Created: 2019/9/4 11:38
  * Description: 
  */

object sample01 extends App {

  println("Hello".intersect("World"))

  val bi: BigInt = 1234567890
  println(bi * bi * bi)

  def abs(x: Double) = if (x > 0) x else -x

}


