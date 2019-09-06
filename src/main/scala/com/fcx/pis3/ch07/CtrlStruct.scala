package com.fcx.pis3.ch07

import java.io.File

/**
 * Author: Will Fan
 * Description: TODO
 * Created: 2019/7/7 21:33
 */
object CtrlStruct extends App {
  val filesHere = new File(".").listFiles
  for (file <- filesHere
       if file.isFile
       if file.getName.endsWith("md")
       ) println(file)

  def fileLines(file: java.io.File) =
    try {
      scala.io.Source.fromFile(file).getLines.toList
    } finally {

    }

  //  for (
  //    file <- filesHere
  //    if file.getName.endsWith("xml");
  //    line <- fileLines(file)
  //    if line.trim.matches(".*2018.*")
  //  ) println(line)

  for {
    file <- filesHere
    if file.getName.endsWith("xml")
    line <- fileLines(file)
    if line.trim.matches(".*2018.*")
  } println(line)
}
