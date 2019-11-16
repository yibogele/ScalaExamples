package com.fcx.learningconcurrency.ch02

import scala.collection._
import com.fcx.learningconcurrency._

/**
 * Author: Will Fan
 * Description: TODO
 * Created: 2019/11/11 21:46
 */
object SynchronizedPool extends App {
  private val tasks = mutable.Queue[() => Unit]()

  object Worker extends Thread {
    setDaemon(true)

    def poll(): () => Unit = tasks.synchronized {
      while (tasks.isEmpty) tasks.wait()
      tasks.dequeue()
    }

    override def run(): Unit = while (true) {
      val task = poll()
      task()
    }
  }

  Worker.start()

  def asynchronous(body: => Unit): Unit = tasks.synchronized {
    tasks.enqueue(() => body)
    tasks.notify()
  }

  asynchronous(log("Hello "))
  asynchronous(log("world!"))
  Thread.sleep(500)
}
