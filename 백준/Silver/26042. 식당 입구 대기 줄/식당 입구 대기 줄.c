/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   26042.c                                            :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: yoshin <yoshin@student.42gyeongsan.kr>     +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2024/09/09 17:16:43 by yoshin            #+#    #+#             */
/*   Updated: 2024/09/09 17:16:43 by yoshin           ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

#include <stdio.h>

typedef int type;

int main(void) {
  int n;
  int i;
  int len;
  type t;
  int s_num;
  int ans[2];
  int *data;

  scanf("%d", &n);
  ans[0] = -1;
  ans[1] = -1;
  len = 0;
  for (i = 0; i < n; i++) {
    scanf("%d", &t);
    if (t == 1) {
      scanf(" %d", &s_num);
      len++;
      if (len > ans[0]) {
        ans[0] = len;
        ans[1] = s_num;
      }
      if (len == ans[0] && ans[1] > s_num) {
        ans[1] = s_num;
      }
    }
    if (t == 2) {
      len--;
    }
  }
  printf("%d %d\n", ans[0], ans[1]);
  return (0);
}
