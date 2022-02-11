/*
 * Copyright (c) 2016-present 贵州纳雍穿青人李裕江<1032694760@qq.com>
 *
 * The software is licensed under the Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 *     http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR
 * PURPOSE.
 * See the Mulan PSL v2 for more details.
 */

package com.github.gzuliyujiang.RoundCornerImage;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * 圆角图片，支持分别设置上下左右四个角
 *
 * @author liyujiang
 * @since 2018/2/2
 */
public class RoundCornerImageView extends ImageView {
    private static final int CORNER_TYPE_ALL = 0;
    private static final int CORNER_TYPE_LEFT = 1;
    private static final int CORNER_TYPE_TOP = 2;
    private static final int CORNER_TYPE_RIGHT = 3;
    private static final int CORNER_TYPE_BOTTOM = 4;
    private static final int CORNER_TYPE_LEFT_FALLING = 5;
    private static final int CORNER_TYPE_RIGHT_FALLING = 6;
    private static final float CORNER_SIZE_DIP = 3;
    private final Path path = new Path();
    private float width, height;
    private final int cornerType;
    private final float cornerSize;

    public RoundCornerImageView(Context context) {
        this(context, null);
    }

    public RoundCornerImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RoundCornerImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray t = context.obtainStyledAttributes(attrs, R.styleable.RoundCornerImageView);
        cornerType = t.getInteger(R.styleable.RoundCornerImageView_lyj_cornerType, CORNER_TYPE_ALL);
        cornerSize = t.getDimension(R.styleable.RoundCornerImageView_lyj_cornerSize, CORNER_SIZE_DIP * getResources().getDisplayMetrics().density);
        t.recycle();
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        width = getWidth();
        height = getHeight();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (width > cornerSize && height > cornerSize) {
            // 左上点
            path.moveTo(cornerSize, 0);
            // 上边线
            path.lineTo(width - cornerSize, 0);
            // 右上角
            if (cornerType == CORNER_TYPE_ALL || cornerType == CORNER_TYPE_RIGHT ||
                    cornerType == CORNER_TYPE_TOP || cornerType == CORNER_TYPE_LEFT_FALLING) {
                path.quadTo(width, 0, width, cornerSize);
            } else {
                path.lineTo(width, 0);
            }
            // 右边线
            path.lineTo(width, height - cornerSize);
            // 右下角
            if (cornerType == CORNER_TYPE_ALL || cornerType == CORNER_TYPE_RIGHT ||
                    cornerType == CORNER_TYPE_BOTTOM || cornerType == CORNER_TYPE_RIGHT_FALLING) {
                path.quadTo(width, height, width - cornerSize, height);
            } else {
                path.lineTo(width, height);
            }
            // 下边线
            path.lineTo(cornerSize, height);
            // 左下角
            if (cornerType == CORNER_TYPE_ALL || cornerType == CORNER_TYPE_LEFT ||
                    cornerType == CORNER_TYPE_BOTTOM || cornerType == CORNER_TYPE_LEFT_FALLING) {
                path.quadTo(0, height, 0, height - cornerSize);
            } else {
                path.lineTo(0, height);
            }
            // 左边线
            path.lineTo(0, cornerSize);
            // 左上角
            if (cornerType == CORNER_TYPE_ALL || cornerType == CORNER_TYPE_LEFT ||
                    cornerType == CORNER_TYPE_TOP || cornerType == CORNER_TYPE_RIGHT_FALLING) {
                path.quadTo(0, 0, cornerSize, 0);
            } else {
                path.lineTo(0, 0);
            }
            canvas.clipPath(path);
        }
        super.onDraw(canvas);
    }

}
