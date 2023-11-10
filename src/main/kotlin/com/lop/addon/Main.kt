package com.lop.addon

import com.lop.devtools.monstera.addon.addon
import com.lop.devtools.monstera.addon.dev.zipper.zipWorld
import com.lop.devtools.monstera.config
import com.lop.devtools.monstera.files.File
import com.lop.devtools.monstera.files.getResource
import com.lop.devtools.stdlib.furnitures.furniture
import com.lop.devtools.stdlib.furnitures.shared.FurnitureDropBehaviour
import com.lop.devtools.stdlib.npcs.npc
import com.lop.devtools.stdlib.packaging.packaging
import com.lop.devtools.stdlib.player.Player
import java.io.File

fun main(args: Array<String>) {
    val conf = addon(config(projectName = "Template") { //todo
        "npm.cmd run build".runCommand(File(System.getProperty("user.dir"), "scripting"))
        projectShort = "te"
        description = "sample"  //todo
        packIcon = getResource("general/pack.png")
        world = getResource("world/template-world")
        version = arrayListOf(0, 1, 0)
        targetMcVersion = arrayListOf(1, 20, 0)
        scriptEntryFile = File("scripting", "dist", "src", "index.js")
        scriptingVersion = "1.6.0-beta"
    }) {
        scripts(directory = File("scripting", "dist", "src"))

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
            renderOffset("tool")
            texture(getResource("item/default_texture.png"))
        }
        Player
            .modify(this)
            .modifyBehaviour { }

        furniture("vase", "Vase", this) {
            dropBehaviour = FurnitureDropBehaviour.CAN_PICKUP
        }

        npc("my_npc", "My NPC", this) {
            //...
        }
    }

    if (args.contains("zip-world"))
        zipWorld(conf, System.getenv("CI_PROJECT_NAME") ?: "local")
}