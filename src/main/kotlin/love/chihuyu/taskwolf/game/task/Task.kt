package love.chihuyu.taskwolf.game.task

import love.chihuyu.taskwolf.game.GameController
import org.bukkit.Location
import org.bukkit.OfflinePlayer

interface Task {
    val name: String
    val location: Location
    // tasks.ymlなどにマップごとのタスクを記述する
    // タスクは座標で管理し、プレイヤーにランダムな位置と任意の数を付与する
    // タスクごとにリスナーを用意し、プレイヤーに割り振られたタスクの座標と参照して完了などの処理を行う

    fun done(player: OfflinePlayer) {
        GameController.remainTasks[player]?.remove(this)
    }
}