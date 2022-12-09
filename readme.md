# HypixelCalculators

This project is a work progress, it aims to be a utility for finding the best ways to make money and (possibly) get exp, without having to look into recipe.

## Useful links

- [Wiki](https://hypixel-skyblock.fandom.com/wiki/Hypixel_SkyBlock_Wiki)
- [Wiki - Minions](https://hypixel-skyblock.fandom.com/wiki/Minions)
- [Wiki - Minion - Blaze](https://hypixel-skyblock.fandom.com/wiki/Blaze_Minion)
- [N8N](https://n8n.reeve.dev/workflow/1)
- [InfluxDB](https://influx.reeve.dev/orgs/3ae323744d88538e/data-explorer)

## Design patterns

This project aims to follow design patterns to make the code more readable.

### Adapter Pattern

First and foremost, the adapter pattern is the most important one, since we're dealing with a REST API, and also attempting to gather data from the wiki, which presents all the data in HTML documents.

Implementations:
- HypixelAPI
- InfluxAPI
- MinionGrabber

### Singleton Pattern

The singleton pattern is used to make sure that only one instance of a class is created, and that instance is shared across the application.  Kotlin allows easy creation of singletons, through the `object` class.

Implementations:
- HypixelAPI
    - The singleton pattern was used for the API so that there weren't a bunch of open clients left floating around
- InfluxAPI
    - Same as above
- RegexLiterals
    - The singleton pattern was used for the regex literals so that they could be used across the application, and since I had to use a builder for some, they couldn't all be in a config.

### Builder Pattern

The builder pattern is used to create objects, and is used to make things easier to put together.

Implementations:
- RegexBuilder
    - This one is used for the more complicated regex, since the biggest one I have right now is around 900 characters
- PageBuilder
    - This is used to make the pages easier to create, which allows me to reuse a lot of HTML, since it forces the pages to be modularized

### Strategy Pattern

This one isn't used as much as the other ones, but it's used with the builder pattern for the pages, where each element of HTML is an implementation of `HtmlComponent`, which provides different html and css per object.