package com.fcx.fps

/**
 * Author: Will Fan
 * Description: TODO
 * Created: 2019/11/14 21:08
 */
object FuncVar extends App {
  val isEven = (i: Int) => i % 2 == 0

  def double(i: Int) = i * 2
  def triple(i: Int) = i * 3

  val funcions = Map(
    "2x" -> double _,
    "3x" -> triple _
  )

  val dub = funcions("2x")
  println(dub(9))
}
