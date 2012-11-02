SECTION = "kernel"
DESCRIPTION = "Linux kernel for Silvermoon platforms"
LICENSE = "GPLv2"
KERNEL_IMAGETYPE = "zImage"

require linux.inc

S = "${WORKDIR}/git"

MULTI_CONFIG_BASE_SUFFIX = ""
BRANCH = "kovan"

COMPATIBLE_MACHINE = "(kovan)"
SRCREV = "5e6e959e2ba7a95d6332145b3b0a44142a526693"

SRC_URI += "git://github.com/kipr/linux.git;branch=${BRANCH} \
	file://defconfig"
