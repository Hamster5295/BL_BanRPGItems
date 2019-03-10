package org.BL.hamster5295.Listener;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import think.rpgitems.data.RPGMetadata;

public class Listener_Attack implements Listener {

    private String worlds;
    private String[] w;

    void Listener_Attack(String worlds){
        this.worlds = worlds;
        w= this.worlds.split(";");
    }


    @EventHandler
    public void onAttack(EntityDamageByEntityEvent e){

        if(e.getDamager() instanceof Player){

            Player p = (Player) e.getDamager();

            for (String i : w) {
                if(RPGMetadata.hasRPGMetadata(p.getItemInHand())&& p.getWorld().getName().equals(i)){
                    e.setCancelled(true);
                    p.sendMessage(ChatColor.RED+"你不能在资源世界使用RPG武器!");
                    return;
                }
            }
        }

    }

}
