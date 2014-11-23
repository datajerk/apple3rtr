Apple /// Ready-to-Run README v1.9 (See CHANGE LOG at end of document)



* WHAT'S IN THE BOX?

(1) Apple /// Computer
    2 MHz 6502
    512K RAM Expansion
    RS-232-C Port
    (2) Joystick Ports
(1) Internal Floppy Drive
(3) External Floppy Drives
(1) CFFA2 Mass Storage Adapter in Slot 1
    (1) 46 MB Internal Hard Disk Drive (HDD) Partitioned into:
        (2) 16MB Partitions:
            /BOS (.PROFILE)
            /HOME (.CFIDE2)
(1) Appli-Card 6 MHz z80 CP/M Adapter in Slot 2 for running those *other*
    business applications (and games!).



* PREINSTALLED SOFTWARE ON HDD

+ BOS 1.0, the *most* advanced Apple /// Operating System
  + BOS Program Switcher
  + BOS Utilities
+ SOS 1.3 System Utilities
+ Backup ///
+ Lazarus ///
+ Access /// 3.2X
+ Access 3270 1.0
+ Apple Writer ///
+ VisiCalc Advanced
+ /// E-Z Pieces
+ Quick File ///
+ Draw ON ///
+ Apple /// Business Basic 1.23
+ Apple /// Pascal 1.1
+ Apple /// Fortran
+ Apple /// COBOL
+ CP/M 2.2 (2 MB Virtual HDD (E:) as file /BOS/CPM1)
  + WordStar 3.0
  + DBaseII 2.3B
  + Turbo Pascal 3.01A
  + Zork I: The Great Underground Empire
  + Zork II: The Wizard of Frobozz
  + Zork III: The Dungeon Master
  + SARGON 2.1



* PREREQUISITES

NOTE:  At the time of this release not all of the capabilities described in
       this document are available in the latest release of MESS--SVN release
       29752 or later should provide all documented functionality.

For OS/X:

  + SDL 1.2.5 is required.  SDL 2.0.x is currently unsupported/unstable.  Use
    this URL:  http://www.libsdl.org/download-1.2.php and install the correct
    SDL distribution for your platform.

  + SDLMESS 64-bit 0.153 or later:  http://sdlmame.lngn.net.  Place in your
    path or in this directory.

    NOTE:  For 115K VSDRIVE and joystick support use the mess64 included with
           this distribution or MESS 0.154 (when released) or later.  See TECH
           TIP #4 and #9.


For Windows:

  + MESS 0.153 or later:  http://www.mamedev.org/release.html  Place in your
    path or this directory.

    NOTE:  The latest SVN Windows binaries can be had from:
           http://www.emucr.com/search/label/MESS

    NOTE:  For 115K VSDRIVE and joystick support get SVN 29752 or later from
           emucr.com.  See TECH TIPs #4 and #9.

  + From the apple3rtr directory type "copy mess.ini.windows mess.ini".


For Linux:

  + Like you need any help. :-)



* COLD BOOTING

NOTE:  Windows users type "mess" or "mess64" instead of "./mess64".

NOTE:  OS/X users type "mess64" instead of "/.mess64" if in your path.

1. Type on a single line (but do not press RETURN):

./mess64 apple3 -skip_gameinfo -volume -24 -resolution 1024x768 -effect Scanlines0x4.png -sl1 cffa2 -hard apple3.hd -sl2 applicard -ramsize 512k

NOTE:  Adjust -volume and -resolution to your taste.  Volume 0 is the loudest.

NOTE:  "-effect Scanlines0x4.png" is option and only optimized for 1024x768.


2. Append to the command line above one of the following floppy images and
*then* press RETURN:

NOTE:  The bosboot and cmpboot images below have been modified to support
       the CFFA2 adapter.

+ Apple /// Demo Disk:

  -flop1 demodisk.dsk

