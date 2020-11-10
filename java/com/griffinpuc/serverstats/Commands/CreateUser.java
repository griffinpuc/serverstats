package com.griffinpuc.serverstats.Commands;

import com.griffinpuc.serverstats.DatabaseConnection;
import com.griffinpuc.serverstats.Serverstats;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CreateUser implements CommandExecutor {

    DatabaseConnection connection;

    public CreateUser(DatabaseConnection connection){
        this.connection = connection;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;


        }

        // If the player (or console) uses our command correct, we can return true
        return true;
    }

}
