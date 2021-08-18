package com.estebanmarin
package scalaplaygound

object Main {
  def main(args: Array[String]): Unit = {
    println("─" * 50)

    code(args)

    println("─" * 50)

  }

  def code(args: Array[String]): Unit = {

    def bankAccount(initialBalance: Int): Symbol => Int => Int = {
      var balance: Int = initialBalance

      val withdraw: Int => Int = amount =>
        if (balance >= amount) {
          balance = balance - amount
          balance
        }
        else
          sys.error(s"Insuficient funds")

      val deposit: Int => Int = amount =>
        if (balance >= 1) {
          balance = balance + amount
          balance
        }
        else {
          balance = amount + balance
          balance
        }

      val dispatch: Symbol => (Int => Int) = operation =>
        operation match {
          case Symbol("withdraw") => withdraw
          case Symbol("deposit")  => deposit
          case _                  => x => x
        }
      dispatch
    }

    val bankAccount1 = bankAccount(initialBalance = 100)

    println(bankAccount1(Symbol("withdraw"))(10))
    println(bankAccount1(Symbol("withdraw"))(50))
    println(bankAccount1(Symbol("deposit"))(50))
    println(bankAccount1(Symbol("bla"))(50))
  }
}
