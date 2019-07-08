package com.fcx.pis3.ch10

/**
  * Author: Will Fan
  * Date: 2019/4/25 14:31
  */
object Sample10 extends App {
  abstract class Element {
    def contents: Array[String]
    def height: Int = contents.length
    def width: Int = if (height == 0) 0 else contents(0).length
  }

  class ArrayElement(val contents: Array[String]) extends Element

  class LineElement(s: String) extends ArrayElement(Array(s)){
    override def height: Int = 1

    override def width: Int = s.length
  }
}
