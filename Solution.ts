
function lemonadeChange(bills: number[]): boolean {
    const LEMONADE_COST = 5;
    const COIN_VALUES = [5, 10, 20];
    const frequencyAvailableValues: number[] = new Array(1 + COIN_VALUES[COIN_VALUES.length - 1]).fill(0);

    for (let givenMoney of bills) {
        ++frequencyAvailableValues[givenMoney];
        let changeToReturn = givenMoney - LEMONADE_COST;

        for (let i = COIN_VALUES.length - 1; i >= 0; --i) {
            let numberOfCoins = Math.min(Math.floor(changeToReturn / COIN_VALUES[i]), frequencyAvailableValues[COIN_VALUES[i]]);
            changeToReturn -= numberOfCoins * COIN_VALUES[i];
            frequencyAvailableValues[COIN_VALUES[i]] -= numberOfCoins;
        }
        if (changeToReturn > 0) {
            return false;
        }
    }
    return true;
};
