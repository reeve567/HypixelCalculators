package dev.reeve.api

class Profile {
	var communityUpgrades = mutableListOf<CommunityUpgrade>()
	var lastSave = 0L
	var cuteName = ""
	var selected = false
	var banking = Banking(0.0)

	data class CommunityUpgrade(
		val upgrade: String,
		val tier: Int,
	)

	data class Banking(
		val balance: Double,
	)
}