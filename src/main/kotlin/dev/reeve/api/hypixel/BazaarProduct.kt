package dev.reeve.api.hypixel

import com.google.gson.annotations.SerializedName

data class BazaarProduct(
	@SerializedName("product_id")
	var productId: String,
	@SerializedName("quick_status")
	var quickStatus: BazaarQuickStatus,
	@SerializedName("sell_summary")
	var sellSummary: List<BazaarSummaryItem>,
	@SerializedName("buy_summary")
	var buySummary: List<BazaarSummaryItem>,
) {
	data class BazaarQuickStatus(
		var sellPrice: Double,
		var buyPrice: Double,
		var sellVolume: Long,
		var buyVolume: Long,
		var sellMovingWeek: Long,
		var buyMovingWeek: Long,
		var sellOrders: Int,
		var buyOrders: Int
	)

	data class BazaarSummaryItem(
		var amount: Long,
		var pricePerUnit: Double,
		var orders: Int
	)
}