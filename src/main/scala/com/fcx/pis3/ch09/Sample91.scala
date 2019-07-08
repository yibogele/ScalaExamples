package com.fcx.pis3.ch09

import java.io.File

/**
  * Author: Will Fan
  * Date: 2019/4/25 13:44
  */
object Sample91 extends App {

  object FileMatcher {
    private def filesHere = (new File(".")).listFiles()

    private def filesMatching(matcher: String => Boolean) =
      for (file <- filesHere; if matcher(file.getName))
        yield file

    def filesEnding(query: String) =
      filesMatching(_.endsWith(query))
  }

}
