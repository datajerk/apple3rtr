Apple /// Ready-to-Run README v1.8 (See CHANGE LOG at end of document)



* WHAT'S IN THE BOX?

(1) Apple /// Computer
    2 MHz 6502
    512K RAM Expansion
    RS-232 Port
(1) Internal Floppy Drive
(3) External Floppy Drives
(1) CFFA2 Mass Storage Adapter in Slot 1
    (1) 46 MB Internal Hard Disk Drive (HDD) Partitioned into:
        (2) 16MB Partitions:
            /BOS (.PROFILE)
            /HOME (.CFIDE2)
(1) Appli-Card 6 MHz z80 CP/M Adapter in Slot 2 for running those *other*
    business applications (and games!).



* WHAT'S NOT IN THE BOX?

At this time the included game ports are not functional.  There will be a
*free* upgrade in the future.



* PREINSTALLED SOFTWARE ON HDD

+ BOS 1.0, the *most* advanced Apple /// Operating System
  + BOS Program Switcher
  + BOS Utilities
+ SOS 1.3 System Utilities
+ Backup ///
+ Lazarus ///
+ Access /// 1.1
+ Apple Writer ///
+ VisiCalc Advanced
+ /// E-Z Pieces
+ Quick File ///
+ Draw ON ///
+ Apple /// Business Basic
+ Apple /// Pascal 1.1
+ Apple /// Fortran
+ Apple /// COBOL
+ CP/M 2.2 (2 MB Virtual HDD (C: or E:) as file /BOS/CPM1)
  + WordStar 3.0
  + DBaseII 2.3B
  + Turbo Pascal 3.01A
  + Zork I: The Great Underground Empire
  + Zork II: The Wizard of Frobozz
  + Zork III: The Dungeon Master



* PREREQUISITES

For OS/X:

  + SDL 1.2.5 is required.  SDL 2.0.x is currently unsupported/unstable.  Use
    this URL:  http://www.libsdl.org/download-1.2.php and install the correct
    SDL distribution for your platform.

  + MESS 0.153 or later:  http://sdlmame.lngn.net.  Place in your path or in
    this directory.

    NOTE:  For 115K VSDRIVE support use the mess64 included with this
           distribution or MESS 0.154 (when released) or later.  See TECH TIP
           #4.


For Windows:

  + MESS 0.153 or later:  http://www.mamedev.org/release.html  Place in your
    path or this directory.

    NOTE:  The latest SVN Windows binaries can be had from emucr.com.

    NOTE:  For 115K VSDRIVE support get SVN 29421 or later from emucr.com.  See
           TECH TIP #4.

  + From the apple3rtr directory type "copy mess.ini.windows mess.ini".



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

+ BOS 1.0 (2) Disk III system with Apple /// preinstalled applications on
  HDD (/BOS):

  -flop1 bosboot.dsk

+ BOS 1.0 (4) Disk III system with Apple /// preinstalled applications on
  HDD (/BOS):

  -flop1 bosboot4.dsk

+ CP/M 2.2 (2) Disk III system with CP/M preinstalled applications on
  HDD (/BOS/CPM1 (C:)):

  NOTE:  A: = .D1, B: = .D2, C: = .PROFILE/CPM1

  -flop1 cpmboot.po 

+ CP/M 2.2 (4) Disk III system with CP/M preinstalled applications on
  HDD (/BOS/CPM1 (E:)):

  NOTE:  A: = .D1, B: = .D2, C: = .D3, D: = .D4, E: = .PROFILE/CPM1

  -flop1 cpmboot4.po 

+ CFFA Utility to create or delete partitions (NOTE:  DO NOT DELETE /BOS!):

  -flop1 cffautil_1.40a.dsk 



* HOW TO OPERATE YOUR NEW APPLE ///

All the keys on your keyboard *should* correspond to the correct Apple ///
keys.  The DELETE/BACKSPACE key has been remapped to the Apple /// LEFT ARROW
key since there is no DELETE/BACKSPACE Apple /// key (each Apple ///
application will determine how the LEFT ARROW behaves).

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

