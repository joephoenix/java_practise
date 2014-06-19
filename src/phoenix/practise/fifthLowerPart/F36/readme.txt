这个程序主要介绍了如何在网页上制作万年历。
用户可以在网页上选择年份和月份，点击“更新”就可以看到这个月份的日历，而且还有水印的效果。
通过这个例子，读者可以学习到在网页上制作万年历。

for (int i = 0; i <= totalWidth; i += CELLWIDTH) {
			g.drawLine(i, TOP, i, TOP + totalHeight); // 绘制表格线
		}
		
for (int i = 0, j = TOP; i <= numRows; i++, j += CELLHEIGHT) {
			g.drawLine(0, j, totalWidth, j); // 绘制表格线
		}


这段代码的主要作用是绘制表格线。
