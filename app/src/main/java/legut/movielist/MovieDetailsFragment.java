package legut.movielist;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.content.ContextCompat;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MovieDetailsFragment extends Fragment {
    @BindView(R.id.bigImage) ImageView bigImage;
    @BindView(R.id.movieTitle) TextView movieTitle;
    @BindView(R.id.ratingBar) RatingBar ratingBar;
    @BindView(R.id.description) TextView description;
    @BindView(R.id.button) Button button;

    Movie movie;
    int position;

    @Override
    public void onPause() {
        super.onPause();
        movie.setRating(ratingBar.getRating());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.movie_details_fragment, container, false);
        ButterKnife.bind(this, view);
        position=getArguments().getInt("position");
        movie=MainActivity.movieList.get(position);
        bigImage.setImageDrawable(ContextCompat.getDrawable(getContext().getApplicationContext(), movie.getImageId()));
        movieTitle.setText(movie.getTitle());
        ratingBar.setRating(movie.getRating());
        description.setText(movie.getDescription());
        return view;
    }

    @OnClick(R.id.button)
    public void button(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("position", position);
        MovieImagesFragment secondFragment = new MovieImagesFragment();
        secondFragment.setArguments(bundle);
        getFragmentManager().beginTransaction().add(R.id.fragment_container, secondFragment).addToBackStack("secondFragment").commit();
        ActorsFragment thirdFragment = new ActorsFragment();
        thirdFragment.setArguments(bundle);
        getFragmentManager().beginTransaction().add(R.id.fragment_container, thirdFragment).addToBackStack("thirdFragment").commit();
    }
}