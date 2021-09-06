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

  def convinientWrite(): Write.Result = {
    println(s"Writting $content to $location ...")
    val e: Exception = new Exception
    Thread.sleep(1000)
    throw Write.Warning("Not enough space on disk")
  }
}
object Write {
  sealed trait Result
  final case class Success(size: Int) extends Result
  final case class Warning(message: String) extends Throwable with Result {
    override def toString: String =
      s"$productPrefix($message)"
  }
  final case class Error(message: String) extends Throwable with Result
}
