package esp.lbelmar.tntnoexplode;

import esp.lbelmar.tntnoexplode.command.AutoTabExplosion;
import esp.lbelmar.tntnoexplode.command.CommandConfigExplosion;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class TntNoExplode extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.saveDefaultConfig();

        getServer().getPluginManager().registerEvents(new ExplosionManager(this), this);

        Objects.requireNonNull(this.getCommand("configExplosion")).setExecutor(new CommandConfigExplosion());

        Objects.requireNonNull(getCommand("configExplosion")).setTabCompleter(new AutoTabExplosion());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
