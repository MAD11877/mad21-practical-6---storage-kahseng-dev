package sg.edu.np.mad.madpractical;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {
    private final static String TAG = "Main Activity";

    static ArrayList<User> userList = new ArrayList<>();
    DBHandler dbHandler = new DBHandler(this, "users.db", null , 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Log.v(TAG, "Create");
        dbHandler.deleteDatabase(this);

        for (int i = 0; i < 20; i++) {
            User newUser = new User();
            newUser.setName("Name" + new Random().nextInt());
            newUser.setDescription("Description " + new Random().nextInt());
            newUser.setFollowed(new Random().nextBoolean());
            newUser.setId(i);
            dbHandler.addUser(newUser);
        }

        userList = dbHandler.getUsers();
        RecyclerView recyclerView = findViewById(R.id.rv);
        UserAdapter mAdapter = new UserAdapter(userList);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
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