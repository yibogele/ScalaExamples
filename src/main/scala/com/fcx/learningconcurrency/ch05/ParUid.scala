package com.fcx.learningconcurrency.ch05

import java.util.concurrent.atomic._
/**
 * Author: Will Fan
 * Description: TODO
 * Created: 2019/12/19 22:27
 */
object ParUid extends App {
  private val uid = new AtomicLong(0L)
  val seqtime = timed{
    for (i <- 0 until 1000000) uid.incrementAndGet()
  }
  log(s"Sequential time $seqtime ms")

  val partime = timed {
    for (i <- ( 0 until 1000000).par) uid.incrementAndGet()
  }

  log(s"Parallel time $partime ms")
}
