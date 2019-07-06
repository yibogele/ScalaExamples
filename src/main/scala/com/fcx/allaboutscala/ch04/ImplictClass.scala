package com.fcx.allaboutscala.ch04

/**
  * Author Will Fan
  * Description TODO
  * Date 2019/4/22 22:10
  */
object ImplictClass extends App {

  case class Donut(name: String, price: Double, productCode: Option[Long] = None)

  val vanillaDonut = Donut("Vanilla Donut", 1.50)

  object DonutImplicits{
    implicit class AugmentedDonut(donut: Donut){
      def uuid: String = s"${donut.name} - ${donut.productCode.getOrElse(12345)}"
    }
  }

  import DonutImplicits._
  println(s"${vanillaDonut.uuid}")
}
