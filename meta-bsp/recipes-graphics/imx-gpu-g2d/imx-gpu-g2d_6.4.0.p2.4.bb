require recipes-graphics/imx-gpu-g2d/imx-gpu-g2d_6.2.4.p4.0.bb

LIC_FILES_CHKSUM = "file://COPYING;md5=228c72f2a91452b8a03c4cab30f30ef9" 

FSLBIN_NAME_arm = "${PN}-${PV}-${TARGET_ARCH}"

SRC_URI[aarch64.md5sum] = "7853a5fcfdaf5036251834993a3487c4"
SRC_URI[aarch64.sha256sum] = "94592a48aedb0f4249d0c94536f691b1b29f4f7e58366dd989b3d3ce79765c53"
SRC_URI[arm.md5sum] = "ca0132947f3e6f3a9515c4daa82b7dde"
SRC_URI[arm.sha256sum] = "450bd18cf2277f2d28cacc9b7742ae533260a4bb43317e3229aff04bcdf0547d"
