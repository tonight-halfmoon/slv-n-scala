import scala.math.BigInt.int2bigInt

object FibonacciTail {

  def main(args: Array[String]) {
    println(fibonacci(Integer.valueOf(args(0))))
  }

  def fibonacci(n: Int): BigInt = {
    @annotation.tailrec
    def go(n: BigInt, acc0: BigInt, acc1: BigInt): BigInt =
      if (0 == n) acc0
      else if (n == 1) acc1
      else go(n - 1, acc1, acc0 + acc1)
    go(n, 0, 1)
  }
}