package br.com.nicemc.principal.core.model.account

import org.bukkit.entity.Player
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Op
import org.jetbrains.exposed.sql.SqlExpressionBuilder
import java.util.UUID

object AccountTable : IntIdTable("accounts") {
    val playerUniqueId = uuid("player_unique_id")
    val playerName = varchar("player_name", 255)
    val group = enumeration<Group>("group")
    val tag = enumeration<Tag>("group")
}

class Account(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<Account>(AccountTable) {

        fun fromPlayer(player: Player) = Account
            .find { playerUniqueIdEq(player.uniqueId) }
            .firstOrNull()

        fun create(player: Player): Account {
            return Account.new {
                this@new.playerUniqueId = player.uniqueId
                this@new.playerName = player.name
                this@new.group = Group.DEFAULT
                this@new.tag = Tag.DEFAULT
            }
        }

        private fun SqlExpressionBuilder.playerUniqueIdEq(id: UUID): Op<Boolean> =
            AccountTable.playerUniqueId eq id

    }

    var playerUniqueId by AccountTable.playerUniqueId
    var playerName by AccountTable.playerName
    var group by AccountTable.group
    var tag by AccountTable.tag

}
