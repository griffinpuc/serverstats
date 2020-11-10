package com.griffinpuc.serverstats;

import com.griffinpuc.serverstats.Commands.CommandInfo;
import com.griffinpuc.serverstats.Commands.CreateUser;
import com.sun.tools.classfile.ConstantPool;
import org.bukkit.plugin.java.JavaPlugin;

import javax.xml.crypto.Data;

public final class Serverstats extends JavaPlugin {

    DatabaseConnection connection;

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.connection = new DatabaseConnection();

        //Commands
        this.getCommand("info").setExecutor(new CommandInfo(this.connection));
        this.getCommand("create").setExecutor(new CreateUser(this.connection));

        //Listener
        getServer().getPluginManager().registerEvents(new EventListener(this.connection), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
