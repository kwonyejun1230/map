package me.yejunhacker.buildmap;

import org.bukkit.plugin.java.JavaPlugin;
import me.yejunhacker.buildmap.commands.MapCommand;

public class BuildMapPlugin extends JavaPlugin {
    private static BuildMapPlugin instance;

    @Override
    public void onEnable() {
        instance = this;
        getCommand("map").setExecutor(new MapCommand());
        getLogger().info("[BuildMap] 플러그인 활성화 완료");
    }

    public static BuildMapPlugin getInstance() {
        return instance;
    }
}
