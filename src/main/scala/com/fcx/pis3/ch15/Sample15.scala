package com.fcx.pis3.ch15

/**
  * Author: Will Fan
  * Date: 2019/4/26 13:49
  */
object Sample15 extends App {
  val v = Var("x")
  val op = BinOp("+", Number(1), v)
  println(v, op)
}

abstract class Expr
case class Var(name: String) extends Expr
case class Number(num: Double) extends Expr
case class UnOp(operator: String, arg: Expr) extends Expr
case class BinOp(operator: String, left: Expr, right: Expr) extends Expr