#include <vector>
#include <numeric>

using namespace std;

int solution(vector<int> numbers) {
    return (((9 * 10) / 2) \
            - std::accumulate(numbers.begin(), numbers.end(), 0));
}