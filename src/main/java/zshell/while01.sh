#!/bin/bash

sum=0
i=0

while (($i <= 100)); do
  let sum+=i
  let i++
done

echo $sum
