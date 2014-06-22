这个程序主要介绍了怎样在网页上制作电子相册。
用户在选项框里选取图像称，网页上就会显示出所以名称的图像。
通过这个例子，读者可以学习到怎样制作网页电子相册。


//得到图像
images[i] = getImage(getDocumentBase(),param);

//增加待加载的图像
imagetracker.addImage(images[i],i); 

这段代码得到图像，然后加载图像。 
