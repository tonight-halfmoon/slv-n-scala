package amazon

import java.util.HashMap

import junit.framework.Assert.assertEquals
import junit.framework.TestCase

class MovieRecmTestCase extends TestCase {

  def AmazonExample1_testGetRecommends {
    val movieMap = new HashMap[Int, Movie]()
    var rootMovie = new Movie(0, 0.0F)
    var topN = 0
    movieMap.put(1, new Movie(1, 1.2F))
    movieMap.put(2, new Movie(2, 3.6F))
    movieMap.put(3, new Movie(3, 2.4F))
    movieMap.put(4, new Movie(4, 4.8F))
    movieMap.get(1).addSimilarMovie(movieMap.get(2))
    movieMap.get(1).addSimilarMovie(movieMap.get(3))
    movieMap.get(2).addSimilarMovie(movieMap.get(4))
    movieMap.get(3).addSimilarMovie(movieMap.get(4))
    rootMovie = movieMap.get(1)
    topN = 2
    assertEquals(List(movieMap.get(2), movieMap.get(4)), MovieRecommendations.getMovieRecoms(rootMovie, topN) sortWith ((m1, m2) => m1.getId < m2.getId))

  }

  def AmazonExample2_testGetRecommends {
    val movieMap = new HashMap[Int, Movie]()
    var rootMovie = new Movie(0, 0.0F)
    var topN = 0
    movieMap.put(1, new Movie(1, 1.2F))
    movieMap.put(2, new Movie(2, 3.6F))
    movieMap.put(3, new Movie(3, 2.4F))
    movieMap.put(4, new Movie(4, 4.8F))
    movieMap.get(1).addSimilarMovie(movieMap.get(2))
    movieMap.get(1).addSimilarMovie(movieMap.get(3))
    movieMap.get(1).addSimilarMovie(movieMap.get(3))
    movieMap.get(2).addSimilarMovie(movieMap.get(4))
    movieMap.get(3).addSimilarMovie(movieMap.get(4))
    rootMovie = movieMap.get(1)
    topN = 4
    assertEquals(List(movieMap.get(2), movieMap.get(3), movieMap.get(4)), MovieRecommendations.getMovieRecoms(rootMovie, topN) sortWith ((m1, m2) => m1.getId < m2.getId))

  }

   def AmazonExampleA1_testGetRecommends {
    val movieMap = new HashMap[Int, Movie]()
    var rootMovie = new Movie(0, 0.0F)
    var topN = 0
    movieMap.put(1, new Movie(1, 1.2F))
    movieMap.put(2, new Movie(2, 3.6F))
    movieMap.put(3, new Movie(3, 2.4F))
    movieMap.put(4, new Movie(4, 4.8F))
    movieMap.get(1).addSimilarMovie(movieMap.get(2))
    movieMap.get(1).addSimilarMovie(movieMap.get(3))
    movieMap.get(2).addSimilarMovie(movieMap.get(4))
    movieMap.get(3).addSimilarMovie(movieMap.get(4))
    rootMovie = movieMap.get(1)
    topN = 1
    assertEquals(List(movieMap.get(4)), MovieRecommendations.getMovieRecoms(rootMovie, topN) sortWith ((m1, m2) => m1.getId < m2.getId))

  }

  def testGetRecommendsTop1 {
    val movieMap = new HashMap[Int, Movie]()
    var rootMovie = new Movie(0, 0.0F)
    var topN = 0
    movieMap.put(1, new Movie(1, 7.9F))
    movieMap.put(2, new Movie(2, 8.3F))
    movieMap.put(3, new Movie(3, 9.3F))
    movieMap.put(4, new Movie(4, 5.3F))
    movieMap.put(5, new Movie(5, 7.3F))
    movieMap.put(6, new Movie(6, 7.6F))
    movieMap.put(7, new Movie(7, 10.21F))
    movieMap.put(8, new Movie(8, 1.1F))
    movieMap.put(9, new Movie(9, 10.1F))
    movieMap.put(10, new Movie(10, 10.2F))
    movieMap.get(1).addSimilarMovie(movieMap.get(3))
    movieMap.get(1).addSimilarMovie(movieMap.get(2))
    movieMap.get(3).addSimilarMovie(movieMap.get(4))
    movieMap.get(2).addSimilarMovie(movieMap.get(5))
    movieMap.get(1).addSimilarMovie(movieMap.get(6))
    movieMap.get(3).addSimilarMovie(movieMap.get(7))
    movieMap.get(7).addSimilarMovie(movieMap.get(8))
    movieMap.get(7).addSimilarMovie(movieMap.get(9))
    movieMap.get(6).addSimilarMovie(movieMap.get(10))    
    rootMovie = movieMap.get(1)
    topN = 1
    assertEquals(List(movieMap.get(7)), MovieRecommendations.getMovieRecoms(rootMovie, topN))
  }

