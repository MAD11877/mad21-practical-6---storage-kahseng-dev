package sg.edu.np.mad.madpractical;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class UserViewHolder extends RecyclerView.ViewHolder {
    ImageView image;
    ImageView imageBig;
    TextView name;
    TextView description;

    public UserViewHolder(View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.img_profile);
        imageBig = itemView.findViewById(R.id.img_profile_big);
        name = itemView.findViewById(R.id.name);
        description = itemView.findViewById(R.id.description);
    }
}
