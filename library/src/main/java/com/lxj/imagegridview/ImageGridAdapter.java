package com.lxj.imagegridview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ImageView;

import java.util.List;

public abstract class ImageGridAdapter<T> {

    private List<T> imageDataSet;

    public ImageGridAdapter(List<T> imageDataSet) {
        this.imageDataSet = imageDataSet;
    }

    /**
     * 如果要实现图片点击的逻辑，重写此方法即可
     *
     * @param context  上下文
     * @param gridView 九宫格控件
     * @param position 当前点击图片的的索引
     */
    protected void onImageItemClick(@NonNull Context context, @NonNull ImageGridView gridView, int position) {
    }

    protected abstract void loadImage(ImageView imageView, int position, @NonNull T item);

    /**
     * 生成ImageView容器的方式，默认使用NineGridImageViewWrapper类，即点击图片后，图片会有蒙板效果
     * 如果需要自定义图片展示效果，重写此方法即可
     *
     * @param context 上下文
     * @return 生成的 ImageView
     */
    protected ImageView generateImageView(Context context) {
        ImageViewWrapper imageView = new ImageViewWrapper(context);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(R.drawable.ic_default_color);
        return imageView;
    }

    public List<T> getImageDataSet() {
        return imageDataSet;
    }

    public T getImageItem(int position) {
        return imageDataSet.get(position);
    }

}