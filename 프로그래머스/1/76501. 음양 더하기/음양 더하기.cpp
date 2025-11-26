#include <vector>
#include <numeric> // inner_product

using namespace std;

int solution(vector<int> absolutes, vector<bool> signs) {
    return inner_product(
        absolutes.begin(), absolutes.end(), signs.begin(),
        0,
        plus<>(),
        [](int val, bool sign) { return sign ? val : -val; }
    );
}
