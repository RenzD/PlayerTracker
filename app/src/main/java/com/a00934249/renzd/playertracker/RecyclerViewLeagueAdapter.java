package com.a00934249.renzd.playertracker;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.a00934249.renzd.playertracker.MyDB.Player;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

import static android.app.Activity.RESULT_OK;
import static com.a00934249.renzd.playertracker.LeagueActivity.adapter;

public class RecyclerViewLeagueAdapter extends RecyclerView.Adapter<RecyclerViewLeagueAdapter.ViewHolder> {
    private static final String TAG = "RecyclerViewLeagueAdapt";

    private ArrayList<String> mImageUrls;
    private ArrayList<String> mPlayerNames;
    private ArrayList<String> mPlayerFG;
    private ArrayList<String> mPlayerAst;
    private ArrayList<String> mPlayerReb;
    private ArrayList<String> mPlayerPts;
    private Context mContext;
    private List<Player> players;
    LeagueActivity league = new LeagueActivity();

    public Intent intent;


    public RecyclerViewLeagueAdapter(List<Player> players, Context mContext) {
        this.players = players;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listleague, parent, false);
        return new ViewHolder(view, league);
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

        holder.parent_layout5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on an image: " + players.get(position).playerName);
                Toast.makeText(mContext, players.get(position).playerName, Toast.LENGTH_SHORT).show();
                intent = new Intent();
                intent.putExtra("playerID", players.get(position).id);
                //((LeagueActivity)mContext).setResult(RESULT_OK, adapter.intent);
                //((LeagueActivity)mContext).finish();
                return;
            }
        });
            /*
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d(TAG, "onClick: clicked on an image: " + players.get(position).playerName);
                    Toast.makeText(mContext, players.get(position).playerName, Toast.LENGTH_SHORT).show();
                    //league.done("playerID", players.get(position).id);
                    //league.finish();
                }
            });
*/
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
        ConstraintLayout parent_layout5;

        public ViewHolder(View itemView, LeagueActivity mActivity) {
            super(itemView);
            image = itemView.findViewById(R.id.player_img3);
            playerName = itemView.findViewById(R.id.player_name3);
            playerFG = itemView.findViewById(R.id.player_fg3);
            playerAst = itemView.findViewById(R.id.player_ast3);
            playerReb = itemView.findViewById(R.id.player_reb3);
            playerPts = itemView.findViewById(R.id.player_pts3);
            parent_layout5 = itemView.findViewById(R.id.parent_layout5);
        }
    }
}
