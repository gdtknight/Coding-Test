/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   10816.c                                            :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: yoshin <yoshin@student.42gyeongsan.kr>     +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2024/09/15 19:48:05 by yoshin            #+#    #+#             */
/*   Updated: 2024/09/15 19:48:06 by yoshin           ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

#include <stdio.h>
#include <stdlib.h>

#define MIN -10000000
#define MAX 10000000
#define SIZE 500000 // 숫자 카드 개수
#define ABS(x) ((x) < 0 ? (-(x)) : (x))

int cnt = 0;

int main(void) {
  int N, M, i;
  int num;

  // 10,000,000
  // 2,147,483,647
  int *target;
  int *count;

  count = (int *)malloc(sizeof(int) * (MAX - MIN + 1));
  if (count == NULL)
    return (0);

  for (i = MIN; i <= MAX; i++) {
    count[i + MAX] = 0;
  }

  scanf("%d", &N);
  for (i = 0; i < N; i++) {
    scanf("%d", &num);
    if (i != N - 1)
      scanf(" ");
    count[num + MAX] += 1;
  }

  scanf("%d", &M);
  target = (int *)malloc(sizeof(int) * M);
  if (target == NULL)
    return (0);

  for (i = 0; i < M; i++) {
    scanf("%d", &target[i]);
    if (i != M - 1)
      scanf(" ");
  }

  for (i = 0; i < M; i++) {
    printf("%d", count[target[i] + MAX]);
    if (i != M - 1)
      printf(" ");
  }
  printf("\n");
  free(target);
  free(count);
  return (0);
}
