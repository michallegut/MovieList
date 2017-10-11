package legut.movielist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final List<Movie> movieList = new ArrayList<>();
    private static boolean initialized=false;
    private RecyclerView recyclerView;
    private MoviesAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mAdapter = new MoviesAdapter(movieList);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                if (findViewById(R.id.fragment_container) != null) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("position", position);
                    MovieDetailsFragment firstFragment = new MovieDetailsFragment();
                    firstFragment.setArguments(bundle);
                    getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, firstFragment).addToBackStack("firstFragment").commit();
                }
            }

            @Override
            public void onLongClick(View view, int position) {
                Movie movie = movieList.get(position);
                View icon = recyclerView.findViewHolderForAdapterPosition(position).itemView.findViewById(R.id.icon);
                if (!movie.isObserved()) icon.setVisibility(View.VISIBLE);
                else icon.setVisibility(View.INVISIBLE);
                movie.setObserved(!movie.isObserved());
            }
        }));
        ItemTouchHelper swipeToDismissTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction)
            {
                movieList.remove(viewHolder.getLayoutPosition());
                mAdapter.notifyDataSetChanged();
            }
        });
        swipeToDismissTouchHelper.attachToRecyclerView(recyclerView);
        if (!initialized) prepareMovieData();
        initialized=true;
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
            super.onBackPressed();
        } else {
            getSupportFragmentManager().popBackStack();
            getSupportFragmentManager().popBackStack();
        }
    }

    private void prepareMovieData() {
        Movie movie = new Movie("Mad Max: Fury Road", "Action & Adventure", "2015", "A woman rebels against a tyrannical ruler in postapocalyptic Australia in search for her home-land with the help of a group of female prisoners, a psychotic worshipper, and a drifter named Max.", getResources().getIdentifier("mad_max_fury_road", "drawable", this.getPackageName()));
        movieList.add(movie);

        movie = new Movie("Inside Out", "Animation, Kids & Family", "2015", "After young Riley is uprooted from her Midwest life and moved to San Francisco, her emotions - Joy, Fear, Anger, Disgust and Sadness - conflict on how best to navigate a new city, house, and school.", getResources().getIdentifier("inside_out", "drawable", this.getPackageName()));
        movieList.add(movie);

        movie = new Movie("Star Wars: Episode VII - The Force Awakens", "Action", "2015", "Three decades after the defeat of the Galactic Empire, a new threat arises. The First Order attempts to rule the galaxy and only a ragtag group of heroes can stop them, along with the help of the Resistance.", getResources().getIdentifier("the_force_awakens", "drawable", this.getPackageName()));
        movieList.add(movie);

        movie = new Movie("Shaun the Sheep", "Animation", "2015", "When Shaun decides to take the day off and have some fun, he gets a little more action than he bargained for. A mix up with the Farmer, a caravan and a very steep hill lead them all to the Big City and it's up to Shaun and the flock to return everyone safely to the green grass of home.", getResources().getIdentifier("shaun_the_sheep", "drawable", this.getPackageName()));
        movieList.add(movie);

        movie = new Movie("The Martian", "Science Fiction & Fantasy", "2015", "An astronaut becomes stranded on Mars after his team assume him dead, and must rely on his ingenuity to find a way to signal to Earth that he is alive.", getResources().getIdentifier("the_martian", "drawable", this.getPackageName()));
        movieList.add(movie);

        movie = new Movie("Mission: Impossible Rogue Nation", "Action", "2015", "Ethan and team take on their most impossible mission yet, eradicating the Syndicate - an International rogue organization as highly skilled as they are, committed to destroying the IMF.", getResources().getIdentifier("mission_impossible_rogue_nation", "drawable", this.getPackageName()));
        movieList.add(movie);

        movie = new Movie("Up", "Animation", "2009", "Seventy-eight year old Carl Fredricksen travels to Paradise Falls in his home equipped with balloons, inadvertently taking a young stowaway.", getResources().getIdentifier("up", "drawable", this.getPackageName()));
        movieList.add(movie);

        movie = new Movie("Star Trek", "Science Fiction", "2009", "The brash James T. Kirk tries to live up to his father's legacy with Mr. Spock keeping him in check as a vengeful Romulan from the future creates black holes to destroy the Federation one planet at a time.", getResources().getIdentifier("star_trek", "drawable", this.getPackageName()));
        movieList.add(movie);

        movie = new Movie("The LEGO Movie", "Animation", "2014", "An ordinary Lego construction worker, thought to be the prophesied 'Special', is recruited to join a quest to stop an evil tyrant from gluing the Lego universe into eternal stasis.", getResources().getIdentifier("the_lego_movie", "drawable", this.getPackageName()));
        movieList.add(movie);

        movie = new Movie("Iron Man", "Action & Adventure", "2008", "After being held captive in an Afghan cave, billionaire engineer Tony Stark creates a unique weaponized suit of armor to fight evil.", getResources().getIdentifier("iron_man", "drawable", this.getPackageName()));
        movieList.add(movie);

        movie = new Movie("Aliens", "Science Fiction", "1986", "The moon has been colonized, but contact is lost. This time, the rescue team has impressive firepower, but will it be enough?", getResources().getIdentifier("aliens", "drawable", this.getPackageName()));
        movieList.add(movie);

        movie = new Movie("Chicken Run", "Animation", "2000", "When a cockerel apparently flies into a chicken farm, the chickens see him as an opportunity to escape their evil owners.", getResources().getIdentifier("chicken_run", "drawable", this.getPackageName()));
        movieList.add(movie);

        movie = new Movie("Back to the Future", "Science Fiction", "1985", "Marty McFly, a 17-year-old high school student, is accidentally sent 30 years into the past in a time-traveling DeLorean invented by his close friend, the maverick scientist Doc Brown.", getResources().getIdentifier("back_to_the_future", "drawable", this.getPackageName()));
        movieList.add(movie);

        movie = new Movie("Raiders of the Lost Ark", "Action & Adventure", "1981", "Archaeologist and adventurer Indiana Jones is hired by the U.S. government to find the Ark of the Covenant before the Nazis.", getResources().getIdentifier("raiders_of_the_lost_ark", "drawable", this.getPackageName()));
        movieList.add(movie);

        movie = new Movie("Goldfinger", "Action & Adventure", "1965", "Investigating a gold magnate's smuggling, James Bond uncovers a plot to contaminate the Fort Knox gold reserve.", getResources().getIdentifier("goldfinger", "drawable", this.getPackageName()));
        movieList.add(movie);

        movie = new Movie("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014", "A group of intergalactic criminals are forced to work together to stop a fanatical warrior from taking control of the universe.", getResources().getIdentifier("guardians_of_the_galaxy", "drawable", this.getPackageName()));
        movieList.add(movie);

        int photo = getResources().getIdentifier("cage_satan", "drawable", this.getPackageName());
        for (Movie m : movieList) {
            for (int j = 0; j < 5; j++) {
                m.actors.add(new Actor(photo, "Nicolas Cage"));
            }
        }
    }
}