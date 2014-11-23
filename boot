#!/bin/bash

function usage {
	echo
	echo "./boot [bos|cpm] [2|4] optional space delimited drive 2-4 images"
	echo
	echo "e.g.: ./boot bos 2"
	echo
	exit 1
}

CMD=mess64
if [ -x mess64 ]
then
	CMD=./mess64
fi


case "$1" in
	bos|BOS)
		IMG=bosboot.dsk
		;;
	cpm|CPM)
		IMG=cpmboot.po
		;;
	*)
		usage
		;;
esac
shift

case "$1" in
	4)
		IMG=$(echo $IMG | sed 's/\./4./')
		;;
	2)
		;;
	*)
		usage
		;;
esac
shift

DRIVES=""
drive=1
while (( "$#" ))
do
	drive=$((drive+1))
	if ((drive == 5))
	then
		echo
		echo "Too many drive images!"
		usage
	fi
	if [ ! -r "$1" ]
	then
		echo
		echo "Cannot read $1"
		echo
		exit 1
	fi
	DRIVES="$DRIVES -flop$drive $1"
	shift
done

set -x

$CMD apple3 \
	-skip_gameinfo \
	-volume -24 \
	-resolution 1024x768 \
	-effect Scanlines0x4.png \
	-sl1 cffa2 \
	-hard apple3.hd \
	-sl2 applicard \
	-ramsize 512k \
	-flop1 $IMG \
	$DRIVES

#future options
#-rs232 null_modem -bitb serialout.txt

