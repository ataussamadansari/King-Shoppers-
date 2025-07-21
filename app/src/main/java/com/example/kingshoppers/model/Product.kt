package com.example.kingshoppers.model

data class ProductItem(
    val id: Int,
    val name: String,
    val image: String,
    val weight: String?,
    val deliveryDays: String?,
    val cutMRP: String,
    val percentageOff: String,
    val labelPercentage: String?,
) {
    val totalPrice: String
        get() {
            return try {
                val mrp = cutMRP.toDouble()
                val percent = percentageOff.replace("%", "").toDouble()
                val discountAmount = (percent / 100) * mrp
                val priceAfterDiscount = mrp - discountAmount
                "₹%.2f".format(priceAfterDiscount)
            } catch (e: Exception) {
                "₹0.00"
            }
        }
}
