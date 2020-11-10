package com.griffinpuc.serverstats;

import com.griffinpuc.serverstats.Commands.CommandInfo;
import org.bukkit.plugin.java.JavaPlugin;

public final class Serverstats extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        //Commands
        this.getCommand("info").setExecutor(new CommandInfo());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
