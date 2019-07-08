package com.fcx.pis3.ch01

/**
  * Author: Will Fan
  * Date: 2019/4/24 8:41
  */
object Sample extends App {
  var capital = Map("US" -> "Washington", "France" -> "Paris")
  capital += ("Japan" -> "Tokyo")
  println(capital("France"))

  def factorial(x: BigInt): BigInt = if (x == 0) 1 else x * factorial(x - 1)

  println(factorial(30))

  import java.math.BigInteger

  def factor(x: BigInteger): BigInteger =
    if (x == BigInteger.ZERO) BigInteger.ONE
    else x.multiply(factor(x.subtract(BigInteger.ONE)))

  println(factor(BigInteger.valueOf(30)))
}
