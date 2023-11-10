package com.lop.addon

import com.lop.devtools.monstera.addon.addon
import com.lop.devtools.monstera.config
import com.lop.devtools.monstera.files.File
import com.lop.devtools.monstera.files.getResource
import java.io.File


fun main(args: Array<String>) {
    val prop = addon(config(projectName = "Dungeon Rush") {
        "npm.cmd run build".runCommand(File(System.getProperty("user.dir"), "scripting"))
        projectShort = "dr"
        description = ""
        packIcon = getResource("general/pack.png")
        world = getResource("world/dr_exp")
        version = arrayListOf(0, 0, 1)
        targetMcVersion = arrayListOf(1, 20, 0)
        scriptEntryFile = File("scripting", "dist", "src", "index.js")
        scriptingVersion = "1.6.0-beta"
    }) {
        scripts(directory = File("scripting", "dist", "src"))
    }
}