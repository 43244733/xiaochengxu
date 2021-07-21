<%--
  Created by IntelliJ IDEA.
  User: 86131
  Date: 2020/5/27
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <!--[if !IE]> -->
    <script src="/js/jquery.js"></script>
</head>
<body>
<div class="page-content">
    <div style="padding: 10px;">
        <tr>
            <td colspan="2">
                <button class="btn btn-sm btn-default" onclick="openMedia()">开启
                    摄像头
                </button>
                <button class="btn btn-sm btn-default" onclick="closeMedia()">关
                    闭摄像头
                </button>
                <button class="btn btn-sm btn-default" onclick="takePhoto()">登录
                </button>
            </td>
        </tr>
        <table>
            <tr>
                <td>
                    <video id="video" width="500px" height="500px"
                           autoplay="autoplay"></video>
                    <canvas id="canvas" width="500px" height="500px"
                            style="display: none"></canvas>
                </td>
                <td>
                    <img id="imgTag" src="" alt="..." width="500px"
                         height="500px"><br>
                </td>
            </tr>
        </table>
        <script>
            let mediaStreamTrack = null; // 视频对象(全局)
            let video;

            function openMedia() {
                let constraints = {
                    video: {width: 500, height: 500},
                    audio: false
                };
//获得video摄像头
                video = document.getElementById('video');
                let promise = navigator.mediaDevices.getUserMedia(constraints);
                promise.then((mediaStream) => {
// mediaStreamTrack = typeof mediaStream.stop === 'function' ? mediaStream : mediaStream.getTracks()[1];
                    mediaStreamTrack = mediaStream.getVideoTracks()
                    video.srcObject = mediaStream;
                    video.play();
                });
            } // 拍照
            function takePhoto() {
//获得Canvas对象
                let video = document.getElementById('video');
                let canvas = document.getElementById('canvas');
                let ctx = canvas.getContext('2d');
                ctx.drawImage(video, 0, 0, 500, 500);
// toDataURL --- 可传入'image/png'---默认, 'image/jpeg'
                let img = document.getElementById('canvas').toDataURL();
// 这里的img就是得到的图片
                console.log('img-----', img);
                document.getElementById('imgTag').src = img;
//上传
                $.ajax({
                    url: "/face/doLogin",
                    type: "POST",
                    data: {"imgData": img},
                    dataType: "json",
                    success: function (data) {
                        var b = data.success;
                        alert(b);
                        if (b) {
                            alert("登录成功");
                        } else {
                            alert("登录失败");
                        }
                    },
                    error: function () {
                        alert("登录失败")
                    }
                });
            } // 关闭摄像头
            function closeMedia() {
                let stream = document.getElementById('video').srcObject;
                let tracks = stream.getTracks();
                tracks.forEach(function (track) {
                    track.stop();
                });
                document.getElementById('video').srcObject = null;
            }
        </script>
    </div>
</div>
</body>
</html>