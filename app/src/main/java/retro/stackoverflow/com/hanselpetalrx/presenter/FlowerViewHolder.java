package retro.stackoverflow.com.hanselpetalrx.presenter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import retro.stackoverflow.com.hanselpetalrx.R;

/**
 * Created by rmcg2 on 05/02/2017.
 */
public class FlowerViewHolder extends RecyclerView.ViewHolder{

    public TextView flowerNameView, flowerDescriptionView, flowerPriceView;
    public ImageView flowerImageView;

    public FlowerViewHolder(View itemView) {
        super(itemView);
        flowerNameView = (TextView)itemView.findViewById(R.id.flower_name);
        flowerDescriptionView = (TextView)itemView.findViewById(R.id.flower_description);
        flowerPriceView = (TextView)itemView.findViewById(R.id.flower_price);
        flowerImageView = (ImageView)itemView.findViewById(R.id.flower_image);
    }
}
