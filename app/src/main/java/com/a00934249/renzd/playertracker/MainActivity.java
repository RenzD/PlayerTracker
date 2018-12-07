package com.a00934249.renzd.playertracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.a00934249.renzd.playertracker.MyDB.Player;
import com.a00934249.renzd.playertracker.MyDB.AppDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final int SEARCH_ACTIVITY_REQUEST_CODE = 0;
    private static final String TAG = "MainActivity";

    //vars
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mPlayerFG = new ArrayList<>();
    private ArrayList<String> mPlayerAst = new ArrayList<>();
    private ArrayList<String> mPlayerReb = new ArrayList<>();
    private ArrayList<String> mPlayerPts = new ArrayList<>();

    private Toolbar toolbar;
    private List<Player> players;
    public static RecyclerView recyclerView;
    public static RecyclerViewAdapter adapter;
    AppDatabase db;

    List<Integer> playerIds = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: started.");

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("PlayerTracker");
        setSupportActionBar(toolbar);
        db = AppDatabase.getInstance(getApplication());
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplication()));
        playerIds.add(1);
        players = db.playerDao().loadAllByIds(playerIds);
        adapter = new RecyclerViewAdapter(players, getApplication());
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        DividerItemDecoration itemDecor = new DividerItemDecoration(this, layoutManager.getOrientation());
        recyclerView.addItemDecoration(itemDecor);
        //getImages();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == SEARCH_ACTIVITY_REQUEST_CODE){
            if (resultCode == RESULT_OK){

                for (Player p: players)
                    Log.d(TAG, p.playerName);
                adapter.swap(players);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_search) {
            startActivityForResult(new Intent(this, LeagueActivity.class), SEARCH_ACTIVITY_REQUEST_CODE);
            return true;
        }
        return false;
    }

    public void goToLeague(View v) {
        Toast.makeText(this, "HI", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, LeagueActivity.class);
        startActivity(intent);
    }

    /*

    private void getImages(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mImageUrls.add("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg");
        mNames.add("Havasu Falls");
        mPlayerFG.add("0.555");
        mPlayerAst.add("1");
        mPlayerReb.add("2");
        mPlayerPts.add("30");

        mImageUrls.add("https://i.redd.it/tpsnoz5bzo501.jpg");
        mNames.add("Trondheim");
        mPlayerFG.add("0.555");
        mPlayerAst.add("1");
        mPlayerReb.add("2");
        mPlayerPts.add("30");

        mImageUrls.add("https://i.redd.it/qn7f9oqu7o501.jpg");
        mNames.add("Portugal");
        mPlayerFG.add("0.555");
        mPlayerAst.add("1");
        mPlayerReb.add("2");
        mPlayerPts.add("30");

        mImageUrls.add("https://i.redd.it/j6myfqglup501.jpg");
        mNames.add("Rocky Mountain National Park");
        mPlayerFG.add("0.555");
        mPlayerAst.add("5");
        mPlayerReb.add("2");
        mPlayerPts.add("30");

        mImageUrls.add("https://i.redd.it/0h2gm1ix6p501.jpg");
        mNames.add("Mahahual");
        mPlayerFG.add("0.555");
        mPlayerAst.add("1");
        mPlayerReb.add("6");
        mPlayerPts.add("30");

        mImageUrls.add("https://i.redd.it/k98uzl68eh501.jpg");
        mNames.add("Frozen Lake");
        mPlayerFG.add("0.555");
        mPlayerAst.add("1");
        mPlayerReb.add("2");
        mPlayerPts.add("30");

        initRecyclerView();

    }

    private void initRecyclerView() {
        Log.d(TAG, "initRecyclerView: init recyclerView.");
        RecyclerView recyclerView = findViewById(R.id.recycler);
        Log.d(TAG, "initRecyclerView: RecyclerView recyclerView");
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(players, this);
        Log.d(TAG, "initRecyclerView: RecyclerViewAdapter adapter");
        recyclerView.setAdapter(adapter);
        Log.d(TAG, "initRecyclerView: recyclerView.setAdapter(adapter);");
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Log.d(TAG, "initRecyclerView: recyclerView.setLayoutManager");

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        DividerItemDecoration itemDecor = new DividerItemDecoration(this, layoutManager.getOrientation());
        recyclerView.addItemDecoration(itemDecor);
    }
    */
}
