package ru.lxckscream.lsannouncements.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import ru.lxckscream.lsannouncements.Main;
import ru.lxckscream.lsannouncements.manager.AnnouncementsManager;

import static ru.lxckscream.lsannouncements.utils.Hex.color;

public class AnnouncementCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
            if (strings.length == 2) {
                if (strings[0].equalsIgnoreCase("force-execute")) {
                    if (commandSender.hasPermission("lsannouncements.force-execute")) {
                        String arg = strings[0];
                        if (Main.getAnnouncementsManager().isContains(arg)) {
                            Main.getAnnouncementsManager().getAnnouncement(arg).execute();
                        } else {
                            commandSender.sendMessage(color(Main.getInstance().getConfig().getString("messages.no-exists")));
                        }
                    } else {
                        commandSender.sendMessage(color(Main.getInstance().getConfig().getString("messages.no-perms")));
                    }
                }
            } else {
                commandSender.sendMessage(color(Main.getInstance().getConfig().getString("messages.args-error")));
            }
        if (strings.length == 1) {
            if (strings[0].equalsIgnoreCase("reload")) {
                if (commandSender.hasPermission("lsannouncements.reload")) {
                    Main.getInstance().reloadConfig();
                    commandSender.sendMessage(color(Main.getInstance().getConfig().getString("messages.reloaded")));
                } else {
                    commandSender.sendMessage(color(Main.getInstance().getConfig().getString("messages.no-perms")));
                }
            }
        }
        return true;
    }
}
