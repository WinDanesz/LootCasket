package com.windanesz.lootcasket;

import com.windanesz.lootcasket.command.CommandDumpItem;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import org.apache.logging.log4j.Logger;

import java.util.Random;

@Mod(modid = LootCasket.MODID, name = LootCasket.NAME, version = "@VERSION@", acceptedMinecraftVersions = "[@MCVERSION@]")
public class LootCasket {

	public static final String MODID = "lootcasket";
	public static final String NAME = "Loot Casket";

	public static final Random rand = new Random();

	public static Logger logger;

	// The instance of wizardry that Forge uses.
	@Mod.Instance(LootCasket.MODID)
	public static LootCasket instance;

	// Location of the proxy code, used by Forge.
	@SidedProxy(clientSide = "com.windanesz.lootcasket.client.ClientProxy", serverSide = "com.windanesz.lootcasket.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		logger = event.getModLog();
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(instance);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) { }

	@EventHandler
	public void serverStarting(FMLServerStartingEvent event) {
		event.registerServerCommand(new CommandDumpItem());
	}
}
