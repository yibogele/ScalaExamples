package com.fcx.s4i.ch04

/**
 * Author: Will Fan
 * Description: TODO
 * Created: 2020/1/11 19:22
 */
object MapSample extends App {

  Test.test()
  Test.test1()

  /**
   *
   */
  object Test {
    def test(): Unit = {
      val scores = Map("Alice" -> 10, "Bob" -> 3, "Cindy" -> 8)
      println(scores)
    }

    def test1(): Unit = {
      val scores = Map(("Alice", 10), ("Bob", 3), ("Cindy", 8))
      println(scores)

      println(scores.getOrElse("Alice", 9))
      println(scores.getOrElse("Fan", 7))
    }

    def test2(): Unit = {

    }
  }

}
