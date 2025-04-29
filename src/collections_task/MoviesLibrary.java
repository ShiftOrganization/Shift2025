package collections_task;

import java.util.Set;
import java.util.TreeSet;

public class MoviesLibrary implements Watchable {
    private Set<String> movies;

    public MoviesLibrary() {
        movies = new TreeSet<>();
    }

    @Override
    public void addMovie(String movie) {
        if (movies.add(movie)) {
            System.out.println("Фильм \"" + movie + "\" добавлен");
        } else {
            System.out.println("Фильм \"" + movie + "\" уже есть в моей коллекции");
        }
    }

    @Override
    public void deleteMovie(String movie) {
        if (movies.remove(movie)) {
            System.out.println("Фильм \"" + movie + "\" удален");
        } else {
            System.out.println("Фильм \"" + movie + "\" не найден");
        }
    }

    @Override
    public void showMoviesCollection() {
        System.out.println("Вот список моих фильмов: " + movies);
    }
}
