package com.fcx.pis3.ch07

import java.io.File

/**
  * Author: Will Fan
  * Date: 2019/4/25 9:06
  */
object Sample extends App {

  val fileshere = (new File(".")).listFiles()

  for (file <- fileshere) println(file)

//  fileshere.foreach(println)
  for (file <- fileshere if file.isFile if file.getName.startsWith("pom")) println(file)

  def fileLines(file: java.io.File) = scala.io.Source.fromFile(file).getLines().toList

  def grep(pattern: String) =
    for {
      file <- fileshere
      if file.getName.startsWith("pom")
      line <- fileLines(file)
      if line.trim.matches(pattern)
    } println(s"$file: ${line.trim}")

  grep(".*scala.*")

  def grep2(pattern: String) =
    for {
      file <- fileshere
      if file.getName.startsWith("pom")
      line <- fileLines(file)
      trimmed = line.trim
      if trimmed.matches(pattern)
    } println(s"$file: $trimmed")
  grep(".*ver.*")

  def xmlFiles =
    for{
      file <- fileshere
      if file.getName.endsWith(".xml")
    } yield file

  val scalaLineLengths =
    for {
      file <- fileshere
      if file.getName.startsWith("pom")
      line <- fileLines(file)
      trimmed = line.trim
      if trimmed.matches(".*scala.*")
    } yield trimmed.length
  println(s"scala line lengths:")
  scalaLineLengths.foreach(len => println(s"\t$len"))
}
