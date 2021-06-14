package esp.lbelmar.tntnoexplode;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

public class RegenRun extends BukkitRunnable {

    ArrayList<BlockState> updatedBlockList = new ArrayList<>();

    public RegenRun(List<Block> blocks) {
        // Run for every block
        for (Block block : blocks) {
            updatedBlockList.add(block.getState());
        }
    }

    @Override
    public void run() {
        // Place of the current item
        int max = updatedBlockList.size() - 1;
        if(max > -1) {
            if(!updatedBlockList.get(max).getType().equals(Material.TNT)){
                updatedBlockList.get(max).update(true, false);
            }
            updatedBlockList.remove(max);
        }
    }
}
