#!/bin/bash

if [ $age -le 0 ]; then
  echo "���䲻��С�ڵ���0"
elif [ $age -gt 0 -a $age -le 18 ]; then
  echo "������1~18"
elif [ $age -gt 18 -a $age -le 40  ]; then
  echo "������19~40"
else
  echo "�������40"
fi
