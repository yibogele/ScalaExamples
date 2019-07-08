package com.fcx.allaboutscala.ch05

/**
  * Author: Will Fan
  * Date: 2019/4/23 11:13
  */
object TraitWithType extends App {

  trait DonutShoppingCartDao[A] {
    def add(donut: A): Long

    def update(donut: A): Boolean

    def search(donut: A): A

    def delete(donut: A): Boolean
  }

  class DonutShoppingCart[A] extends DonutShoppingCartDao[A]{
    override def add(donut: A): Long = 1

    override def update(donut: A): Boolean = true

    override def search(donut: A): A = donut

    override def delete(donut: A): Boolean = true

    println("....")
  }

  val donutShoppingCart1: DonutShoppingCart[String] = new DonutShoppingCart[String]
  println(donutShoppingCart1.add("aaa"))


  val donutShoppingCart2: DonutShoppingCartDao[String] = new DonutShoppingCart[String]
  println(donutShoppingCart2.search("Hello"))
}
