package collections_task;

public class Main {
    public static void main(String[] args) {
        MoviesLibrary library = new MoviesLibrary();

        library.addMovie("Mask");
        library.addMovie("Titanic");
        library.addMovie("Home Alone");
        library.addMovie("Lion King");
        library.addMovie("Speed");
        library.addMovie("Terminator");
        library.addMovie("Mad Max");
        library.addMovie("Mask");
        library.addMovie("Titanic");

        library.showMoviesCollection();

        library.deleteMovie("Titanic");
        library.deleteMovie("Some abstract movie");

        library.showMoviesCollection();
    }
}
