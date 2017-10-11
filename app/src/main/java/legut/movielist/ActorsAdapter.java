package legut.movielist;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

class ActorsAdapter extends RecyclerView.Adapter<ActorsAdapter.MyViewHolder> {
    private List<Actor> actorsList;

    class MyViewHolder extends RecyclerView.ViewHolder {
        CircleImageView photo;
        public TextView name;

        MyViewHolder(View view) {
            super(view);
            photo = (CircleImageView) view.findViewById(R.id.photo);
            name = (TextView) view.findViewById(R.id.name);
        }
    }

    ActorsAdapter(List<Actor> actorsList) {
        this.actorsList = actorsList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.actors_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Actor actor = actorsList.get(position);
        holder.photo.setImageDrawable(ContextCompat.getDrawable(holder.itemView.getContext(), actor.getPhoto()));
        holder.name.setText(actor.getName());
    }

    @Override
    public int getItemCount() {
        return actorsList.size();
    }
}