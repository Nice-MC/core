package br.com.nicemc.principal.core.model.account.group

object CreatorDefinition: GroupDefinition {

    override fun getPermissions(): Set<String> = setOf(

        // -- Tags
        "tag.streamer",
        "tag.youtuber",
        "tag.creator",
        "tag.ultra",
        "tag.pro",
        "tag.mvp",
        "tag.vip",
        "tag.default"
    )

}
