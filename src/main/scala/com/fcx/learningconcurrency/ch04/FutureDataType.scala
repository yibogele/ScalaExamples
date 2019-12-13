package com.fcx.learningconcurrency.ch04

import com.fcx.learningconcurrency._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.io.Source

/**
 * Author: Will Fan
 * Description: TODO
 * Created: 2019/12/1 17:04
 */
object FutureDataType extends App {
  val buildFile: Future[String] = Future {
    val f = Source.fromFile("pom.xml")
    try f.getLines.mkString("\n") finally f.close()
  }

  log(s"started reading the build file asynchronously.")
  log(s"status: ${buildFile.isCompleted}")
  Thread.sleep(250)
  log(s"status: ${buildFile.isCompleted}")
  log(s"value: ${buildFile.value}")
}
