package com.fcx.learningconcurrency.ch03

import com.fcx.learningconcurrency._
/**
 * Author: Will Fan
 * Description: TODO
 * Created: 2019/11/24 12:25
 */
object LazyValsObject extends App {
  object Lazy { log("Running Lazy constructor.")}
  log("Main thread is about to reference Lazy.")
  Lazy
  log("Main thread completed.")

}
