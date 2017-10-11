package legut.movielist;

class Actor {
    private int photo;
    private String name;

    Actor(int photo, String name) {
        this.photo = photo;
        this.name = name;
    }

    int getPhoto() {
        return photo;
    }

    public String getName() {
        return name;
    }
}
