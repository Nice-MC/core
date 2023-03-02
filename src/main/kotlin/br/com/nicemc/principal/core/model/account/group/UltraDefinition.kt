package br.com.nicemc.principal.core.model.account.group

object UltraDefinition: GroupDefinition {

    override fun getPermissions(): Set<String> = setOf(
        "tag.ultra",
        "tag.pro",
        "tag.mvp",
        "tag.vip",
        "tag.default"
    )

}
