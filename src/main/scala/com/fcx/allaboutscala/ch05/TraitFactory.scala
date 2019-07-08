package com.fcx.allaboutscala.ch05

/**
  * Author: Will Fan
  * Date: 2019/4/23 13:32
  */
object TraitFactory extends App {
  object Cakes{
    trait Cake{
      def name: String
    }

    class UnknownCake extends Cake{
      override def name: String = "Unkown Cake"
    }

    class Cupcake extends Cake {
      override def name: String = "Cupcake"
    }

    class Donut extends Cake {
      override def name: String = "Donut"
    }
  }

  object CakeFactory{
    import Cakes._

    def apply(cake: String): Cake = {
      cake match {
        case "cupcake" => new Cupcake
        case "donut" => new Donut
        case _ => new UnknownCake
      }
    }
  }

  println(s"A cupcake = ${CakeFactory("cupcake").name}")
  println(s"A donut = ${CakeFactory("donut").name}")
  println(s"Unknown cake = ${CakeFactory("coconut tart").name}")
}
