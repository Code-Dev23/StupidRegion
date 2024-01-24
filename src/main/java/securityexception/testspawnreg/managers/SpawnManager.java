package securityexception.testspawnreg.managers;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.Location;
import securityexception.testspawnreg.TestSpawnReg;
import securityexception.testspawnreg.utilities.Cuboid;
import securityexception.testspawnreg.utilities.SerializationUtil;

@Getter @Setter
public class SpawnManager {
    private Cuboid cuboid;
    private Location pos1, pos2;

    public SpawnManager() {
        Location pos1 = SerializationUtil.stringToLocation(TestSpawnReg.getInstance().getConfig().getString("SPAWN_REG.POS1"));
        Location pos2 = SerializationUtil.stringToLocation(TestSpawnReg.getInstance().getConfig().getString("SPAWN_REG.POS2"));
        if (pos1 == null || pos2 == null) {
            System.out.println("Position 1 or 2 not found!");
            return;
        }
        setPos1(pos1);
        setPos2(pos2);
        setCuboid(new Cuboid(pos1, pos2));
    }
}
