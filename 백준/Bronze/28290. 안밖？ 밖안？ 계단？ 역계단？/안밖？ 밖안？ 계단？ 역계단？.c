/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   28290.c                                            :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: yoshin <yoshin@student.42gyeongsan.kr>     +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2024/09/11 13:24:17 by yoshin            #+#    #+#             */
/*   Updated: 2024/09/11 13:36:22 by yoshin           ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

#include <stdio.h>
#include <string.h>

#define IN_OUT_MSG "in-out\n"
#define OUT_IN_MSG "out-in\n"
#define STAIRS_MSG "stairs\n"
#define REVERSE_MSG "reverse\n"
#define UNKNOWN_MSG "molu\n"

/*
 * 안밖	"fdsajkl;" 또는"jkl;fdsa"
 * 밖안	"asdf;lkj" 또는 ";lkjasdf"
 * 계단	"asdfjkl;"
 * 역계단	";lkjfdsa"
 */
int main(void) {
  char str[9], *msg;
  char *in_out1 = "fdsajkl;";
  char *in_out2 = "jkl;fdsa";
  char *out_in1 = "asdf;lkj";
  char *out_in2 = ";lkjasdf";
  char *stairs = "asdfjkl;";
  char *reverse_stairs = ";lkjfdsa";

  scanf("%s", str);
  msg = UNKNOWN_MSG;
  if (strcmp(str, in_out1) == 0 || strcmp(str, in_out2) == 0)
    msg = IN_OUT_MSG;
  if (strcmp(str, out_in1) == 0 || strcmp(str, out_in2) == 0)
    msg = OUT_IN_MSG;
  if (strcmp(str, stairs) == 0)
    msg = STAIRS_MSG;
  if (strcmp(str, reverse_stairs) == 0)
    msg = REVERSE_MSG;
  printf("%s\n", msg);
  return (0);
}
