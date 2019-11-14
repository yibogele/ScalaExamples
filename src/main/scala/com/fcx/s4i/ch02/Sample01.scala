package com.fcx.s4i.ch02

/**
 * Author: Will Fan
 * Created: 2019/9/9 15:01
 * Description: 
 */
object Sample01 extends App {
  def decorate(str: String, left: String = "[", right: String = "]") =
    left + str + right

  println(decorate("你好"))

  //
  def sum(args: Int*) = {
    var result = 0
    for (arg <- args) result += arg

    result
  }

  val s = sum(1, 2, 3, 12, 23, 34)
  println(s)

  println(sum(1 to 5: _*))

  //
  def recursiveSum(args: Int*): Int = {
    if (args.isEmpty) 0
    else args.head + recursiveSum(args.tail: _*)
  }
  println(recursiveSum(1 to 12: _*))

  // proc
  def box(s: String) {
    val border = "-" * (s.length + 2)
    printf(f"$border%n|$s|%n$border%n")
  }
  box("hello")
}

