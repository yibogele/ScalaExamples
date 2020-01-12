package com.fcx.s4i.ch06

/**
 * Author: Will Fan
 * Description: TODO
 * Created: 2020/1/12 20:06
 */
object SampleEnum extends App {

  object TrafficLightColor extends Enumeration{
    type TrafficLightColor = Value
    val Red, Yellow, Green = Value
  }

  import TrafficLightColor._

  def doWhat(color: TrafficLightColor): String = {
    if (color == Red) "stop"
    else if (color == Yellow) "hurry up"
    else "go"
  }

  println(doWhat(Red), doWhat(Yellow), doWhat(Green))

  for (c <- TrafficLightColor.values) println(s"${c.id}: $c")
}
