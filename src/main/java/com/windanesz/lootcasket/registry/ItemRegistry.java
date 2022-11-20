package com.windanesz.lootcasket.registry;

import com.windanesz.lootcasket.LootCasket;
import com.windanesz.lootcasket.item.ItemCasket;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.registries.IForgeRegistry;

import javax.annotation.Nonnull;

@ObjectHolder(LootCasket.MODID)
@Mod.EventBusSubscriber
public final class ItemRegistry {

	public static final Item small_casket = placeholder();

	private ItemRegistry() {} // No instances!

	@SubscribeEvent
	public static void register(RegistryEvent.Register<Item> event) {

		IForgeRegistry<Item> registry = event.getRegistry();
		registerItem(registry, "small_casket", LootCasket.MODID, new ItemCasket());
	}

	@Nonnull
	@SuppressWarnings("ConstantConditions")
	public static <T> T placeholder() { return null; }

	// below registry methods are courtesy of EB
	public static void registerItem(IForgeRegistry<Item> registry, String name, String modid, Item item) {
		registerItem(registry, name, modid, item, false);
	}

	public static void registerItem(IForgeRegistry<Item> registry, String name, String modid, Item item, boolean setTabIcon) {
		item.setRegistryName(modid, name);
		item.setTranslationKey(item.getRegistryName().toString());
		registry.register(item);

	}
}