Apple /// Ready-to-Run README v1.2 (See CHANGE LOG at end of document)


* WHAT'S IN THE BOX?

(1) Apple /// Computer
    2 MHz 6502
    512K RAM Expansion
(1) Internal Floppy Drive
(3) External Floppy Drives (but you'll only ever need one, see HDD below)
(1) CFFA2 Mass Storage Adapter in Slot 1
(1) 46 MB Internal Hard Disk Drive (HDD) Partitioned into:
    (2) 16MB Partitions:
        /BOS (.PROFILE)
        /HOME (.CFIDE2)
(1) Appli-Card 6 MHz z80 CP/M Adapter in Slot 2 for running those *other*
    business applications (and games!).



* WHAT'S NOT IN THE BOX?

At this time the included serial, printer, and game ports are not functional.
There will be a *free* upgrade in the future.



* PREINSTALLED SOFTWARE on HDD

+ BOS 1.0, the *most* advanced Apple /// Operating System
  + BOS Program Switcher
  + BOS Utilities
+ SOS 1.3 System Utilities
+ /// E-Z Pieces
+ Apple Writer ///
+ Draw ON ///
+ VisiCalc Advanced
+ Quick File ///
+ Apple /// COBOL
+ Apple /// Business Basic
+ Apple /// Pascal 1.1
+ CP/M 2.2 (2 MB Virtual HDD (C:) as file /BOS/CPM1)
  + Turbo Pascal 3.01a
  + Zork I: The Great Underground Empire
  + Zork II: The Wizard of Frobozz
  + Zork III: The Dungeon Master



* PREREQUISITES

For OS/X (and Linux):

SDL 1.2.5 is required.  SDL 2.0.x is currently unsupported/unstable.  Use this
URL:  http://www.libsdl.org/download-1.2.php and install the correct SDL
distribution for your platform.

For Windows:

From the apple3rtr director type "copy mess.ini.windows mess.ini".



* COLD BOOTING

NOTE:  Windows users type "mess" instead of "./mess64".

1. Simply type on a single line (but do not press RETURN):

./mess64 apple3 -skip_gameinfo -volume -24 -resolution 800x600 -sl1 cffa2 -hard apple3.hd -sl2 applicard -ramsize 512k

NOTE:  Adjust -volume and -resolution to your taste.  Volume 0 is the loudest.


2. Append to the command line above one of the following floppy images and
*then* press RETURN:

Apple /// Demo Disk:

  -floppydisk1 demodisk.dsk

BOS 1.0 with Apple /// preinstalled applications on HDD (/BOS):

  -floppydisk1 bosboot.dsk

CP/M 2.2 with CP/M preinstalled applications on HDD (/BOS/CPM1):

  -floppydisk1 cpmboot.po 

CFFA Utility to create or delete partitions (NOTE:  DO NOT DELETE /BOS!):

  -floppydisk1 cffautil_1.40a.dsk 



* HOW TO OPERATE Your New Apple ///

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
mapped to the F1 key, and the UI Menu to the F2 key.  NOTE: OS/X users if you
have F1/F2 set to control brightness (default OS/X behavior) then use fn-F1 and
fn-F2 for F1 and F2 anytime you are instructed to use F1 or F2.

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



* BUILD NOTES:

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



* TECH NOTES

#1:  Using Meat-net to get data/programs in and out of the Apple ///.

Getting things in and out of the Apple /// has to be done with floppy images.
There are many applications that can manipulate Apple /// SOS and CP/M floppy
images.  The following have been known to work:

For SOS, Apple Commander works very well: http://applecommander.sourceforge.net

For CP/M, use CPM Tools (http://www.moria.de/~michael/cpmtools/) with a format
type of apple-do for DOS and apple-po for ProDOS ordered disk images.

DOS order images should be suffixed with .do or .dsk.  ProDOS ordered diskimage
should be siffixed with .po.  The incorrect suffix will confuse MESS.



* CHANGE LOG

v1.0:  -Initial release.

v1.1:  -Updated mess64 to latest SVN build
       -Added Draw ON /// to HD image

v1.2:  -Added Quick File /// to HD image
       -Added /// E-Z Pieces
       -Changed CP/M Turbo Pascal terminal to SOROC (TINST)
       -Added -skip_gameinfo to command line to "skip" game info (i.e. start
        emulation without a pausing).



