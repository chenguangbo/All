#!/bin/sh
if [ $1 -eq $2 -a $1 = 1  ]
then 
	echo " -a 表示and 逻辑与   同时成立输出"
elif [ $1 -ne $2 -o $2 = 2  ]
then 
	echo " -o 表示or 逻辑或   有一个成立输出"
else
	echo "others"
fi

