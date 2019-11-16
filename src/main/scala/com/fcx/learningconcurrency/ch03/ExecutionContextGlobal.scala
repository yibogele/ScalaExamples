package com.fcx.learningconcurrency.ch03

import scala.concurrent._
import com.fcx.learningconcurrency._
/**
 * Author: Will Fan
 * Description: TODO
 * Created: 2019/11/13 21:24
 */
object ExecutionContextGlobal extends App {
  val ectx = ExecutionContext.global
  ectx.execute(() => log("Running on the execution context."))
  Thread.sleep(500)
}
