package ru.lxckscream.lsannouncements.announcement;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.List;

public class Announcement {
    String name;
    AnnouncementType announcementType;
    int delay;
    int delayNotSet;
    List<String> messageLines;
    List<String> specialPlayers;
    List<String> world;
    String permission;

    public Announcement(String name, AnnouncementType announcementType, int delay, List<String> messageLines) {
        this.name = name;
        this.announcementType = announcementType;
        this.delay = delay;
        this.delayNotSet = delay;
        this.messageLines = messageLines;
    }

    public void execute() {
        if (announcementType == AnnouncementType.ALL_PLAYERS) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                for (String ln : messageLines) {
                    player.sendMessage(ln);
                }
            }
        }
        if (announcementType == AnnouncementType.ALL_PLAYERS_WITH_PERMISSION) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                if (player.hasPermission(permission)) {
                    for (String ln : messageLines) {
                        player.sendMessage(ln);
                    }
                }
            }
        }
        if (announcementType == AnnouncementType.SPECIAL_PLAYERS) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                if (specialPlayers.contains(player.getName())) {
                    for (String ln : messageLines) {
                        player.sendMessage(ln);
                    }
                }
            }
        }
        if (announcementType == AnnouncementType.PLAYERS_IN_WORLD) {
            for (String world : world) {
                getWorld().add(world);
            }
            for (Player player : Bukkit.getOnlinePlayers()) {
                if (world.contains(player.getWorld().getName())) {
                    for (String ln : messageLines) {
                        player.sendMessage(ln);
                    }
                }
            }
        }

        delay = delayNotSet;
    }

    public void setWorld(List<String> world) {
        this.world = world;
    }

    public List<String> getWorld() {
        return world;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAnnouncementType(AnnouncementType announcementType) {
        this.announcementType = announcementType;
    }

    public void setMessageLines(List<String> messageLines) {
        this.messageLines = messageLines;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public void setSpecialPlayers(List<String> specialPlayers) {
        this.specialPlayers = specialPlayers;
    }

    public String getName() {
        return name;
    }

    public AnnouncementType getAnnouncementType() {
        return announcementType;
    }

    public List<String> getSpecialPlayers() {
        return specialPlayers;
    }

    public List<String> getMessageLines() {
        return messageLines;
    }

    public String getPermission() {
        return permission;
    }
}
