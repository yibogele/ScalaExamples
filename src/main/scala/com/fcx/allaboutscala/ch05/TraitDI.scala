package com.fcx.allaboutscala.ch05

/**
  * Author: Will Fan
  * Date: 2019/4/23 11:25
  */
object TraitDI extends App {
  trait DonutDatabase[A]{
    def addOrUpdate(donut: A): Long

    def query(donut: A): A

    def delete(donut: A): Boolean
  }

  class CassandraDonutStore[A] extends DonutDatabase[A]{
    override def addOrUpdate(donut: A): Long = 1

    override def query(donut: A): A = donut

    override def delete(donut: A): Boolean = true
  }

  trait DonutShoppingCartDao[A]{
    val donutDatabase: DonutDatabase[A]

    def add(donut: A): Long = {
      donutDatabase.addOrUpdate(donut)
    }

    def update(donut: A): Boolean = {
      donutDatabase.addOrUpdate(donut)
      true
    }

    def search(donut: A): A = {
      donutDatabase.query(donut)
    }

    def delete(donut: A): Boolean = {
      donutDatabase.delete(donut)
    }
  }

  trait DonutInventoryService[A]{
    val donutDatabase: DonutDatabase[A]

    def checkStock(donut: A): Int = {
      donutDatabase.query(donut)
      1
    }
  }

  trait DonutShoppingCartService[A] extends DonutShoppingCartDao[A] with DonutInventoryService[A]{
    override val donutDatabase: DonutDatabase[A] = new CassandraDonutStore[A]
  }

  class DonutShoppingCart[A] extends DonutShoppingCartService[A]{

  }

  val donutShoppingCart: DonutShoppingCart[String] = new DonutShoppingCart[String]
  println(donutShoppingCart.add("aaaa"))
}
