package sg.edu.np.mad.madpractical;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = "Main Activity";

    static User user = new User();
    DBHandler dbHandler = new DBHandler(this, "users.db", null , 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.v(TAG, "Create");

        TextView userName = findViewById(R.id.userName);
        TextView userDescription = findViewById(R.id.userDescription);
        Button followButton = findViewById(R.id.btnFollow);

        int id = getIntent().getIntExtra("id", 0);
        user = ListActivity.userList.get(id);

        userName.setText(user.name);
        userDescription.setText(user.description);
        followButton.setText(user.isFollowed() ? "Unfollow" : "Follow");

        followButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                user.setFollowed(!user.isFollowed());
                followButton.setText(user.isFollowed() ? "Unfollow" : "Follow");

                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(
                        MainActivity.this,
                        !user.isFollowed() ? "Unfollowed" : "Followed",
                        duration
                );
                toast.show();

                dbHandler.updateUser(user);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(TAG, "Start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG, "Resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG, "Pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(TAG, "Stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG, "Destroy");
    }
}