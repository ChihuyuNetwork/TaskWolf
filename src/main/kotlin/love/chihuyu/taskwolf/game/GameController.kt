package love.chihuyu.taskwolf.game

import love.chihuyu.taskwolf.game.task.Task
import org.bukkit.OfflinePlayer

object GameController {

    var remainTasks = hashMapOf<OfflinePlayer, MutableList<Task>>()
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