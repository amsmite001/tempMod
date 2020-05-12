package com._Ayanami.prison;

import com._Ayanami.prison.commands.CommandListener;
import com._Ayanami.prison.commands.Gibey;
import com._Ayanami.prison.commands.OnPlayerJoin;
import com._Ayanami.prison.commands.Smite;
import com._Ayanami.prison.proxy.CommonProxy;
import com._Ayanami.prison.util.Reference;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

//import com.mojang.brigadier.CommandDispatcher;// Not supported in 1.12. Any errors caused by this will be ignored and mentioned


@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)
public class Main {

	@Instance
	public static Main instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;
	
	@EventHandler
	public static void PreInit(FMLPreInitializationEvent event) {
		System.out.println("PreInit Called");
		
	}
	
	
	@EventHandler
	public static void init(FMLInitializationEvent event) {
		System.out.println("Init Called");
		MinecraftForge.EVENT_BUS.register(new OnPlayerJoin());
		MinecraftForge.EVENT_BUS.register(new CommandListener());
		
	}
	
	@EventHandler
	public static void PostInit(FMLPostInitializationEvent event) {}
	
	
	@EventHandler
	public void ServerLoad(FMLServerStartingEvent event) {
		System.out.println("Server Called");
		event.registerServerCommand(new Gibey());
		event.registerServerCommand(new Smite());
	}
}
