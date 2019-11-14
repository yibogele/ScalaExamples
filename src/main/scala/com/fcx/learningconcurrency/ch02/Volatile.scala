package com.fcx.learningconcurrency.ch02

import com.fcx.learningconcurrency._
/**
 * Author: Will Fan
 * Description: TODO
 * Created: 2019/11/13 20:25
 */
object Volatile extends App {
  val pages = for (i <- 1 to 5) yield
    new Page("Na" * (100 - 20 * i) + " Batman!", -1)

  @volatile var found = false

  for (p <- pages) yield thread {
    var i = 0
    while (i < p.txt.length && !found)
      if (p.txt(i) == '!') {
        p.position = i
        found = true

      }else i += 1
  }
  while (!found) {}
  log(s"results: ${pages.map(_.position)}")
}
class Page(val txt: String, var position: Int)
