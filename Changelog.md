# CHANGE LOG #


## v1.0

- Initial release.


## v1.1

- Updated mess64 to latest SVN build
- Added Draw ON /// to HD image


## v1.2

- Added Quick File /// to HD image
- Added /// E-Z Pieces
- Changed CP/M Turbo Pascal terminal to SOROC (TINST)
- Added `-skip_gameinfo` to command line to *skip* game info (i.e. start emulation without a pausing).


## v1.3

- Updated: `mess.ini`/`mess.ini.windows` (cleanup)
- Added Backup ///.  Use this and MeatNet for virtual to physical (`.PROFILE/.CFIDE1` <=> `.PROFILE`) transfers through MeatSpace.
- Changed default BOS blanker (type `open-apple-B` from BOS).


## v1.4

- Added MORE INFO ABOUT MESS APPLE /// section
- Added `Backup3.cffa2.dsk` image for virtual <=> physical and vv.
- Added `bosboot4.dsk`.  Chaged System Parameters "Number of Disk III Drives" from 2 to 4.  Now `.D3` and `.D4` work.  `bosboot.dsk` and `cpmboot.po` only support (2) Disk III drives (`.D1` and `.D2`).
- Added `cpmboot4.dsk`.  Chaged System Parameters "Number of Disk III Drives" from 2 to 4.  Now `.D3` and `.D4` work as `C:` and `D:`, HD (`/BOS/CPM1`) is now `E:`.


## v1.5

- Added Lazarus ///
- Added ADTPro 1.2.9
- Added Apple /// Fortran (`/BOS/FORTRAN`)
- Added TECH TIP #2:  Fortran /// Q&D HOW-TO


## v1.6

- Added Access /// 1.1
- Added CP/M DBaseII 2.3B (`/BOS/CPM1`, `C:` or `E:`)
- Added CP/M WordStar 3.0 (`/BOS/CPM1`, `C:` or `E:`)
- Added `artwork/Scanlines*` and updated command to utilize.  Much better!


## v1.7

- Updated command line to use shorter options.
- Added boot command for OS/X and Linux users (sorry Windows), to use
	```
	type: ./boot bos|cpm 2|4 [drive system]
	```
	
	e.g.:

	```
	./boot bos 2
	./boot bos 4
	./boot cpm 2
	./boot cpm 4
	```
	
- Updated OS/X mess64 with rs232 support.  Windowers check <http://emucr.com>.
- Updated default `bosboot.dsk` and `bosboot4.dsk` `.RS232` driver to 9600 8N1 for use with `-rs232 null_modem -bitb` options.
- Added `Generic Serial (.RS232)` printer to /// E-Z Pieces.
- Added TECH TIP #3:  Get "online" with Access /// HOW-TO


## v1.8

- Included mess64 (OS/X) updated to SVN 29421.  Fixes for 115K serial port speed.
- `mess.exe` removed, 0.153 released.
- Added TECH TIP #4:  VSDRIVE HOW-TO
- Added `bosbootvsd.dsk` and `bosbootvsd19k.dsk` (see TECH TIP #4).
- Removed ADTPro from *BOS Menu* (didn't work)
- Added ADTPro-1.3.0 for VSDRIVE support
- Moved `ADTPro-1.3.0/disks/VDRIVE-1.3.0.DSK` to `.`
- Added `VDRIVE-1.3.0.19k.DSK` (19K version of above)
- Removed `ADTPro-1.3.0/disks/*`
- Added to `ADTPro-1.3.0/disks` `v800k.zip` and `v19m.zip`


## v1.9

- Removed `Apple_III_Fortran_Reference_Manual.pdf` (can be googled)
- Added MESS chdman for OS/X.
- Added TECH TIP #5:  Directly Manipulating apple3.hd HOW-TO
- Added TECH TIP #6:  Directly Manipulating CPM1 HOW-TO
- SARGON 2.1 added to CPM1 using TECH TIP #6.
- Updated Access /// to version 3.2X (Source: `APPLE-3-WAP-int-01b.dsk`)
- Added `Access_3_Interperter_Command_Text_File_Processing.txt`
- Added Access 3270 1.0 (Source: `APPLE-3-WAP-tel-11b.dsk`)
	> I had this working--now not working.  Dunno why.  Fix it later.  For now, including bootable/
runable `access.3270.dsk`.

- Added `access.3270.dsk`
- Added `Access_3270_Review.txt`
- Upgraded Business Basic to version 1.23 (`bye` to exit!) (Used TT #5)
- Moved `bosboot4.dsk` to `bosboot.dsk`.  If you want a 2 floppy system run SCP and create your own.  Or recover from v1.8.
- Moved `cpmboot4.po` to `cpmboot.po`.  If you want a 2 floppy system run SCP and create your own.  Or recover from v1.8.
- Updated `bosboot.dsk` `.PRINTER` (was `.DAISY`) @ 9600, 8-N-1.
- Updated `cpmboot.po` `.PRINTER` @ 9600, 8-N-1.
- Removed `Generic Serial (.RS232)` printer from /// E-Z Pieces.
- Added `Generic Serial (.PRINTER)` printer to /// E-Z Pieces.
- Added TECH TIP #7:  Printing HOW-TO
- Added TECH TIP #8:  Disable All Audio HOW-TO
- Added TECH TIP #9:  Joystick HOW-TO
- Included mess64 (OS/X) updated to SVN 29752.  Serial port fixes and joystick support.
- Updated OS/X and Linux `./boot` script.


## v2.0

- Updated `access.3270.dsk` with copy of original 3270 disk.  Fonts work.
- Updated TECH TIP #4 with VSDRIVE volume info.
- Included mess (32-bit) and mess64 (OS/X) updated to SVN 30386.  Keyboard issues resolved!  `RESET` button works (mapped to `F3`)!
- Updated *HOW TO OPERATE YOUR NEW APPLE ///* with `RESET` details.
- Upgraded 46MB HD to 128MB supporting the max number of CFFA2 partitions.
- Updated *WHAT'S IN THE BOX?*
	- Changed:  46MB -> 128MB
	- Added:  AppleColor Monitor 100
- Added TECH TIP #10:  Numeric Pad HOW-TO
- Added *Smaller* and *Even smaller* resolution/scanline options to *COLD BOOTING*.
- Updated ADTPro to 2.0.0
- Updated VSDRIVE driver in `bosbootvsd.dsk` and `bosbootvsdroot.dsk`
- Removed `bosbootvsd19k.dsk`, 115K is really the only way to go.
- Removed `VDRIVE-1.3.0.19k.DSK`
- Removed `VDRIVE-1.3.0.DSK`
- Added `VDRIVE-2.0.0.DSK`
- Removed 32-bit OS/X mess
- Added TECH TIP #11:  Boot from VSDRIVE HOW-TO
- Removed `mess64` and `chdman` binaries (use MESS 0.155 release).
- Added `roms/a3fdc.zip` to support MESS 0.155 change to using proper FDC ROM.
- Added `roms/a2thunpl.zip` to support Thunderclock card
- Updated `boot` with more options and inline help, just type `./boot` (OS/X and Linux users only).
- Removed "TECH TIP" labels, just titles with TOC now.
- Rewrote much of `README` and moved it to `README.md` to prepare to dump on github.

## v2.1

- Updated ADTPro to 2.0.02
- Updated OSX Mess to 0191
- Minor cleanup