Fast typing with the SHIFT keys can be a challenge.  You'll adjust.  It is
unknown at this time if this is a MESS issue or an Apple /// issue.



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

Post a message on comp.sys.apple2.



* MORE INFO ABOUT MESS APPLE ///

http://rbelmont.mameworld.info/



* TECH TIPS

#1:  Using Meat-net to get data/programs in and out of the Apple ///:

Getting things in and out of the Apple /// has to be done with floppy images
(or comm programs (see TIP #3) or VSDRIVE (see TIP #4)).  There are a few
applications that can manipulate Apple /// SOS and CP/M floppy images.  The
following have been known to work:

For SOS, AppleCommander works very well:  http://applecommander.sourceforge.net
(CiderPress for Windows/WINE also works:  http://ciderpress.sourceforge.net)

For CP/M, use CPM Tools (http://www.moria.de/~michael/cpmtools/) with a format
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


#3:  Get "online" with Access /// HOW-TO:

The MESS 0.153 Apple /// driver now inlcudes RS-232 support.  To enable, append
-rs232 null_modem -bitb <target> where <target> is a filename (for printer
output, e.g. printer.txt) or a socket description (socket.host:port) for TCP-
based bidirectional null-modem access, e.g. socket.127.0.0.1:2023.

NOTE:  If MESS crashes while starting with -rs232 null_modem -bitb socket...,
       then wait 30 seconds and try again.

As with physical null-modem serial-to-serial communications it is necessary to
match the baud (300, 600, 1200, 2400, 4800, 9600) and protocol (8-N-1 only
available) on both ends.  For the MESS end of the null-modem connection this
can be accomplished via the Bitbanger Control menu in the UI Menu.  The default
is 9600, 8-N-1.  For the Apple /// end, the settings my be available in the
application (e.g. Access ///) or may require a change to the .RS232 driver
configuration block via the System Configuration Program (SCP).  See the "Apple
/// Standard Device Drivers Manual" for more details.

Examples:

+ /bin/bash access from Access ///:

1.  Install socat
2.  Type:

    socat tcp-l:2023,reuseaddr,fork exec:/bin/bash,pty,setsid,setpgid,stderr,ctty &

3.  Append to MESS command line: 

    -rs232 null_modem -bitb socket.127.0.0.1:2023


+ Printer output:

1.  Append to MESS command line: 

    -rs232 null_modem -bitb printer.txt


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
and the names must be unchanged.  You can create new virtual disks with
AppleCommander (http://applecommander.sourceforge.net/) or CiderPress
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
speed use the included mess64 (OS/X) or obtain an SVN build >= 29421 from
emucr.com.  Only SVN 29241 has been tested with 115K.  Official MESS releases
> 0.153 should work as well.

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

NOTE:  The bosboot VSDRIVE disks have .RS232 removed.  Serial printing and
       other non-VSDRIVE serial functions will be unavailable.

NOTE:  If MESS crashes while starting with -rs232 null_modem -bitb socket...,
       then wait 30 seconds and try again.

To use VSDRIVE with any other boot disk, use the System Configuration Program
(SCP) to add the driver VSDRIVE.A3DRVR from VDRIVE-1.3.0.DSK (115K) or
VDRIVE-1.3.0.19k.DSK.  See the "Apple /// Standard Device Drivers Manual" for
more details.

VSDRIVE 115K performs at ~1/5th the speed of the CFFA2.  The intended purpose
is for large scale transfers.



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

v1.8:  * mess64 (OS/X) updated to SVN 29421.  Fixes for 115K serial port speed.
       * mess.exe removed, 0.153 released.
       * Added TECH TIP #4:  VSDRIVE HOW-TO
       * Added bosbootvsd.dsk and bosbootvsd19k.dsk (see TECH TIP #4).
       * Removed ADTPro from BOS Menu (didn't work)
       * Added ADTPro-1.3.0 for VSDRIVE support
       * Moved ADTPro-1.3.0/disks/VDRIVE-1.3.0.DSK to .
       * Added VDRIVE-1.3.0.19k.DSK (19K version of above)
       * Removed ADTPro-1.3.0/disks/*
       * Added to ADTPro-1.3.0/disks v800k.zip and v19m.zip



