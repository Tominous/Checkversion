package net.itor4589.checkver;

import static java.rmi.server.LogStream.log;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import us.myles.ViaVersion.api.Via;
import us.myles.ViaVersion.api.protocol.ProtocolVersion;

public class Main extends JavaPlugin implements Listener{
       
  private static String prefix = ChatColor.GRAY + "§4[" + ChatColor.GOLD + "§bCheck§e|§bVersion" + ChatColor.GRAY + "§4] " + ChatColor.DARK_GRAY;
  private static Main instance;
    
    @Override
    public void onEnable() {
        getConfig().options().copyDefaults(true);
        saveConfig();
        instance = this;
        log("§4=================================");
        log("§eplugin was creator by Itor4589");
        log("§4=================================");
        getServer().getPluginManager().registerEvents(this, this);
        Plugin viaversion = Bukkit.getPluginManager().getPlugin("ViaVersion");
    }
    
    
    @SuppressWarnings("unchecked")
    @EventHandler
    public void Join (PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_8.getId()){
             Bukkit.broadcastMessage(getConfig().getString("Prefix").replace("&", "§") + "" + getConfig().getString("1").replaceAll("&", "§").replaceAll("<player>", p.getName()));
        } else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_9.getId()){
             Bukkit.broadcastMessage(getConfig().getString("Prefix").replace("&", "§") + "" + getConfig().getString("2").replaceAll("&", "§").replaceAll("<player>", p.getName()));
        } else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_10.getId()){
             Bukkit.broadcastMessage(getConfig().getString("Prefix").replace("&", "§") + "" + getConfig().getString("3").replaceAll("&", "§").replaceAll("<player>", p.getName()));
        } else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_11.getId()){
             Bukkit.broadcastMessage(getConfig().getString("Prefix".replace("&", "§")) + "" + getConfig().getString("4").replaceAll("&", "§").replaceAll("<player>", p.getName()));
        } else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_12.getId()){
             Bukkit.broadcastMessage(getConfig().getString("Prefix").replace("&", "§") + "" + getConfig().getString("5").replaceAll("&", "§").replaceAll("<player>", p.getName()));
        }
        
    }
  public static void log(String message)
  {
    Bukkit.getConsoleSender().sendMessage(getPrefix() + message);
  }
  
  public static String getPrefix()
  {
    return prefix;
  }
  
  public static Main getInstance()
  {
    return instance;
    
  }
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if (cmd.getName().equalsIgnoreCase("Checkversion"))
    {
      if (args.length < 1)
      {
        sender.sendMessage("§aUsage : /Checkversion Reload");
      }
      else
      {
        if (sender.hasPermission("Checkversion.reload"))
        {
          if (args[0] == "reload") {}
          reloadConfig();
          saveConfig();
          sender.sendMessage("§6[Checkversion] §aConfig has been Reloaded !!!");
        }
        return false;
      }
      return false;
    }
    return false;
  }
}
