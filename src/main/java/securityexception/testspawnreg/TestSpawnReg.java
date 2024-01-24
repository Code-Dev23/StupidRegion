package securityexception.testspawnreg;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;
import securityexception.testspawnreg.commands.SetSpawnRegCommand;
import securityexception.testspawnreg.listeners.PlayerListeners;
import securityexception.testspawnreg.managers.SpawnManager;

public final class TestSpawnReg extends JavaPlugin {

    @Getter
    private static TestSpawnReg instance;
    @Getter
    private SpawnManager spawnManager;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        spawnManager = new SpawnManager();

        getServer().getPluginManager().registerEvents(new PlayerListeners(), this);
        getCommand("setspawnreg").setExecutor(new SetSpawnRegCommand());
    }

    @Override
    public void onDisable() {

    }
}
