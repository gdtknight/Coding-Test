/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   2166.c                                             :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: yoshin <yoshin@student.42gyeongsan.kr>     +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2024/09/13 04:18:13 by yoshin            #+#    #+#             */
/*   Updated: 2024/09/13 04:58:15 by yoshin           ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

#include <stdio.h>
#define ABS(x) ((x) > 0 ? (x) : -(x))

int main(void) {
  double ans;
  double N, startX, startY, x, y, prevX, prevY;

  scanf("%lf", &N);

  ans = 0.0;
  scanf("%lf %lf", &startX, &startY);
  prevX = startX;
  prevY = startY;
  for (int idx = 1; idx < N; idx++) {
    scanf("%lf %lf", &x, &y);
    ans += 0.5 * (prevX * y - x * prevY);
    prevX = x;
    prevY = y;
  }
  ans += 0.5 * (prevX * startY - startX * prevY);
  printf("%.1f\n", ABS(ans));

  return (0);
}
