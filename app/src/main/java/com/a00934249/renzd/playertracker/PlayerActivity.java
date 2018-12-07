package com.a00934249.renzd.playertracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.a00934249.renzd.playertracker.MyDB.Player;
import com.bumptech.glide.Glide;

public class PlayerActivity extends AppCompatActivity{


    private Player player;
    ImageView image;
    TextView playerName;
    TextView playerFG;
    TextView playerAst;
    TextView playerReb;
    TextView playerPts;
    TextView playerMp;
    TextView player3P;
    TextView player3PA;
    TextView player2P;
    TextView player2PA;
    TextView playereFG;
    TextView playerFT;
    TextView playerStl;
    TextView playerBlk;
    TextView playerTov;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        Toolbar toolbar;
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("PlayerTracker");
        setSupportActionBar(toolbar);
        player = (Player) getIntent().getSerializableExtra("Player");

        image = findViewById(R.id.imageView);
        playerName = findViewById(R.id.playerName);
        playerFG = findViewById(R.id.FieldGoal);
        playerAst = findViewById(R.id.Assist);
        playerReb = findViewById(R.id.Rebounds);
        playerPts = findViewById(R.id.Points);
        playerMp = findViewById(R.id.Minutes);
        player3P =findViewById(R.id.Threes);
        player3PA = findViewById(R.id.ThreesAttempts);
        player2P = findViewById(R.id.Twos);
        player2PA = findViewById(R.id.TwosAttempts);
        playereFG = findViewById(R.id.eFg);
        playerFT = findViewById(R.id.FreeThrow);
        playerStl = findViewById(R.id.Steals);
        playerBlk = findViewById(R.id.Blocks);
        playerTov = findViewById(R.id.Tov);
        setDisplay();
    }

    protected void setDisplay(){
        Glide.with(this).load(player.imageURL).into(image);
        playerName.setText(player.playerName);
        playerFG.setText(String.valueOf(player.playerFG));
        playerAst.setText(String.valueOf(player.playerAst));
        playerReb.setText(String.valueOf(player.playerReb));
        playerPts.setText(String.valueOf(player.playerPts));
        playerMp.setText(player.playerMp);
        player3P.setText(player.player3P);
        player3PA.setText(player.player3PA);
        player2P.setText(player.player2P);
        player2PA.setText(player.player2PA);
        playereFG.setText(player.playereFG);
        playerFT.setText(player.playerFT);
        playerStl.setText(player.playereStl);
        playerBlk.setText(player.playerBlk);
        playerTov.setText(player.playerTov);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.player_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_back) {
            finish();
            return true;
        }
        return false;
    }



}
