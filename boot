#!/bin/bash

usage() {
cat <<EOF

Usage: ${0##*/} [-h] [-sml] [-r prt|null|vsd] [-o port] [-acn] diskimage1 [diskimage2 diskimage3 ...]

diskimage1 (and only diskimage1) may use the following optional aliases:

    bos       = bosboot.dsk
    cpm       = cpmboot.po
    vsd       = bosvsdboot.dsk
    vsdroot   = bosvsdrootboot.dsk

    -h        display this help and exit
    -s        512x384 resolution with scanlines
    -m        768x576 resolution with scanlines
    -l        1024x768 resolution with scanlines
    -r prt    rs232 printer @ 9600 BPS outputing to printer.txt
    -r null   rs232 null modem @ 9600 BPS listening on "port", default 2023
    -r full   rs232 null modem @ 115K BPS listening on "port", default 2023
    -r vsd    rs232 null modem @ 115K BPS listening on "port", default 1977
    -o port   override default port (requires -r), port = 0 will be random
    -a        launch ADTPro on port specified by -r vsd or -o
    -c        launch socat on port specified by -r null or -o
    -n        no HD

EOF
}

baud115k() {
	cp -f cfg/apple3.cfg cfg/apple3.cfg.SAVE
	grep -v ":rs232:null_modem:RS232_" <cfg/apple3.cfg.SAVE >cfg/apple3.cfg
	perl -pi -e 's!</input>!    <port tag=":rs232:null_modem:RS232_TXBAUD" type="CONFIG" mask="255" defvalue="7" value="13" />\n            <port tag=":rs232:null_modem:RS232_RXBAUD" type="CONFIG" mask="255" defvalue="7" value="13" />\n        </input>!' cfg/apple3.cfg
}

baud9600() {
	cp -f cfg/apple3.cfg cfg/apple3.cfg.SAVE
	grep -v ":rs232:null_modem:RS232_" <cfg/apple3.cfg.SAVE >cfg/apple3.cfg
}

countdown() {
	for i in 5 4 3 2 1
	do
		echo -n "$i "
		sleep 1
	done
}

CMD=mame64
if [ -x mame64 ]
then
	CMD=./mame64
fi

PTV=""
SIZE="-resolution 768x576 -effect Scanlines75x3 -window"
HD="-sl1 cffa2 -hard1 apple3.hd -bios original"
ADTV=2.0.3
PORT_OVERRIDE=0
LAUNCH_ADT=0
LAUNCH_SOCAT=0
OPTIND=1
PORT=1977

while getopts "hsmlr:o:acn" opt; do
	case "$opt" in
		h)
			usage
			exit 0
			;;
		s)
			SIZE="-resolution 512x384 -effect Scanlines75x2 -window"
			;;
		m)
			SIZE="-resolution 768x576 -effect Scanlines75x3 -window"
			;;
		l)
			SIZE="-resolution 1024x768 -effect Scanlines0x4 -window"
			;;
		r)
			SERIAL=$OPTARG
			case "$SERIAL" in
				prt)
					PTV="-rs232 null_modem -bitb printer.txt"
					baud9600
					;;
				null)
					if ((PORT_OVERRIDE == 0))
					then
						PORT=2023
					fi
					baud9600
					PTV="-rs232 null_modem -bitb socket.127.0.0.1:$PORT"
					;;
				full)
					if ((PORT_OVERRIDE == 0))
					then
						PORT=2023
					fi
					baud115k
					PTV="-rs232 null_modem -bitb socket.127.0.0.1:$PORT"
					;;
				vsd)
					if ((PORT_OVERRIDE == 0))
					then
						PORT=1977
					fi
					baud115k
					PTV="-rs232 null_modem -bitb socket.127.0.0.1:$PORT"
					;;
				*)
					echo "ERROR: " >&2
					;;
			esac
			;;
		o)
			PORT_OVERRIDE=1
			PORT=$OPTARG
			if ((PORT == 0))
			then
				PORT=$(( $(( $RANDOM  % 1000 )) + 1000 )) # 1000-1999 random port
			fi
			PTV=$(echo $PTV | sed "s/:.*$/:$PORT/")
			;;
		a)
			if (( LAUNCH_SOCAT == 1 ))
			then
				echo "ERROR: "
			fi
			LAUNCH_ADT=1
			;;
		c)
			if (( LAUNCH_ADT == 1 ))
			then
				echo "ERROR: "
			fi
			LAUNCH_SOCAT=1
			;;
		n)
			HD=""
			;;
        '?')
			usage >&2
			exit 1
			;;
    esac
done
shift "$((OPTIND-1))" 

if (( $# == 0 ))
then
	usage
	exit 1
fi

IMG=""
case "$1" in
	bos)
		IMG=bosboot.dsk
		;;
	cpm)
		IMG=cpmboot.po
		;;
	vsd|vsdroot)
		IMG=bosboot$1.dsk
		baud115k
		PTV="-rs232 null_modem -bitb socket.127.0.0.1:$PORT"
		;;
esac

if [ -n "$IMG" ]
then
	shift
	set -- $IMG $*
fi

DRIVES=""
drive=0
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

if (( LAUNCH_ADT == 1 ))
then
	cd ADTPro-$ADTV
	perl -pi -e "s/SerialIPPort=.*/SerialIPPort=$PORT/" disks/ADTPro.properties
	./adtpro.sh localhost &
	sleep 4
	cd ..
fi

if (( LAUNCH_SOCAT == 1 ))
then
	socat tcp-l:$PORT,reuseaddr,fork exec:/bin/bash,pty,setsid,setpgid,stderr,ctty &
	SOCAT_PID=$!
	sleep 1
fi

echo Running... $CMD apple3 \
	-skip_gameinfo \
	-volume -24 \
	$HD \
	-sl2 thclock \
	-sl3 applicard \
	-ramsize 512k \
	$SIZE $DRIVES $PTV

while ! $CMD apple3 \
	-skip_gameinfo \
	-volume -24 \
	$HD \
	-sl2 thclock \
	-sl3 applicard \
	-ramsize 512k \
	$SIZE $DRIVES $PTV
do
	echo -n "Cannot open socket, retrying in "
	countdown
	echo
done

if (( LAUNCH_ADT == 1 ))
then
	for i in $(ps axuww | grep ADTPro | grep java | grep -v grep | awk '{print $2}')
	do
		kill $i
	done
fi

if (( LAUNCH_SOCAT == 1 ))
then
	kill $SOCAT_PID
fi
