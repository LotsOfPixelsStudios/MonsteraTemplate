# MonsteraTemplate

## Getting Started

You can search project wide for the keyword "todo" to see what you should change.

## Scripting

Note: You need to activate scripting in the world (edit the world in minecraft and check the holiday creator features
within the experiments)

To disable scripting:

- remove the `npm.cmd run build` command from the config (Main.kt)
- remove the `scriptEntryFile` from the config (Main.kt)
- remove the `scriptingVersion` from the config (Main.kt)
- remove the `scripts()` function call from the addon (Main.kt)
- optionally you can remove the whole scripting directory on the root
