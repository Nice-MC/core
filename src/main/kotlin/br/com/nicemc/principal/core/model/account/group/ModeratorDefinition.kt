package br.com.nicemc.principal.core.model.account.group

object ModeratorDefinition: GroupDefinition {

    override fun getPermissions(): Set<String> = setOf(

        // -- Tags
        "tag.moderator",
        "tag.ultra",
        "tag.pro",
        "tag.mvp",
        "tag.vip",
        "tag.default"
    )

}
