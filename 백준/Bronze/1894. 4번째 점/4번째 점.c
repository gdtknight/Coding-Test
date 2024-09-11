/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   1894.c                                             :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: yoshin <yoshin@student.42gyeongsan.kr>     +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2024/09/11 20:40:32 by yoshin            #+#    #+#             */
/*   Updated: 2024/09/11 21:59:37 by yoshin           ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

#include <stdio.h>
#include <stdlib.h>

typedef struct point {
  double x;
  double y;
} Point;

void finalize(Point **vertex, int idx);

int main(void) {
  Point *vertex[4];
  double x_sum;
  double y_sum;

  int mid_idx1;
  int mid_idx2;

  for (int idx = 0; idx < 4; idx++) {
    vertex[idx] = (Point *)malloc(sizeof(Point));
    if (vertex[idx] == NULL)
      finalize(vertex, idx);
  }

  while (scanf("%lf %lf %lf %lf %lf %lf %lf %lf", &vertex[0]->x, &vertex[0]->y,
               &vertex[1]->x, &vertex[1]->y, &vertex[2]->x, &vertex[2]->y,
               &vertex[3]->x, &vertex[3]->y) != EOF) {
    x_sum = 0.0;
    y_sum = 0.0;
    for (int idx = 0; idx < 3; idx++) {
      for (int jdx = idx + 1; jdx < 4; jdx++) {
        if (vertex[idx]->x == vertex[jdx]->x &&
            vertex[idx]->y == vertex[jdx]->y) {
          mid_idx1 = idx;
          mid_idx2 = jdx;
          idx = 3;
          break;
        }
      }
    }

    for (int idx = 0; idx < 4; idx++) {
      if (idx == mid_idx1 || idx == mid_idx2)
        continue;
      x_sum += vertex[idx]->x;
      y_sum += vertex[idx]->y;
    }

    // printf("\n");
    // for (int cur = 0; vertex[cur] != NULL; cur++)
    //   printf("[%lf, %lf]\n", vertex[cur]->x, vertex[cur]->y);

    // clang-format off
    printf("%.3lf %.3lf\n",
           (x_sum - vertex[mid_idx1]->x),
           (y_sum - vertex[mid_idx1]->y));
    // clang-format on
  }

  return (0);
}

void finalize(Point **vertex, int idx) {
  while (idx--)
    free(vertex[idx]);
}
