package com.fcx.s4i.ch02


/**
 * Author: Will Fan
 * Description: TODO
 * Created: 2020/1/12 9:03
 */
object Sample02 extends App {
//  Test.testIo()
//  Test.traversStr()
//  Test.trvStr()
  /**
   * test impl
   */
  object Test {
    //
    def testIo(): Unit = {
      import scala.io._

      val name = StdIn.readLine("Your name:")
      print("Your age:")
      val age = StdIn.readInt()
      println(s"Hello, $name! Next year, you will be ${age + 1}.")
    }

    //
    def traversStr(): Unit = {
      val s = "Hello"
      var sum = 0
      for (i <- 0 until s.length)
        sum += s(i)
      println(sum)
    }

    //
    def trvStr(): Unit ={
      val s = "Hello"
      var sum = 0
      for (str <- s)
        sum += str
      println(sum)
    }

    //
    def advFor(): Unit ={
      for (i <- 1 to 3; j <- 1 to 3) print(f"${10 * i + j}%3d"); println()

      for (i <- 1 to 3; j <- 1 to 3 if i != j) print(f"${10 * i + j}%3d"); println()

      for (i <- 1 to 3; from = 4 - i; j <- from to 3) print(f"${10 * i + j}%3d"); println()
      // same as {{
      for {
        i <- 1 to 3
        from = 4 - i
        j <- from to 3
      }print(f"${10 * i + j}%3d"); println()
      // }}

      val vec = for (i <- 1 to 10) yield i % 3; println(vec)
      // same as {{
      println(for (i <- 1 to 10) yield i % 3)
      // }}

      println(for (c <- "Hello"; i <- 0 to 1) yield (c + i).toChar)
      println(for (i <- 0 to 1; c <- "Hello") yield (c + i).toChar)
    }

    //

  }

  Test.advFor()
}
