package tomoto.customanvilrecipe;

import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import tomoto.customanvilrecipe.commandexecutor.AnvilExecutor;
import tomoto.customanvilrecipe.commandexecutor.AnvilTabCompleter;
import tomoto.customanvilrecipe.guiinventory.clicklistener.CustomAnvilRecipe;

public final class AnvilMain extends JavaPlugin {
    private ProtocolManager protocolManager;
    @Override
    public void onEnable() {
        protocolManager = ProtocolLibrary.getProtocolManager();
        getCommand("anvil").setTabCompleter(new AnvilTabCompleter());
        getCommand("anvil").setExecutor(new AnvilExecutor());
        Bukkit.getPluginManager().registerEvents(new CustomAnvilRecipe(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
