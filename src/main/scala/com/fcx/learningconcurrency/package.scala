package com.fcx

import scala.concurrent.ExecutionContext

/**
 * Author: Will Fan
 * Description: TODO
 * Created: 2019/11/10 15:56
 */
package object learningconcurrency {
  def log(msg: String): Unit = {
    println(s"${Thread.currentThread.getName}: $msg")
  }

  def thread(body: => Unit): Thread = {
    val t = new Thread {
      override def run() = body
    }

    t.start()
    t
  }

  def execute(body: =>Unit): Unit = ExecutionContext.global.execute(() => body)
}
