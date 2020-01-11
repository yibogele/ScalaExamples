package com.fcx.learningconcurrency.ch05

import scala.collection.GenSet

/**
 * Author: Will Fan
 * Description: TODO
 * Created: 2020/1/7 21:36
 */
object ParSideEffectsIncorrect extends App {
  def intersectionSize(a: GenSet[Int], b: GenSet[Int]): Int = {
    var total = 0
    for (x <- a) if (b contains x) total += 1
    total
  }

  def intersectionSizeV2(a: GenSet[Int], b: GenSet[Int]): Int = {
    a.count(x => b contains x)
  }

  val a = (0 until 1000).toSet
  val b = (0 until 1000 by 4).toSet
  val seqres = intersectionSize(a, b)
  val parres = intersectionSize(a.par, b.par)
  log(s"Sequential result - $seqres")
  log(s"Parallel result - $parres")

  val parres2 = intersectionSizeV2(a, b)
  log(s"Parallel result 2 - $parres2")
}
