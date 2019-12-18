case class Problem03() {
  case class Point(val x: Int, val y: Int) {
    def step(direction: Char) = direction match {
      case 'L' => Point(x-1, y)
      case 'R' => Point(x+1, y)
      case 'D' => Point(x, y-1)
      case 'U' => Point(x, y+1)
      case _ => this
    }
    def distance = x.abs + y.abs
    def delay(points: IndexedSeq[Point]) = points indexOf this
  }
  def decode(segment: String) = {
    val (direction, length) = segment.splitAt(1)
    direction * length.toInt
  }
  def wire(input: String) = {
    val directions = input.split(",").map(decode).mkString("")
    directions.scanLeft(Point(0, 0))((p: Point, s: Char) => p.step(s))
  }
  def run(inputs: List[String]): String = {
    val wires = inputs.map(wire(_))
    val intersections = wires.reduce(_ intersect _) drop 1
    List(intersections.map(_.distance).min, intersections.map(p => wires.map(p.delay(_)).sum).min).mkString(" ")
  }
}
