package dev.reeve.api.hypixel

data class ItemsResult(
	var items: List<Item> = listOf()
): UpdatedResult()