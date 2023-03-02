package br.com.nicemc.principal.core.system.listener

import br.com.nicemc.api.extensions.event
import br.com.nicemc.api.extensions.events
import br.com.nicemc.api.extensions.player
import br.com.nicemc.api.utils.print
import br.com.nicemc.principal.core.CorePlugin
import org.bukkit.event.player.AsyncPlayerPreLoginEvent
import org.bukkit.event.player.PlayerJoinEvent

fun CorePlugin.registerPlayerEvents() = events {

    event<AsyncPlayerPreLoginEvent> {
        if (player(uniqueId) != null) {
            loginResult = AsyncPlayerPreLoginEvent.Result.KICK_OTHER;
            kickMessage = "Account already online."
        }
    }

    event<PlayerJoinEvent> {
        try {
            accountManager.loadPlayer(player)
        } catch (e: Exception) {
            player.kickPlayer("Failed to load player data.")
            e.print()
        }
    }

}
