SECTION = "kernel"
DESCRIPTION = "Linux kernel for Silvermoon platforms"
LICENSE = "GPLv2"
KERNEL_IMAGETYPE = "zImage"

require linux.inc

S = "${WORKDIR}/git"

MULTI_CONFIG_BASE_SUFFIX = ""
BRANCH = "kovan"

COMPATIBLE_MACHINE = "(kovan)"
SRCREV = "6012eef3d4b2915ca88c72ec2862fa7e1550b3d7"

SRC_URI += "git://github.com/kipr/linux.git;branch=${BRANCH} \
	file://defconfig"
