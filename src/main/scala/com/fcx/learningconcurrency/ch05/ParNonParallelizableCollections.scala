package com.fcx.learningconcurrency.ch05

/**
 * Author: Will Fan
 * Description: TODO
 * Created: 2020/1/7 19:56
 */
object ParNonParallelizableCollections extends App {
  val list = List.fill(1000000)("")
  val vector = Vector.fill(1000000)("")
  log(s"list conversion time: ${timed(list.par)} ms")
  log(s"vector conversion time: ${timed(vector.par)} ms")
}
