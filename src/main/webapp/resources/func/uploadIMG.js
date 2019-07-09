var rawIMGsrc = $('img#avatarIMG')[0].src;
var imgFile = null;
var image = new Image();
var new_src = "";

var checkIMG = function(o) {
    if (o.files[0] != null) {
        if (o.files[0].size <= 48000) {
            imgFile = o.files[0];
            if(window.FileReader) {
                var fr = new FileReader();
                fr.onloadend = function(e) {
                    image.onload = function() {
                        if (image.height <= 1134 && image.width <= 780) {
                            $('img#avatarIMG')[0].src = e.target.result;
                            new_src = e.target.result;
                        } else {
                            $('img#avatarIMG')[0].src = rawIMGsrc;
                            imgFile = null;
                            $('div#imgModalBody')[0].innerText = "请选择尺寸为小于780*1134的图片!";
                            $('div#imgModal').modal('show');
                        }
                    }
                    image.src = e.target.result;
                }
                fr.readAsDataURL(imgFile);
            }
        } else {
            $('div#imgModalBody')[0].innerText = "图片过大,请选择小于48k的图片!";
            $('div#imgModal').modal('show');
        }
    }
};

var submitIMG = function() {
    if (imgFile != null) {
        axios.post('/admin/uploadAvatar', {
            id: curEmployeeId,
            avatar: new_src
        }).then(function(res) {
            window.location.reload();
        }).catch(function(error) {
            console.info(error);
        })
    }
}