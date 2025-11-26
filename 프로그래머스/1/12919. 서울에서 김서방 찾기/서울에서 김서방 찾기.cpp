#include <vector>
#include <string>
#include <algorithm> // find
#include <iterator>  // distance

using namespace std;

string solution(vector<string> seoul) {
    // Kim이 위치한 인덱스 찾기 (함수형)
    auto idx = distance(
        seoul.begin(), 
        find(seoul.begin(), seoul.end(), "Kim")
    );
    return "김서방은 " + to_string(idx) + "에 있다";
}
