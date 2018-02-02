import scala.collection.immutable.Stack;

/*
	Problem Statement: Find out the maximum element value in a Stack.
*/
object MaxElement {
  def main(args: Array[String]): Unit = {
    val n = readInt()
    val stack = Stack.empty
    val smax = scala.collection.mutable.Stack.empty[Int]
    process(stack, n, smax)
  }

  private def process(s: Stack[Int], n: Int, sm:scala.collection.mutable.Stack[Int]): Unit = n match {
    case 0 => true
    case _ =>
      {
        val line = readLine().split(' ').map(x=>x.toInt)
        line.length match
        {
          case 2 =>
            val elem = line.last
            process(s.push(elem), n-1, pushMax(elem, sm))
          case 1 =>
            val option = line.head
            option match
            {
              case 2 =>
                if (s.isEmpty)
                  process(s, n-1,sm)
                else
                {
                  val (p,t) = s.pop2
                  process(t, n-1, popMax(p, sm))
                }
              case 3 =>
                {
                  if (!sm.isEmpty)
                    println(sm.top)
                  process(s, n-1, sm)
                }
              case _ => "Not interested!"
            }
          case _ => "Not interested!"
        }
      }
  }

  private def pushMax(e: Int, sm:scala.collection.mutable.Stack[Int]): scala.collection.mutable.Stack[Int] = {
    if (sm.isEmpty)
    {
      sm.push(e)
    }
    else if (e >= sm.top)
    {
      sm.push(e)
    }
    return sm
  }

  private def popMax(p:Int, sm:scala.collection.mutable.Stack[Int]): scala.collection.mutable.Stack[Int] = {
    if (!sm.isEmpty && p == sm.top)
      sm.pop
    return sm
  }
}
