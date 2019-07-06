package com.fcx.allaboutscala.ch04

/**
  * Author Will Fan
  * Description TODO
  * Date 2019/4/22 22:29
  */
object TypeClass extends App {

  abstract class Donut(name: String){
    def printName: Unit
  }

  case class VanillaDonut(name: String) extends Donut(name){
    override def printName: Unit = println(name)
  }
  val vanillaDonut = VanillaDonut("Vanilla Donut")

  case class GlazeddDonut(name: String) extends Donut(name){
    override def printName: Unit = println(name)
  }
  val glazeddDonut = GlazeddDonut("Glazed Donut")

  class ShoppingCart[D <: Donut](donuts: Seq[D]){
    def printCartItems: Unit = donuts.foreach(_.printName)
  }

  val shoppingCart: ShoppingCart[Donut] = new ShoppingCart(Seq[Donut](vanillaDonut, glazeddDonut))
  shoppingCart.printCartItems
}
