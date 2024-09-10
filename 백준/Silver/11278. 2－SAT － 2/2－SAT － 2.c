/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   11278.c                                            :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: yoshin <yoshin@student.42gyeongsan.kr>     +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2024/09/10 14:59:00 by yoshin            #+#    #+#             */
/*   Updated: 2024/09/10 16:28:52 by yoshin           ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

/*
 * (x | y) & (-y | z) & (x | -z) & (z | y)
 */
#include <stdio.h>
#include <stdlib.h>

#define abs(x) ((x) < 0 ? -(x) : (x))

void finalize(int **clause, int idx);
int recursive(int **clause, int **vars, int digit, int N, int M);

int main(void) {
  int N, M;
  int i, j;
  int **clause;
  int *vars;

  scanf("%d %d", &N, &M);

  vars = (int *)malloc(sizeof(int) * (N + 1));
  if (vars == NULL)
    return (0);
  clause = (int **)malloc(sizeof(int *) * M);
  if (clause == NULL)
    return (0);

  for (int idx = 0; idx < M; idx++) {
    scanf("%d %d", &i, &j);
    clause[idx] = (int *)malloc(sizeof(int) * 2);
    if (clause[idx] == NULL)
      finalize(clause, idx);
    clause[idx][0] = i;
    clause[idx][1] = j;
  }

  if (recursive(clause, &vars, 0, N, M)) {
    printf("1\n");
    for (int idx = 1; idx <= N; idx++) {
      printf("%d", vars[idx]);
      if (idx != N)
        printf(" ");
    }
    printf("\n");
    return (0);
  }

  printf("0\n");

  for (int idx = 0; idx < M; idx++)
    free(clause[idx]);
  free(clause);
  free(vars);
  return (0);
}

int recursive(int **clause, int **vars, int digit, int N, int M) {
  int ans;
  int i, j, a, b;

  ans = 1;
  if (digit == N) {
    for (int idx = 0; idx < M; idx++) {
      i = clause[idx][0];
      j = clause[idx][1];
      a = (*vars)[abs(i)];
      b = (*vars)[abs(j)];
      if (i < 0)
        a = !a;
      if (j < 0)
        b = !b;
      ans = ans & (a | b);
    }
    return (ans);
  }

  (*vars)[digit + 1] = 0;
  if (recursive(clause, vars, digit + 1, N, M))
    return (1);
  (*vars)[digit + 1] = 1;
  return (recursive(clause, vars, digit + 1, N, M));
}

void finalize(int **clause, int idx) {
  while (idx--)
    free(clause[idx]);
  free(clause);
}
