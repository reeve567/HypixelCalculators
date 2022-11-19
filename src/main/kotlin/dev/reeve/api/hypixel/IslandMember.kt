package dev.reeve.api.hypixel

data class IslandMember(
	var personalBankUpgrade: Int = 0,
	var coinPurse: Double = 0.0,
	var craftedGenerators: MutableList<String> = mutableListOf()
) {

	fun getTopGenerators(): MutableMap<String, Int> {
		val topGenerators = mutableMapOf<String, Int>()
		craftedGenerators.forEach { generator ->
			val underScore = generator.indexOfLast { c -> c == '_' }
			val generatorName = generator.substring(0, underScore)
			val generatorLevel = generator.substring(underScore + 1).toInt()

			if (topGenerators.containsKey(generatorName)) {
				if (topGenerators[generatorName]!! < generatorLevel) {
					topGenerators[generatorName] = generatorLevel
				}
			} else {
				topGenerators[generatorName] = generatorLevel
			}
		}
		return topGenerators
	}
}