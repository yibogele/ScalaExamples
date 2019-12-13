package com.fcx.learningconcurrency.ch04

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.io.Source

import com.fcx.learningconcurrency._
/**
 * Author: Will Fan
 * Description: TODO
 * Created: 2019/12/1 17:15
 */
object FuturesCallbacks extends App {
  def getUrlSpec: Future[List[String]] = Future {
    val url = "http://www.w3.org/Addressing/URL/url-spec.txt"
    val f = Source.fromURL(url)
    try f.getLines.toList finally f.close()
  }

  val urlSpec: Future[List[String]] = getUrlSpec

  def find(lines: List[String], keyword: String): String =
    lines.zipWithIndex collect {
      case (line, n) if line.contains(keyword) => (n, line)
    } mkString("\n")

  urlSpec foreach (lines => log(find(lines, "telnet")))
  log("callback registered, continuing with other work.")
  Thread.sleep(2000)

  urlSpec foreach(lines => log(find(lines, "password")))
}
