package ru.lxckscream.lsannouncements.manager;

import org.bukkit.scheduler.BukkitRunnable;
import ru.lxckscream.lsannouncements.Main;
import ru.lxckscream.lsannouncements.announcement.Announcement;

import java.util.List;

public class AnnouncementsManager {
    List<Announcement> announcements;

    public AnnouncementsManager() {
        new BukkitRunnable() {

            @Override
            public void run() {

            }
        }.runTaskTimer(Main.)
    }

    public List<Announcement> getAnnouncements() {
        return announcements;
    }

    public void setAnnouncements(List<Announcement> announcements) {
        this.announcements = announcements;
    }
}
