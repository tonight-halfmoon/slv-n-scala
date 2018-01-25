package amazon

import scala.collection.mutable.ListBuffer

class Movie(id: Int, r: Float) {
  val movieId = id
  val rating = r
  var dSimilars = ListBuffer[Movie]()

  def getSimilars: List[Movie] = dSimilars.toList

  def addSimilarMovie(movie: Movie): Unit =
    {
      dSimilars.append(movie)
      movie.dSimilars.append(this)
    }
  def getId: Int = movieId

  def getRating: Float = rating

  def printMe = print(movieId + " ")
  
  override def toString : String = getId.toString
}    