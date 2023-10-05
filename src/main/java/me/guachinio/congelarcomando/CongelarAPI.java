package me.guachinio.congelarcomando;

import org.bukkit.entity.Player;

import java.util.ArrayList;

public class CongelarAPI {

    public static Main MainClass = Main.instancia;

    public static ArrayList<Player> jogadoresCongelados = new ArrayList<Player>();

    public static void registrarCongelado(String player) {
        MainClass.getConfig().set(player, true);
        MainClass.saveConfig();
    }
    public static void removerCongelado(String player) {
        MainClass.getConfig().set(player, null);
        MainClass.saveConfig();
    }

    public static boolean estaCongelado(Player player) {
        String congelado = MainClass.getConfig().getString(player.getName());
        boolean isCongelado;
        if(congelado == "true"){
            isCongelado = true;
        }else{
            isCongelado = false;
        }
        return isCongelado;
    }
}
