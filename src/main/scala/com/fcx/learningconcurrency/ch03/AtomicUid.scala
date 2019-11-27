package com.fcx.learningconcurrency.ch03

import java.util.concurrent.atomic._
import com.fcx.learningconcurrency._

/**
 * Author: Will Fan
 * Description: TODO
 * Created: 2019/11/16 22:37
 */
object AtomicUid extends App {
  private val uid = new AtomicLong(0)

  def getUniqueId: Long = uid.incrementAndGet()

  execute {
    log(s"Uid asynchronously: $getUniqueId")
  }
  log(s"Got a unique id: $getUniqueId")
}
