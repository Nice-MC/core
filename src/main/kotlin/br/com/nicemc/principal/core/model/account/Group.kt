package br.com.nicemc.principal.core.model.account

import br.com.nicemc.principal.core.model.account.group.*
import br.com.nicemc.principal.core.model.account.group.BuilderDefinition
import br.com.nicemc.principal.core.model.account.group.CreatorDefinition
import br.com.nicemc.principal.core.model.account.group.PartnerDefinition
import br.com.nicemc.principal.core.model.account.group.AdminDefinition
import br.com.nicemc.principal.core.model.account.group.ModeratorDefinition

enum class Group(
    val definition: GroupDefinition
) {

    ADMIN(AdminDefinition),
    MODERATOR(ModeratorDefinition),
    BUILDER(BuilderDefinition),
    CREATOR(CreatorDefinition),
    PARTNER(PartnerDefinition),
    ULTRA(UltraDefinition),
    VIP(VipDefinition),
    DEFAULT(DefaultDefinition)

}
