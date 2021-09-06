package com.estebanmarin.scalaplaygound

class File(
    location: String,
    name: String,
    extention: String,
    content: String,
  ) {
  def write(): Write.Result = {
    println(s"Writting $content to $location ...")
    Thread.sleep(1000)
    Write.Success(content.size)
  }
}
object Write {
  sealed trait Result
  final case class Success(size: Int) extends Result
  final case class Warning(message: String) extends Result
  final case class Error(message: String) extends Result
}
