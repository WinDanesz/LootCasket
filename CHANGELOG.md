# Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

 
## [v1.0.1] - 2022-11-21
### :sparkles: New Features
- [`481322c`](https://github.com/WinDanesz/LootCasket/commit/481322c65515b6c5aac2ff9d24efcd6c780262c8) - /lcdumpitem command - dumps the nbt format of the item in your mainhand *(commit by [@WinDanesz](https://github.com/WinDanesz))*
- [`4c760ea`](https://github.com/WinDanesz/LootCasket/commit/4c760eacf07cce9aca6e7f3b101024b05239f1a1) - Added support for a new (optional) "Rolls" tag. Specifying it with a LootTable will cause the casket to roll the loottable multiple times, e.g. "Rolls": 5 will give you 5x the loot of the table, randomly each time. *(commit by [@WinDanesz](https://github.com/WinDanesz))*
- [`178d3b9`](https://github.com/WinDanesz/LootCasket/commit/178d3b9335f2528c1977397e65628b9e6bb5bd85) - Removed the "ItemStack" tag, replaced with the "Items" tag. "Items" can be a list of ItemStacks in an nbt-serialized format. *(commit by [@WinDanesz](https://github.com/WinDanesz))*


[v1.0.1]: https://github.com/WinDanesz/LootCasket/compare/v1.0.0...v1.0.1