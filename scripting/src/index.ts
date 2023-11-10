import {world} from "@minecraft/server";

world.afterEvents.itemUse.subscribe(event => {
    if (event.itemStack.typeId == "minecraft:apple") {
        event.source.sendMessage("Hello World!")
    }
})
