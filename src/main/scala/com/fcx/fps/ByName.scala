package com.fcx.fps

/**
 * Author: Will Fan
 * Description: TODO
 * Created: 2019/11/15 20:38
 */
object ByName extends App {
  import com.fcx.fps.byname._
  val (result, time) = Test.timer{
    println("hello")
  }
  println(result, time)

  Test.test{
    System.currentTimeMillis()
  }
}

package byname{
  object Test{
    def timer[A](blockCode: => A) = {
      val startTime = System.nanoTime()
      val result = blockCode
      val endTime = System.nanoTime()
      val delta = endTime - startTime
      (result, delta/1000000d)
    }

    def test[A](codeBlock: => A) = {
      println("before 1st block")
      val a = codeBlock
      println(a)
      Thread.sleep(10)

      println("before 2nd block")
      val b = codeBlock
      println(b)
      Thread.sleep(10)

      println("before 3rd block")
      val c = codeBlock
      println(c)

    }
  }
}
