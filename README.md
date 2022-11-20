
# Loot Casket &nbsp; [![Build Mod](https://github.com/WinDanesz/LootCasket/actions/workflows/gradle.yml/badge.svg)](https://github.com/WinDanesz/LootCasket/actions/workflows/gradle.yml) [![Curseforge](http://cf.way2muchnoise.eu/full_loot-casket_downloads.svg)](https://www.curseforge.com/minecraft/mc-mods/loot-casket) [![Curseforge](http://cf.way2muchnoise.eu/versions/608287.svg)](http://www.curseforge.com/minecraft/mc-mods/loot-casket/files) [![Discord](https://img.shields.io/discord/544897694448091146?color=7289DA&label=Discord)](https://discord.gg/wuSsgKwAKv)

Loot Casket is a 1.12.2 Minecraft mod, adding the Small Casket item into the game.

**Features**

Adds a single item - the Small Casket.
The casket's content can be defined using NBT tags, and it can contain the following:
  A) A reference to an existing loot table. When a player opens the casket, they get a random roll of that loot table (as if they opened a chest), then the casket disappears
  B) A reference to an existing loot table AND a specific pool of that table. When a player opens the casket, they get a random roll of that loot table's specified pool (as if they opened a chest), then the casket disappears
  C) An NBT-serialized ItemStack - basically any item saved as an nbt tag. When a player opens the casket, they get the specific item
 
**Example Use Cases**
- Pack makers can give quest rewards wrapped in caskets - just for the looks of it, or to give random rewards perhaps
- Easily reference loot tables and attach them to entities as drops, there are mods for attaching items to entities as loot.
- Etc..
- Got an idea? Tell me in the comment section!

**Planned features**
  - Config option to attach a casket to entities as loot
  - Config option to define custom caskets for mods that do not support nbt tags for their loot (e.g. Infernal Mobs)
  
**Example Casket**
Using the give command, this casket would give you the content of a mineshaft chest:
<br />
`/give @p loot-casket:small_casket 1 0 { "LootTable": "minecraft:chests/abandoned_mineshaft", "Rarity" : "epic" }`
 
