package com._Ayanami.prison.commands;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class OnPlayerJoin {

	@SubscribeEvent
	public void PlayerJoin(EntityJoinWorldEvent event) {
		if(event.getEntity() instanceof EntityPlayer) {
		EntityPlayer player = (EntityPlayer) event.getEntity();
		player.sendMessage(new TextComponentString("Your UUID is " + player.getUniqueID()));

		
		}

	}
}