package com.griffinpuc.serverstats.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandInfo implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            player.sendMessage("Server Stats Plugin v1.0 BETA");

        }

        // If the player (or console) uses our command correct, we can return true
        return true;
    }

}
