package br.com.nicemc.principal.core.model.account.group

object BuilderDefinition: GroupDefinition {

    override fun getPermissions(): Set<String> = setOf(

        // -- Tags
        "tag.builder",
        "tag.ultra",
        "tag.pro",
        "tag.mvp",
        "tag.vip",
        "tag.default"
    )

}
