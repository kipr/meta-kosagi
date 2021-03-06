DESCRIPTION = "Units to initialize usb gadgets"

PR = "r3"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

COMPATIBLE_MACHINE = "(kovan)"
PACKAGE_ARCH = "${MACHINE_ARCH}"

SRC_URI = "file://storage-gadget-init.service \
           file://network-gadget-init.service \
           file://udhcpd.service \
           file://udhcpd.conf \
           file://udhcpd.rules \
           file://g-ether-start-service.sh \
           file://g-ether-load.sh \
          "

do_install() {
	install -d ${D}${base_libdir}/systemd/system/basic.target.wants
	install -m 0644 ${WORKDIR}/*.service ${D}${base_libdir}/systemd/system

	for i in ${WORKDIR}/network-gadget-init.service ; do
		install -m 0644 $i ${D}${base_libdir}/systemd/system
		ln -sf ../$(basename $i) ${D}${base_libdir}/systemd/system/basic.target.wants/
	done

	install -d ${D}${sysconfdir}/udev/rules.d
	install -m 0644 ${WORKDIR}/*.rules ${D}${sysconfdir}/udev/rules.d
	install -m 0644 ${WORKDIR}/*.conf ${D}${sysconfdir}

	install -d ${D}${bindir}
	install -m 0755 ${WORKDIR}/*.sh ${D}${bindir}

	install -d ${D}${sysconfdir}/tmpfiles.d
}

PACKAGES =+ "${PN}-storage ${PN}-network ${PN}-udhcpd"

FILES_${PN} = "${sysconfdir}/tmpfiles.d"

FILES_${PN}-storage = "${base_libdir}/systemd/system/storage-gadget-init.service \
                       ${base_libdir}/systemd/system/basic.target.wants/storage-gadget-init.service"

FILES_${PN}-network = "${base_libdir}/systemd/system/network-gadget-init.service \
                       ${base_libdir}/systemd/system/basic.target.wants/network-gadget-init.service \
                       ${bindir}/g-ether-load.sh \
                       ${bindir}/g-ether-start-service.sh \
                       ${sysconfdir}/udev/rules.d/udhcpd.rules"

FILES_${PN}-udhcpd = "${base_libdir}/systemd/system/udhcpd.service \
                      ${base_libdir}/systemd/system/basic.target.wants/udhcpd.service \
                      ${sysconfdir}/udhcpd.conf"

RRECOMMENDS_${PN} = "${PN}-storage ${PN}-network ${PN}-udhcpd"
