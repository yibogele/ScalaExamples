package com.fcx.fps

/**
 * Author: Will Fan
 * Description: TODO
 * Created: 2019/11/16 22:07
 */
object RecursiveSum extends App {

  import com.fcx.fps.temp.Test._

  val list = 1 :: 2 :: 3 :: 4 :: 5 :: Nil
  println(sum(list))

  val list1 = List.range(1, 10000)
  val x = sum(list1)
  println(x)
}

package temp {

  object Test {
    def sum(list: List[Int]): Int = list match {
      case Nil => 0
      case x :: xs => x + sum(xs)
    }
  }

}