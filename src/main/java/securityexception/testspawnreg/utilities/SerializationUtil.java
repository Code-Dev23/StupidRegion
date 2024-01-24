package securityexception.testspawnreg.utilities;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public class SerializationUtil {
    public static String locationToString(Location location) {
        if (location == null) return "";

        return location.getWorld().getName() +
                ";" +
                location.getBlockX() +
                ";" +
                location.getBlockY() +
                ";" +
                location.getBlockZ() +
                ";" +
                location.getYaw() +
                ";" +
                location.getPitch();
    }

    public static Location stringToLocation(String string) {
        if (string == null || string.isEmpty()) return null;

        String[] fields = string.split(";");

        try {
            return new Location(
                    Bukkit.getWorld(fields[0]),
                    Integer.parseInt(fields[1]),
                    Integer.parseInt(fields[2]),
                    Integer.parseInt(fields[3]),
                    Float.parseFloat(fields[4]),
                    Float.parseFloat(fields[5])
            );
        } catch (Exception ignored) {
        }

        return null;
    }
}
