package com.github.draylar.fi.config;

import com.github.draylar.fi.FluidInteractionMaps;
import com.github.draylar.fi.FluidInteractions;
import com.google.common.jimfs.File;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.Block;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ConfigIO
{
    public static void checkConfigFolder()
    {
        Path configPath = Paths.get(FabricLoader.getInstance().getConfigDirectory() + "");
        if(configPath.toFile().isDirectory()) checkConfigFile(configPath);

        // create folder if it doesn't exit
        else
        {
            configPath.toFile().mkdirs();
            checkConfigFile(configPath);
        }
    }

    public static void checkConfigFile(Path path)
    {
        Path configPath = Paths.get(path + "/fluid-interactions.config");

        if(!configPath.toFile().exists()) createNewFile(configPath);

        try
        {
            String input = new String(Files.readAllBytes(configPath));
            loadConfigFromString(input);
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void loadConfigFromString(String config)
    {
        String[] lines = config.split("\n");

        for(String s : lines)
        {
            s = s.replace(" ", "");

            Identifier blockIdentifier = new Identifier(s.substring(s.indexOf("\"") + 1, s.lastIndexOf("\"")));
            int weight = Integer.parseInt(s.substring(s.indexOf(",") + 1, s.indexOf(")")));
            Block registryBlock = Registry.BLOCK.get(blockIdentifier);

            if(s.startsWith("cobble")) FluidInteractionMaps.addRandomCobblestone(registryBlock.getDefaultState(), weight);
            else if (s.startsWith("stone")) FluidInteractionMaps.addRandomStone(registryBlock.getDefaultState(), weight);
            else if (s.startsWith("obsidian")) FluidInteractionMaps.addRandomObsidian(registryBlock.getDefaultState(), weight);
        }
    }

    private static void createNewFile(Path path)
    {
        try
        {
            path.toFile().createNewFile();
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
