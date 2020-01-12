package com.fcx.learningconcurrency.ch05

import scala.collection.concurrent._
/**
 * Author: Will Fan
 * Description: TODO
 * Created: 2020/1/11 19:10
 */
object ConcurrentTrieMap extends App {
  val cache = new TrieMap[Int, String]()

  for (i <- 0 until 100) cache(i) = i.toString
  for ((number, string) <- cache.par) cache(-number) = s"-$string"
  log(s"cache - ${cache.keys.toList.sorted}")
}
