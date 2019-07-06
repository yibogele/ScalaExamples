package com.fcx.allaboutscala

/**
  * Author Will Fan
  * Description TODO
  * Date 2019/4/22 22:17
  */
package object ch04 {

  case class Donut(name: String, price: Double, productCode: Option[Long] = None)

  implicit class AugmentedDonut(donut: Donut){
    def uuid: String = s"${donut.name} - ${donut.productCode.getOrElse(12345)}"
  }
}
