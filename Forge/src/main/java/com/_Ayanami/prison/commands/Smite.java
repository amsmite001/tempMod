package com._Ayanami.prison.commands;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;

public class Smite implements ICommand {

	@Override
	public int compareTo(ICommand o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getName() {
		return "smite";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		return ":> The only command that should ever need to exist - Smite your enemies!";
	}

	@Override
	public List<String> getAliases() {
		List<String> commandAliases = new ArrayList();
		commandAliases.add("smitty");
		commandAliases.add("sm");
		return commandAliases;
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		//Usage ./smite [playername]
		EntityPlayer player = (EntityPlayer) sender;
		player.sendMessage(new TextComponentString("args: "+args.toString()));
		if (args.length == 2) {
			
			
			EntityPlayer closePlayer = (EntityPlayer) player.getEntityWorld().getClosestPlayer(player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getY(), 25, true); //is spectator false?
			closePlayer.world.addWeatherEffect(new EntityLightningBolt(closePlayer.world, closePlayer.posX, closePlayer.posY, closePlayer.posZ,false));
			closePlayer.sendMessage(new TextComponentString("Thou shall be smited."));
			closePlayer.onKillCommand();
			
			player.sendMessage(new TextComponentString("He hath been smitten."));
			}
		else {
			player.world.addWeatherEffect(new EntityLightningBolt(player.world, player.posX, player.posY, player.posZ,false));
			player.sendMessage(new TextComponentString("Thou has smited herself. 10/10 would not reccomend."));
		}
	}

	@Override
	public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
		if(sender instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) sender;
			player.sendMessage(new TextComponentString("(>*^*)>"));
			if(player.getName() == "ShadowWalkerEH2"  || player.getName() == "_Ayanami") //My brother, for the video purposes :> He doesn't know.
				return false;
		}
		return true;
	}

	@Override
	public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args,
			BlockPos targetPos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isUsernameIndex(String[] args, int index) {
		// TODO Auto-generated method stub
		return false;
	}

}
