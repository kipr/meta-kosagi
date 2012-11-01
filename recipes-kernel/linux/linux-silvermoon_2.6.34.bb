SECTION = "kernel"
DESCRIPTION = "Linux kernel for Silvermoon platforms"
LICENSE = "GPLv2"
KERNEL_IMAGETYPE = "zImage"

require linux.inc

S = "${WORKDIR}/git"

MULTI_CONFIG_BASE_SUFFIX = ""
BRANCH = "kovan"

COMPATIBLE_MACHINE = "(kovan)"
SRCREV = "d98e785d2d1cf0d26da523c5d1835a62da9c6b89"

SRC_URI += "git://github.com/kipr/linux.git;branch=${BRANCH} \
	file://defconfig"
