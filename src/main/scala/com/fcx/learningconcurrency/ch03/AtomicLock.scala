package com.fcx.learningconcurrency.ch03

import java.util.concurrent.atomic.AtomicBoolean
import com.fcx.learningconcurrency._
/**
 * Author: Will Fan
 * Description: TODO
 * Created: 2019/11/17 18:12
 */
object AtomicLock extends App {
  private val lock = new AtomicBoolean(false)
  def mySynchronized(body: =>Unit): Unit = {
    while (!lock.compareAndSet(false, true)){}
    try body finally lock.set(false)
  }

  var count = 0
  for (i<- 0 until 10) execute {mySynchronized( count += 1)}
  Thread.sleep(1000)
  log(s"Count is: $count")
}
