/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   30030.c                                            :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: yoshin <yoshin@student.42gyeongsan.kr>     +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2024/09/09 17:07:54 by yoshin            #+#    #+#             */
/*   Updated: 2024/09/09 17:07:54 by yoshin           ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

#include <stdio.h>

int main(void) {
  int A, B;

  scanf("%d", &B);

  A = B / 110 * 100;
  printf("%d\n", A);

  return (0);
}
