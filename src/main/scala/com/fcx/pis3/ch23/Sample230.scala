package com.fcx.pis3.ch23

/**
  * Author: Will Fan
  * Date: 2019/4/29 10:16
  */
object Sample230 extends App {
  case class Person(name: String, isMale: Boolean, children: Person*)

  val lara = Person("lara", false)
  val bob = Person("Bob", true)
  val julie = Person("Julie", false, lara, bob)
  val persons = List(lara, bob, julie)

  val cnames = persons filter (p => !p.isMale) flatMap (p => (p.children map (c => (p.name, c.name))))
  println(cnames)

  val pcnames = for (p <- persons; if !p.isMale; c <- p.children) yield (p.name, c.name)
  println(pcnames)

}
