import kotlin.io.path.Path

tasks.register("cleanAllAddons") {
    group = "monstera"
    doLast {
        var mojangPath: java.nio.file.Path = Path(
            System.getenv("LOCALAPPDATA"),
            "Packages",
            "Microsoft.MinecraftUWP_8wekyb3d8bbwe",
            "LocalState",
            "games",
            "com.mojang"
        )

        val beh = mojangPath.resolve("development_behavior_packs")
        val res = mojangPath.resolve("development_resource_packs")

        beh.toFile().deleteRecursively()
        res.toFile().deleteRecursively()
    }
}