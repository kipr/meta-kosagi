COMPATIBLE_MACHINE = "novena"

require linux.inc

DESCRIPTION = "Linux kernel for the Novena platform"

PR = "r3"

# Bump MACHINE_KERNEL_PR in the machine config if you update the kernel.
# This is on the rpi-patches branch
SRCREV = "f59b51fe3d3092c08d7d554ecb40db24011b2ebc"

SRC_URI = "git://github.com/torvalds/linux.git;protocol=git;branch=master \
           file://defconfig \
"          

LINUX_VERSION ?= "3.6.0"
PV = "${LINUX_VERSION}+${PR}+git"

S = "${WORKDIR}/git"

# NOTE: For now we pull in the default config from the RPi kernel GIT tree.

KERNEL_DEFCONFIG = "novena_defconfig"

# CMDLINE for raspberrypi
CMDLINE_raspberrypi = "dwc_otg.lpm_enable=0 console=ttyAMA0,115200 kgdboc=ttyAMA0,115200 root=/dev/mmcblk0p2 rootfstype=ext4 rootwait"

PARALLEL_MAKEINST = ""

#do_configure_prepend() {
#    install -m 0644 ${S}/arch/${ARCH}/configs/${KERNEL_DEFCONFIG} ${WORKDIR}/defconfig || die "No default configuration for ${MACHINE} / ${KERNEL_DEFCONFIG} available."
#}
#
#do_install_prepend() {
#    install -d ${D}/lib/firmware
#}