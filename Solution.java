
public class Solution {

    private static final int LEMONADE_COST = 5;
    private static final int[] COIN_VALUES = {5, 10, 20};

    public boolean lemonadeChange(int[] bills) {
        int[] frequencyAvailableValues = new int[1 + COIN_VALUES[COIN_VALUES.length - 1]];

        for (int givenMoney : bills) {
            ++frequencyAvailableValues[givenMoney];
            int changeToReturn = givenMoney - LEMONADE_COST;

            for (int i = COIN_VALUES.length - 1; i >= 0; --i) {
                int numberOfCoins = Math.min(changeToReturn / COIN_VALUES[i], frequencyAvailableValues[COIN_VALUES[i]]);
                changeToReturn -= numberOfCoins * COIN_VALUES[i];
                frequencyAvailableValues[COIN_VALUES[i]] -= numberOfCoins;
            }
            if (changeToReturn > 0) {
                return false;
            }
        }
        return true;
    }
}
