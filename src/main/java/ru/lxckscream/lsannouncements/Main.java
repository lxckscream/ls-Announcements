package ru.lxckscream.lsannouncements;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import ru.lxckscream.lsannouncements.announcement.Announcement;
import ru.lxckscream.lsannouncements.announcement.AnnouncementType;
import ru.lxckscream.lsannouncements.commands.AnnouncementCommand;
import ru.lxckscream.lsannouncements.manager.AnnouncementsManager;

import static ru.lxckscream.lsannouncements.utils.Hex.color;

public final class Main extends JavaPlugin {
    static AnnouncementsManager announcementsManager;
    static Main instance;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        announcementsManager = new AnnouncementsManager();
        getCommand("announcements").setExecutor(new AnnouncementCommand());

        // Initialization
        for (String ln : getConfig().getConfigurationSection("announcements").getKeys(false)) {
            AnnouncementType announcementType = AnnouncementType.valueOf(getConfig().getString("announcements." + ln + ".type"));
            Announcement announcement = new Announcement(getConfig().getString(ln), announcementType, getConfig().getInt("announcements." + ln + ".delay"), color(getConfig().getStringList("announcements." + ln + ".message")));
            if (announcementType == AnnouncementType.ALL_PLAYERS_WITH_PERMISSION) {
                if (getConfig().getString("announcements." + ln + ".permission") == null) {
                    getLogger().severe("Error with initialize " + ln + "! Please check, set is permission setting?");
                } else {
                    announcement.setPermission(getConfig().getString("announcements." + ln + ".permission"));
                    announcementsManager.getAnnouncements().add(announcement);
                }
            } else if (announcementType == AnnouncementType.SPECIAL_PLAYERS) {
                if (getConfig().getStringList("announcements." + ln + ".special-players") == null) {
                    getLogger().severe("Error with initialize " + ln + "! Please check, set is permission setting?");
                } else {
                    announcement.setSpecialPlayers(getConfig().getStringList("announcements." + ln + ".special-players"));
                    announcementsManager.getAnnouncements().add(announcement);
                }
            } else if (announcementType == AnnouncementType.PLAYERS_IN_WORLD) {
                if (getConfig().getStringList("announcements." + ln + ".world") == null) {
                    getLogger().severe("Error with initialize " + ln + "! Please check, set is permission setting?");
                } else {
                    announcement.setWorld(getConfig().getStringList("announcements." + ln + ".world"));
                    announcementsManager.getAnnouncements().add(announcement);
                }
            } else if (announcementType == AnnouncementType.ALL_PLAYERS) {
                announcementsManager.getAnnouncements().add(announcement);
            } else {
                getLogger().severe("Unknown type for announcement " + ln + "!");
            }
        }
    }

    public static Main getInstance() {
        return instance;
    }

    public static AnnouncementsManager getAnnouncementsManager() {
        return announcementsManager;
    }
}
