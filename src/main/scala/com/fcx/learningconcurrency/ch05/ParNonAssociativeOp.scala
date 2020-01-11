package com.fcx.learningconcurrency.ch05

import scala.collection.GenIterable


/**
 * Author: Will Fan
 * Description: TODO
 * Created: 2020/1/11 10:53
 */
object ParNonAssociativeOp extends App {
  def test(doc: GenIterable[Int]): Unit ={
    val seqtext = doc.seq.reduceLeft(_ - _)
    val partext = doc.par.reduce(_ - _)
    log(s"Sequential result - $seqtext")
    log(s"Parallel result   - $partext")
  }
  test(0 until 30)
}
