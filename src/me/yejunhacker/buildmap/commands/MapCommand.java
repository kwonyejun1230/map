package me.yejunhacker.buildmap.commands;

import me.yejunhacker.buildmap.gui.MapGUI;
import me.yejunhacker.buildmap.model.AreaManager;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class MapCommand implements CommandExecutor {
    private final Map<String, Location> pos1 = new HashMap<>();
    private final Map<String, Location> pos2 = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) return false;

        if (args.length == 0) {
            MapGUI.open(player);
            return true;
        }

        String sub = args[0].toLowerCase();
        switch (sub) {
            case "pos1" -> {
                pos1.put(player.getName(), player.getLocation());
                player.sendMessage("§apos1 위치 저장 완료");
            }
            case "pos2" -> {
                pos2.put(player.getName(), player.getLocation());
                player.sendMessage("§apos2 위치 저장 완료");
            }
            case "setarea" -> {
                if (args.length < 2) {
                    player.sendMessage("§c구역 이름을 입력해주세요");
                    return true;
                }
                String name = args[1];
                if (!pos1.containsKey(player.getName()) || !pos2.containsKey(player.getName())) {
                    player.sendMessage("§cpos1과 pos2를 먼저 설정하세요");
                    return true;
                }
                AreaManager.createArea(name, pos1.get(player.getName()), pos2.get(player.getName()), player.getName());
                player.sendMessage("§a[BuildMap] 구역 '" + name + "' 생성 완료");
            }
            case "rate" -> {
                if (args.length < 3) {
                    player.sendMessage("§c/map rate <구역명> <1~5>");
                    return true;
                }
                String name = args[1];
                int rate = Integer.parseInt(args[2]);
                AreaManager.rateArea(name, player.getUniqueId(), rate);
                player.sendMessage("§a[BuildMap] 평가 완료");
            }
        }
        return true;
    }
}
