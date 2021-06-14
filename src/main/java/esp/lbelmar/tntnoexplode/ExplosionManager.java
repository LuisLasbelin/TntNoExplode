package esp.lbelmar.tntnoexplode;

import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.entity.EntityExplodeEvent;

import java.util.List;

public class ExplosionManager implements Listener {

    TntNoExplode plugin;

    public ExplosionManager(TntNoExplode tntNoExplode) {
        plugin = tntNoExplode;
    }

    @EventHandler
    public void onExplodeEntity(EntityExplodeEvent event) {
        List<Block> blocks = event.blockList();
        new RegenRun(blocks).runTaskTimer(plugin, 1, 1);
        event.setYield(0);
    }

    @EventHandler
    public void onExplodeBlock(BlockExplodeEvent event) {
        List<Block> blocks = event.blockList();
        new RegenRun(blocks).runTaskTimer(plugin, 1, 1);
        event.setYield(0);
    }
}
