package br.com.nicemc.principal.core.model.account.manager

import br.com.nicemc.api.architecture.lifecycle.LifecycleListener
import br.com.nicemc.api.collections.onlinePlayerMapOf
import br.com.nicemc.api.extensions.BukkitDispatchers
import br.com.nicemc.principal.core.CorePlugin
import br.com.nicemc.principal.core.model.account.Account
import kotlinx.coroutines.*
import org.bukkit.entity.Player

class AccountManager(
    override val plugin: CorePlugin
) : LifecycleListener<CorePlugin> {

    private val accountsCache by lazy { onlinePlayerMapOf<Account>() }

    private val job by lazy { Job() }
    private val coroutineScope by lazy { CoroutineScope(job + BukkitDispatchers.SYNC) }

    private val sqlManager get() = plugin.accountSqlManager

    override fun onPluginEnable() {}

    override fun onPluginDisable() {
        job.cancel()
    }

    fun loadPlayer(player: Player) {
        coroutineScope.launch {
            val account = sqlManager.accountFromPlayer(player)

            if (player.isOnline) // IDEA: coroutineScope based on player lifecycle
                accountsCache[player] = account
        }
    }

}
