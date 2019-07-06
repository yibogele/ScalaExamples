package com.fcx.pis3.ch06

/**
  * Author Will Fan
  * Description TODO
  * Date 2019/4/24 20:39
  */
object Sample extends App {

  class Rational(n: Int, d: Int) {
    require(d != 0)
    private val g = gcd(n.abs, d.abs)
    val num: Int = n / g
    val denom: Int = d / g

    override def toString: String = s"$num/$denom"

    def this(n: Int) = this(n, 1)

    def +(other: Rational): Rational = new Rational(num * other.denom + other.num * denom,
      denom * other.denom)

    def +(i: Int): Rational = new Rational(num + i * denom, denom)

    def -(other: Rational): Rational = new Rational(num * other.denom - other.num * denom, denom * other.denom)

    def -(i: Int): Rational = new Rational(num - i * denom, denom)

    def *(other: Rational): Rational = new Rational(num * other.num, denom * other.denom)

    def *(i: Int): Rational = new Rational(num * i, denom)

    def /(other: Rational): Rational = new Rational(num * other.denom, denom * other.num)

    def /(i: Int): Rational = new Rational(num, denom * i)

    def <(other: Rational) = this.num * other.denom < other.num * this.denom

    def max(other: Rational) = if (this < other) other else this

    private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  }

  implicit def intToRational(i: Int): Rational = new Rational(i)

  val half = new Rational(1, 2)
  val two3rds = new Rational(2, 3)
  println(half < two3rds)
  println(2 * half)
}
