package com.a00934249.renzd.playertracker.MyDB;

        import android.arch.persistence.room.Dao;
        import android.arch.persistence.room.Delete;
        import android.arch.persistence.room.Insert;
        import android.arch.persistence.room.Query;
        import android.arch.persistence.room.Update;

        import java.util.List;

@Dao
public interface PlayerDao {

    @Query("SELECT * FROM players")
    List<Player> getALL();

    @Query("SELECT * FROM players WHERE id IN (:playerIds)")
    List<Player> loadAllByIds(List<Integer> playerIds);

    @Query("SELECT * FROM players WHERE `player name` LIKE :playername LIMIT 1")
    Player findByName(String playername);


    @Query("SELECT * FROM players WHERE `player name` LIKE :name")
    List<Player> filterQuery(String name);

    @Insert
    void insertAll(Player... players);

    @Delete
    void delete(Player player);

    @Update
    void updatePlayers(Player... players);
}
