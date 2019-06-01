package com.github.draylar.fi.config;

import me.sargunvohra.mcmods.autoconfig1.ConfigData;
import me.sargunvohra.mcmods.autoconfig1.annotation.Config;

import java.util.HashMap;

@Config(name = "fluidinteractions")
public class FIConfig implements ConfigData
{
    public HashMap<String, Integer> cobblestone = new HashMap<>();
    public HashMap<String, Integer> stone = new HashMap<>();
    public HashMap<String, Integer> obsidian = new HashMap<>();
}
