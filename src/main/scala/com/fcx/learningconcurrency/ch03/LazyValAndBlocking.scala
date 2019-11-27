package com.fcx.learningconcurrency.ch03

import com.fcx.learningconcurrency._
/**
 * Author: Will Fan
 * Description: TODO
 * Created: 2019/11/24 12:38
 */
object LazyValAndBlocking extends App {
  lazy val x: Int = {
    val t = thread{ println(s"Initializing $x.")}
    t.join()
    1
  }
  x
}
