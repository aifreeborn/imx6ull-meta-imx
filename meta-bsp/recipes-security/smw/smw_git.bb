# Copyright 2020-21 NXP

SUMMARY = "NXP i.MX Security Middleware Library"
DESCRIPTION = "NXP i.MX Security Middleware Library"
SECTION = "base"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=8636bd68fc00cc6a3809b7b58b45f982"

DEPENDS = "json-c optee-os optee-client python3-pycryptodomex-native"
DEPENDS_append_mx8qxp = " imx-seco-libs"

SRCBRANCH = "master"
SMW_LIB_SRC ?= "git://source.codeaurora.org/external/imx/imx-smw.git;protocol=https"
SRC_URI = "${SMW_LIB_SRC};branch=${SRCBRANCH} \
    file://0001-CMakeLists.txt-core-pkcs11-Use-CMAKE_INSTALL_LIBDIR-.patch"
SRCREV = "c0fd15d727130d460e5733c0e652633540dc3756"

S = "${WORKDIR}/git"

inherit cmake python3native

OPTEE_OS_TA_EXPORT_DIR_aarch64 = "${STAGING_INCDIR}/optee/export-user_ta_arm64"
OPTEE_OS_TA_EXPORT_DIR_arm = "${STAGING_INCDIR}/optee/export-user_ta_arm32"

EXTRA_OECMAKE = " \
    -DTA_DEV_KIT_ROOT=${OPTEE_OS_TA_EXPORT_DIR} \
    -DTEEC_ROOT=${STAGING_DIR_HOST} \
    -DJSONC_ROOT="${COMPONENTS_DIR}/${TARGET_ARCH}/json-c/usr" \
"
EXTRA_OECMAKE_append_mx8qxp = " -DSECO_ROOT=${STAGING_INCDIR}"

OECMAKE_TARGET_COMPILE += "build_tests"
OECMAKE_TARGET_INSTALL += "install_tests"

PACKAGES =+ "${PN}-tests"

FILES_${PN} += "${base_libdir}/optee_armtz/*"

FILES_${PN}-tests = "${bindir}/* ${datadir}/${BPN}/*"

RDEPENDS_${PN}-tests += "bash cmake"

COMPATIBLE_MACHINE = "(imx)"
