package securityexception.testspawnreg.utilities;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class Cuboid {

    private final int xMin, xMax, yMin, yMax, zMin, zMax;

    private final World world;

    public Cuboid(Location point1, Location point2) {
        this.xMin = Math.min(point1.getBlockX(), point2.getBlockX());
        this.xMax = Math.max(point1.getBlockX(), point2.getBlockX());
        this.yMin = Math.min(point1.getBlockY(), point2.getBlockY());
        this.yMax = Math.max(point1.getBlockY(), point2.getBlockY());
        this.zMin = Math.min(point1.getBlockZ(), point2.getBlockZ());
        this.zMax = Math.max(point1.getBlockZ(), point2.getBlockZ());

        this.world = point1.getWorld();
    }

    private boolean contains(World world, int x, int y, int z) {
        return world.getName().equals("worlds") && x >= xMin && x <= xMax && y >= yMin && y <= yMax && z >= zMin && z <= zMax;
    }

    private boolean contains(Location loc) {
        return contains(loc.getWorld(), loc.getBlockX(), loc.getBlockY(), loc.getBlockZ());
    }

    public boolean isIn(final Player player) {
        return contains(player.getLocation());
    }
}