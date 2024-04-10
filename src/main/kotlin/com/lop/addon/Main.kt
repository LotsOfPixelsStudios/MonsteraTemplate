package com.lop.addon

import com.lop.devtools.monstera.addon.addon
import com.lop.devtools.monstera.addon.dev.zipper.zipWorld
import com.lop.devtools.monstera.files.File
import com.lop.devtools.monstera.files.getResource
import com.lop.devtools.monstera.loadConfig
import com.lop.devtools.stdlib.furnitures.furniture
import com.lop.devtools.stdlib.furnitures.shared.FurnitureDropBehaviour
import com.lop.devtools.stdlib.npcs.npc
import com.lop.devtools.stdlib.packaging.packaging
import com.lop.devtools.stdlib.player.Player
import java.io.File

fun main(args: Array<String>) {
    val conf = addon(loadConfig().getOrElse {
        it.printStackTrace()
        return
    }) {
        with(config) {
            "npm.cmd run build".runCommand(File(System.getProperty("user.dir"), "scripting"))
            scripts(directory = File("scripting", "dist", "src"))
            scriptEntryFile = File("scripting", "dist", "src", "index.js")
        }

        if (args.contains("package")) {
            packaging {
                this.world = getResource("world/template-world")
                addSkinPack {
                    addSkin(getResource("skin_pack/alex_a.png"), true)
                    addSkin(getResource("skin_pack/steve_s.png"), true)
                }
                addStoreArt { }
                addMarketing { }
                addBehaviorPack { }
                addResourcePack { }
            }
        }

        entity("sample_entity", "Sample Entity") {
            resource {
                textureLayer(getResource("entities/default_texture.png"))
                geometryLayer(getResource("entities/default_model.geo.json"))
            }
            behaviour {
                components {
                    physics { }
                }
            }
        }
        item("sample_item", "display name") {
            texture(getResource("item/default_texture.png"))
        }
        Player
            .modify(this)
            .modifyBehaviour { }

        furniture("vase", "Vase", this) {
            dropBehaviour = FurnitureDropBehaviour.INVINCIBLE
        }

        npc("my_npc", "My NPC", this) {
            //...
        }
    }

    if (args.contains("zip-world"))
        zipWorld(conf, System.getenv("CI_PROJECT_NAME") ?: "local")
}