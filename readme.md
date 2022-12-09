# HypixelCalculators

This project is a work progress, it aims to be a utility for finding the best ways to make money and (possibly) get exp, without having to look into recipe.

## Useful links

- [Wiki](https://hypixel-skyblock.fandom.com/wiki/Hypixel_SkyBlock_Wiki)
- [Wiki - Minions](https://hypixel-skyblock.fandom.com/wiki/Minions)
- [Wiki - Minion - Blaze](https://hypixel-skyblock.fandom.com/wiki/Blaze_Minion)
- [N8N](https://n8n.reeve.dev/workflow/1)
- [InfluxDB](https://influx.reeve.dev/orgs/3ae323744d88538e/data-explorer)

## Implemented Design patterns

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

This is eventually going to be (replaced?/expanded?) with the template pattern.
The big difference is that instead of just using an interface for the base methods, it uses an abstract class, which allows me to add in base functionality for the implementations to use.

## Planned Design Patterns

### Template Pattern

This is another pattern for the pages, but this one is only planned.
The plan is to add more base functionality to the `HtmlComponent` class so that there's less boilerplate code in the classes like `Header` and `NavigationBar`.
Mostly things like utility functions for creating specific html elements that I use all the time

### Observer Pattern

Also a planned pattern, but this one would take a lot more work to implement, since the pages would be served one at a time, and then I'd need to write client code to listen for updates, but it'd be nice to see prices in real time for the products.