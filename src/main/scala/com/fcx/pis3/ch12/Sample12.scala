package com.fcx.pis3.ch12

/**
  * Author: Will Fan
  * Date: 2019/4/26 8:24
  */
object Sample12 extends App {

  class Animal
  trait Furry extends Animal
  trait HasLegs extends Animal
  trait FourLegged extends HasLegs
  class Cat extends Animal with Furry with FourLegged
}
