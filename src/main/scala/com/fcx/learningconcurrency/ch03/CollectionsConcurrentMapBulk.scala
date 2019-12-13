package com.fcx.learningconcurrency.ch03

import java.util.concurrent.ConcurrentHashMap
import scala.collection.JavaConverters._

import com.fcx.learningconcurrency._
/**
 * Author: Will Fan
 * Description: TODO
 * Created: 2019/11/30 16:07
 */
object CollectionsConcurrentMapBulk extends App {
  val names = new ConcurrentHashMap[String, Int]().asScala
  names("Johnny") = 0
  names("Jane") = 0
  names("Jack") = 0
  execute{
    for (n <- 0 until 10) names(s"John $n") = n
  }

  execute {
    for (n <- names) log(s"name: $n")
  }

  Thread.sleep(1000)
}
