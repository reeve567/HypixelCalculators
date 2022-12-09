package dev.reeve.api.hypixel

data class ProfilesResult(
	var profiles: List<Profile> = listOf()
): Result()
