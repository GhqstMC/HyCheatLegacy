package xyz.lilithmod.lilithplus.config

import gg.essential.vigilance.Vigilant
import gg.essential.vigilance.data.Property
import gg.essential.vigilance.data.PropertyType
import xyz.lilithmod.lilithplus.LilithPlus
import java.io.File

object LilithPlusConfig : Vigilant(File(LilithPlus.modDir, "${LilithPlus.ID}.toml"), LilithPlus.NAME) {
    @Property(
        type = PropertyType.SWITCH,
        name = "Hello!",
        description = "Thanks for using this template!",
        category = "General"
    )
    var testProperty = false

    init {
        initialize()
    }
}