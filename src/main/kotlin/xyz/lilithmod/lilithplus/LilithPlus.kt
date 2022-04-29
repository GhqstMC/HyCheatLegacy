package xyz.lilithmod.lilithplus

import cc.woverflow.onecore.utils.Updater
import cc.woverflow.onecore.utils.command
import cc.woverflow.onecore.utils.openScreen
import net.minecraft.client.Minecraft
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent
import xyz.lilithmod.lilithplus.config.LilithPlusConfig
import io.sentry.Sentry
import java.io.File

@Mod(
    modid = LilithPlus.ID,
    name = LilithPlus.NAME,
    version = LilithPlus.VER,
    modLanguageAdapter = "gg.essential.api.utils.KotlinAdapter"
)
object LilithPlus {

    const val NAME = "@NAME@"
    const val VER = "@VER@"
    const val ID = "@ID@"

    val modDir = File(File(Minecraft.getMinecraft().mcDataDir, "W-OVERFLOW"), NAME)

    @Mod.EventHandler
    fun onFMLPreInitalization(event: FMLPreInitializationEvent) {
        if (!modDir.exists()) modDir.mkdirs()
        Updater.addToUpdater(event.sourceFile, NAME, ID, VER, "W-OVERFLOW/$ID")
    }

    @Mod.EventHandler
    fun onInitialization(event: FMLInitializationEvent) {
        LilithPlusConfig.preload()
        command(ID) {
            main {
                LilithPlusConfig.openScreen()
            }
        }
        Sentry.init { options ->
            options.dsn = "https://133b8f49ee7743dcb713dcb6f7cf48d7@o998490.ingest.sentry.io/5957324"
            options.tracesSampleRate = 1.0
            options.release = "lilithplus@${VER}"
            options.environment = "dev"
        }
        Sentry.setTag("OS", System.getProperty("os.name"))
    }
}