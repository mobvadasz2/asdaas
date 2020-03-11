package com.mobvadasz2.stats.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StatsCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender.hasPermission("stats.*"))
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (args.length == 0) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "§8§m-------------------------------"));
                    sender.sendMessage("");
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&fKilleid: &d" + player.getStatistic(Statistic.PLAYER_KILLS)));
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&fHalálaid: &d" + player.getStatistic(Statistic.DEATHS)));
                    sender.sendMessage("");
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "§8§m-------------------------------"));
                } else {
                    Player target = Bukkit.getPlayerExact(args[0]);
                    if (target != null) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "§8§m-------------------------------"));
                        sender.sendMessage("");
                        sender.sendMessage(ChatColor.LIGHT_PURPLE + target.getName());
                        sender.sendMessage("");
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&fKilljei: &d" + target.getStatistic(Statistic.PLAYER_KILLS)));
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&fHalálai: &d" + target.getStatistic(Statistic.DEATHS)));
                        sender.sendMessage("");
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "§8§m-------------------------------"));
                    } else {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&dA játékos nem letézik, vagy nem elérhető"));
                    }
                }
            } else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&fEhhez játékosnak kell lenned!"));
            }
        else {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&fNeked ehhez nincs jogod!"));
        }
        return false;
    }
}
