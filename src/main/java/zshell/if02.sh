#!/bin/bash

if [ $age -le 0 ]; then
  echo "年龄不能小于等于0"
elif [ $age -gt 0 -a $age -le 18 ]; then
  echo "年龄在1~18"
elif [ $age -gt 18 -a $age -le 40  ]; then
  echo "年龄在19~40"
else
  echo "年龄大于40"
fi
