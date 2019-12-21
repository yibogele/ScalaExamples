package com.fcx.learningconcurrency.ch05

import scala.util.Random

/**
 * Author: Will Fan
 * Description: TODO
 * Created: 2019/12/19 22:18
 */
object ParBasic extends App {

//  import com.fcx.learningconcurrency._

  val numbers = Random.shuffle(Vector.tabulate(5000000)(i => i))
  val seqtime = timed {
    numbers.max
  }
  log(s"Sequential time $seqtime ms")
  val partime = timed {
    numbers.par.max
  }
  log(s"Parallel time $partime ms")
}
