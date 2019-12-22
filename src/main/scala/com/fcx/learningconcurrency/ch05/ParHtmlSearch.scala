package com.fcx.learningconcurrency.ch05

import scala.collection.GenSeq
import scala.concurrent.Future
import scala.io.Source
import scala.concurrent.ExecutionContext.Implicits.global

/**
 * Author: Will Fan
 * Description: TODO
 * Created: 2019/12/21 17:47
 */
object ParHtmlSearch extends App {
  def getHtmlSpec = Future {
    val url = "http://www.w3.org/MarkUp/html-spec/html-spec.txt"
    val specSrc = Source.fromURL(url)
    try specSrc.getLines().toArray finally specSrc.close()
  }


  def warmedTimed[T](n: Int = 200) (body: =>T): Double = {
    for (_ <- 0 until n) body
    timed(body)
  }

  def search(d: GenSeq[String]) = warmedTimed() {
    d.indexWhere(line => line.matches(".*TEXTAREA.*"))
  }

  getHtmlSpec foreach {
    specDoc =>
//      def search(d: GenSeq[String]): Double =
//        timed {
//          d.indexWhere(line => line.matches(".*TEXTAREA.*"))
//        }

      val seqtime = search(specDoc)
      log(s"Sequential time $seqtime ms")
      val partime = search(specDoc.par)
      log(s"Parallel time $partime ms")
  }
}
