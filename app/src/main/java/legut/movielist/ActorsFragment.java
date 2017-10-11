package legut.movielist;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class ActorsFragment extends Fragment {
    private RecyclerView recyclerView;
    private ActorsAdapter aAdapter;
    Movie movie;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.actors_list_fragment, container, false);
        movie=MainActivity.movieList.get(getArguments().getInt("position"));
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        aAdapter = new ActorsAdapter(movie.actors);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(view.getContext().getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(aAdapter);
        return view;
    }
}
