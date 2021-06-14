package esp.lbelmar.tntnoexplode;

import org.bukkit.plugin.java.JavaPlugin;

public final class TntNoExplode extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new ExplosionManager(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
