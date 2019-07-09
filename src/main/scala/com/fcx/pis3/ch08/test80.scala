package com.fcx.pis3.ch08

/**
  * Author: Will Fan
  * Created: 2019/7/9 8:56
  * Description: 
  */
object test80 extends App {
  val func = (_: Int) + (_: Int)

  println(func(5, 10))

  def bang(x: Int): Int = {
    if (x == 0) throw new Exception("bang!")
    else bang(x - 1)
  }

  bang(6)
}
