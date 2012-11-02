SECTION = "kernel"
DESCRIPTION = "Linux kernel for Silvermoon platforms"
LICENSE = "GPLv2"
KERNEL_IMAGETYPE = "zImage"

require linux.inc

S = "${WORKDIR}/git"

MULTI_CONFIG_BASE_SUFFIX = ""
BRANCH = "kovan"

COMPATIBLE_MACHINE = "(kovan)"
SRCREV = "932954f21a4e147e078b06771dd7e3e2e71b3eec"

SRC_URI += "git://github.com/kipr/linux.git;branch=${BRANCH} \
	file://defconfig"
