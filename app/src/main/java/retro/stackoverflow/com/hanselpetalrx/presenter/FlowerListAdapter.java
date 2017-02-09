package retro.stackoverflow.com.hanselpetalrx.presenter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import retro.stackoverflow.com.hanselpetalrx.R;
import retro.stackoverflow.com.hanselpetalrx.model.Flower;

/**
 * Created by rmcg2 on 05/02/2017.
 */

public class FlowerListAdapter extends RecyclerView.Adapter<FlowerViewHolder> {

    List<Flower> flowerList;

    public FlowerListAdapter(List<Flower> data) {
        this.flowerList = data;
    }

    public void populate(List<Flower> data){
        flowerList.clear();
        flowerList.addAll(data);
        notifyDataSetChanged();

    }

    // Called when RCV is first created - this creates an instance of the viewholder
    @Override
    public FlowerViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(
                viewGroup.getContext()).inflate(
                R.layout.list_item_view,
                viewGroup, false);
        return new FlowerViewHolder(view);
    }

    // This binds the data to the viewholder
    @Override
    public void onBindViewHolder(FlowerViewHolder holder, int position) {
        // Need to get current position from the data list that was passed to the view populate method
        Flower flower = flowerList.get(position);
        holder.flowerNameView.setText(flower.getName());
        holder.flowerDescriptionView.setText(flower.getDescription());
        holder.flowerPriceView.setText(String.valueOf(flower.getPrice()));
    }

    @Override
    public int getItemCount() {
        return flowerList != null ? flowerList.size() : 0;
    }
}
