package com.fcx.learningconcurrency.ch05

import scala.collection._
/**
 * Author: Will Fan
 * Description: TODO
 * Created: 2020/1/11 10:54
 */
object ParNonCommutativeOp extends App {
  val doc = mutable.ArrayBuffer.tabulate(20)(i => s"Page $i, ")
  def test(doc: GenIterable[String]): Unit = {
    val seqtext = doc.seq.reduceLeft(_ + _)
    val partext = doc.par.reduce(_ + _)
    log(s"Sequential result - $seqtext")
    log(s"Parallel result   - $partext")
  }

  test(doc)
  test(doc.toSet)
}