+ BOS 1.0 (4) Disk III system with Apple /// preinstalled applications on
  HDD (/BOS):

  -flop1 bosboot.dsk

+ CP/M 2.2 (4) Disk III system with CP/M preinstalled applications on
  HDD (/BOS/CPM1 (E:)):

  NOTE:  A: = .D1, B: = .D2, C: = .D3, D: = .D4, E: = .PROFILE/CPM1

  -flop1 cpmboot.po 

+ CFFA Utility to create or delete partitions (NOTE:  DO NOT DELETE /BOS!):

  -flop1 cffautil_1.40a.dsk 



* HOW TO OPERATE YOUR NEW APPLE ///

All the keys on your keyboard *should* correspond to the correct Apple ///
keys (Left-Option/Alt = Open-Apple and Right-Alt/Option/Alt = Close-Apple).
The DELETE/BACKSPACE key has been remapped to the Apple /// LEFT ARROW key
since there is no DELETE/BACKSPACE Apple /// key (each Apple /// application
will determine how the LEFT ARROW behaves).

To remove or insert virtual floppies you will have to engage *PARTIAL
Emulation* mode and then launch the *UI Menu*.

The default for MESS is to use the INSERT key to toggle PARTIAL/FULL Emulation
mode and to use the TAB key to launch and dismiss the UI Menu.  There are a few
issues with the MESS defaults.  First, not all keyboards have an INSERT key,
and 2nd, while in PARTIAL Emulation mode keys sent for special functions such
as launching the UI Menu are also sent to the Apple ///.  This can contribute
to a poor experience.

To address the aforementioned the PARTIAL/FULL Emulation mode toggle has been
mapped to the F1 key, and the UI Menu to the F2 key.

NOTE:  OS/X users, if you have F1/F2 set to control brightness (default OS/X
       behavior) then use fn-F1 and fn-F2 for F1 and F2 anytime you are
       instructed to use F1 or F2.

To remove or insert a virtual floppy press F1 to engage PARTIAL Emulation mode,
then immediately press F2 to access the UI Menu.  NOTE:  While in PARTIAL
Emulation mode many of the other keys on the keyboard will be setup to perform
other functions, e.g. "P" will PAUSE the Apple ///.  Refer to the MESS
documentation (http://www.mess.org/mess/howto#using_mess) *and be careful!*

In the UI Menu, DOWN ARROW to the "File Manager", press RETURN, select the
drive, and then select the new floppy image.  To dismiss the UI Menu avoid
using ESC or "Return to System".  The last RETURN will get sent to the system
when the UI Menu exits, and if not careful in PARTIAL Emulation mode an ESC
will power off the Apple ///.  After you have made any and all changes in the
UI Menu use F2 to quickly return to the Apple ///, then F1 to return to FULL
Emulation mode.

In summary:

1.  F1, F2 (fn-F1,F2)
2.  ARROW to File Manager
3.  Select your images
4.  F2, F1 (fn-F2,F1)

To power down your Apple ///:  Quit any applications, and then select "Quit"
from the BOS Program Switcher.  If using CP/M, just quit your application
first.  For any other single disk application, just quit.  Now you are ready to
power down.  To power down press F1 to enter PARTIAL Emulation mode, then press
ESC to shutdown.



* KNOWN ISSUES

+ Fast typing with the SHIFT keys can be a challenge.  You'll adjust.  It is
  unknown at this time if this is a MESS issue or an Apple /// issue.

+ Apple ][ emulation mode is defunct.



* BUILD NOTES

To roll-your-own (OS/X):

1.  Install Xcode
2.  Install the Xcode command line tools from the Xcode site.
3.  Type: svn checkout svn://dspnet.fr/mame/trunk
4.  Type: cd trunk
5.  Have fun checking all that code for exploits. :-)
6.  Type: make TARGET=mess PTR64=1 -j4 (use -j2 for i3 and i5 processors)
7.  Type: cp mess64 *to someplace else*

