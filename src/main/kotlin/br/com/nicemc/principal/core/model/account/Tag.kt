package br.com.nicemc.principal.core.model.account

enum class Tag(
    val prefix: String,
    val color: Char
) {

    ADMIN("ADMIN", '4'),
    DEVELOPER("DEV", '4'),
    MODERATOR("MODERATOR", '5'),
    BUILDER("BUILDER", 'e'),
    STREAMER("STREAMER", 'b'),
    YOUTUBER("YOUTUBER", 'b'),
    CREATOR("CREATOR", 'b'),
    ULTRA("ULTRA", 'd'),
    PRO("PRO", '6'),
    MVP("MVP", '3'),
    VIP("VIP", 'a'),
    DEFAULT("", '7');

    val permission = "tag.${name.lowercase()}"

}
