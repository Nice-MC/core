package br.com.nicemc.principal.core.model.account.group

object AdminDefinition: GroupDefinition {

    override fun getPermissions(): Set<String> = setOf(
        "*"
    )

}
