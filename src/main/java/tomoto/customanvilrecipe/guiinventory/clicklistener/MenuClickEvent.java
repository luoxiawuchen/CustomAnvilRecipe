package tomoto.customanvilrecipe.guiinventory.clicklistener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import tomoto.customanvilrecipe.guiinventory.gui.CreateGui;
import tomoto.customanvilrecipe.guiinventory.gui.MenuGui;

public class MenuClickEvent implements Listener {
    @EventHandler
    public void onMenuClick(InventoryClickEvent event) {
        Player player;
        if(event.getWhoClicked().getOpenInventory().getTitle().equals(MenuGui.guiName)) {
            player = (Player)event.getWhoClicked();
            event.setCancelled(true);
        }
        else {
            return;
        }

        String buttonName = null;
        if(event.getCurrentItem() != null) {
            buttonName = event.getCurrentItem().getItemMeta().getDisplayName();
        }
        else {
            return;
        }

        switch (buttonName) {
            case MenuGui.createButtonName:
                new CreateGui().openGui(player);
                break;
            case MenuGui.listButtonName:

                break;
        }
    }
}