package dev.reeve.api.hypixel

data class Profiles(
	var success: Boolean = false,
	var profiles: List<Profile> = listOf()
)
