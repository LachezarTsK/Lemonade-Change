
using System;

public class Solution
{
    private static readonly int LEMONADE_COST = 5;
    private static readonly int[] COIN_VALUES = { 5, 10, 20 };

    public bool LemonadeChange(int[] bills)
    {
        int[] frequencyAvailableValues = new int[1 + COIN_VALUES[COIN_VALUES.Length - 1]];

        foreach (int givenMoney in bills)
        {
            ++frequencyAvailableValues[givenMoney];
            int changeToReturn = givenMoney - LEMONADE_COST;

            for (int i = COIN_VALUES.Length - 1; i >= 0; --i)
            {
                int numberOfCoins = Math.Min(changeToReturn / COIN_VALUES[i], frequencyAvailableValues[COIN_VALUES[i]]);
                changeToReturn -= numberOfCoins * COIN_VALUES[i];
                frequencyAvailableValues[COIN_VALUES[i]] -= numberOfCoins;
            }
            if (changeToReturn > 0)
            {
                return false;
            }
        }
        return true;
    }
}
