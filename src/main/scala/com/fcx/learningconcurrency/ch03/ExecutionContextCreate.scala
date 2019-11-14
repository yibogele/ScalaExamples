package com.fcx.learningconcurrency.ch03

import com.fcx.learningconcurrency._
import scala.concurrent._
import java.util.concurrent._
/**
 * Author: Will Fan
 * Description: TODO
 * Created: 2019/11/13 21:28
 */
object ExecutionContextCreate extends App {
  val pool = new ForkJoinPool(2)
  val ectx = ExecutionContext.fromExecutorService(pool)
  ectx.execute(() => log("Running on the execution context again."))
  Thread.sleep(500)
}
