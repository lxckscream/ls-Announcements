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
                for (Announcement announcement : announcements) {
                    if (announcement.getDelay() <= 0) {
                        announcement.execute();
                    } else {
                        Main.getInstance().getLogger().info("The announcement " + announcement.getName() + " will be executed then " + announcement.getDelay());
                        announcement.setDelay(announcement.getDelay()-1);
                    }
                }
            }
        }.runTaskTimer(Main.getInstance(), 20, 20);
    }

    public boolean isContains(String name) {
        for (Announcement announcement : announcements) {
            if (announcement.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public Announcement getAnnouncement(String name) {
        for (Announcement announcement : announcements) {
            if (announcement.getName().equals(name)) {
                return announcement;
            }
        }
        return null;
    }

    public List<Announcement> getAnnouncements() {
        return announcements;
    }

    public void setAnnouncements(List<Announcement> announcements) {
        this.announcements = announcements;
    }
}
