package com.griffinpuc.serverstats;

import com.griffinpuc.serverstats.Library.User;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class EventListener implements Listener
{

    DatabaseConnection connection;

    public EventListener(DatabaseConnection connection){
        this.connection = connection;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) throws Exception {
        Player newPlayer = event.getPlayer();
        User loggedUser = this.connection.checkUser(newPlayer.getUniqueId().toString());

        if(loggedUser == null){
            System.out.println("USER DOESNT EXIST YET");
        }

    }

}