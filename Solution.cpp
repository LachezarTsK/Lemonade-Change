
#include <array>
#include <vector>
#include <algorithm>
using namespace std;

class Solution {

    static constexpr int LEMONADE_COST = 5;
    static constexpr array<int, 3> COIN_VALUES{ { 5, 10, 20 } };

public:
    bool lemonadeChange(const vector<int>& bills) const {
        array <int, 1 + COIN_VALUES[COIN_VALUES.size() - 1]> frequencyAvailableValues{};

        for (const auto& givenMoney : bills) {
            ++frequencyAvailableValues[givenMoney];
            int changeToReturn = givenMoney - LEMONADE_COST;

            for (size_t i = COIN_VALUES.size() - 1; i != variant_npos; --i) {
                int numberOfCoins = min(changeToReturn / COIN_VALUES[i], frequencyAvailableValues[COIN_VALUES[i]]);
                changeToReturn -= numberOfCoins * COIN_VALUES[i];
                frequencyAvailableValues[COIN_VALUES[i]] -= numberOfCoins;
            }
            if (changeToReturn > 0) {
                return false;
            }
        }
        return true;
    }
};
