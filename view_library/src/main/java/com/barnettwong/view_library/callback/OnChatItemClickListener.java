package com.barnettwong.view_library.callback;

/**
 * Created by wang on 2019/1/21 10:19
 */
/**
 * 聊天列表中对内容的点击事件监听
 */
public interface OnChatItemClickListener {
    void onPhotoClick(int position);

    void onTextClick(int position);

    void onFaceClick(int position);
}
