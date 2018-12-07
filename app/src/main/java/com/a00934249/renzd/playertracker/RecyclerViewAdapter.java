package com.a00934249.renzd.playertracker;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.a00934249.renzd.playertracker.MyDB.Player;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<String> mImageUrls;
    private ArrayList<String> mPlayerNames;
    private ArrayList<String> mPlayerFG;
    private ArrayList<String> mPlayerAst;
    private ArrayList<String> mPlayerReb;
    private ArrayList<String> mPlayerPts;
    private Context mContext;
    private List<Player> players;

    MainActivity ma = new MainActivity();

    public RecyclerViewAdapter(List<Player> players, Context mContext) {
        this.players = players;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        Glide.with(mContext)
                .asBitmap()
                .load(players.get(position).imageURL)
                .into(holder.image);

        holder.playerName.setText(players.get(position).playerName);
        holder.playerFG.setText(String.valueOf(players.get(position).playerFG));
        holder.playerAst.setText(String.valueOf(players.get(position).playerAst));
        holder.playerReb.setText(String.valueOf(players.get(position).playerReb));
        holder.playerPts.setText(String.valueOf(players.get(position).playerPts));


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on an image: " + players.get(position).playerName);
                Toast.makeText(mContext, players.get(position).playerName, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(mContext, PlayerActivity.class);
                intent.putExtra("Player", players.get(position));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intent);
            }
        });
    }

    public void swap(List list) {
        if (players != null) {
            players.clear();
            players.addAll(list);
        } else {
            players = list;
        }
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return players.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView image;
        TextView playerName;
        TextView playerFG;
        TextView playerAst;
        TextView playerReb;
        TextView playerPts;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.player_img);
            playerName = itemView.findViewById(R.id.player_name);
            playerFG = itemView.findViewById(R.id.player_fg);
            playerAst = itemView.findViewById(R.id.player_ast);
            playerReb = itemView.findViewById(R.id.player_reb);
            playerPts = itemView.findViewById(R.id.player_pts);
        }
    }
}
