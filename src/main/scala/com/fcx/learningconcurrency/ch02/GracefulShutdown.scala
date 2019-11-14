package com.fcx.learningconcurrency.ch02

import scala.collection.mutable
import com.fcx.learningconcurrency._

/**
 * Author: Will Fan
 * Description: TODO
 * Created: 2019/11/11 22:24
 */
object GracefulShutdown extends App {
  private val tasks = mutable.Queue[() => Unit]()

  object Worker extends Thread{
    var terminated = false

    def poll(): Option[() => Unit] = tasks.synchronized{
      while (tasks.isEmpty && !terminated) tasks.wait()
      if (!terminated) Some(tasks.dequeue()) else None
    }

    import scala.annotation.tailrec

    @tailrec override def run(): Unit = poll() match {
      case Some(task) => task(); run()
      case None =>
    }

    def shutdown(): Unit = tasks.synchronized{
      terminated = true
      tasks.notify()
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
  Worker.shutdown()
}
