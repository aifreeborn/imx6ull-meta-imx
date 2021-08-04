DESCRIPTION = "A library to retrieve i.MX GPU performance data"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://COPYING;md5=e565271ec9a80ce47abbddc4bffe56fa"

SRC_URI[arm-fb.md5sum] = "144b3a95bb59111c3af5d25241f14183"
SRC_URI[arm-fb.sha256sum] = "9f919132759712e217002ee71ac81eaaefaef8e4399bee4a20f3a50a3a404ccb"

SRC_URI[arm-wayland.md5sum] = "3574874683d47cca06161b8a0961296e"
SRC_URI[arm-wayland.sha256sum] = "d98fe8392f8fba51dc931c02d780cad2851d161e65759502549de2025802ac5b"

SRC_URI[arm-x11.md5sum] = "62788042779d29e9f69931f607c79826"
SRC_URI[arm-x11.sha256sum] = "35fb8d4fb54e0a64d783ee0d602c42b5bc1511f0c8dd4a0946a287cf6247f80b"

SRC_URI[aarch64-fb.md5sum] = "af545d2c294fb933d9d3819977286c34"
SRC_URI[aarch64-fb.sha256sum] = "94637fe6ddde4207772fca2fcd459934795aedb4bae4c34777fe43d55b33e1bd"

SRC_URI[aarch64-wayland.md5sum] = "06f3cbaae36b5e3a55d8d9ccbda0a80d"
SRC_URI[aarch64-wayland.sha256sum] = "0301604a5d6783a1e873f093fca0af26cfb3bcda0c678e334e003e4bb8a8de15"

SRC_URI[aarch64-x11.md5sum] = "bb862e55b8ee79ee5a83b0119618cd07"
SRC_URI[aarch64-x11.sha256sum] = "85c1b51d33e5939600af311d509191387b864db2e0b55e11347b93831e662228"

inherit fsl-eula-unpack2 fsl-eula-graphics

PACKAGE_ARCH = "${MACHINE_SOCARCH}"

RDEPENDS_${PN} = "imx-gpu-viv"

# Compatible only with i.MX with GPU
COMPATIBLE_MACHINE        = "(^$)"
COMPATIBLE_MACHINE_imxgpu = "${MACHINE}"
