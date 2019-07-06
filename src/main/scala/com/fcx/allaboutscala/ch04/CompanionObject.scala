package com.fcx.allaboutscala.ch04

/**
  * Author Will Fan
  * Description TODO
  * Date 2019/4/22 20:59
  */
object CompanionObject extends App {
  println("step 1: define a simple class")
  class Donut(name: String, productCode: Long){
    def print = println(s"donut name = $name, product code = $productCode")
  }

  println("step 2: define a companion object")
  object Donut{
    def apply(name: String, productCode: Long): Donut = new Donut(name, productCode)
  }

  println("step 3: create instance using companion object")
  val glazedDonut = Donut("Glazed Donut", 11111)
  val vanillaDonut = Donut("Vanilla Donut", 22222)

  println("Step 4: call function on object")
  glazedDonut.print
  vanillaDonut.print
}
