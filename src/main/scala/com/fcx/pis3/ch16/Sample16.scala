package com.fcx.pis3.ch16

/**
  * Author: Will Fan
  * Date: 2019/4/26 15:29
  */
object Sample16 extends App {

  def append[T] (xs: List[T], ys: List[T]): List[T] =
    xs match {
      case List() => ys
      case x :: xs1 => x :: append(xs1, ys)
    }
}