  def testGetRecommendsTop3 {
    val movieMap = new HashMap[Int, Movie]()
    var rootMovie = new Movie(0, 0.0F)
    var topN = 0
    movieMap.put(1, new Movie(1, 7.9F))
    movieMap.put(2, new Movie(2, 8.3F))
    movieMap.put(3, new Movie(3, 9.3F))
    movieMap.put(4, new Movie(4, 5.3F))
    movieMap.put(5, new Movie(5, 7.3F))
    movieMap.put(6, new Movie(6, 7.6F))
    movieMap.put(7, new Movie(7, 10.21F))
    movieMap.put(8, new Movie(8, 1.1F))
    movieMap.put(9, new Movie(9, 10.1F))
    movieMap.put(10, new Movie(10, 10.2F))
    movieMap.get(1).addSimilarMovie(movieMap.get(3))
    movieMap.get(1).addSimilarMovie(movieMap.get(2))
    movieMap.get(3).addSimilarMovie(movieMap.get(4))
    movieMap.get(2).addSimilarMovie(movieMap.get(5))
    movieMap.get(1).addSimilarMovie(movieMap.get(6))
    movieMap.get(3).addSimilarMovie(movieMap.get(7))
    movieMap.get(7).addSimilarMovie(movieMap.get(8))
    movieMap.get(7).addSimilarMovie(movieMap.get(9))
    movieMap.get(6).addSimilarMovie(movieMap.get(10))
    rootMovie = movieMap.get(1)
    topN = 3
    assertEquals(List(movieMap.get(7), movieMap.get(10), movieMap.get(9)), MovieRecommendations.getMovieRecoms(rootMovie, topN))
  }

  def testGetRecommends_N0 {
    val movieMap = new HashMap[Int, Movie]()
    var rootMovie = new Movie(0, 0.0F)
    var topN = 0
    movieMap.put(1, new Movie(1, 7.9F))
    movieMap.put(2, new Movie(2, 8.3F))
    movieMap.put(3, new Movie(3, 9.3F))
    movieMap.put(4, new Movie(4, 5.3F))
    movieMap.put(5, new Movie(5, 7.3F))
    movieMap.put(6, new Movie(6, 7.6F))
    movieMap.put(7, new Movie(7, 10.21F))
    movieMap.put(8, new Movie(8, 1.1F))
    movieMap.put(9, new Movie(9, 10.1F))
    movieMap.put(10, new Movie(10, 10.2F))
    movieMap.put(11, new Movie(11, 10.2F))
    movieMap.put(12, new Movie(12, 10.2F))
    movieMap.put(13, new Movie(13, 10.2F))
    movieMap.put(14, new Movie(14, 10.2F))
    movieMap.put(15, new Movie(15, 10.2F))
    movieMap.put(16, new Movie(16, 10.2F))
    movieMap.put(17, new Movie(17, 10.2F))

    movieMap.get(1).addSimilarMovie(movieMap.get(3))
    movieMap.get(1).addSimilarMovie(movieMap.get(2))
    movieMap.get(3).addSimilarMovie(movieMap.get(4))
    movieMap.get(2).addSimilarMovie(movieMap.get(5))
    movieMap.get(1).addSimilarMovie(movieMap.get(6))
    movieMap.get(3).addSimilarMovie(movieMap.get(7))
    movieMap.get(7).addSimilarMovie(movieMap.get(8))
    movieMap.get(7).addSimilarMovie(movieMap.get(9))
    movieMap.get(8).addSimilarMovie(movieMap.get(10))
    movieMap.get(9).addSimilarMovie(movieMap.get(11))
    movieMap.get(9).addSimilarMovie(movieMap.get(12))
    movieMap.get(10).addSimilarMovie(movieMap.get(13))
    movieMap.get(10).addSimilarMovie(movieMap.get(14))
    movieMap.get(11).addSimilarMovie(movieMap.get(15))
    movieMap.get(12).addSimilarMovie(movieMap.get(16))
    movieMap.get(12).addSimilarMovie(movieMap.get(17))
    rootMovie = movieMap.get(1)
    topN = 0
    assertEquals(List(), MovieRecommendations.getMovieRecoms(rootMovie, topN))
  }

