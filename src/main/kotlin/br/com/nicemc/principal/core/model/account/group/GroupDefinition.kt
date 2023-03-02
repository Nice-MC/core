package br.com.nicemc.principal.core.model.account.group

sealed interface GroupDefinition {

    fun getPermissions(): Set<String>

}
