package com.fcx.pis3.ch20

/**
  * Author: Will Fan
  * Date: 2019/4/28 14:39
  */
object Sample20_1 extends App {
  trait Abstract {
    type T
    def transform(x: T): T
    val initial: T
    var current: T
  }

  class Concrete extends Abstract{
    type T = String

    override def transform(x: String): String = x + x

    override val initial: String = "hi"
    override var current: String = initial
  }
}
