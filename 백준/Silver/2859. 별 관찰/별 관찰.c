/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   2859.c                                             :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: yoshin <yoshin@student.42gyeongsan.kr>     +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2024/09/11 14:58:35 by yoshin            #+#    #+#             */
/*   Updated: 2024/09/11 20:21:54 by yoshin           ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int convert_str_to_minute(char *time);
void convert_minutes_to_time(int minutes, char **time);
int same_time(int min1, int min2);
int find_lcm(int n1, int n2);

int main(void) {
  char *time;
  char *weekend[7];
  int twinkle[2];
  int period[2];
  int count;

  time = (char *)malloc(sizeof(char) * 6);
  if (time == NULL)
    return (0);

  weekend[0] = "Saturday";
  weekend[1] = "Sunday";
  weekend[2] = "Monday";
  weekend[3] = "Tuesday";
  weekend[4] = "Wednesday";
  weekend[5] = "Thursday";
  weekend[6] = "Friday";

  scanf("%s", time);
  twinkle[0] = convert_str_to_minute(time);
  scanf("%s", time);
  twinkle[1] = convert_str_to_minute(time);
  scanf("%s", time);
  period[0] = convert_str_to_minute(time);
  scanf("%s", time);
  period[1] = convert_str_to_minute(time);

  // clang-format off
  // printf("T[0]: %d, T[1]: %d\nP[0]: %d, P[1]: %d\n",
  //       twinkle[0], twinkle[1], period[0], period[1]);
  // clang-format on

  count = 0;
  while (count++ <= 1440) {
    // printf("T[0] : %d, T[1] : %d\n", twinkle[0], twinkle[1]);
    if (twinkle[0] < twinkle[1]) {
      twinkle[0] += period[0];
      continue;
    }
    if (twinkle[0] > twinkle[1])
      twinkle[1] += period[1];
    if (same_time(twinkle[0], twinkle[1]) == 0) {
      printf("%s\n", weekend[(twinkle[0] / (24 * 60)) % 7]);
      convert_minutes_to_time(twinkle[0] % (24 * 60), &time);
      printf("%s\n", time);
      free(time);
      return (0);
    }
  }

  printf("Never\n");
  free(time);
  return (0);
}

int convert_str_to_minute(char *time) {

  if (strlen(time) != 5 || time[2] != ':')
    return (-1);

  return (((time[0] - '0') * 10 + time[1] - '0') * 60 +
          ((time[3] - '0') * 10 + time[4] - '0'));
}

void convert_minutes_to_time(int minutes, char **time) {
  int hour;
  int minute;

  hour = (minutes / 60) % 24;
  minute = minutes % 60;
  (*time)[0] = (hour / 10) + '0';
  (*time)[1] = (hour % 10) + '0';
  (*time)[2] = ':';
  (*time)[3] = (minute / 10) + '0';
  (*time)[4] = (minute % 10) + '0';
  (*time)[5] = '\0';
}

int same_time(int min1, int min2) {
  int result;
  char *time1, *time2;

  time1 = (char *)malloc(sizeof(char) * 6);
  if (time1 == NULL)
    return (0);
  time2 = (char *)malloc(sizeof(char) * 6);
  if (time2 == NULL)
    return (0);

  convert_minutes_to_time(min1, &time1);
  convert_minutes_to_time(min2, &time2);

  result = strcmp(time1, time2);

  free(time1);
  free(time2);

  return (result);
}

int find_lcm(int n1, int n2) {
  int max = n1 > n2 ? n1 : n2;
  int lcm = max;

  while ((lcm % n1 != 0) || (lcm % n2 != 0)) {
    lcm += max;
  }
  return (lcm);
}
