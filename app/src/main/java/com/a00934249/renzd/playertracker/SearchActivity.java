package com.a00934249.renzd.playertracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;


public class SearchActivity extends AppCompatActivity {
    private Toolbar toolbar;
    public EditText playerName;
    public Spinner playerFG;
    public Spinner playerAst;
    public Spinner playerReb;
    public Spinner playerPts;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Search");
        setSupportActionBar(toolbar);

        playerName = findViewById(R.id.Name);
        playerFG = findViewById(R.id.FG);
        playerAst = findViewById(R.id.Ast);
        playerReb = findViewById(R.id.Reb);
        playerPts = findViewById(R.id.Pts);

    }

    public void filter(View v){

        Intent intent = new Intent();
        intent.putExtra("Name", playerName.getText().toString());
        intent.putExtra("playerFG", playerFG.getSelectedItem().toString());
        intent.putExtra("playerAst", playerAst.getSelectedItem().toString());
        intent.putExtra("playerReb", playerReb.getSelectedItem().toString());
        intent.putExtra("playerPts", playerPts.getSelectedItem().toString());
        setResult(RESULT_OK, intent);
        finish();
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
