package com.windanesz.lootcasket.client;

import com.windanesz.lootcasket.CommonProxy;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.text.Style;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {

	@Override
	public String translate(String key, Style style, Object... args) {
		return style.getFormattingCode() + I18n.format(key, args);
	}
}