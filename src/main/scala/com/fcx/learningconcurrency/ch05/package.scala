package com.fcx.learningconcurrency

/**
 * Author: Will Fan
 * Description: TODO
 * Created: 2019/12/19 22:29
 */
package object ch05 {
  val log: String=>Unit = com.fcx.learningconcurrency.log

  @volatile var dummy: Any = _
  def timed[T](body: =>T): Double = {
    val start = System.nanoTime()
    dummy = body
    val end = System.nanoTime()
    ((end - start) / 1000) / 1000.0
  }
}
