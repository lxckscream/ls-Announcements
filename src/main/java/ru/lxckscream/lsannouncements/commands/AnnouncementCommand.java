package ru.lxckscream.lsannouncements.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class AnnouncementCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender.hasPermission("lsannouncements.force-execute")) {
            if (strings.length == 2) {
                if (strings[0].equalsIgnoreCase("force-execute")) {

                }
            }
        }
        return true;
    }
}
