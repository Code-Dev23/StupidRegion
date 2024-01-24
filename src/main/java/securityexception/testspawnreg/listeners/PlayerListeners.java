package securityexception.testspawnreg.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import securityexception.testspawnreg.TestSpawnReg;

public class PlayerListeners implements Listener {
    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        if (TestSpawnReg.getInstance().getSpawnManager().getCuboid().isIn(player))
            event.setCancelled(true);

    }
}
