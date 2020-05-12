package com._Ayanami.prison.commands;

import net.minecraftforge.event.CommandEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CommandListener {

	@SubscribeEvent
	public void onCommand(CommandEvent event) {
		System.out.println("The event is: " + event.toString());
		if(!event.hasResult())
			System.out.println("EVENT ERROR---------------"); //Throwing an error has a chance to crash forge.
		else
			System.out.println("RESUlT---------"+event.getResult().toString());
	}
}
