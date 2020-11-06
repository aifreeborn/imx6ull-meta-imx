require recipes-graphics/imx-gpu-g2d/imx-gpu-g2d_6.4.0.p2.4.bb

LIC_FILES_CHKSUM = "file://COPYING;md5=cf3f9b8d09bc3926b1004ea71f7a248a" 

FSLBIN_NAME_arm = "${PN}-${PV}-${TARGET_ARCH}"

SRC_URI[aarch64.md5sum] = "5d8d1b094fa1744f6837d53f6445a124"
SRC_URI[aarch64.sha256sum] = "69f375bb68caa6bca4c9a9097f1619afbb0117ecc29d322a12c88f3ca40d1a67"
SRC_URI[arm.md5sum] = "f04b6a1f823e992bc6014413dca2911f"
SRC_URI[arm.sha256sum] = "2d34c54ced9e312bb4cbd2cca7c044053033878e1df6ed0b3a663367ab4b1ca8"
