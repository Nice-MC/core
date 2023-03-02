package br.com.nicemc.principal.core.model

class Metadata {

    private val metadata: MutableMap<String, Any> = mutableMapOf()

    fun getAll() = metadata.toMap()
    fun containsKey(key: String): Boolean = metadata.containsKey(key)
    fun containsValue(value: Any): Boolean = metadata.containsValue(value)
    fun remove(key: String) = metadata.remove(key)

    operator fun get(key: String): Any? = metadata[key]
    operator fun set(key: String, value: Any) = run { metadata[key] = value }

}
