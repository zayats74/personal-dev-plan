package ru.scalabook.pdp

import cats.effect.IO

@main def hello(): Unit = {
  println("Hello world!")
  println(msg)
}

def msg = "I was compiled by Scala 3. :)"
