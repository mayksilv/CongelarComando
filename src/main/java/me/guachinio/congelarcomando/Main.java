package me.guachinio.congelarcomando;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    public static Main instancia;
    @Override
    public void onEnable() {
        instancia = this;
        instancia.saveDefaultConfig();
        instancia.saveConfig();
        System.out.println("[GuachinioFreezer] Plugin iniciado!");
        // Plugin startup logic
        getCommand("congelar").setExecutor(new Comando());
        getServer().getPluginManager().registerEvents(new Eventos(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
