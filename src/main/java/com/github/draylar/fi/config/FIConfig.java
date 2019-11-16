package com.github.draylar.fi.config;

import com.github.draylar.fi.FluidInteractions;
import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;

import java.util.HashMap;

@Config(name = FluidInteractions.MODID)
public class FIConfig implements ConfigData {
    public HashMap<String, Integer> cobblestone = new HashMap<>();
    public HashMap<String, Integer> stone = new HashMap<>();
    public HashMap<String, Integer> obsidian = new HashMap<>();
}
