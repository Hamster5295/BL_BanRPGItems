package org.BL.hamster5295.main;

import org.BL.hamster5295.Listener.Listener_Attack;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Logger;

public class Main extends JavaPlugin {

    private Logger log = getLogger();
    private File path = new File(getDataFolder()+File.separator);
    private File file = new File(getDataFolder()+File.separator+"banWorlds.txt");
    private String worlds;

    @Override
    public void onEnable() {
        log.info("Start loading BL_BanRPGItem");

        try {

            if (!path.mkdirs()) {
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
                worlds = String.valueOf(in.readChar());
            }else {
                file.createNewFile();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        Bukkit.getPluginManager().registerEvents(new Listener_Attack(),this);

        log.info("Loading completed.");
    }
}
