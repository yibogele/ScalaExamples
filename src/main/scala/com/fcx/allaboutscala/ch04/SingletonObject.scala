package com.fcx.allaboutscala.ch04

/**
  * Author Will Fan
  * Description TODO
  * Date 2019/4/22 21:40
  */
object SingletonObject extends App {

  object DonutShoppingCartCaculator{
    val discount: Double = 0.01

    def calculateTotalCost(donuts: List[String]): Double = {
      1
    }
    println("hello")
  }
  println(s"${DonutShoppingCartCaculator.discount}")

}
