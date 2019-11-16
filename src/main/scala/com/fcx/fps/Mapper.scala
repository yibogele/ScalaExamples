package com.fcx.fps

/**
 * Author: Will Fan
 * Description: TODO
 * Created: 2019/11/15 20:27
 */
object Mapper extends App {

  def map[A, B](f: A => B, list: Seq[A]): Seq[B] = {
    for {
      x <- list
    } yield f(x)
  }
}
