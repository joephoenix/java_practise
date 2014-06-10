这个程序主要介绍了在网页上展示伸展的文字。
用户可以看到网页上的文字由小到大不断的伸展，直到文字显示最大才又重新开始显示，在显示过程中，文字还不断的闪烁。
通过这个例子，读者可以学到如何在网页中伸展文字，如何让文字在网页中有闪烁效果。

if (phase == 0) {
  // 重新绘制2D图形，设置图形的参数，如颜色、字体等
  graphics.setColor(Color.orange);
  graphics.fillRect(0, 0, appletWidth, appletHeight);
  graphics.setFont(font);
  graphics.setColor(Color.white);
  graphics.drawString(message, 0, 50);
  phase++;
} else if (phase == 1) {
// 重新绘制2D图形，设置图形的参数，如颜色、字体等
  graphics.setColor(Color.pink);
  graphics.fillRect(0, 0, appletWidth, appletHeight);
  graphics.setFont(font);
  graphics.setColor(Color.black);
  graphics.drawString(message, 0, 50);
  phase = 0;
}

通过不停的改变phase的大小，实现循环重新绘制2D图形，从而达到文字闪烁的效果。