package esp.lbelmar.tntnoexplode;

import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.w3c.dom.Entity;

import java.util.List;
import java.util.Objects;

public class ExplosionManager implements Listener {

    TntNoExplode plugin;

    public ExplosionManager(TntNoExplode tntNoExplode) {
        plugin = tntNoExplode;
    }

    @EventHandler
    public void onExplodeEntity(EntityExplodeEvent event) {
        // Reading from the config
        // State can be
        // only_creeper, only_tnt, all, none
        String state = plugin.getConfig().getString("config-explosion");

        switch (Objects.requireNonNull(state)) {
            case "only-creeper":
                if(event.getEntity().getType().equals(EntityType.CREEPER)) {
                    List<Block> blocks = event.blockList();
                    new RegenRun(blocks).runTaskTimer(plugin, 1, 1);
                    event.setYield(0);
                }
                break;
            case "only-tnt":
                if(event.getEntity().getType().equals(EntityType.PRIMED_TNT) || event.getEntity().getType().equals(EntityType.MINECART_TNT) || event.getEntity().getType().equals(EntityType.ENDER_CRYSTAL)) {
                    List<Block> blocks = event.blockList();
                    new RegenRun(blocks).runTaskTimer(plugin, 1, 1);
                    event.setYield(0);
                }
                break;
            case "all":
                List<Block> blocks = event.blockList();
                new RegenRun(blocks).runTaskTimer(plugin, 1, 1);
                event.setYield(0);
                break;
            default:
                break;
        }
    }

    @EventHandler
    public void onExplodeBlock(BlockExplodeEvent event) {
        List<Block> blocks = event.blockList();
        new RegenRun(blocks).runTaskTimer(plugin, 1, 1);
        event.setYield(0);
    }
}
