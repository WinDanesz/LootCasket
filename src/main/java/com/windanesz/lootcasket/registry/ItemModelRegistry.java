package com.windanesz.lootcasket.registry;

import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public final class ItemModelRegistry {
	private ItemModelRegistry() { // no instances
	}

	@SubscribeEvent
	public static void register(ModelRegistryEvent event) {
		registerItemModel(ItemRegistry.small_casket); // Standard item model
	}

	public static void registerItemModel(Item item) {
		ModelBakery.registerItemVariants(item, new ModelResourceLocation(item.getRegistryName(), "inventory"));
		ModelLoader.setCustomMeshDefinition(item, s -> new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}

}

