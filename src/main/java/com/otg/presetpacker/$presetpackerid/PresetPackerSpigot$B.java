package com.otg.presetpacker.$presetpackerid;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.jar.JarFile;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PresetPackerSpigot$B extends JavaPlugin {
    @Override
    public void onEnable() {
        Logger logger = Bukkit.getLogger();
        try {
            String presetFolderPath = new File(".").getCanonicalPath() + File.separator + "plugins" + File.separator + "OpenTerrainGenerator" + File.separator + "Presets" + File.separator;
            logger.log(Level.INFO, "Starting extraction of ${modDisplayName}");
            JarFile jarFile = new JarFile(new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().getFile()));
            int filesWritten = new PresetUnpackUtil$B().extractPreset(jarFile, presetFolderPath);
            jarFile.close();
            logger.log(Level.INFO, "Preset ${modDisplayName} extracted, wrote "+filesWritten+" files");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
