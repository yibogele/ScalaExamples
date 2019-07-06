package com.fcx.allaboutscala.ch04

/**
  * Author Will Fan
  * Description TODO
  * Date 2019/4/22 21:14
  */
object CompanionObjectAsFactory extends App {
  println("define a simple class ")
  class Donut(name: String, productCode: Option[Long] = None){
    def print = println(s"Donut name = $name, product code = ${productCode.getOrElse((0))}")
  }

  println("step 2: inheritance")
  class GlazedDonut(name: String) extends Donut(name)
  class VanillaDonut(name: String) extends Donut(name)

  println("step 3: factory object")
  object Donut{
    def apply(name: String): Donut = {
      name match {
        case "Glazed Donut" => new GlazedDonut(name)
        case "Vanilla Donut" => new VanillaDonut(name)
        case _ => new Donut(name)
      }
    }
  }

  println("step 4: call factory")
  val glazedDonut = Donut("Glazed Donut")
  println(s"the class type of glazedDonut is ${glazedDonut.getClass}")
  glazedDonut.print

  val vanillaDonut = Donut("Vanilla Donut")
  vanillaDonut.print
}
