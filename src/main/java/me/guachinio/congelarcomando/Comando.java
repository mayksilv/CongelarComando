package me.guachinio.congelarcomando;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Comando implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player p = (Player) commandSender;
            if (strings.length == 1) {
                Player playerfromargs = Bukkit.getPlayerExact(strings[0]);
                if(playerfromargs != null && playerfromargs.isOnline()) {
                    if (!CongelarAPI.estaCongelado(playerfromargs)) {
                        p.sendMessage("Você congelou " + strings[0]);
                        CongelarAPI.registrarCongelado(strings[0]);
                    } else {
                        p.sendMessage("Você descongelou " + strings[0]);
                        CongelarAPI.removerCongelado(strings[0]);
                    }
                }else{
                    p.sendMessage("§cEste jogador não está online!");
                }
            } else {
                return false;
            }
        } else {
            commandSender.sendMessage("§cVocê é um console!");
        }

        return true;
    }
}
