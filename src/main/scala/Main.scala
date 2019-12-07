import scala.io.Source

object Main extends App {
  println("Hello, World!")
  println("Problem01: " + new Problem01().run(Source.fromResource("01.txt").getLines.toArray))
  println("Problem04: " + new Problem04().run(Source.fromResource("04.txt").mkString.trim))
}
