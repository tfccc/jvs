#!/bin/bash

function add() {
    s=$[$1+$2]
    echo "两数之和="$s
}
read -p "请输入第一个数字: " a
read -p "请输入第二个数字: " b
