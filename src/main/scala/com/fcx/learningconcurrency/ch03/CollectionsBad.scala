package com.fcx.learningconcurrency.ch03

import scala.collection._
import com.fcx.learningconcurrency._
/**
 * Author: Will Fan
 * Description: TODO
 * Created: 2019/11/24 12:47
 */
object CollectionsBad extends App {
  val buffer = mutable.ArrayBuffer[Int]()
  def asyncAdd(numbers: Seq[Int]) = execute {
    buffer ++= numbers
    log(s"buffer = $buffer")
  }

  asyncAdd(0 until 10)
  asyncAdd(10 until 20)
  Thread.sleep(500)
}
