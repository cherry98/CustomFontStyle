##### 使用步骤
1. 创建assets

    在src-main下创建assets，并将.ttf字体资源拷贝到文件夹下

2. 为TextView设置相应的字体
 ```
 AssetManager assets = getAssets();//获取AssetManager引用
 Typeface typeface = Typeface.createFromAsset(assets, "fangzhengcuyuan.ttf");//创建Typeface对象
 tv_show.setTypeface(typeface);

...