package dev.reeve.api.hypixel

data class Minion(
	val name: String, val id: String, val drops: HashMap<String, MinionDrop>, val tiers: ArrayList<MinionTier>
) {

	data class MinionDrop(
		val average: Double,
		val chance: Double,
	)

	data class MinionTier(
		val cooldown: Int, val storage: Int
	)
}