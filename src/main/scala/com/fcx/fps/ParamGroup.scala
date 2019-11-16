package com.fcx.fps

/**
 * Author: Will Fan
 * Description: TODO
 * Created: 2019/11/15 21:10
 */
object ParamGroup extends App {
  import com.fcx.fps.paramgroup.Test._

  var i = 1
  whilst(i < 5) {
    println(i)
    i += 1
  }

  implicit val b: Boolean = true
  printIntIfTrue(12)
}

package paramgroup {
  object Test {
    def whilst(cond: => Boolean)(codeBlock: => Unit) : Unit = {
      while(cond)
        codeBlock
    }

    def printIntIfTrue(a: Int)(implicit b: Boolean): Unit = if (b) println(a)
  }
}
