/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   2839.c                                             :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: yoshin <yoshin@student.42gyeongsan.kr>     +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2024/09/13 22:52:06 by yoshin            #+#    #+#             */
/*   Updated: 2024/09/13 22:57:04 by yoshin           ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

#include <stdio.h>

int main(void) {
  int N;
  int five, three;

  scanf("%d", &N);
  for (five = N / 5; five >= 0; five--) {
    for (three = (N - five * 5) / 3; three >= 0; three--) {
      if (five * 5 + three * 3 != N)
        break;
      printf("%d\n", (five + three));
      return (0);
    }
  }
  printf("-1\n");

  return (0);
}
