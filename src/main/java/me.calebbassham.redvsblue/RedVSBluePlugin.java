package me.calebbassham.redvsblue;

import me.calebbassham.scenariomanager.api.ScenarioManagerInstance;
import org.bukkit.plugin.java.JavaPlugin;

public class RedVSBluePlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        ScenarioManagerInstance.getScenarioManager().register(new RedVSBlue(), this);
    }
}
