import scala.collection.mutable.Buffer

case class Problem09() {
  class Computer(val memory: Buffer[Long], var base: Int = 0, var output: Long = 0) {
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
          output = read(mode, pc+1)
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
    def execute(input: Long) = {
      var address = pc
      while (op != 3 && step(input) != address) {
        address = pc
      }
      if (op == 3) {
        step(input)
        while (op != 3 && step(input) != address) {
          address = pc
        }
      }
      this
    }
  }
  def run(inputs: String): String = {
    val program = inputs.split(",").map(_.toLong)
    List(new Computer(program.toBuffer.padTo(2048, 0L)).execute(1).output,
         new Computer(program.toBuffer.padTo(2048, 0L)).execute(2).output).mkString(" ")
  }
}
