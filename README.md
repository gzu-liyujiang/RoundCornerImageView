# 项目说明

安卓圆角图片控件，支持分别设置上下左右四个角，通过Path实现绘制，在ListView/RecyclerView里比较丝滑。

![效果图](/screenshot.jpg)

## 例子演示：

```xml
<com.github.gzuliyujiang.RoundCornerImage.RoundCornerImageView
    android:layout_width="90dp"
    android:layout_height="90dp"
    android:layout_marginStart="10dp"
    android:scaleType="fitXY"
    android:src="@android:drawable/sym_def_app_icon"
    app:lyj_cornerSize="30dp"
    app:lyj_cornerType="left_falling"/>
```

## 许可协议

```text
Copyright (c) 2016-present 贵州纳雍穿青人李裕江<1032694760@qq.com>

The software is licensed under the Mulan PSL v2.
You can use this software according to the terms and conditions of the Mulan PSL v2.
You may obtain a copy of Mulan PSL v2 at:
    http://license.coscl.org.cn/MulanPSL2
THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR
PURPOSE.
See the Mulan PSL v2 for more details.
```
