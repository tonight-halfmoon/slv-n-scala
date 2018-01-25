package amazon

import java.util.HashMap
import java.util.Locale
import java.util.Scanner

import scala.collection.JavaConversions.bufferAsJavaList
import scala.collection.mutable.ListBuffer

object MovieRecommendations {

  def main(args: Array[String]): Unit =
    {
      val movieMap = new HashMap[Int, Movie]()
      var rootMovie = new Movie(0, 0.0F)
      var topN = 0
      val sc = new Scanner(System.in)
      sc.useLocale(new Locale("en", "US"))
      var s1 = "noexityet"
      while (sc.hasNextLine() && s1.equals("noexityet")) {
        val nextString = sc.next
        if (nextString.equals("movie")) {
          val id = sc.nextInt()
          val rating = sc.nextFloat()
          movieMap.put(id, new Movie(id, rating))
        }
        else if (nextString.equals("similar")) {
          val movie1 = movieMap.get(sc.nextInt());
          val movie2 = movieMap.get(sc.nextInt());
          movie1.addSimilarMovie(movie2)
        }
        else if (nextString.equals("params")) {
          rootMovie = movieMap.get(sc.nextInt())
          topN = sc.nextInt()
        }
        else if (nextString.equals("e")) {
          s1 = "exit"
        }
      }

      val res = getMovieRecoms(rootMovie, topN)
      var output = "result"
      if (res == Nil) {
        output += "<null>"
      }
      else {
        /*val sorted = */(res sortWith((m1,m2) => m1.getId < m2.getId)) foreach(nextMovie => print(nextMovie.getId + " "))
        /*sorted*/ 
        //res foreach(_.printMe)
      }
      println
      println(output)
    }

  
  def topRating(m1: Movie, m2: Movie): Movie =
    {
      if (m1.getRating > m2.getRating)
        return m1
      return m2
    }

  def findTops(rmvr: ListBuffer[Movie], n: Int): List[Movie] =
    (rmvr, n) match 
    {
      case (null, _n) => List() /** Base case */
      case (rmvr, 0) => rmvr.toList /** Base case */
      case _ =>
        if (rmvr.size < n)  /** to avoid asking for more than the total number of similar and similar of similar movies */
          return rmvr.toList
        @annotation.tailrec
        def findTops(rmvr: ListBuffer[Movie], tmvr: ListBuffer[Movie], M: Int, i: Int): List[Movie] =
           (rmvr, M, i) match
           {
             case (rmvr, M, M)  => tmvr.toList /** Base case */
             case (rmvr, n, i) =>
               val tmv = rmvr.reduceLeft(topRating)
               findTops(rmvr.-=(tmv), tmvr.+=(tmv), n, i + 1)
           }
        findTops(rmvr, ListBuffer(), n, 0)
    }

  def getMovieRecoms(movie: Movie, n: Int): List[Movie] =
    (movie, n) match {
      case (null, _n)    => List()  /** Base case */
      case (_movie, 0)   => List()  /** Base case */
      case _anythingelse => getMovieRecoms(movie, movie.getSimilars, n, movie.getSimilars, List(), ListBuffer())
    }

  def getMovieRecoms(mv: Movie, mvs: List[Movie], n: Int, fdss: List[Movie], traversedsofar: List[Movie], output: ListBuffer[Movie]): List[Movie] =
    (mvs, fdss) match 
    {
      case (_mvs, List()) => /** Base case*/
        return findTops(output.distinct, n)
      case (List(), _fdss) =>
        val cmv = fdss.head
        val cmvs = cmv.getSimilars
        getMovieRecoms(cmv, cmvs diff traversedsofar, n, fdss.drop(1) ::: cmvs diff traversedsofar, traversedsofar, output)
      case _drop0mvs =>
        output.add(mvs.head)
        return getMovieRecoms(mv, mvs.drop(1), n, fdss, mv :: traversedsofar, output)
    }
} /***23rd April 16; Jeddah, SA*/