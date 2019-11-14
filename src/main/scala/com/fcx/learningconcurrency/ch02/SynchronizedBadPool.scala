package com.fcx.learningconcurrency.ch02

import scala.collection._
import com.fcx.learningconcurrency._
/**
 * Author: Will Fan
 * Description: TODO
 * Created: 2019/11/10 17:58
 */
object SynchronizedBadPool extends App {
  private val tasks = mutable.Queue[() => Unit]()

  val worker: Thread = new Thread{
    def poll(): Option[() => Unit] = tasks.synchronized {
      if (tasks.nonEmpty) Some(tasks.dequeue()) else None
    }

    override def run(): Unit = while (true) poll() match {
      case Some(task) => task()
      case None =>
    }
  }

  worker.setName("Worker")
  worker.setDaemon(true)
  worker.start()

  def asynchronous(body: =>Unit): Unit = tasks.synchronized{
    tasks.enqueue(() => body)
  }

  asynchronous { log("Hello")}
  asynchronous { log(" World!")}
  Thread.sleep(5000)
}
