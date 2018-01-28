#/bin/sh
num=1
sum=0
mm=1
while [ $num -le 100 ]
do 
	sum=`expr $sum + $num`
	num=`expr $num + $mm`
	echo $num
#	sleep 1
done
echo $sum








