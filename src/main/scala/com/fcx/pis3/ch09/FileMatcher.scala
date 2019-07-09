package com.fcx.pis3.ch09

import java.io.File

/**
  * Author: Will Fan
  * Created: 2019/7/9 9:52
  * Description: 
  */
object FileMatcher {
  private def filesHere = new File(".").listFiles

  def fileEnding(query: String) =
    for (file <- filesHere; if file.getName.endsWith(query))
      yield file

}
