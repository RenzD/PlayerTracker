package com.a00934249.renzd.playertracker.MyDB;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "players")
public class Player implements Serializable {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "player name")
    public String playerName;

    @ColumnInfo(name = "image URL")
    public String imageURL;

    @ColumnInfo(name = "player FG")
    public double playerFG;

    @ColumnInfo(name = "player Ast")
    public double playerAst;

    @ColumnInfo(name = "player Reb")
    public double playerReb;

    @ColumnInfo(name = "player Pts")
    public double playerPts;

    @ColumnInfo(name = "player Mp")
    public String playerMp;

    @ColumnInfo(name = "player 3P")
    public String player3P;

    @ColumnInfo(name = "player 3PA")
    public String player3PA;

    @ColumnInfo(name = "player 2P")
    public String player2P;

    @ColumnInfo(name = "player 2PA")
    public String player2PA;

    @ColumnInfo(name = "player eFG")
    public String playereFG;

    @ColumnInfo(name = "player FT")
    public String playerFT;

    @ColumnInfo(name = "player Stl")
    public String playereStl;

    @ColumnInfo(name = "player Blk")
    public String playerBlk;

    @ColumnInfo(name = "player Tov")
    public String playerTov;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public double getPlayerFG() {
        return playerFG;
    }

    public void setPlayerFG(double playerFG) {
        this.playerFG = playerFG;
    }

    public double getPlayerAst() {
        return playerAst;
    }

    public void setPlayerAst(int playerAst) {
        this.playerAst = playerAst;
    }

    public double getPlayerReb() {
        return playerReb;
    }

    public void setPlayerReb(int playerReb) {
        this.playerReb = playerReb;
    }

    public double getPlayerPts() {
        return playerPts;
    }

    public void setPlayerPts(int playerPts) {
        this.playerPts = playerPts;
    }

    public void setPlayerBlk(String playerBlk) {
        this.playerBlk = playerBlk;
    }

    public String getPlayerMp() {
        return playerMp;
    }

    public void setPlayerMp(String playerMp) {
        this.playerMp = playerMp;
    }

    public String getPlayer3P() {
        return player3P;
    }

    public void setPlayer3P(String player3P) {
        this.player3P = player3P;
    }

    public String getPlayer3PA() {
        return player3PA;
    }

    public void setPlayer3PA(String player3PA) {
        this.player3PA = player3PA;
    }

    public String getPlayer2P() {
        return player2P;
    }

    public void setPlayer2P(String player2P) {
        this.player2P = player2P;
    }

    public String getPlayer2PA() {
        return player2PA;
    }

    public void setPlayer2PA(String player2PA) {
        this.player2PA = player2PA;
    }

    public String getPlayereFG() {
        return playereFG;
    }

    public void setPlayereFG(String playereFG) {
        this.playereFG = playereFG;
    }

    public String getPlayerFT() {
        return playerFT;
    }

    public void setPlayerFT(String playerFT) {
        this.playerFT = playerFT;
    }

    public String getPlayereStl() {
        return playereStl;
    }

    public void setPlayereStl(String playereStl) {
        this.playereStl = playereStl;
    }

    public String getPlayerBlk() {
        return playerBlk;
    }

    public void setPlayereBlk(String playerBlk) {
        this.playerBlk = playerBlk;
    }

    public String getPlayerTov() {
        return playerTov;
    }

    public void setPlayerTov(String playerTov) {
        this.playerTov = playerTov;
    }

    public Player(String playerName, String imageURL, double playerFG, double playerAst, double playerReb, double playerPts, String playerMp,
                  String player3P, String player3PA, String player2P, String player2PA, String playereFG, String playerFT, String playereStl,
                  String playerBlk, String playerTov) {
        this.playerName = playerName;
        this.imageURL = imageURL;
        this.playerFG = playerFG;
        this.playerAst = playerAst;
        this.playerReb = playerReb;
        this.playerPts = playerPts;
        this.playerMp = playerMp;
        this.player3P = player3P;
        this.player3PA = player3PA;
        this.player2P = player2P;
        this.player2PA = player2PA;
        this.playereFG = playereFG;
        this.playerFT = playerFT;
        this.playereStl = playereStl;
        this.playerBlk = playerBlk;
        this.playerTov = playerTov;
    }

    public static Player[] populateData() {
        return new Player[]{
                new Player("1 Curry", "https://b.fssta.com/uploads/application/nba/headshots/1550.vresize.350.425.medium.7.png", 0.55, 5, 3, 30
                        , "28", "5", "10", "6", "10", "0.560", "0.900", "3", "0.5", "2"),
                new Player("2 Curry", "https://b.fssta.com/uploads/application/nba/headshots/1550.vresize.350.425.medium.7.png", 0.55, 5, 3, 30
                        , "28", "5", "10", "6", "10", "0.560", "0.900", "3", "0.5", "2"),
                new Player("3 Curry", "https://b.fssta.com/uploads/application/nba/headshots/1550.vresize.350.425.medium.7.png", 0.55, 5, 3, 30
                        , "28", "5", "10", "6", "10", "0.560", "0.900", "3", "0.5", "2"),
                new Player("4 Curry", "https://b.fssta.com/uploads/application/nba/headshots/1550.vresize.350.425.medium.7.png", 0.55, 5, 3, 30
                        , "28", "5", "10", "6", "10", "0.560", "0.900", "3", "0.5", "2"),
                new Player("5 Curry", "https://b.fssta.com/uploads/application/nba/headshots/1550.vresize.350.425.medium.7.png", 0.55, 5, 3, 30
                        , "28", "5", "10", "6", "10", "0.560", "0.900", "3", "0.5", "2"),
                new Player("6 Curry", "https://nhl.bamcontent.com/images/headshots/current/168x168/8474564.jpg", 0.55, 5, 3, 30
                        , "28", "5", "10", "6", "10", "0.560", "0.900", "3", "0.5", "2"),
                new Player("7 Curry", "https://nhl.bamcontent.com/images/headshots/current/168x168/8474564.jpg", 0.55, 5, 3, 30
                        , "28", "5", "10", "6", "10", "0.560", "0.900", "3", "0.5", "2"),
                new Player("8Curry", "https://nhl.bamcontent.com/images/headshots/current/168x168/8474564.jpg", 0.55, 5, 3, 30
                        , "28", "5", "10", "6", "10", "0.560", "0.900", "3", "0.5", "2"),
                new Player("9 Curry", "https://nhl.bamcontent.com/images/headshots/current/168x168/8474564.jpg", 0.55, 5, 3, 30
                        , "28", "5", "10", "6", "10", "0.560", "0.900", "3", "0.5", "2"),

                //new Player("", "", "", "", "", "", "", "", "", "", "", ""),
        };
    }
}
