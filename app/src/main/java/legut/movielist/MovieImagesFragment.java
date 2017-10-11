package legut.movielist;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.content.ContextCompat;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieImagesFragment extends Fragment {
    @BindView(R.id.imageView) ImageView imageView;
    @BindView(R.id.imageView2) ImageView imageView2;
    @BindView(R.id.imageView3) ImageView imageView3;
    @BindView(R.id.imageView4) ImageView imageView4;
    @BindView(R.id.imageView5) ImageView imageView5;
    @BindView(R.id.imageView6) ImageView imageView6;

    Movie movie;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.movie_images_fragment, container, false);
        ButterKnife.bind(this, view);
        movie=MainActivity.movieList.get(getArguments().getInt("position"));
        imageView.setImageDrawable(ContextCompat.getDrawable(getContext().getApplicationContext(), movie.getImageId()));
        imageView2.setImageDrawable(ContextCompat.getDrawable(getContext().getApplicationContext(), movie.getImageId()));
        imageView3.setImageDrawable(ContextCompat.getDrawable(getContext().getApplicationContext(), movie.getImageId()));
        imageView4.setImageDrawable(ContextCompat.getDrawable(getContext().getApplicationContext(), movie.getImageId()));
        imageView5.setImageDrawable(ContextCompat.getDrawable(getContext().getApplicationContext(), movie.getImageId()));
        imageView6.setImageDrawable(ContextCompat.getDrawable(getContext().getApplicationContext(), movie.getImageId()));
        return view;
    }
}