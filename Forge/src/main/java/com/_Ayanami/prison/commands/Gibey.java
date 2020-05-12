package com._Ayanami.prison.commands;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;

public class Gibey implements ICommand {

	@Override
	public int compareTo(ICommand arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getName() {
		return "Gibe";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		return "Returns Chat Gibe";
	}

	@Override
	public List<String> getAliases() {
		List<String> commandAliases = new ArrayList();
		commandAliases.add("gibe");
		commandAliases.add("g");
		return commandAliases;
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		if(sender instanceof EntityPlayer) {
			if(checkPermission(server,sender)) {
			EntityPlayer player = (EntityPlayer) sender;
			player.sendMessage(new TextComponentString("(>*^*)>"));
		}
		}

	}

	@Override
	public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
		EntityPlayer player = (EntityPlayer) sender;
		System.out.println(player.getName());
		player.sendMessage(new TextComponentString(player.getName()));
		if(player.getName()=="Ayanami_"|| player.getUniqueID().toString()=="61d10809-a686-401c-a5fe-53d71bc64aab") {
			player.sendMessage(new TextComponentString("No boi"));
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
