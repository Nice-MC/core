package br.com.nicemc.principal.core.model.account

import br.com.nicemc.principal.core.model.Metadata
import br.com.nicemc.principal.core.utils.jsonb
import com.google.gson.GsonBuilder
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable

object AccountConfigurationsTable : IntIdTable("accounts_configurations") {
    val account = (integer("account_id").references(AccountTable.id))
    val key = varchar("key", 255)
    val value = jsonb("value", Metadata::class.java, GsonBuilder().create(), false)
}

class AccountConfigurations(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<AccountConfigurations>(AccountConfigurationsTable) {
        fun create(account: Account, key: String, value: Metadata): AccountConfigurations {
            return AccountConfigurations.new {
                this@new.key = key
                this@new.value = value
                this@new.account = account.id.value
            }
        }
    }

    var account by AccountConfigurationsTable.account
    var key by AccountConfigurationsTable.key
    var value by AccountConfigurationsTable.value

}
