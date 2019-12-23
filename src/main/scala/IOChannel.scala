import scala.collection.mutable.Buffer

trait IOChannel[A] {
  def input(): A
  def output(signal: A)
}
