import kotlin.io.path.Path

tasks.register("cleanAllWorlds") {
    group = "monstera"

    doLast {
        var worldPath: java.nio.file.Path = Path(
            System.getenv("LOCALAPPDATA"),
            "Packages",
            "Microsoft.MinecraftUWP_8wekyb3d8bbwe",
            "LocalState",
            "games",
            "com.mojang",
            "minecraftWorlds"
        )

        worldPath.toFile().deleteRecursively()
    }
}