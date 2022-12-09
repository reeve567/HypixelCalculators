package dev.reeve

import dev.reeve.api.hypixel.HypixelAPI
import kotlin.test.Test

class HypixelAPITest {

	private val xwyId = "5c69a18acdcd4a7bb67885b70efdf0b1"
	private val apiToken: String = System.getenv("HYPIXEL_API_TOKEN")

	@Test
	fun testBazaar() {
		val bazaar = HypixelAPI.fetchBazaar()

		assert(bazaar != null)
		assert(bazaar!!.success)
		// products *can* be removed, so checking the total amount or greater isn't really a good test
		// there *are* over 800 though, so making sure there's at least a few should be good enough
		assert(bazaar.products.size >= 5)
	}

	@Test
	fun testItems() {
		val items = HypixelAPI.items //  lazy loaded

		assert(items.success)
		println(items.items.size)
		// last I checked, there were 4146 items available, and these can't really be removed
		assert(items.items.size >= 4000)
	}

	@Test
	fun testProfiles() {
		HypixelAPI.setApiKey(apiToken)
		val profile = HypixelAPI.fetchPlayerProfiles(xwyId)

		assert(profile != null)
		assert(profile!!.success)
		assert(profile.profiles.isNotEmpty())
	}
}