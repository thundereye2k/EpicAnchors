package com.songoda.epicanchors.hooks;

import br.net.fabiozumbi12.RedProtect.Bukkit.API.RedProtectAPI;
import br.net.fabiozumbi12.RedProtect.Bukkit.RedProtect;
import br.net.fabiozumbi12.RedProtect.Bukkit.Region;
import com.songoda.epicanchors.api.utils.ProtectionPluginHook;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class HookRedProtect implements ProtectionPluginHook {

    private final RedProtect redProtect;

    public HookRedProtect() {
        this.redProtect = RedProtect.get();
    }

    @Override
    public JavaPlugin getPlugin() {
        return redProtect;
    }

    @Override
    public boolean canBuild(Player player, Location location) {
        RedProtectAPI api = redProtect.getAPI();
        Region region = api.getRegion(location);
        
        return region != null && region.canBuild(player);
    }

}