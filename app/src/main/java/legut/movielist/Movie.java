package legut.movielist;

import java.util.ArrayList;
import java.util.List;

class Movie {
    private String title;
    private String genre;
    private String year;
    private String description;
    private int imageId;
    private float rating;
    private boolean observed;
    List<Actor> actors;

    Movie(String title, String genre, String year, String description, int imageId) {
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.description = description;
        this.imageId = imageId;
        rating=0;
        observed=false;
        actors = new ArrayList<>();
    }

    String getTitle() {
        return title;
    }

    String getYear() {
        return year;
    }

    String getGenre() {
        return genre;
    }

    int getImageId() {
        return imageId;
    }

    String getDescription() {
        return description;
    }

    float getRating() {
        return rating;
    }

    void setRating(float rating) {
        this.rating = rating;
    }

    boolean isObserved() {
        return observed;
    }

    void setObserved(boolean observed) {
        this.observed = observed;
    }
}