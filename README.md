# MonsteraTemplate

## Licence Notice:

This project is released under the Apache 2.0 licence although the kotlin library Monstera is released under GPL-3.0,
as mentioned there, such a project like this, where the library is just "used" to create a minecraft addon, we can put
our own licence.

## Getting Started

You can search project wide for the keyword "todo" to see what you should change.

### Std Lib:

#### No access

If you want to use the std lib, you can write us an e-mail or contact the maintainer on GitHub.

If you don't have access to the std lib, disable it by removing the following line from the `build.gradle.kts`

````gradle
implementation("com.lotsofpixelsstudios:monstera-std-lib:<version>")
````

Reload the gradle project and remove code that would throw an error.

#### With access

If you have access go to you're gradle home directory (on Windows: `%HOMEPATH%\.gradle`) and add a file named
`env-timoliacreative.local.gradle.kts` and add the following line:

````gradle
project.extra["gitlab_token"] = "<you're access token>"
````

With you're access token and reload the gradle project.

## Scripting

Note: You need to activate scripting in the world (edit the world in minecraft and check the holiday creator features
within the experiments)

To disable scripting:

- remove the `npm.cmd run build` command from the config (Main.kt)
- remove the `scriptEntryFile` from the config (Main.kt)
- remove the `scriptingVersion` from the config (Main.kt)
- remove the `scripts()` function call from the addon (Main.kt)
- optionally you can remove the whole scripting directory on the root