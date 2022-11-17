package dev.reeve.api

data class Item(
	val id: String,
	val material: String,
	val name: String,
	val tier: String,
	val color: String? = null,
	val skin: String? = null,
	val npcSellPrice: Int? = null,
	val category: String,
) {
}