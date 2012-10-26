SECTION = "kernel"
DESCRIPTION = "Linux kernel for Silvermoon platforms"
LICENSE = "GPLv2"
KERNEL_IMAGETYPE = "zImage"
PR = "r0"
require linux.inc

S = "${WORKDIR}/git"

MULTI_CONFIG_BASE_SUFFIX = ""
BRANCH = "kovan"

COMPATIBLE_MACHINE = "(kovan)"
SRCREV = "cf75e1e901ebeb9b521a7c8aa7cfda647a1db825"

SRC_URI += "git://github.com/kipr/linux.git;branch=${BRANCH} \
	file://defconfig"
