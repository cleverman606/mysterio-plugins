import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.AnvilChangeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class AnvilCombineListener implements Listener {

    private final JavaPlugin plugin;

    public AnvilCombineListener(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onAnvilCombine(AnvilChangeEvent event) {
        ItemStack firstItem = event.getFirstItem();
        ItemStack secondItem = event.getSecondItem();

        if (firstItem != null && secondItem != null && 
            firstItem.getType().toString().endsWith("_CHESTPLATE") && 
            secondItem.getType() == Material.ELYTRA) {

            ItemStack newItem = new ItemStack(firstItem.getType());
            ItemMeta meta = newItem.getItemMeta();
            if (meta != null) {
                meta.setDisplayName(firstItem.getItemMeta().getDisplayName() + " with Elytra");
                newItem.setItemMeta(meta);
            }

            event.setResult(newItem);
        }
    }
}