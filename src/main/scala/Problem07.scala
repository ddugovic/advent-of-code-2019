case class Problem07() {
  class Computer(val memory: Array[Int], var pc: Int = 0, var output: Int = 0) {
    def op = memory(pc) % 100
    def read(mode: Int, address: Int) = if (mode % 10 == 1) memory(address) else memory(memory(address))
    def write(address: Int, value: Int) = {memory(memory(address)) = value}
    def step(input: Int) = {
      val mode = memory(pc) / 100
      op match {
        case 1 => {
          write(pc+3, read(mode, pc+1) + read(mode/10, pc+2))
          pc += 4
        }
        case 2 => {
          write(pc+3, read(mode, pc+1) * read(mode/10, pc+2))
          pc += 4
        }
        case 3 => {
          write(pc+1, input)
          pc += 2
        }
        case 4 => {
          output = read(mode, pc+1)
          pc += 2
        }
        case 5 => {
          pc = if (read(mode, pc+1) != 0) read(mode/10, pc+2) else pc + 3
        }
        case 6 => {
          pc = if (read(mode, pc+1) == 0) read(mode/10, pc+2) else pc + 3
        }
        case 7 => {
          write(pc+3, if (read(mode, pc+1) < read(mode/10, pc+2)) 1 else 0)
          pc += 4
        }
        case 8 => {
          write(pc+3, if (read(mode, pc+1) == read(mode/10, pc+2)) 1 else 0)
          pc += 4
        }
        case 99 => pc 
      }
    }
    def load(input: Int) = {
      // ASSUME first instruction is an input
      step(input)
      this
    }
    def execute(input: Int) = {
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
  class Network(memory: Array[Int], input: Seq[Int]) {
    val computers = input.map(new Computer(memory.clone).load(_)).toList
    def execute(input: Int) = computers.foldLeft(input)((i: Int, c: Computer) => c.execute(i).output)
    def execute2(input: Int, iterations: Int): Int = {
      var signal = input
      1 to iterations foreach { _ => signal = execute(signal) }
      signal
    }
  }
  def run(inputs: String): String = {
    val disk = inputs.split(",").map(_.toInt)
    val phases = (0 to 4).permutations
    val phases2 = (5 to 9).permutations
    Seq(phases.map(new Network(disk, _).execute(0)).max, phases2.map(new Network(disk, _).execute2(0, 100)).max).mkString(" ")
  }
}
