package dev.reeve.api.hypixel

import java.util.UUID

class Profile {
	var communityUpgrades = mutableListOf<CommunityUpgrade>()
	var lastSave = 0L
	var cuteName = ""
	var selected = false
	var banking = Banking(0.0)
	var members = mutableMapOf<UUID, IslandMember>()

	data class CommunityUpgrade(
		val upgrade: String,
		val tier: Int,
	)

	data class Banking(
		val balance: Double,
	)
}