package com.fcx.pis3.ch07

/**
  * Author: Will Fan
  * Created: 2019/7/8 9:44
  * Description: 
  */
object list719 extends App{

  def makeRowSeq(row: Int) = {
    for (col <- 1 to 10) yield {
      val prod = (row * col).toString
      val padding = " " * (4 - prod.length)
      padding + prod
    }
  }

  def makeRow(row: Int) = makeRowSeq(row).mkString

  def multiTable() = {
    val tableSeq =
      for (row <- 1 to 10)
        yield makeRow(row)

    tableSeq.mkString("\n")
  }

  println(multiTable())
}

