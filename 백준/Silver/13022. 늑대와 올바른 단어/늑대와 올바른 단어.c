/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   13022.c                                            :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: yoshin <yoshin@student.42gyeongsan.kr>     +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2024/10/29 09:21:40 by yoshin            #+#    #+#             */
/*   Updated: 2024/10/29 09:41:37 by yoshin           ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

#include <stdio.h>

int main(void) {
  char word[51];
  char c;
  int cnt[4];
  int idx;

  c = 0;
  cnt[0] = 0;
  cnt[1] = 0;
  cnt[2] = 0;
  cnt[3] = 0;

  scanf("%s", word);

  idx = 0;
  while (word[idx] != '\0') {
    c = word[idx++];
    if (c == 'w') {
      cnt[0] += 1;
      if (word[idx] != 'w' && word[idx] != 'o') {
        printf("0");
        return (0);
      }
    } else if (c == 'o') {
      cnt[1] += 1;
      if (word[idx] != 'o' && word[idx] != 'l') {
        printf("0");
        return (0);
      }
    } else if (c == 'l') {
      cnt[2] += 1;
      if (word[idx] != 'l' && word[idx] != 'f') {
        printf("0");
        return (0);
      }
    } else if (c == 'f') {
      cnt[3] += 1;
      if (word[idx] != 'f' && word[idx] != '\0' && word[idx] != 'w') {
        printf("0");
        return (0);
      }
      if ((word[idx] == '\0' || word[idx] == 'w') &&
          (cnt[0] != cnt[1] || cnt[0] != cnt[2] || cnt[0] != cnt[3])) {
        printf("0");
        return (0);
      }
      if (word[idx] == 'w') {
        cnt[0] = 0;
        cnt[1] = 0;
        cnt[2] = 0;
        cnt[3] = 0;
      }
    } else {
      printf("0");
      return (0);
    }
  }

  printf("1");
  return (0);
}
