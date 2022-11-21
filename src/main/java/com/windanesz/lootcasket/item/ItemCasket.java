package com.windanesz.lootcasket.item;

import com.windanesz.lootcasket.LootCasket;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.storage.loot.LootTable;
import net.minecraftforge.common.IRarity;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class ItemCasket extends Item {

	public ItemCasket() {
		super();
		setMaxStackSize(1);
		setCreativeTab(CreativeTabs.MISC);
	}

	public static EnumRarity getRarity(String rarity) {
		for (EnumRarity currentRarity : EnumRarity.values()) {
			if (currentRarity.name().equalsIgnoreCase(rarity)) { return currentRarity; }
		}
		return null;
	}

	public int getMaxItemUseDuration(ItemStack stack) {
		return 5;
	}

	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer playerIn, EnumHand handIn) {
		playerIn.setActiveHand(handIn);
		return new ActionResult<>(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
	}

	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add(LootCasket.proxy.translate("item." + this.getRegistryName().toString() + ".desc"));
	}

	@Override
	public IRarity getForgeRarity(ItemStack stack) {
		if (stack.hasTagCompound() && stack.getTagCompound().hasKey("Rarity")) {
			EnumRarity rarity = getRarity(stack.getTagCompound().getString("Rarity"));
			if (rarity != null) {
				return rarity;
			}
		}

		return super.getForgeRarity(stack);
	}

	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World world, EntityLivingBase entityLiving) {

		if (!world.isRemote && entityLiving instanceof EntityPlayer && stack.hasTagCompound()) {
			NBTTagCompound nbt = stack.getTagCompound();

			//noinspection ConstantConditions
			if (nbt.hasKey("LootTable")) {

				int rolls = nbt.hasKey("Rolls") ? nbt.getInteger("Rolls") : 1;

				String loottable = nbt.getString("LootTable");
				LootTable table = world.getLootTableManager().getLootTableFromLocation(new ResourceLocation(loottable));
				if (table == null) {
					return super.onItemUseFinish(stack, world, entityLiving);
				}

				LootContext context = new LootContext.Builder((WorldServer) world).withPlayer((EntityPlayer) entityLiving).withLuck(0).build();
				if (nbt.hasKey("Pool")) {
					for (int i = 0; i < rolls; i++) {
						List<ItemStack> item = new ArrayList<>();
						table.getPool(nbt.getString("Pool")).generateLoot(item, world.rand, context);

						for (ItemStack itemStack : item) {
							if (!((EntityPlayer) entityLiving).addItemStackToInventory(itemStack)) {
								((EntityPlayer) entityLiving).dropItem(itemStack, true);
							}
						}
					}
				} else {
					for (int i = 0; i < rolls; i++) {
						for (ItemStack itemStack : table.generateLootForPools(world.rand, context)) {
							if (!((EntityPlayer) entityLiving).addItemStackToInventory(itemStack)) {
								((EntityPlayer) entityLiving).dropItem(itemStack, true);
							}
						}
					}
				}
				stack.shrink(1);
				return stack;
			} else if (nbt.hasKey("ItemStack")) {
				ItemStack itemStack = new ItemStack(nbt.getCompoundTag("ItemStack"));
				if (itemStack != null && itemStack != ItemStack.EMPTY) {
					if (!((EntityPlayer) entityLiving).addItemStackToInventory(itemStack)) {
						((EntityPlayer) entityLiving).dropItem(itemStack, true);
					}
					stack.shrink(1);
					return stack;
				}
			}
		}

		return super.onItemUseFinish(stack, world, entityLiving);
	}
}
