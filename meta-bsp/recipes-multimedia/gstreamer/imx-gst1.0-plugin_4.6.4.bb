# Copyright (C) 2014,2016 Freescale Semiconductor
# Copyright 2017-2021 NXP
# Copyright (C) 2012-2015 O.S. Systems Software LTDA.
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Gstreamer freescale plugins"
LICENSE = "GPLv2 & LGPLv2 & LGPLv2.1"
SECTION = "multimedia"

DEPENDS = "imx-codec imx-parser libdrm gstreamer1.0 gstreamer1.0-plugins-base gstreamer1.0-plugins-bad"
DEPENDS:append:mx6 = " imx-lib"
DEPENDS:append:mx7 = " imx-lib"
DEPENDS:append:mx8ulp = " imx-lib"
DEPENDS:append:imxvpu = " imx-vpuwrap"

# For backwards compatibility
RREPLACES:${PN} = "gst1.0-fsl-plugin"
RPROVIDES:${PN} = "gst1.0-fsl-plugin"
RCONFLICTS:${PN} = "gst1.0-fsl-plugin"

LIC_FILES_CHKSUM = "file://COPYING-LGPL-2;md5=5f30f0716dfdd0d91eb439ebec522ec2 \
                    file://COPYING-LGPL-2.1;md5=fbc093901857fcd118f065f900982c24"

IMXGST_SRC ?= "git://source.codeaurora.org/external/imx/imx-gst1.0-plugin.git;protocol=https"
SRCBRANCH = "master"

SRC_URI = "${IMXGST_SRC};branch=${SRCBRANCH} \
"
SRCREV = "3bc459b1e9c2c973b24aa43e4d469a9455deba7e"

S = "${WORKDIR}/git"

inherit meson pkgconfig use-imx-headers

PLATFORM:mx6 = "MX6"
PLATFORM:mx6sl = "MX6SL"
PLATFORM:mx6sx = "MX6SX"
PLATFORM:mx6ul = "MX6UL"
PLATFORM:mx6sll = "MX6SLL"
PLATFORM:mx7= "MX7D"
PLATFORM:mx7ulp= "MX7ULP"
PLATFORM:mx8 = "MX8"

# Todo add a mechanism to map possible build targets
EXTRA_OEMESON = "-Dplatform=${PLATFORM} \
                 -Dc_args="${CFLAGS} -I${STAGING_INCDIR_IMX}" \
"

PACKAGES =+ "${PN}-gplay ${PN}-libgplaycore ${PN}-libgstfsl ${PN}-grecorder ${PN}-librecorder-engine ${PN}-libplayengine"

# Add codec list that the beep plugin run-time depended
BEEP_RDEPENDS = "imx-codec-aac imx-codec-mp3 imx-codec-oggvorbis"
RDEPENDS:${PN} += "imx-parser ${BEEP_RDEPENDS} gstreamer1.0-plugins-good-id3demux "

PACKAGECONFIG ?= ""

# FIXME: Add all features
# feature from excluded mm packages
PACKAGECONFIG[ac3] += ",,imx-ac3codec,imx-ac3codec"
# feature from special mm packages
PACKAGECONFIG[aacp] += ",,imx-aacpcodec,imx-aacpcodec"
MSDEPENDS = "imx-msparser imx-mscodec"
PACKAGECONFIG[wma10dec] += ",,${MSDEPENDS},${MSDEPENDS}"
PACKAGECONFIG[wma8enc] += ",,${MSDEPENDS},${MSDEPENDS}"

FILES:${PN} = "${libdir}/gstreamer-1.0/*.so ${datadir}"

FILES:${PN}-dbg += "${libdir}/gstreamer-1.0/.debug"
FILES:${PN}-dev += "${libdir}/gstreamer-1.0/*.la ${libdir}/pkgconfig/*.pc"
FILES:${PN}-staticdev += "${libdir}/gstreamer-1.0/*.a"
FILES:${PN}-gplay = "${bindir}/gplay-1.0"
FILES:${PN}-libgplaycore = "${libdir}/libgplaycore-1.0${SOLIBS}"
FILES:${PN}-libgstfsl = "${libdir}/libgstfsl-1.0${SOLIBS}"
FILES:${PN}-grecorder = "${bindir}/grecorder-1.0"
FILES:${PN}-librecorder-engine = "${libdir}/librecorder_engine-1.0${SOLIBS}"
FILES:${PN}-libplayengine = "${libdir}/libplayengine-1.0${SOLIBS}"

COMPATIBLE_MACHINE = "(mx6|mx7|mx8)"
