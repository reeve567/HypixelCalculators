package dev.reeve.api

data class Profiles(
	var success: Boolean = false,
	var profiles: List<Profile> = listOf()
)
