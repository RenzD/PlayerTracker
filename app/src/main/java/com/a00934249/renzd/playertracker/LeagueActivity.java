package com.a00934249.renzd.playertracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.a00934249.renzd.playertracker.MyDB.AppDatabase;
import com.a00934249.renzd.playertracker.MyDB.Player;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class LeagueActivity extends AppCompatActivity
{
    public static final int SEARCH_ACTIVITY_REQUEST_CODE = 0;
    private static final String TAG = "LeagueActivity";
    private Toolbar toolbar;
    private List<Player> players;
    public static RecyclerView recyclerView;
    public static RecyclerViewLeagueAdapter adapter;
    AppDatabase db;

    private ArrayList<String> mImageUrls = new ArrayList<>();
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mPlayerFG = new ArrayList<>();
    private ArrayList<String> mPlayerAst = new ArrayList<>();
    private ArrayList<String> mPlayerReb = new ArrayList<>();
    private ArrayList<String> mPlayerPts = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_league);
        Log.d(TAG, "onCreate: started");

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("League");
        setSupportActionBar(toolbar);
        db = AppDatabase.getInstance(getApplication());
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplication()));
        players = db.playerDao().getALL();
        adapter = new RecyclerViewLeagueAdapter(players, getApplication());
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        DividerItemDecoration itemDecor = new DividerItemDecoration(this, layoutManager.getOrientation());
        recyclerView.addItemDecoration(itemDecor);

        //getIncomingIntent();

        //getLeaguePlayers();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == SEARCH_ACTIVITY_REQUEST_CODE){
            if (resultCode == RESULT_OK){
                players = db.playerDao().filterQuery(
                        "%" + data.getStringExtra("Name") + "%"
                        );
                for (Player p: players)
                    Log.d(TAG, p.playerName);
                adapter.swap(players);
            }
        }
    }

    public void done(View view) {

        Log.d(TAG, "done: intent");
        setResult(RESULT_OK, adapter.intent);
        finish();
        return;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_search) {
            startActivityForResult(new Intent(this, SearchActivity.class), SEARCH_ACTIVITY_REQUEST_CODE);
            return true;
        }
        if (item.getItemId() == R.id.action_back) {
            finish();
            return true;
        }
        return false;
    }

    /*
    private void getIncomingIntent() {
        Log.d(TAG, "getIncomingIntent: checking for incoming intents");
        if(getIntent().hasExtra("image_url") && getIntent().hasExtra("player_name")) {
            Log.d(TAG, "getIncomingIntent: found intent extras.");
            String imageUrl = getIntent().getStringExtra("image_url");
            String playerName = getIntent().getStringExtra("player_name");
            setImage(imageUrl, playerName);
        }
    }

    private void setImage(String imageUrl, String playerName) {
        Log.d(TAG, "setImage: setting to image and name to widget");
        TextView name = findViewById(R.id.playerName);
        name.setText(playerName);
        ImageView image = findViewById(R.id.playerIMG);
        Glide.with(this)
                .asBitmap()
                .load(imageUrl)
                .into(image);
    }
*/
    /*
    private void getLeaguePlayers(){
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

        initRecyclerView();

    }

    private void initRecyclerView() {
        Log.d(TAG, "initRecyclerView2: init recyclerView.");
        RecyclerView recyclerView = findViewById(R.id.recycler);
        RecyclerViewLeagueAdapter adapter = new RecyclerViewLeagueAdapter(players, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        DividerItemDecoration itemDecor = new DividerItemDecoration(this, layoutManager.getOrientation());
        recyclerView.addItemDecoration(itemDecor);
    }
    */
}

