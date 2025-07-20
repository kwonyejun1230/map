package me.yejunhacker.buildmap.gui;

import me.yejunhacker.buildmap.model.AreaManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MapGUI {
    public static void open(Player player) {
        Inventory inv = Bukkit.createInventory(null, 54, "§8[건축 구역 지도]");

        AreaManager.getAreas().forEach((name, area) -> {
            ItemStack item = new ItemStack(Material.GRASS_BLOCK);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§a" + name);
            meta.setLore(java.util.List.of(
                "§7건축자: " + area.owner(),
                "§7평점: " + area.getRatingAverage() + " / 5.0"
            ));
            item.setItemMeta(meta);
            inv.addItem(item);
        });

        player.openInventory(inv);
    }

    public static void handleClick(InventoryClickEvent e) {
        // 구현 생략: 클릭 시 정보 팝업 또는 순간이동 등
    }
}
