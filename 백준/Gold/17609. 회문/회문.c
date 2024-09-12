/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   17609.c                                            :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: yoshin <yoshin@student.42gyeongsan.kr>     +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2024/09/13 05:00:57 by yoshin            #+#    #+#             */
/*   Updated: 2024/09/13 06:13:58 by yoshin           ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

#include <stdio.h>
#include <string.h>

int is_palindrome(char *str);
int is_pseudo_palindrome(char *str);

int main(void) {
  int T;
  char str[100001];

  scanf("%d", &T);

  for (int idx = 0; idx < T; idx++) {
    scanf("%s", str);
    if (is_palindrome(str))
      printf("0\n");
    else if (is_pseudo_palindrome(str))
      printf("1\n");
    else
      printf("2\n");
  }

  return (0);
}

int is_palindrome(char *str) {
  int len;
  int flag;

  flag = 1;
  len = strlen(str);
  for (int idx = 0; idx < len / 2; idx++) {
    if (str[idx] != str[len - 1 - idx]) {
      flag = 0;
      break;
    }
  }
  return (flag);
}

int is_pseudo_palindrome(char *str) {
  int len;
  int flag;

  len = strlen(str);
  for (int idx = 0, jdx = len - 1; idx < jdx; idx++, jdx--) {
    if (str[idx] == str[jdx])
      continue;
    flag = 1;
    for (int i = idx + 1, j = jdx; i < j; i++, j--) {
      if (str[i] != str[j]) {
        flag = 0;
        break;
      }
    }
    if (flag)
      return (1);
    flag = 1;
    for (int i = idx, j = jdx - 1; i < j; i++, j--) {
      if (str[i] != str[j]) {
        flag = 0;
        break;
      }
    }
    if (flag)
      return (1);
    break;
  }
  return (0);
}
