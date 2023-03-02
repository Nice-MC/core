package br.com.nicemc.principal.core

import br.com.nicemc.api.architecture.KotlinPlugin
import br.com.nicemc.api.architecture.module.Module
import br.com.nicemc.principal.core.model.account.manager.AccountManager
import br.com.nicemc.principal.core.model.account.manager.AccountSqlManager
import br.com.nicemc.principal.core.system.listener.registerPlayerEvents

@Module(name = "NiceCore", version = "1.0.0")
class CorePlugin : KotlinPlugin() {

    val accountSqlManager = lifecycle(100) { AccountSqlManager(this) }
    val accountManager = lifecycle(90) { AccountManager(this) }

    override fun onPluginEnable() {
        registerPlayerEvents()
    }

}
