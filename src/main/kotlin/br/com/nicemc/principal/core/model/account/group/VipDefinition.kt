package br.com.nicemc.principal.core.model.account.group

object VipDefinition: GroupDefinition {

    override fun getPermissions(): Set<String> = setOf(
        "tag.vip",
        "tag.default"
    )

}
