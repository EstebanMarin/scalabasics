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
      def withdraw(amount: Int): Unit
      def deposit(amount: Int): Unit
      def getBalance: Int
    }

    class Account(initialBalance: Int) extends BankAccount {
      private[this] var _balance: Int = initialBalance

      def withdraw(amount: Int): Unit =
        if (this._balance >= amount) {
          this._balance = this._balance - amount
        }
        else
          sys.error(s"Insuficient funds")

      def deposit(amount: Int): Unit =
        if (this._balance >= 1) {
          this._balance = this._balance + amount
        }
        else {
          this._balance = amount + this._balance
        }

      def getBalance: Int = this._balance

    }

    object Account {

      def makeTransfer(
          from: BankAccount,
          amount: Int,
          to: BankAccount,
        ): Unit = {

        def showBothAccounts(): Unit = {
          println(s"from: ${from.getBalance}")
          println(s"to: ${to.getBalance}")
        }

        showBothAccounts()
        from.withdraw(amount = amount)
        to.deposit(amount = amount)

        println()
        showBothAccounts()
      }
    }

    val bankAccount1 = new Account(initialBalance = 200)
    val bankAccount2 = new Account(initialBalance = 600)

    println(bankAccount1.getBalance)
    bankAccount1.withdraw(amount = 50)
    println(bankAccount1.getBalance)

    println(bankAccount1.getBalance)
    bankAccount1.withdraw(amount = 50)
    println(bankAccount1.getBalance)

    println(bankAccount1.getBalance)
    bankAccount1.deposit(amount = 250)
    println(bankAccount1.getBalance)

    Account.makeTransfer(from = bankAccount1, amount = 50, to = bankAccount2)

  }
}
