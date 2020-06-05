# Add needed Freescale packages and definitions

PACKAGES += " \
    ${PN}-fslcodec-testapps \
"

RDEPENDS_${PN}-fslcodec-testapps += " \
    imx-codec-test-bin \
    imx-codec-test-source \
"

ALLOW_EMPTY_${PN}-fslcodec-testapps = "1"

SOC_TOOLS_IMX_TESTAPPS = " \
    cryptodev-module \
    cryptodev-tests \
    imx-kobs \
    vlan \
    ${PN}-fslcodec-testapps \
"

SOC_TOOLS_TESTAPPS = ""
SOC_TOOLS_TESTAPPS_imx = "${SOC_TOOLS_IMX_TESTAPPS}"

SOC_TOOLS_TEST        = ""
SOC_TOOLS_TEST_imx    = "imx-test"
SOC_TOOLS_TEST_imxgpu = "imx-test imx-gpu-viv-demos"
SOC_TOOLS_TEST_append_mx8qm = " imx-seco-libs dvbapp-tests"
SOC_TOOLS_TEST_append_mx8x  = " imx-seco-libs"

RDEPENDS_${PN} += " \
    can-utils \
    coreutils \
    cpufrequtils \
    e2fsprogs-resize2fs \
    iw \
    linuxptp \
    minicom \
    mmc-utils \
    nano \
    ntpdate \
    openssl-bin \
    procps \
    ptpd \
    python-pip \
    udev-extraconf \
    ${SOC_TOOLS_TESTAPPS} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'tk', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'weston-examples', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wifi', 'hostapd sigma-dut', '', d)} \
    ${@bb.utils.contains('MACHINE_FEATURES', 'qca6174', 'qca-tools', \
       bb.utils.contains('MACHINE_FEATURES', 'qca9377', 'qca-tools', \
                                                                 '', d), d)} \
"
