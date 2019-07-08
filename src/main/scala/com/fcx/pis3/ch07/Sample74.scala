package com.fcx.pis3.ch07

/**
  * Author: Will Fan
  * Date: 2019/4/25 9:46
  */
object Sample74 extends App{

  val firstArg = if (!args.isEmpty) args(0) else ""

  val friend =
    firstArg match {
      case "salt" => "pepper"
      case "chips" => "salsa"
      case "eggs" => "bacon"
      case _ => "huh?"
    }

  println(friend)

  def tryfunc = try {} catch { case ex: Exception =>  } finally {}
}
