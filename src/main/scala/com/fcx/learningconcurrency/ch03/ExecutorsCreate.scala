package com.fcx.learningconcurrency.ch03

import java.util.concurrent.ForkJoinPool

import com.fcx.learningconcurrency._

/**
 * Author: Will Fan
 * Description: TODO
 * Created: 2019/11/13 21:10
 */
object ExecutorsCreate extends App {
  val executor = new ForkJoinPool

  executor.execute(() => log("This task is run asynchronously."))
  Thread.sleep(500)
}
