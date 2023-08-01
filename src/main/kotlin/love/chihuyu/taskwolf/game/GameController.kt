package love.chihuyu.taskwolf.game

import org.bukkit.OfflinePlayer

object GameController {

    var remainTasks = hashMapOf<OfflinePlayer, Int>()
    var isStarted = false

    fun start() {
        isStarted =  true
    }

    fun end(role: Role) {
        isStarted = false
    }

    fun sabotage() {

    }
}