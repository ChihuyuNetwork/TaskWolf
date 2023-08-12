package love.chihuyu.taskwolf.game.task

import love.chihuyu.taskwolf.game.GameController
import love.chihuyu.taskwolf.game.task.impl.ButtonTask
import love.chihuyu.taskwolf.game.task.impl.LeverTask
import love.chihuyu.taskwolf.game.task.impl.PressureTask
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.player.PlayerInteractEvent

object TaskListeners : Listener {

    @EventHandler
    fun onInteractButtonTask(event: PlayerInteractEvent) {
        val player = event.player
        val task = GameController.remainTasks[player]!!.firstOrNull { it.location == event.clickedBlock?.location } ?: return

        when (event.clickedBlock?.type ?: return) {
            Material.BAMBOO_BUTTON,
            Material.BIRCH_BUTTON,
            Material.ACACIA_BUTTON,
            Material.CHERRY_BUTTON,
            Material.CRIMSON_BUTTON,
            Material.JUNGLE_BUTTON,
            Material.MANGROVE_BUTTON,
            Material.OAK_BUTTON,
            Material.DARK_OAK_BUTTON,
            Material.SPRUCE_BUTTON,
            Material.STONE_BUTTON,
            Material.WARPED_BUTTON,
            Material.POLISHED_BLACKSTONE_BUTTON -> {
                if (task !is ButtonTask) return
            }
            Material.ACACIA_PRESSURE_PLATE,
            Material.BAMBOO_PRESSURE_PLATE,
            Material.BIRCH_PRESSURE_PLATE,
            Material.CHERRY_PRESSURE_PLATE,
            Material.CRIMSON_PRESSURE_PLATE,
            Material.DARK_OAK_PRESSURE_PLATE,
            Material.HEAVY_WEIGHTED_PRESSURE_PLATE,
            Material.JUNGLE_PRESSURE_PLATE,
            Material.LIGHT_WEIGHTED_PRESSURE_PLATE,
            Material.MANGROVE_PRESSURE_PLATE,
            Material.OAK_PRESSURE_PLATE,
            Material.POLISHED_BLACKSTONE_PRESSURE_PLATE,
            Material.SPRUCE_PRESSURE_PLATE,
            Material.STONE_PRESSURE_PLATE,
            Material.WARPED_PRESSURE_PLATE -> {
                if (task !is PressureTask) return
            }
            Material.LEVER -> {
                if (task !is LeverTask) return

            }
            else -> return
        }
    }

    @EventHandler
    fun onClickInventory(event: InventoryClickEvent) {
        val player = event.whoClicked
    }
}