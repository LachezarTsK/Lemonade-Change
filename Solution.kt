
import kotlin.math.min

class Solution {

    private companion object {
        const val LEMONADE_COST = 5
        val COIN_VALUES = intArrayOf(5, 10, 20)
    }

    fun lemonadeChange(bills: IntArray): Boolean {
        val frequencyAvailableValues = IntArray(1 + COIN_VALUES[COIN_VALUES.size - 1])

        for (givenMoney in bills) {
            ++frequencyAvailableValues[givenMoney]
            var changeToReturn = givenMoney - LEMONADE_COST

            for (i in COIN_VALUES.size - 1 downTo 0) {
                val numberOfCoins = min(changeToReturn / COIN_VALUES[i], frequencyAvailableValues[COIN_VALUES[i]])
                changeToReturn -= numberOfCoins * COIN_VALUES[i]
                frequencyAvailableValues[COIN_VALUES[i]] -= numberOfCoins
            }
            if (changeToReturn > 0) {
                return false
            }
        }
        return true
    }
}
