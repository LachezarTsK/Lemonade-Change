
package main

import "fmt"

const LEMONADE_COST int = 5
var COIN_VALUES [3]int = [3]int{5, 10, 20}

func lemonadeChange(bills []int) bool {
    frequencyAvailableValues := make([]int, 1 + COIN_VALUES[len(COIN_VALUES) - 1])

    for _, givenMoney := range bills {
        frequencyAvailableValues[givenMoney]++
        changeToReturn := givenMoney - LEMONADE_COST

        for i := len(COIN_VALUES) - 1; i >= 0; i-- {
            numberOfCoins := min(changeToReturn/COIN_VALUES[i], frequencyAvailableValues[COIN_VALUES[i]])
            changeToReturn -= numberOfCoins * COIN_VALUES[i]
            frequencyAvailableValues[COIN_VALUES[i]] -= numberOfCoins
        }
        if changeToReturn > 0 {
            return false
        }
    }
    return true
}
