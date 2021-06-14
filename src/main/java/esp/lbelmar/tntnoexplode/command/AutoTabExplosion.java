package esp.lbelmar.tntnoexplode.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AutoTabExplosion implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {

        if (command.getName().equals("configExplosion")) {

            List<String> mainArguments = Arrays.asList("none", "only-creeper", "only-tnt", "all");
            List<String> finalList = new ArrayList<>();

            for (String string : mainArguments) {
                // This only works if the player has already started typing the subcommand
                if (string.startsWith(args[0].toLowerCase())) {
                    finalList.add(string);
                }
            }
            Collections.sort(finalList);
            return finalList;
        }
        return null;
    }
}
