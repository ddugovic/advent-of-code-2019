import scala.collection.mutable.Buffer
import scala.collection.mutable.Map

case class Problem11() {
  class Robot(var r: Int = 50, var c: Int = 50, var direction: Char = '^', val map: Map[(Int, Int), Long] = Map(), val hull: Array[Array[Char]] = Array.ofDim[Char](100, 100)) {
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
  }
  class Computer(val memory: Buffer[Long], val robot: Robot = new Robot()) {
    var base = 0
    var pc = 0
    def op = memory(pc) % 100
    def relativeAddress(mode: Int, address: Long) = if (mode % 10 == 2) base + address else address
    def read(mode: Int, address: Long) = if (mode % 10 == 1) memory(address.toInt) else memory(relativeAddress(mode, memory(address.toInt)).toInt)
    def write(mode: Int, address: Int, value: Long) = {memory(relativeAddress(mode, memory(address)).toInt) = value}
    def step(input: Long) = {
      val mode = memory(pc).toInt / 100
      op match {
        case 1 => {
          write(mode/100, pc+3, read(mode, pc+1) + read(mode/10, pc+2))
          pc += 4
        }
        case 2 => {
          write(mode/100, pc+3, read(mode, pc+1) * read(mode/10, pc+2))
          pc += 4
        }
        case 3 => {
          write(mode, pc+1, input)
          pc += 2
        }
        case 4 => {
          robot.output(read(mode, pc+1))
          pc += 2
        }
        case 5 => {
          pc = if (read(mode, pc+1) != 0) read(mode/10, pc+2).toInt else pc + 3
        }
        case 6 => {
          pc = if (read(mode, pc+1) == 0) read(mode/10, pc+2).toInt else pc + 3
        }
        case 7 => {
          write(mode/100, pc+3, if (read(mode, pc+1) < read(mode/10, pc+2)) 1 else 0)
          pc += 4
        }
        case 8 => {
          write(mode/100, pc+3, if (read(mode, pc+1) == read(mode/10, pc+2)) 1 else 0)
          pc += 4
        }
        case 9 => {
          base += read(mode, pc+1).toInt
          pc += 2
        }
        case 99 => pc 
      }
    }
    def execute() = {
      var address = pc
      while (step(robot.input) != address) {
        address = pc
      }
      this
    }
  }
  def run(inputs: String): String = {
    val program = inputs.split(",").map(_.toLong)
    val r = 0
    val c = 0
    val map = Map((r, c) -> 1L)
    val hull = Array.tabulate(6, 43) {(a, b) => ' '}
    Seq(new Computer(program.toBuffer.padTo(1200, 0L)).execute().robot.map.size,
        new Computer(program.toBuffer.padTo(1200, 0L), new Robot(r, c, '^', map, hull)).execute().robot.hull.map(_.mkString).mkString("\n")).mkString("\n")
  }
}
