package com.fcx.s4i.ch05

/**
 * Author: Will Fan
 * Description: TODO
 * Created: 2020/1/12 11:13
 */
object Sample01 extends App {

  class Test{ outer =>
    def test: Unit = {
      val inside = new Inside
      println(inside.count)
    }

    def name: String = {
      "Will Fan"
    }

    class Inside{
      private[Test] val count = 20

      println(s"${outer.name}")
    }
  }

  val test = new Test
  test.test
}