  def testGetRecommends12 {
    val movieMap = new HashMap[Int, Movie]()
    var rootMovie = new Movie(0, 0.0F)
    var topN = 0
    movieMap.put(1, new Movie(1, 7.9F))
    movieMap.put(2, new Movie(2, 8.3F))
    movieMap.put(3, new Movie(3, 9.3F))
    movieMap.put(4, new Movie(4, 5.3F))
    movieMap.put(5, new Movie(5, 7.3F))
    movieMap.put(6, new Movie(6, 7.6F))
    movieMap.put(7, new Movie(7, 10.21F))
    movieMap.put(8, new Movie(8, 1.1F))
    movieMap.put(9, new Movie(9, 10.1F))
    movieMap.put(10, new Movie(10, 10.2F))
    movieMap.get(1).addSimilarMovie(movieMap.get(3))
    movieMap.get(1).addSimilarMovie(movieMap.get(2))
    movieMap.get(3).addSimilarMovie(movieMap.get(4))
    movieMap.get(2).addSimilarMovie(movieMap.get(5))
    movieMap.get(1).addSimilarMovie(movieMap.get(6))
    movieMap.get(3).addSimilarMovie(movieMap.get(7))
    movieMap.get(7).addSimilarMovie(movieMap.get(8))
    movieMap.get(7).addSimilarMovie(movieMap.get(9))
    movieMap.get(6).addSimilarMovie(movieMap.get(10))
    rootMovie = movieMap.get(1)
    topN = 12
    assertEquals(List(movieMap.get(3),
      movieMap.get(2),
      movieMap.get(6),
      movieMap.get(4),
      movieMap.get(7),
      movieMap.get(5),
      movieMap.get(10),
      movieMap.get(8),
      movieMap.get(9)), MovieRecommendations.getMovieRecoms(rootMovie, topN))
  }

  def testGetRecommends7_10 {
    val movieMap = new HashMap[Int, Movie]()
    var rootMovie = new Movie(0, 0.0F)
    var topN = 0
    movieMap.put(1, new Movie(1, 7.9F))
    movieMap.put(2, new Movie(2, 8.3F))
    movieMap.put(3, new Movie(3, 9.3F))
    movieMap.put(4, new Movie(4, 5.3F))
    movieMap.put(5, new Movie(5, 7.3F))
    movieMap.put(6, new Movie(6, 7.6F))
    movieMap.put(7, new Movie(7, 10.21F))
    movieMap.put(8, new Movie(8, 1.1F))
    movieMap.put(9, new Movie(9, 10.1F))
    movieMap.put(10, new Movie(10, 10.2F))
    movieMap.get(1).addSimilarMovie(movieMap.get(3))
    movieMap.get(1).addSimilarMovie(movieMap.get(2))
    movieMap.get(3).addSimilarMovie(movieMap.get(4))
    movieMap.get(2).addSimilarMovie(movieMap.get(5))
    movieMap.get(1).addSimilarMovie(movieMap.get(6))
    movieMap.get(3).addSimilarMovie(movieMap.get(7))
    movieMap.get(7).addSimilarMovie(movieMap.get(8))
    movieMap.get(7).addSimilarMovie(movieMap.get(9))
    movieMap.get(6).addSimilarMovie(movieMap.get(10))
    rootMovie = movieMap.get(1)
    topN = 2
    assertEquals(List(movieMap.get(7), movieMap.get(10)), MovieRecommendations.getMovieRecoms(rootMovie, topN))
  }
}