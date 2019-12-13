package com.fcx.learningconcurrency.ch04

import java.io._

import org.apache.commons.io.FileUtils
import scala.concurrent.ExecutionContext.Implicits.global

import scala.collection.JavaConverters._
import scala.concurrent.Future
import scala.io.Source

import com.fcx.learningconcurrency._
/**
 * Author: Will Fan
 * Description: TODO
 * Created: 2019/12/1 17:56
 */
object FutureClumsyCallbacks extends App {
  def backlistFile(name: String): Future[List[String]] = Future {
    val lines = Source.fromFile(name).getLines

    lines.filter(x => !x.startsWith("#") && !x.isEmpty).toList
  }

  def findFiles(patterns: List[String]): List[String] = {
    val root = new File(".")
    for {
      f <- FileUtils.iterateFiles(root, null, true).asScala.toList
      pat <- patterns
      abspat = root.getCanonicalPath + File.separator + pat
      if f.getCanonicalPath.contains(abspat)
    } yield f.getCanonicalPath

  }

  backlistFile(".gitignore") foreach {
    lines =>
      val files = findFiles(lines)
      log(s"matches: ${files.mkString("\n")}")
  }

  Thread.sleep(1000)
}
