package me.yejunhacker.buildmap.model;

import org.bukkit.Location;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class BuildArea {
    public final String name;
    public final Location pos1, pos2;
    public final String owner;
    private final Set<UUID> voters = new HashSet<>();
    private int totalScore = 0;

    public BuildArea(String name, Location pos1, Location pos2, String owner) {
        this.name = name;
        this.pos1 = pos1;
        this.pos2 = pos2;
        this.owner = owner;
    }

    public double getRatingAverage() {
        if (voters.isEmpty()) return 0;
        return Math.round(((double) totalScore / voters.size()) * 10.0) / 10.0;
    }

    public void rate(UUID player, int score) {
        if (voters.contains(player)) return;
        voters.add(player);
        totalScore += score;
    }

    public String owner() { return owner; }
}
