import scala.io.Source

object Main extends App {
  println("Hello, World!")
  println("Problem01: " + new Problem01().run(Source.fromResource("01.txt").getLines.toList))
  println("Problem03: " + new Problem03().run(Source.fromResource("03.txt").getLines.toList))
  println("Problem04: " + new Problem04().run(Source.fromResource("04.txt").mkString.trim))
  println("Problem06: " + new Problem06().run(Source.fromResource("06.txt").getLines.toList))
}
