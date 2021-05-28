package sg.edu.np.mad.madpractical;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {
    ArrayList<User> data;

    public UserAdapter(ArrayList<User> input) {
        data = input;
    }

    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.user, parent, false);
        return new UserViewHolder(item);
    }

    public void onBindViewHolder(UserViewHolder holder, int position) {
        Context context = holder.itemView.getContext();
        User user = data.get(position);
        holder.name.setText(user.name);
        holder.description.setText(user.description);

        if (user.name.endsWith("7")) {
            holder.imageBig.setImageResource(R.mipmap.ic_launcher_round);
            holder.imageBig.setVisibility(View.VISIBLE);
        } else {
            holder.imageBig.setVisibility(View.GONE);
        }

        holder.image.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(context)
                    .setTitle("Profile")
                    .setMessage(user.name)
                    .setNegativeButton("Close", null)
                    .setPositiveButton("View", (dialog, id) -> {
                        Intent intent = new Intent(context, MainActivity.class);
                        intent.putExtra("id", position);
                        context.startActivity(intent);
                    });

            AlertDialog dialog = builder.create();
            dialog.show();
        });
    }

    public int getItemCount() {
        return data.size();
    }
}
