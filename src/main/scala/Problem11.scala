import scala.collection.mutable.Buffer
import scala.collection.mutable.Map

case class Problem11() {
  class Robot(program: Buffer[Long], var r: Int, var c: Int, var direction: Char = '^', val map: Map[(Int, Int), Long] = Map(), val hull: Array[Array[Char]] = Array.ofDim[Char](100, 100)) extends IOChannel[Long] {
    val computer: Computer = new Computer(this, program)
    var count: Int = 0
    def step(color: Long, turn: Long) = {
      output(color)
      output(turn)
    }
    def input = this.map.getOrElse((r, c), 0L)
    def output(signal: Long) = {
      if (count % 2 == 0) {
        this.map((r, c)) = signal
        this.hull(r)(c) = if (signal == 0L) '.' else '#'
      } else {
        this.direction = this.direction match {
          case '^' => if (signal == 0) '<' else '>'
          case '<' => if (signal == 0) 'v' else '^'
          case '>' => if (signal == 0) '^' else 'v'
          case 'v' => if (signal == 0) '>' else '<'
        }
        this.r += (this.direction match {
          case '^' => -1
          case 'v' => 1
          case _ => 0
        })
        this.c += (this.direction match {
          case '>' => 1
          case '<' => -1
          case _ => 0
        })
      }
      count += 1
    }
    def run() = {
      computer.run()
      this
    }
  }
  def run(inputs: String): String = {
    val program = inputs.split(",").map(_.toLong)
    val map = Map((0, 0) -> 1L)
    val hull = Array.tabulate(6, 43) {(a, b) => ' '}
    Seq(new Robot(program.toBuffer.padTo(1200, 0L), 50, 50).run().map.size,
        new Robot(program.toBuffer.padTo(1200, 0L), 0, 0, '^', map, hull).run().hull.map(_.mkString).mkString("\n")).mkString("\n")
  }
}
