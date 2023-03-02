package br.com.nicemc.principal.core.model.account.manager

import br.com.nicemc.api.architecture.lifecycle.LifecycleListener
import br.com.nicemc.api.exposed.DatabaseTypeConfig
import br.com.nicemc.api.exposed.databaseTypeFrom
import br.com.nicemc.principal.core.CorePlugin
import br.com.nicemc.principal.core.model.account.Account
import br.com.nicemc.principal.core.model.account.AccountConfigurationsTable
import br.com.nicemc.principal.core.model.account.AccountTable
import com.zaxxer.hikari.HikariDataSource
import kotlinx.coroutines.Dispatchers
import org.bukkit.entity.Player
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.jetbrains.exposed.sql.transactions.transaction

class AccountSqlManager(
    override val plugin: CorePlugin
) : LifecycleListener<CorePlugin> {

    private lateinit var dataSource: HikariDataSource
    private lateinit var database: Database

    override fun onPluginEnable() {
        dataSource = databaseTypeFrom(
            dataFolder = plugin.dataFolder,
            config = DatabaseTypeConfig()
        ).dataSource()
        database = Database.connect(dataSource)

        transaction {
            SchemaUtils.create(AccountTable)
            SchemaUtils.create(AccountConfigurationsTable)
        }
    }

    override fun onPluginDisable() {
        dataSource.close()
    }

    suspend fun accountFromPlayer(
        player: Player
    ): Account = newSuspendedTransaction(Dispatchers.IO, database) {
        Account.fromPlayer(player) ?: run {
            Account.create(player)
        }
    }

}
