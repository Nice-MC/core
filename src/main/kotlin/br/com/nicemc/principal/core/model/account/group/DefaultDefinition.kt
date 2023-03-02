package br.com.nicemc.principal.core.model.account.group

object DefaultDefinition: GroupDefinition {

    override fun getPermissions(): Set<String> = setOf(
        "tag.default"
    )

}
