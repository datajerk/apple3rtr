#!/bin/bash

function usage {
	echo
	echo "./boot [bos|cpm|vsd] {p|t} {diskimage diskimage ...} # vsd voids p|t"
	echo
	echo "e.g.: ./boot bos"
	echo
	exit 1
}

EXTRA=""
PT=""
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
	vsd|VSD)
		IMG=bosbootvsd.dsk
		EXTRA="-rs232 null_modem -bitb socket.127.0.0.1:1977"
		;;
	*)
		usage
		;;
esac
shift

case "$1" in
	p|P)
		PT="-rs232 null_modem -bitb printer.txt"
		shift
		;;
	t|T)
		PT="-rs232 null_modem -bitb socket.127.0.0.1:2023"
		shift
		;;
esac

if [ -z "$EXTRA" ]
then
	EXTRA=$PT
fi

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
	$DRIVES $EXTRA

