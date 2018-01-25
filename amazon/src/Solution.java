package amazon;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Solution
{
/*    public static class Movie
    {
        private final int movieId;
        private final float rating;
        private List<Movie> similarMovies; // Similarity is bidirectional

        public Movie(int movieId, float rating)
        {
            this.movieId = movieId;
            this.rating = rating;
            similarMovies = new ArrayList<Movie>();
        }

        public int getId()
        {
            return movieId;
        }

        public float getRating()
        {
            return rating;
        }

        public void addSimilarMovie(Movie movie)
        {
            similarMovies.add(movie);
            movie.similarMovies.add(this);
        }

        public List<Movie> getSimilarMovies()
        {
            return similarMovies;
        }
    }*/

    /*
     * @param movie Current movie.
     * @param numTopRatedSimilarMovies the maximum number of recommended movies to return.
     * @return List of top rated similar movies. 
     * Assumptions I made: TODO 
     * Description of my approach: TODO 
     * Runtime complexity of my approach: TODO
     * Justification of runtime complexity: TODO
     */
    /*
     * Sample Input 

 
movie 1 1.2 
movie 2 3.6 
movie 3 2.4
movie 4 4.8
similar 1 2
similar 1 3
similar 2 4
similar 3 4
params 1 2
e

Sampel Input 2

movie 1 7.9 
movie 2 8.3 
movie 3 9.5
movie 4 5.4
movie 5 7.5
movie 6 7.6 
movie 7 10.21
movie 8 1.1
movie 9 10.1
movie 10 10.2
similar 1 3
similar 1 2
similar 3 4
similar 2 5
similar 1 6
similar 3 7
similar 7 8 
similar 7 9
similar 6 10
params 1 3
e

 */
    
    public static void main(String[] args) throws IOException
    {
        final Map<Integer, Movie> movieMap = new HashMap<Integer, Movie>();
        Movie rootMovie = null;
        int numTopRatedSimilarMovies = 0;

        final Scanner in = new Scanner(System.in);
        in.useLocale(new Locale("en", "US"));

        while (in.hasNextLine())
        {
            final String type = in.next();

            if (type.equals("movie"))
            {
                final int id = in.nextInt();
                final float rating = in.nextFloat();
                movieMap.put(id, new Movie(id, rating));
            }
            else if (type.equals("similar"))
            {
                final Movie movie1 = movieMap.get(in.nextInt());
                final Movie movie2 = movieMap.get(in.nextInt());
                movie1.addSimilarMovie(movie2);
            }
            else if (type.equals("params"))
            {
                rootMovie = movieMap.get(in.nextInt());
                numTopRatedSimilarMovies = in.nextInt();
            }
            else if (type.equals("e"))
            { 
                break;
                // ignore comments and whitespace
            }
        }

        final List<Movie> result = getMovieRecommendations(rootMovie, numTopRatedSimilarMovies);

        String output = "result";

        if (result == null)
        {
            output += " <null>";
        }
        else
        {
            Collections.sort(result, new Comparator<Object>()
            {
                @Override
                public int compare(Object m1, Object m2)
                {
                    return ((Movie) m1).getId() - ((Movie) m2).getId();
                }
            });

            for (Movie m : result)
            {
                output += " ";
                output += m.getId();
            }
        }

        System.out.println(output);
        System.out.println("Sth");

        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        bw.write(output);
        bw.newLine();
        bw.close();
    }

    private static List<Movie> getMovieRecommendations(Movie rootMovie, int numTopRatedSimilarMovies)
    {
        // TODO Auto-generated method stub
        return null;
    }
}
