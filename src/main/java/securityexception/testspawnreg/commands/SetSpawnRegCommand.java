package securityexception.testspawnreg.commands;

import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import securityexception.testspawnreg.TestSpawnReg;
import securityexception.testspawnreg.utilities.Messages;
import securityexception.testspawnreg.utilities.SerializationUtil;

public class SetSpawnRegCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = (Player) sender;

        Block block = player.getTargetBlockExact(5);

        if (block == null)
            return false;
        if (args[0].equalsIgnoreCase("pos1")) {
            TestSpawnReg.getInstance().getConfig().set("SPAWN_REG.POS1", SerializationUtil.locationToString(block.getLocation()));
            TestSpawnReg.getInstance().saveConfig();
            player.sendMessage(Messages.color("&aFirst position configurated."));
            return true;
        }
        if (args[0].equalsIgnoreCase("pos2")) {
            TestSpawnReg.getInstance().getConfig().set("SPAWN_REG.POS2", SerializationUtil.locationToString(block.getLocation()));
            TestSpawnReg.getInstance().saveConfig();
            player.sendMessage(Messages.color("&aSecond position configurated."));
            return true;
        }

        return true;
    }
}