Go to http://www.mess.org/mess/howto#compiling_mess for more details.



* SUPPORT

RTFMs:  http://apple3.org and http://www.mess.org/mess/howto.

Post a message to comp.sys.apple2.



* MORE INFO ABOUT MESS APPLE ///

http://rbelmont.mameworld.info/



* TECH TIPS

#1:  Using Meat-net to get data/programs in and out of the Apple ///:

Getting things in and out of the Apple /// can be done with floppy images (or
comm programs (see TIP #3) or VSDRIVE (see TIP #4) or by direct manipulation
of apple3.hd (see TIP #5)).  The following applications have been known to work
with Apple /// SOS and CP/M floppy images:

For SOS, AppleCommander works very well:  http://applecommander.sourceforge.net
(CiderPress for Windows/WINE also works:  http://ciderpress.sourceforge.net)

For CP/M, use CPMTools (http://www.moria.de/~michael/cpmtools/) with a format
type of apple-do for DOS and apple-po for ProDOS ordered disk images.  OS/X
users will need to install the CLI development tools to build.  Windows users
can download Bill Buckels binaries:  http://www.cpm8680.com/cpmtools

DOS order images should be suffixed with .do or .dsk.  ProDOS ordered diskimage
should be suffixed with .po.  The incorrect suffix will confuse MESS.


#2:  Fortran /// Q&D HOW-TO:

1.  Launch Pascal ///, edit and save your program, e.g. /HOME/HELLO.F
2.  From Pascal ///, X)ecute /BOS/FORTRAN/FORTRAN OR launch Fortran /// from
    the BOS Menu.
3.  Follow the prompts, e.g. /HOME/HELLO.F, /HOME/HELLO
4.  From System Utilities copy /BOS/FORTRAM/SYSTEM.LIBRARY to /HOME/HELLO.LIB
5.  From Pascal ///, X)ecute /HOME/HELLO

Google "Apple III Fortran Reference Manual" for more details.


#3:  Get "online" with Access /// HOW-TO:

The MESS 0.153 Apple /// driver now inlcudes RS-232 support.  To enable for
communications use append:  -rs232 null_modem -bitb <target>, where <target> is
a socket descriptor (socket.host:port) for TCP-based bidirectional null-modem
communications, e.g. socket.127.0.0.1:2023.

NOTE:  If MESS crashes while starting with -rs232 null_modem -bitb socket...,
       then wait 30 seconds and try again.

As with physical null-modem serial-to-serial communications it is necessary to
match the baud (300, 600, 1200, 2400, 4800, 9600, 115200) and protocol (e.g.
8-N-1) on both ends.  For the MESS end of the null-modem connection this
can be accomplished via the System Configuration menu in the UI Menu.  The
default is 9600, 8-N-1.  For the Apple /// end, the settings my be available in
the application (e.g. Access ///) or may require a change to the .RS232 driver
configuration block via the System Configuration Program (SCP).  See the "Apple
/// Standard Device Drivers Manual" for more details.

E.g., /bin/bash access from Access ///:

1.  Install socat

2.  Type:

    socat tcp-l:2023,reuseaddr,fork exec:/bin/bash,pty,setsid,setpgid,stderr,ctty &

    IMPORTANT:  POTENTIAL SECURITY RISK!!!  USE A FIREWALL OR READ SOCAT DOCS
                IN HOW TO LIMIT ACCESS!!!

3.  Append to MESS command line: 

    -rs232 null_modem -bitb socket.127.0.0.1:2023

4.  After shutting down MESS kill socat:

    kill %1


#4:  VSDRIVE HOW-TO:

VSDRIVE (Virtual Serial Drive) is an RS-232-based virtual drive hosted by a Mac
or PC running ADTPro in "localhost" mode.  Before continuing please read
http://adtpro.sourceforge.net/vdrive.html to familiarize yourself with VSDRIVE.

VSDRIVE is a built-in feature of ADTPro.  Only ADTPro-1.3.0 has been tested
(http://sourceforge.net/projects/adtpro/files/adtpro/ADTPro-1.3.0) and is
included with this distribution.

In the "disks" subdirectory of the included ADTPro-1.3.0 there are two zip
files, v800k.zip and v16m.zip, containing two files, Virtual.po and Virtual2.po.
The sizes are 800K and 16M respectively.  You can replace them with any size
ProDOS formatted volume as long as the volume is < 16MB (max recognized by SOS)
and the names unchanged.  You can create new virtual disks with AppleCommander
(http://applecommander.sourceforge.net/) or CiderPress
(http://ciderpress.sourceforge.net/).

NOTE:  < 16MB is 32767 sectors (max).  The provided 16MB images are 32767
       sectors.

To start VSDRIVE:

1.  Type: cd ADTPro-1.3.0/disks
2.  Unzip v800k.zip for two 800K virtual disks or unzip v16m.zip for two 16M
    virtual disks.  Tip:  Mac users can type "unzip filename.zip".
3.  Type: cd ..
4.  Type: "./adtpro.sh localhost &" (Mac) or "adtpro localhost" (PC).
5.  Type: cd ..

If using MESS 0.153 then only 19.2K serial rates are supported.  For 115K
speed use the included mess64 (OS/X) or obtain an SVN build >= 29752 from
emucr.com.  SVN 29421 and 29752 has been tested with 115K.  Official MESS
releases >= 0.154 should work as well.

To use VSDRIVE 19.2K standalone, append to the MESS command line:

-flop1 VDRIVE-1.3.0.19k.DSK -rs232 null_modem -bitb socket.127.0.0.1:1977

To use VSDRIVE 115K standalone, append to the MESS command line:

-flop1 VDRIVE-1.3.0.DSK -rs232 null_modem -bitb socket.127.0.0.1:1977

To use VSDRIVE 19.2K with BOS, CFFA2, etc..., append to the MESS command line:

-flop1 bosbootvsd19k.dsk -rs232 null_modem -bitb socket.127.0.0.1:1977

To use VSDRIVE 115K with BOS, CFFA2, etc..., append to the MESS command line:

-flop1 bosbootvsd.dsk -rs232 null_modem -bitb socket.127.0.0.1:1977

INPORTANT:  IN ALL CASES, CHANGE THE BAUD RATE FROM THE UI MENU TO EITHER 19200
            OR 115200 BEFORE ACCESSING .VSDRIVE or .VSDRIVE2!  See TECH TIP #3
            on changing baud rates.

NOTE:  The bosboot VSDRIVE disks have .RS232 and .PRINTER removed.  Serial
       printing and other non-VSDRIVE serial functions will be unavailable.

NOTE:  If MESS crashes while starting with -rs232 null_modem -bitb socket...,
       then wait 30 seconds and try again.

To use VSDRIVE with any other boot disks, use the System Configuration Program
(SCP) to add the driver VSDRIVE.A3DRVR from VDRIVE-1.3.0.DSK (115K) or
VDRIVE-1.3.0.19k.DSK.  See the "Apple /// Standard Device Drivers Manual" for
more details.

VSDRIVE 115K performs at ~1/5th the speed of the CFFA2.  The intended purpose
is for large scale transfers *the Apple /// way*.  Advanced users will want to
use the direct methods below.


#5:  Directly Manipulating apple3.hd HOW-TO:

TECH TIPs #1, #3, and #4 all provide Apple /// "native" ways of transfering
files (disk, serial, and VSDRIVE).  However, the fatest way, is to directly
manipulate the HDD image from the host OS.

Prerequisites:

1.  The 'chdman' utility located in the MESS tools directory.  Hopefully your
    MESS binary distribution included this utiliy.  (An OS/X version of chdman
    is included with this distribution.)  To invoke, use ./chdman or include in
    your path.

2.  The 'dd' command.  Windows users will need to install/use cygwin
    (http://www.cygwin.com/) and run the following commands from a bash shell.

To extract the BOS and HOME volumes, type:

    chdman extracthd -f -i apple3.hd -o apple3.hd.image
    dd if=apple3.hd.image of=bos.po bs=512 skip=1 count=32767
    dd if=apple3.hd.image of=home.po bs=512 skip=32768 count=32767

The 'chdman extracthd' command will extract the raw bits from the CHD formatted
apple3.hd image into the file apple3.hd.image.

The two 'dd' commands will create the files bos.po and home.po.  Both are 16MB
ProDOS (SOS) formatted images that can be directly manipulated with
AppleCommander (http://applecommander.sourceforge.net/) or CiderPress
(http://ciderpress.sourceforge.net/).

To create a new HD image from existing bos.po and home.po images:

1.  Backup your files with:

    cp -f apple3.hd apple3.hd.backup
    cp -f apple3.hd.image apple3.hd.image.backup

2.  Concatenate the partition table, bos.po, home.po, and the rest of the
    orginial image into a new image (The '(' and ')' are part of the command):

    (dd if=apple3.hd.image.backup bs=512 count=1; cat bos.po home.po; dd if=apple3.hd.image.backup bs=512 skip=65535) >apple3.hd.image

3.  Create a new [replacement] CHD formated HDD image:

    chdman createhd -f -c none -i apple3.hd.image -o apple3.hd

4.  Test your new image.

5.  Cleanup (or not, it's good to have a backup), type:

    rm apple3.hd.backup apple3.hd.image.backup bos.po home.po


#6:  Directly Manipulating CPM1 HOW-TO:

The safest way to work with the CP/M HD image is from CP/M using floppy images
to add or backup content.  However, the advanced user, may find that a bit
pedestrian.

Prerequisites:

1.  CLEARLY UNDERSTAND TECH TIP #5!

2.  Download and install CPMTools (http://www.moria.de/~michael/cpmtools/).
    OS/X users will need to install the CLI development tools to build.
    Windows users can download Bill Buckels binaries:
    http://www.cpm8680.com/cpmtools

3.  Edit CPMTools diskdefs and append:

    diskdef a3cpmhd
      seclen 128
      tracks 512
      sectrk 32
      blocksize 4096
      maxdir 512
      skew 0
      boottrk 2
      os 2.2
    end

    NOTE:  If you create a different size CPM1 or CPM2, then you will need to
           use STAT x:DSK: where x is the HD image letter to get the geometry
           info required to build a CPMTools disk definition.  E.g.:

               E: Drive Characteristics
           16320: 128 Byte Record Capacity
            2040: Kilobyte Drive  Capacity
             512: 32  Byte Directory Entries
               0: Checked  Directory Entries
             256: Records/ Extent
              32: Records/ Block
              32: Sectors/ Track
               2: Reserved Tracks

4.  Extract CPM1 from bos.po:

    A.  Follow TECH TIP #5 and extract bos.po

    B.  Using AppleCommander or CiderPress extract CPM1, e.g. OS/X:

        alias applecmd='java -jar /Applications/AppleCommander.app/Contents/Resources/Java/AppleCommander.jar'
        applecmd -g bos.po cpm1 >CPM1

Directly Manipulate CPM1:

At this point you should have a 2097152 byte file called CPM1.  Use the
CPMTools commands cpmls, cpmcp, cpmrm, etc... with the -f a3cpmhd option to
directly manipulate CPM1, e.g.:

Listing files from CPM1, type:

    cpmls -f a3cpmhd CPM1

Extract files from CPM1, type:

    cpmcp -f a3cpmhd cpm1 0:zork1.com zork1.com

Remote or Write/Update files to CPM1, type:

    cpmrm -f a3cpmhd CPM1 0:sargon.com
    cpmcp -f a3cpmhd CPM1 ~/Downloads/SARGON.COM 0:sargon.com

    NOTE:  You must remove the file first (if it exists).

Updating bos.po with CPM1:

1.  Use AppleCommander or CiderPress to remove the old CPM1 and replace it with
    the new CPM1, e.g. OS/X:

    applecmd -d bos.po CPM1
    applecmd -p bos.po CPM1 PDA <CPM1

2.  Follow TECH TIP #5 update/create apple3.hd with the updated bos.po.

NOTE:  An alternative to using TECH TIP #5 would be TECH TIP #4 by copying
       /BOS/CPM1 to .VSDRIVE, and then using AppleCommander or CiderPress to
       extract/replace CPM1 from Virtual.po.


#7:  Printing HOW-TO

The MESS 0.153 Apple /// driver now inlcudes RS-232 support.  To enable for
printer use append:   -rs232 null_modem -bitb <target>, where <target> is a
filename for the printer output, e.g. printer.txt.

As with physical null-modem serial-to-serial communications it is necessary to
match the baud (300, 600, 1200, 2400, 4800, 9600, 115200) and protocol (e.g.
8-N-1) on both ends.  For the MESS end of the null-modem connection this
can be accomplished via the System Configuration menu in the UI Menu.  The
default is 9600, 8-N-1.  For the Apple /// end, the settings are available in
the .PRINTER driver configuration block via the System Configuration Program
(SCP).  See the "Apple /// Standard Device Drivers Manual" for more details.

NOTE:  bosboot.dsk and cpmboot.po have .PRINTER set to 9600 8-N-1 to match the
       MESS default.

To capture printer output append to MESS command line: 

    -rs232 null_modem -bitb printer.txt

SOS Printing:  Use .PRINTER

CP/M Printing:  Use LST:

If given an option to append line feeds (LF) to carriage returns (CR), take it.


#8:  Disable All Audio HOW-TO

Just append to command line:

    -audiodriver none


#9:  Joystick HOW-TO

The MESS 0.154 Apple /// driver now inlcudes analog joystick support.

NOTE:  Your average USB retro gamepad/stick will not work since Apple ///
       joysticks are analog.  Get an analog stick.

Known working analog sticks:  

+ Classic Apple II joysticks with the following adapter:
  https://www.tindie.com/products/option8/retroconnector-joystick-shield/
+ Xbox 360

Nothing is required except to connect your joystick *before launching MESS*.
Use the Analog Controls menu from the UI Menu to adjust the center and
sensitivity as necessary.


* CHANGE LOG

v1.0:  * Initial release.

v1.1:  * Updated mess64 to latest SVN build
       * Added Draw ON /// to HD image

v1.2:  * Added Quick File /// to HD image
       * Added /// E-Z Pieces
       * Changed CP/M Turbo Pascal terminal to SOROC (TINST)
       * Added -skip_gameinfo to command line to "skip" game info (i.e. start
         emulation without a pausing).

v1.3:  * Updated: mess.ini/mess.ini.windows (cleanup)
       * Added Backup ///.  Use this and MeatNet for virtual to physical
         (.PROFILE/.CFIDE1 <=> .PROFILE) transfers through MeatSpace.
       * Changed default BOS blanker (type open-apple-B from BOS).

v1.4:  * Added MORE INFO ABOUT MESS APPLE /// section
       * Added Backup3.cffa2.dsk image for virtual <=> physical and vv.
       * Added bosboot4.dsk.  Chaged System Parameters "Number of Disk III
         Drives" from 2 to 4.  Now .D3 and .D4 work.  bosboot.dsk and
         cpmboot.po only support (2) Disk III drives (.D1 and .D2).
       * Added cpmboot4.dsk.  Chaged System Parameters "Number of Disk III
         Drives" from 2 to 4.  Now .D3 and .D4 work as C: and D:, HD
         (/BOS/CPM1) is now E:.

v1.5:  * Added Lazarus ///
       * Added ADTPro 1.2.9
       * Added Apple /// Fortran (/BOS/FORTRAN)
       * Added TECH TIP #2:  Fortran /// Q&D HOW-TO

v1.6:  * Added Access /// 1.1
       * Added CP/M DBaseII 2.3B (/BOS/CPM1, C: or E:)
       * Added CP/M WordStar 3.0 (/BOS/CPM1, C: or E:)
       * Added artwork/Scanlines* and updated command to utilize.  Much better!

v1.7:  * Updated command line to use shorter options.
       * Added boot command for OS/X and Linux users (sorry Windows), to use
         type: ./boot bos|cpm 2|4 [drive system], e.g.:
           ./boot bos 2
           ./boot bos 4
           ./boot cpm 2
           ./boot cpm 4
       * Updated OS/X mess64 with rs232 support.  Windowers check emucr.com.
       * Updated default bosboot.dsk and bosboot4.dsk .RS232 driver to 9600 8N1
         for use with -rs232 null_modem -bitb options.
       * Added "Generic Serial (.RS232)" printer to /// E-Z Pieces.
       * Added TECH TIP #3:  Get "online" with Access /// HOW-TO

v1.8:  * Included mess64 (OS/X) updated to SVN 29421.  Fixes for 115K serial port
         speed.
       * mess.exe removed, 0.153 released.
       * Added TECH TIP #4:  VSDRIVE HOW-TO
       * Added bosbootvsd.dsk and bosbootvsd19k.dsk (see TECH TIP #4).
       * Removed ADTPro from BOS Menu (didn't work)
       * Added ADTPro-1.3.0 for VSDRIVE support
       * Moved ADTPro-1.3.0/disks/VDRIVE-1.3.0.DSK to .
       * Added VDRIVE-1.3.0.19k.DSK (19K version of above)
       * Removed ADTPro-1.3.0/disks/*
       * Added to ADTPro-1.3.0/disks v800k.zip and v19m.zip

v1.9:  * Removed Apple_III_Fortran_Reference_Manual.pdf (can be googled)
       * Added MESS chdman for OS/X.
       * Added TECH TIP #5:  Directly Manipulating apple3.hd HOW-TO
       * Added TECH TIP #6:  Directly Manipulating CPM1 HOW-TO
       * SARGON 2.1 added to CPM1 using TECH TIP #6.
       * Updated Access /// to version 3.2X (Source: APPLE-3-WAP-int-01b.dsk)
       * Added Access_3_Interperter_Command_Text_File_Processing.txt
       * Added Access 3270 1.0 (Source: APPLE-3-WAP-tel-11b.dsk)
         NOTE:  I had this working--now not working.  Dunno why.  Fix it later.
                For now, including bootable/runable access.3270.dsk.
       * Added access.3270.dsk
       * Added Access_3270_Review.txt
       * Upgraded Business Basic to version 1.23 ('bye' to exit!) (Used TT #5)
       * Moved bosboot4.dsk to bosboot.dsk.  If you want a 2 floppy system run
         SCP and create your own.  Or recovery from v1.8.
       * Moved cpmboot4.po to cpmboot.po.  If you want a 2 floppy system run
         SCP and create your own.  Or recovery from v1.8.
       * Updated bosboot.dsk .PRINTER (was .DAISY) @ 9600, 8-N-1.
       * Updated cpmboot.po .PRINTER @ 9600, 8-N-1.
       * Removed "Generic Serial (.RS232)" printer from /// E-Z Pieces.
       * Added "Generic Serial (.PRINTER)" printer to /// E-Z Pieces.
       * Added TECH TIP #7:  Printing HOW-TO
       * Added TECH TIP #8:  Disable All Audio HOW-TO
       * Added TECH TIP #9:  Joystick HOW-TO
       * Included mess64 (OS/X) updated to SVN 29752.  Serial port fixes and
         joystick support.
       * Updated OS/X and Linux ./boot script.



