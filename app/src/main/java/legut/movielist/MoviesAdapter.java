package legut.movielist;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {
    private List<Movie> moviesList;

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title, year, genre;
        ImageView image, icon;

        MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            genre = (TextView) view.findViewById(R.id.genre);
            year = (TextView) view.findViewById(R.id.year);
            image = (ImageView) view.findViewById(R.id.image);
            icon = (ImageView) view.findViewById(R.id.icon);
        }
    }

    MoviesAdapter(List<Movie> moviesList) {
        this.moviesList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Movie movie = moviesList.get(position);
        holder.setIsRecyclable(false);
        holder.title.setText(movie.getTitle());
        holder.genre.setText(movie.getGenre());
        holder.year.setText(movie.getYear());
        holder.image.setImageDrawable(ContextCompat.getDrawable(holder.itemView.getContext(), movie.getImageId()));
        if (movie.isObserved()) holder.icon.setVisibility(View.VISIBLE);
        if (position%2==1) {
            holder.title.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_END);
            holder.genre.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_END);
            holder.year.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_START);
            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams)holder.image.getLayoutParams();
            params.removeRule(RelativeLayout.ALIGN_PARENT_END);
            params.addRule(RelativeLayout.ALIGN_PARENT_START);
            holder.image.setLayoutParams(params);
        }
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}