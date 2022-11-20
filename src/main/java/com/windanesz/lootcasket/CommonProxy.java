package com.windanesz.lootcasket;

import net.minecraft.util.text.Style;

public class CommonProxy {

	public String translate(String key, Object... args){
		return translate(key, new Style(), args);
	}

	public String translate(String key, Style style, Object... args){
		return key;
	}
}
