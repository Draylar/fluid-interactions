package com.github.draylar.fi;

import com.github.draylar.fi.config.ConfigIO;
import net.fabricmc.api.ModInitializer;

public class FluidInteractions implements ModInitializer
{
	@Override
	public void onInitialize()
	{
		ConfigIO.checkConfigFolder();
	}
}
