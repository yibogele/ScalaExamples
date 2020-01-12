package com.fcx.s4i.ch06

import java.util.UUID

import sun.awt.AWTAccessor.AccessibleContextAccessor

import scala.util.Random

/**
 * Author: Will Fan
 * Description: TODO
 * Created: 2020/1/12 19:15
 */
object Sample01 extends App {

  abstract class UndoableAction(val desc: String){
    def undo(): Unit
    def redo(): Unit
  }

  object DoNothingAction extends UndoableAction("Do Nothing"){
    override def undo(): Unit = {}

    override def redo(): Unit = {}
  }

  val actions = Map("open" -> DoNothingAction, "save" -> DoNothingAction)
  println(actions)
  println(DoNothingAction.desc)

  class Account private (val id: Int, initialBalance: Double) {
    private val balance = initialBalance

    def getBalance: Double = balance

    override def toString: String = s"id: $id, balance: $balance."
  }

  object Account {
    private def newUniqueNumber(): Int = Random.nextInt()

    def apply(initialBalance: Double): Account = new Account(newUniqueNumber(), initialBalance)
  }

  val account = Account(1000.0)
  println(account)

  val a, b, c = 1
  println(a, b, c)
}
