package com.fcx.learningconcurrency.ch03

import com.fcx.learningconcurrency._
/**
 * Author: Will Fan
 * Description: TODO
 * Created: 2019/11/13 21:42
 */
object ExecutionContextSleep extends App {
  for (i <- 0 until 32) execute {
    Thread.sleep(2000)
    log(s"Task $i completed.")
  }
  Thread.sleep(10000)
}
