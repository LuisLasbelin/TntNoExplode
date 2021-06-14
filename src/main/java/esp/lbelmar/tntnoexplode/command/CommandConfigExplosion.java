package esp.lbelmar.tntnoexplode.command;

import esp.lbelmar.tntnoexplode.TntNoExplode;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandConfigExplosion implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        TntNoExplode plugin = TntNoExplode.getPlugin(TntNoExplode.class);

        if (args[0].equalsIgnoreCase("none")) {
            // Writing to the config
            plugin.getConfig().set("config-explosion", "none");
            Bukkit.broadcastMessage("Explosion regeneration set to none, be careful!");
        }
        if (args[0].equalsIgnoreCase("only-creeper")) {
            // Writing to the config
            plugin.getConfig().set("config-explosion", "only-creeper");
            Bukkit.broadcastMessage("Explosion regeneration set to only creepers, you will still die from their explosions :)");
        }
        if (args[0].equalsIgnoreCase("only-tnt")) {
            // Writing to the config
            plugin.getConfig().set("config-explosion", "only-tnt");
            Bukkit.broadcastMessage("Explosion regeneration set to only TNT, seems like someone was being funny");
        }
        if (args[0].equalsIgnoreCase("all")) {
            // Writing to the config
            plugin.getConfig().set("config-explosion", "all");
            Bukkit.broadcastMessage("Explosion regeneration set to all, no destruction allowed!");
        }
        plugin.saveConfig();

        return true;
    }
}
