package com.fcx.allaboutscala.ch04

/**
  * Author Will Fan
  * Description TODO
  * Date 2019/4/22 21:26
  */
object CompanionObjectFields extends App {

  class Donut(name: String, productCode: Option[Long] = None){
    def print = println(s"Donut name = $name, productCode = ${productCode.getOrElse(0)}, " +
      s"uuid = ${Donut.uuid}")
  }

  object Donut{
    private val uuid = 1

    def apply(name: String, productCode: Option[Long] = None): Donut = new Donut(name, productCode)

    def apply(name: String): Donut = new Donut(name)
  }

  val glazedDonut = Donut("Glazed Donut", Some(1111))
  val vanillaDonut = Donut("Vanilla Donut")


  glazedDonut.print
  vanillaDonut.print
}
