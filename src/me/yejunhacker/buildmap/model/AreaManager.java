package me.yejunhacker.buildmap.model;

import org.bukkit.Location;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class AreaManager {
    private static final Map<String, BuildArea> areaMap = new HashMap<>();

    public static void createArea(String name, Location p1, Location p2, String owner) {
        areaMap.put(name, new BuildArea(name, p1, p2, owner));
    }

    public static void rateArea(String name, UUID player, int score) {
        if (areaMap.containsKey(name)) {
            areaMap.get(name).rate(player, score);
        }
    }

    public static Map<String, BuildArea> getAreas() {
        return areaMap;
    }
}
