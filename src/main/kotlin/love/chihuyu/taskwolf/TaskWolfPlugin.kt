package love.chihuyu.taskwolf

import dev.jorel.commandapi.kotlindsl.anyExecutor
import dev.jorel.commandapi.kotlindsl.commandAPICommand
import love.chihuyu.taskwolf.game.GameController
import love.chihuyu.timerapi.TimerAPI
import net.kyori.adventure.text.Component
import org.bukkit.plugin.java.JavaPlugin

class TaskWolfPlugin: JavaPlugin() {
    companion object {
        lateinit var TaskWolfPlugin: JavaPlugin
    }

    init {
        TaskWolfPlugin = this
    }

    override fun onEnable() {
        super.onEnable()

        registerCommands()
    }

    private fun registerCommands() {
        commandAPICommand("start") {
            anyExecutor { sender, _ ->
                TimerAPI.run("taskwolf-countdown", 5, 20) {
                    tick {
                        server.broadcast(Component.text("${5 - elapsed}秒後に開始します"))
                    }
                    end {
                        GameController.start()
                    }
                }
            }
        }
    }
}