package com.fcx.fps

/**
 * Author: Will Fan
 * Created: 2019/11/16 16:41
 * Description: 
 */
object PartialFunc extends App {

  import com.fcx.fps.partial.Test._

  println(add2(5))
  println(plus2(12))
}

package partial {

  object Test {
    def add(a: Int, b: Int) = a + b

    def plus(a: Int)(b: Int) = a + b

    val add2 = add(2, _)
    val plus2 = plus(2) _
  }

}
