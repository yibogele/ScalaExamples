package com.fcx.allaboutscala.ch05

/**
  * Author: Will Fan
  * Date: 2019/4/23 11:08
  */
object ExtendTrait extends App {

  trait DonutShoppingCartDao{
    def add(donutName: String): Long

    def update(donutName: String): Boolean

    def search(donutName: String): String

    def delete(donutName: String): Boolean
  }

  class DonutShoppingCart extends DonutShoppingCartDao {
    override def add(donutName: String): Long = 1

    override def update(donutName: String): Boolean = true

    override def search(donutName: String): String = donutName

    override def delete(donutName: String): Boolean = true
  }

}
