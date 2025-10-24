#include <string>
#include <vector>

using namespace std;

bool solution(int x) {
    int	num = x;
    int	digit_sum = 0;
    
    while (num > 0) {
        digit_sum += num % 10;
        num /= 10;
    }
    return (x % digit_sum == 0);
}