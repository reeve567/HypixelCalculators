package dev.reeve.api.hypixel

import java.util.UUID

data class Profile(
	var communityUpgrades: MutableList<CommunityUpgrade>,
	var lastSave: Long,
	var cuteName: String,
	var selected: Boolean,
	var banking: Banking,
	var members: MutableMap<String, IslandMember>
) {
	data class CommunityUpgrade(
		val upgrade: String,
		val tier: Int,
	)

	data class Banking(
		val balance: Double,
	)
}