package com.fcx.pis3.ch08

import scala.io.Source

/**
  * Author: Will Fan
  * Date: 2019/4/25 10:32
  */
object Sample81 extends App {

  object LongLines {
    def processFile(filename: String, width: Int) = {
      val source = Source.fromFile(filename)
      for (line <- source.getLines())
        processLine(filename, width, line)
    }

    private def processLine(filename: String, width: Int, line: String) =
      if (line.length > width) println(s"$filename: ${line.trim}")
  }

  object LongLines2 {
    def processFile(filename: String, width: Int) = {
      def processLine(line: String) =
        if (line.length > width) println(s"$filename: ${line.trim}")

      val source = Source.fromFile(filename)
      for (line <- source.getLines())
        processLine(line)
    }


  }

  object FindLongLines extends App {
    //    def main(args: Array[String]): Unit = {
    val width = args(0).toInt
    for (arg <- args.drop(1))
      LongLines.processFile(arg, width)
    //    }
  }

}
