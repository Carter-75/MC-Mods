package com.flatxpgain.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;

@Config(name = "flat_xp_gain")
public class ModConfig implements ConfigData {
    public boolean modEnabled = true;
    public boolean flatXpEnabled = false;
    public boolean linearXpEnabled = true;
    
    public int level1XpCost = 100;
    public int nextXpAddition = 1;
}
