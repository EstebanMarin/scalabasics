package com.estebanmarin
package scalaplaygound

object Main {
  def main(args: Array[String]): Unit = {
    println("─" * 50)

    code(args)

    println("─" * 50)

  }

  def code(args: Array[String]): Unit = {

    trait BankAccount {
      def withdraw: Int => Unit
      def deposit: Int => Unit
      def getBalance: () => Int
    }

    class Account(initialBalance: Int) extends BankAccount {
      var balance: Int = initialBalance

      def withdraw: Int => Unit = amount =>
        if (balance >= amount) {
          balance = balance - amount
        }
        else
          sys.error(s"Insuficient funds")

      def deposit: Int => Unit = amount =>
        if (balance >= 1) {
          balance = balance + amount
        }
        else {
          balance = amount + balance
        }

      def getBalance: () => Int = () => balance

    }

    val bankAccount1 = new Account(initialBalance = 200)

    println(bankAccount1.getBalance())
    bankAccount1.withdraw(50)
    println(bankAccount1.getBalance())

    println(bankAccount1.getBalance())
    bankAccount1.withdraw(50)
    println(bankAccount1.getBalance())

    println(bankAccount1.getBalance())
    bankAccount1.deposit(250)
    println(bankAccount1.getBalance())

    def makeTransfer(
        from: BankAccount,
        amount: Int,
        to: BankAccount,
      ): Unit = {

      def showBothAccounts(): Unit = {
        println(s"from: ${from.getBalance()}")
        println(s"to: ${to.getBalance()}")
      }

      showBothAccounts()
      from.withdraw(amount)
      to.deposit(amount)

      println()
      showBothAccounts()
    }

    val bankAccount2 = new Account(initialBalance = 600)

    makeTransfer(from = bankAccount1, amount = 50, to = bankAccount2)

  }
}
