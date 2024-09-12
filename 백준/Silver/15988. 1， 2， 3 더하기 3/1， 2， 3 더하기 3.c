/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   15988.c                                            :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: yoshin <yoshin@student.42gyeongsan.kr>     +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2024/09/12 17:30:55 by yoshin            #+#    #+#             */
/*   Updated: 2024/09/13 00:38:24 by yoshin           ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

#include <stdio.h>

#define DIVIDER 1000000009

long long dp[1000001];

int main(void) {
  int T;
  int n;

  dp[0] = 1;
  dp[1] = 1;
  dp[2] = 2;
  for (int idx = 3; idx <= 1000000; idx++) {
    dp[idx] = (dp[idx - 1] + dp[idx - 2] + dp[idx - 3]) % DIVIDER;
  }

  scanf("%d", &T);
  for (int i = 0; i < T; i++) {
    scanf("%d", &n);
    printf("%d\n", dp[n]);
  }
  return (0);
}
