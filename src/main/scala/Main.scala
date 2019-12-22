import scala.io.Source

object Main extends App {
  println("Hello, World!")
  println("Problem01: " + new Problem01().run(Source.fromResource("01.txt").getLines.toSeq))
  println("Problem02: " + new Problem02().run(Source.fromResource("02.txt").mkString.trim))
  println("Problem03: " + new Problem03().run(Source.fromResource("03.txt").getLines.toSeq))
  println("Problem04: " + new Problem04().run(Source.fromResource("04.txt").mkString.trim))
  println("Problem05: " + new Problem05().run(Source.fromResource("05.txt").mkString.trim))
  println("Problem06: " + new Problem06().run(Source.fromResource("06.txt").getLines.toList))
  println("Problem07: " + new Problem07().run(Source.fromResource("07.txt").mkString.trim))
  println("Problem08: " + new Problem08().run(Source.fromResource("08.txt").mkString.trim))
  println("Problem09: " + new Problem09().run(Source.fromResource("09.txt").mkString.trim))
  println("Problem10: " + new Problem10().run(Source.fromResource("10.txt").mkString.trim))
  println("Problem11: " + new Problem11().run(Source.fromResource("11.txt").mkString.trim))
}
