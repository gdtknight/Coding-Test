#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

long long solution(int a, int b) {
    int temp = 0;
    long long answer = 0;
    
    if (a > b) {
        temp = a;
        a = b;
        b = temp;
    }
        
    for (int i = a; i <= b; i++)
        answer = answer + (long long) i;
    return answer;
}