require u-boot.inc

UBOOT_BINARY = "u-boot.bin"
UBOOT_IMAGE = "u-boot-${MACHINE}-${PV}-${PR}.bin"
UBOOT_SYMLINK = "u-boot-${MACHINE}.bin"

PV = "2009.07"
PR = "r9"

COMPATIBLE_MACHINE = "(kovan)"

SRC_URI = "git://github.com/kipr/u-boot-2009.07-silvermoon.git;protocol=git;branch=${MACHINE} \
          "

SRCREV = "31d2c765192eff6fb55eb8d2f7f76dcc3f0ef600"

LIC_FILES_CHKSUM = "file://COPYING;md5=4c6cde5df68eff615d36789dc18edd3b"

S = "${WORKDIR}/git/src"
