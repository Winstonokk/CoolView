package com.barnettwong.coolview.activity;

import com.barnettwong.coolview.R;
import com.barnettwong.view_library.emojikeyboard.chat.OnOperationListener;
import com.barnettwong.view_library.emojikeyboard.chat.bean.Emojicon;
import com.barnettwong.view_library.emojikeyboard.chat.bean.Faceicon;
import com.barnettwong.view_library.emojikeyboard.chat.emoji.DisplayRules;
import com.barnettwong.view_library.view.MyEmojiKeyBoard;
import com.blankj.utilcode.util.KeyboardUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by wang on 2019/1/21 09:45
 */
public class EmojiKeyboardActivity extends BaseActivity {
    @BindView(R.id.emojiKeyBoard)
    MyEmojiKeyBoard emojiBoard;

    @Override
    public int getLayoutId() {
        return R.layout.activity_emojikeyboard;
    }

    @Override
    public void initView() {
        emojiBoard.setFocus();
        initEmojiData();
        initListener();
    }

    private void initListener() {
        emojiBoard.setOnOperationListener(new OnOperationListener() {
            @Override
            public void send(String content) {
                if(StringUtils.isEmpty(content)){
                    ToastUtils.showShort("发表内容不能为空");
                    return;
                }
                //发送，请求服务
//                mPresenter.getReviewVideoRequest(uid, mVideoListBean.getId(), content);
                //隐藏软键盘
                hideSoftInput();
            }

            @Override
            public void selectedFace(Faceicon content) {
            }

            @Override
            public void selectedEmoji(Emojicon emoji) {
                emojiBoard.getEditTextBox().append(emoji.getValue());
            }

            @Override
            public void selectedBackSpace(Emojicon back) {
                DisplayRules.backspace(emojiBoard.getEditTextBox());
            }

            @Override
            public void selectedFunction(int index) {

            }
        });
    }

    private void hideSoftInput() {
        KeyboardUtils.hideSoftInput(EmojiKeyboardActivity.this);
        emojiBoard.hideLayout();
        emojiBoard.hideKeyboard(EmojiKeyboardActivity.this);
    }

    private void initEmojiData() {
        List<String> faceCagegory = new ArrayList<>();
        File faceList = new File("");
        if (faceList.isDirectory()) {
            File[] faceFolderArray = faceList.listFiles();
            for (File folder : faceFolderArray) {
                if (!folder.isHidden()) {
                    faceCagegory.add(folder.getAbsolutePath());
                }
            }
        }
        emojiBoard.setFaceData(faceCagegory);
    }

}
