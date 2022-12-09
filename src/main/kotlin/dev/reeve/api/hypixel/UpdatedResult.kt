package dev.reeve.api.hypixel

sealed class UpdatedResult: Result() {
	var lastUpdated: Long = 0
}