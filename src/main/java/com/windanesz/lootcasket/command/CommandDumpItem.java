package com.windanesz.lootcasket.command;

import com.windanesz.lootcasket.LootCasket;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.PlayerNotFoundException;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;

public class CommandDumpItem extends CommandBase {

	public String getName() {
		return "lcdumpitem";
	}

	@Override
	public int getRequiredPermissionLevel() {
		return 2;
	}

	@Override
	public boolean checkPermission(MinecraftServer server, ICommandSender p_71519_1_) {
		return true;
	}

	@Override
	public String getUsage(ICommandSender p_71518_1_) {
		return "commands." + LootCasket.MODID + ":lcdumpitem.usage";
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] arguments) throws CommandException {

		EntityPlayerMP player = null;
		try {
			player = getCommandSenderAsPlayer(sender);
		}
		catch (PlayerNotFoundException exception) {
			return;
		}

		if (!player.getHeldItemMainhand().isEmpty()) {
			NBTTagCompound nbt = new NBTTagCompound();
			player.getHeldItemMainhand().writeToNBT(nbt);
			player.sendMessage(new TextComponentString(nbt.toString()));
		} else {
			player.sendMessage(new TextComponentTranslation("commands." + LootCasket.MODID + ":lcdumpitem.usage"));
		}
	}
}
