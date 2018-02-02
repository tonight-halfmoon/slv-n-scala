package data.structures

/*
	Can a client modify an immutable object in runtime?
*/

object ModifyList {
  
  def main(args: Array[String]) : Unit = {print(modify(List(1,2,3,4)))}

  def modify(L:List[Int]): List[Int] =
  {
    //L.map(add)
    map(add, L) 
  }
 
  def add(v:Int)  = v + 1;

  def map[U](f:Int => U, L:List[Int]) : List[U] =
	    (L)
	    match{
	    	case Nil => Nil
	    	case _   => f(L.head) :: map(f, L.tail) 
	  	}
}