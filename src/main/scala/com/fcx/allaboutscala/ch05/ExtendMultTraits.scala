package com.fcx.allaboutscala.ch05

/**
  * Author: Will Fan
  * Date: 2019/4/23 11:21
  */
object ExtendMultTraits extends App {

  trait DonutShoppingCartDao[A]{
    def add(donut: A): Long

    def update(donut: A): Boolean

    def search(donut: A): A

    def delete(donut: A): Boolean
  }

  trait DonutInventoryService[A]{
    def checkStock(donut: A): Int
  }

  class DonutShoppingCart[A] extends DonutShoppingCartDao[A] with DonutInventoryService[A]{
    override def add(donut: A): Long = 1

    override def update(donut: A): Boolean = true

    override def search(donut: A): A = donut

    override def delete(donut: A): Boolean = true

    override def checkStock(donut: A): Int = 1
  }

}
