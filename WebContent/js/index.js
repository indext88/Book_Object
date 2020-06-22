/**
 * 主页面的轮毂显示
 */
var i = 0;
				var timeInterval = 2000;
				var mm = new Array();
				mm[0] = "img_1.jpg";
				mm[1] = "img_2.jpg";
				mm[2] = "img_3.jpg";
				mm[3] = "img_4.jpg";
				setInterval(qiehuan, timeInterval);
				function qiehuan() {

					if (i == mm.length - 1) {
						i = 0;
					} else {
						i += 1;
					}
					var img = mm[i];
					document.getElementById("img").src = "../Img/" + img;
				}